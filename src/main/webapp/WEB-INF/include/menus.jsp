<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.menuLine{
    font-size: 12pt;
    font-family: 'PT Sans', Arial, Sans-serif;
    position: relative;
    padding-top: 13px;
}
.menuLine a{
    padding: 0 1.5% 0 1.5%;
}
html {
  -webkit-touch-callout:none;
  -webkit-user-select:none;
  -webkit-tap-highlight-color:rgba(0, 0, 0, 0);
}
.clearfix a{
  color: #FFFFFF;
  text-align: center;
  padding: 14.5px 16px;
  text-decoration: none;
}
.clearfix a:hover{
  /*color: #597812;*/
  color: #FFD400;
  font-weight:normal;
}
.menu {
  width: 100%;
  height: 50px;
  text-align: center;
  max-width: 100%;
  background-position: center;
  background-size: cover;
  background-color: #333333;color: white;
  position: absolute;z-index: 1;
}
</style>
<body style="background-color:#F6F6F6; height: 100%;">
<div class="menu">
  <p class="menuLine">
    <a href="/">메인화면</a>
    <a href="/Board/GameList?pageNum=1&contentNum=30">게임 리스트</a>
    <a href="/RecomGameList?u_id=${login.u_id }&genre1=${login.genre1}&genre2=${login.genre2}&genre3=${login.genre3}">게임 추천</a>
    <a href="/totalList?menu_id=1&pageNum=1&contentNum=30">전체게시판</a>
    <a href="/managementList?menu_id=3&pageNum=1&contentNum=30">공지사항</a>
    <a href="/managementList?menu_id=4&u_id=${login.u_id}&authority=0&pageNum=1&contentNum=30">고객센터</a>
    <c:set var="admin" value="${login}"/>
    <c:if test="${admin.authority eq '0'}">
      <a href="/declarationList">관리페이지</a>
      <a href="/GameListInsert">게임목록db에 넣기</a>
    </c:if>
  </p>
</div>
</body>