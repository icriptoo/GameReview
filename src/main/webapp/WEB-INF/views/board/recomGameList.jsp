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
<script>
function btnGSearch(e){
  e.preventDefault();
  var url = "/Board/GameList?pageNum=1&contentNum=30";
  url += "&gameName=" + $("#gameName").val();
  if ($("#gameName").val() === ""){
    alert("게임명을 입력해주세요.");
  }else{
    location.href = url;
  }
}

</script>
</head>
<body>
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
  <div>
    <table>
      <td colspan="4" style="font-size:25px;">
       "${title}" 와(과) 유사한 추천게임입니다.
      </td>
      <c:forEach var="list" items="${gameList}">
        <tr onClick="location.href='/GameReviewList?g_idx=${list.g_idx}&menu_id=1&pageNum=1&contentNum=30'">
          <td>
            <img src="${list.g_img}" alt="${list.g_name}" style="width: 165px; height: 115px;">
          </td>
          <td colspan="2">
            <ul class="gList">
              <li><strong>게임명 : </strong><span class="gName">${list.g_name}</span> <span class="eGName">${list.g_ename}</span></li>
              <li><strong>장르명 : </strong>${list.g_genre}</li>
              <li><strong>개발사 : </strong>${list.g_company}</li>
              <li><strong>서비스 : </strong>${list.g_service}</li>
              <li><strong>플랫폼 : </strong>${list.g_platform}</li>
              <li><strong>출시일 : </strong>${list.g_date}</li>
            </ul>
          </td>
          <td style="font-size:20px;">
            평점 : ${list.g_score}
          </td>
        </tr>
      </c:forEach>
      <td colspan="4" style="font-size:25px;">
             "${genre}" 추천게임입니다.
            </td>
            <c:forEach var="list" items="${gameList2}">
              <tr onClick="location.href='/GameReviewList?g_idx=${list.g_idx}&menu_id=1&pageNum=1&contentNum=30'">
                <td>
                  <img src="${list.g_img}" alt="${list.g_name}" style="width: 165px; height: 115px;">
                </td>
                <td colspan="2">
                  <ul class="gList">
                    <li><strong>게임명 : </strong><span class="gName">${list.g_name}</span> <span class="eGName">${list.g_ename}</span></li>
                    <li><strong>장르명 : </strong>${list.g_genre}</li>
                    <li><strong>개발사 : </strong>${list.g_company}</li>
                    <li><strong>서비스 : </strong>${list.g_service}</li>
                    <li><strong>플랫폼 : </strong>${list.g_platform}</li>
                    <li><strong>출시일 : </strong>${list.g_date}</li>
                  </ul>
                </td>
                <td style="font-size:20px;">
                  평점 : ${list.g_score}
                </td>
              </tr>
            </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
