<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="referrer" content="no-referrer" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>Insert title here</title>
<style>

.headerB{ font-size: 80px!important }

.rightAside {
	float: right;
	width: 350px;
}
.leftAside {
	float: left;
	width: 350px;
}
ul{
    list-style:none;
}

.eGName{
    color:#c0c0c0;
}
</style>
</head>


<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Game List</b></h1>
</header>

<div style="width: 100%; height: 500px; ">
  <div>
    <aside class="leftAside">
      <h1></h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>



  <table>

    <div>
        <tr onClick="location.href='/GameReviewList?g_idx=${gameListVo.g_idx}&menu_id=1'">
          <td>
            <img src="${gameListVo.g_img}" alt="${gameListVo.g_name}" style="width: 165px; height: 115px;">
          </td>
          <td colspan="2">
            <ul class="gList">
              <li><strong>게임명 : </strong><span class="gName">${gameListVo.g_name}</span> <span class="eGName">${gameListVo.g_ename}</span></li>
              <li><strong>장르명 : </strong>${gameListVo.g_genre}</li>
              <li><strong>개발사 : </strong>${gameListVo.g_company}</li>
              <li><strong>서비스 : </strong>${gameListVo.g_service}</li>
              <li><strong>플랫폼 : </strong>${gameListVo.g_platform}</li>
              <li><strong>출시일 : </strong>${gameListVo.g_date}</li>
            </ul>
          </td>
          <td style="font-size:20px;">
            평점 : ${gameListVo.g_score}
          </td>
        </tr>
    </div>

    <tr>
      <th colspan="6" style="text-align:center">
        <button style="font-size:20px;" onClick="location.href='/GameReviewList?g_idx=${gameListVo.g_idx}&menu_id=1'" >리뷰게시판</button>
        <button style="font-size:20px;" onClick="location.href='/GameReviewList?g_idx=${gameListVo.g_idx}&menu_id=2'" >자유게시판</button>
      </th>
    </tr>

          <tr>
          <th width="10%" style="text-align:center">번호</th>
          <th width="25%" style="text-align:center">제목</th>
          <c:if test= "${menu_id eq 1}">
            <th width="5%" style="text-align:center">평점</th>
          </c:if>
          <th width="10%" style="text-align:center">작성자</th>
          <th width="10%" style="text-align:center">작성일</th>
          <th width="5%" style="text-align:center">조회수</th>
          </tr>

          <c:forEach var="item" items="${boardList}" >
            <tr>
              <td width="10%" style="text-align:center">${item.b_idx}</td>
              <td width="25%" style="text-align:left"><a href="/View?b_idx=${item.b_idx}&menu_id=${menu_id}">${item.title}</a></td>
              <c:if test="${menu_id eq 1}">
                <td width="5%" style="text-align:center">${item.r_score}</td>
              </c:if>
              <td width="5%" style="text-align:center">${item.u_id}</td>
              <td width="10%" style="text-align:center">${item.indate}</td>
              <td width="5%" style="text-align:center">${item.b_count}</td>
            </tr>
          </c:forEach>


          <tr>
            <td colspan="4">
            <c:choose>
                    <c:when test="${sT eq 0}">
                      <tr>
                        <td class="page" id="page" colspan="2" style="text-align:center;">
                          <div class="pager">
                            <c:if test="${Pager.prev}">
                              <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}">< 이전</a>
                              <a class="firstPageNum" href="/Board/GameReviewList?pageNum=1&contentNum=30">1</a>
                              ...
                            </c:if>
                            <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                              <a class="pageNum" href="/Board/GameReviewList?pageNum=${idx}&contentNum=${idx*30}">${idx}</a>
                            </c:forEach>
                            <c:if test="${Pager.next}">
                              ...
                              <a class="lastPageNum" href="/Board/GameReviewList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}">${Pager.lastPageNum}</a>
                              <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}">다음 ></a>
                            </c:if>
                          </div>
                        </td>
                      </tr>
                    </c:when>
                    <c:when test="${sT eq 101}">
                      <td class="page" id="page" colspan="2" style="text-align:center;">
                        <div class="pager">
                          <c:if test="${Pager.prev}">
                            <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&gameName=${gN}">< 이전</a>
                            <a class="firstPageNum" href="/Board/GameReviewList?pageNum=1&contentNum=30&gameName=${gN}">1</a>
                            ...
                          </c:if>
                          <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                            <a class="pageNum" href="/Board/GameReviewList?pageNum=${idx}&contentNum=${idx*30}&gameName=${gN}">${idx}</a>
                          </c:forEach>
                          <c:if test="${Pager.next}">
                            ...
                            <a class="lastPageNum" href="/Board/GameReviewList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&gameName=${gN}">${Pager.lastPageNum}</a>
                            <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&gameName=${gN}">다음 ></a>
                          </c:if>
                        </div>
                      </td>
                    </c:when>
                    <c:otherwise>
                      <tr>
                        <td class="page" id="page" colspan="2" style="text-align:center;">
                          <div class="pager">
                            <c:if test="${Pager.prev}">
                              <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&searchType=${sT}">< 이전</a>
                              <a class="firstPageNum" href="/Board/GameReviewList?pageNum=1&contentNum=30&searchType=${sT}">1</a>
                              ...
                            </c:if>
                            <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                              <a class="pageNum" href="/Board/GameReviewList?pageNum=${idx}&contentNum=${idx*30}&searchType=${sT}">${idx}</a>
                            </c:forEach>
                            <c:if test="${Pager.next}">
                              ...
                              <a class="lastPageNum" href="/Board/GameReviewList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&searchType=${sT}">${Pager.lastPageNum}</a>
                              <a href="http://localhost:8080/Board/GameReviewList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&searchType=${sT}">다음 ></a>
                            </c:if>
                          </div>
                        </td>
                      </tr>
                    </c:otherwise>
                  </c:choose>

            <tr style="border-top: 1px solid #000">
              <td style="padding-left: 50px; border-radius: 4px; background: #f1f1f1; padding: 15px 0px 15px 20px;">
                <select class="search" id="searchType">
                  <option value="title"><strong>제목</strong></option>
                  <option value="board_local"><strong>지역</strong></option>
                  <option value="writer"><strong>작성자</strong></option>
                  <option value="board_check"><strong>접수상태</strong></option>
                </select>
                <input id="keyword" class="keyword" type="text">
                <button id="btnSearch" class="searchB">검색</button>
              </td >
              <td colspan="5" style="text-align: right; border-radius: 4px; background: #f1f1f1; padding: 15px 20px 15px 0px;">
              <c:if test="${sessionScope.login.u_id ne null}">
              <button style="font-size:20px;" onClick="location.href='/boardWrite?g_idx=${gameListVo.g_idx}&menu_id=${menu_id}'" >글쓰기</button>
              </c:if>
              </td>
            </tr>

  </table>

</div>
<script>
console.log(${Pager});
</script>
</body>
</html>
