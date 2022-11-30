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
  <a class ="o" href="/index" class="w3-bar-item w3-button">메인</a>
  <a class ="o" href="/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10" class="w3-bar-item w3-button">해주세요</a>
  <a class ="o" href="/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10" class="w3-bar-item w3-button">할게요</a>
  <a class ="o" href="/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10" class="w3-bar-item w3-button">후기</a>
  <a class ="o" href="/logout" class="w3-bar-item w3-button">로그아웃</a>
  <strong><a class ="o" href="/getUser" class="w3-bar-item w3-button">내 정보</a></strong>
</div>