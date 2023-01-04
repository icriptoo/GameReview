import pandas as pd
import numpy as np
import sys
import cx_Oracle
from sklearn.feature_extraction.text import TfidfVectorizer

from sklearn.metrics.pairwise import cosine_similarity

# -*- coding: utf-8 -*-

title = sys.argv[1]

game_data = pd.read_csv('C:/GameReview/src/main/webapp/WEB-INF/pythonFile/GameList.csv', low_memory=False, encoding='cp949')
# game_data = game_data.loc[game_data['original_language'] == 'en', :]
game_data = game_data[['G_IDX', 'G_NAME', 'G_GENRE', 'G_COMPANY', 'G_SERVICE', 'G_PLATFORM']]
# print(game_data.shape)
# print(game_data.head(5))

tfidf_vector = TfidfVectorizer()
tfidf_matrix = tfidf_vector.fit_transform(game_data['G_GENRE'] + " " + game_data['G_COMPANY'] + " " + game_data['G_PLATFORM']).toarray()
tfidf_matrix_feature = tfidf_vector.get_feature_names_out()

tfidf_matrix = pd.DataFrame(tfidf_matrix, columns=tfidf_matrix_feature, index = game_data.G_NAME)
# print(tfidf_matrix.shape)
# print(tfidf_matrix.head())

cosine_sim = cosine_similarity(tfidf_matrix)

cosine_sim_df = pd.DataFrame(cosine_sim, index = game_data.G_NAME, columns = game_data.G_NAME)
# print(cosine_sim_df.shape)
# print(cosine_sim_df.head())

def game_recommendations(target_title, matrix, items, k=10): # k= 뽑아올 게임개수
    recom_idx = matrix.loc[:, target_title].values.reshape(1, -1).argsort()[:, ::-1].flatten()[1:k+1]
    recom_title = items.iloc[recom_idx, :].G_NAME.values
    recom_genre = items.iloc[recom_idx, :].G_GENRE.values
    recom_company = items.iloc[recom_idx, :].G_COMPANY.values
    target_title_list = np.full(len(range(k)), target_title)
    target_genre_list = np.full(len(range(k)), items[items.G_NAME == target_title].G_GENRE.values)
    target_company_list = np.full(len(range(k)), items[items.G_NAME == target_title].G_COMPANY.values)
    d = {
        'target_title':target_title_list,
        'target_genre':target_genre_list,
        'target_company':target_company_list,
        'recom_title' : recom_title,
        'recom_genre' : recom_genre,
        'recom_company': recom_company
    }
    return pd.DataFrame(d)

re = game_recommendations(title, cosine_sim_df, game_data)
re = re[['recom_title']]
print(re.to_string(index=False))