<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.o{
margin-left:5px;
margin-right:5px;
font-size: 19px;
}
.oo {
text-align:right;
}
</style>

<div class = "oo" id="mySidebar"  style= "background-color:#FFF">
  <a class ="o" href="/home" class="w3-bar-item w3-button">메인</a>
  <a class ="o" href="/GameListInsert" class="w3-bar-item w3-button">게임목록db에 넣기</a>
  <a class ="o" href="/Board/GameList?pageNum=1&contentNum=30" class="w3-bar-item w3-button">게임 리스트</a>

</div>