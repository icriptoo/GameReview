<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
nav{
    font-size: 12pt;
    font-family: 'PT Sans', Arial, Sans-serif;
    position: relative;
}
nav ul{
    padding: 0;
    margin: 0 auto;
    width: auto;
}
nav li{
}
nav a{
    line-height: 50px;
  height: 50px;
}
nav li a{
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
}
nav li:last-child a{
    border-right: 0;
    }
nav a:hover, nav a:active{
}
nav a#pull{
    display: none;
}
html {
  -webkit-touch-callout:none;
  -webkit-user-select:none;
  -webkit-tap-highlight-color:rgba(0, 0, 0, 0);
}
li.asd{
  /*position: relative;*/
  display: inline-block;
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
  width: 5000px;
  height: 50px;
  text-align: center;
  max-width: 100%;
  background-position: center;
  background-size: cover;
  background-color: #333333;color: white;
  position: absolute;z-index: 1;
}
</style>

<body style="background-color:#F6F6F6">
<div class="menu">
  <nav class="clearfix">
    <ul class="clearfix">
      <li class="asd"><a href="/">메인화면</a></li>
      <li class="asd"><a href="/Board/GameList?pageNum=1&contentNum=30">게임 리스트</a></li>
      <li class="asd"><a href="/RecomGameList?u_id=${ sessionScope.login.u_id }">게임 추천</a></li>
      <li class="asd"><a href="/totalList?menu_id=1&pageNum=1&contentNum=30">전체리뷰게시판</a></li>
      <li class="asd"><a href="/totalList?menu_id=2&pageNum=1&contentNum=30">전체자유게시판</a></li>
      <li class="asd"><a href="/managementList?menu_id=3&pageNum=1&contentNum=30">공지사항</a></li>
      <li class="asd"><a href="/supportList?menu_id=4&pageNum=1&contentNum=30">고객센터</a></li>
      <c:set var="admin" value="${login}"/>
      <c:if test="${admin.authority eq '0'}">
        <li class="asd"><a href="/">신고관리</a></li>
        <li class="asd"><a href="/GameListInsert">게임목록db에 넣기</a></li>
      </c:if>
    </ul>
  </nav>
</div>
</body>
<script>
</script>