<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<style>
body {
  padding-top: 70px;
  padding-bottom: 30px;
}
#title{
  width: 1200px;
  margin-top:10px;
  margin-left: 50px;
}
#cont{
  margin-left: 50px;
  width: 1500px;
  height: 500px;
}
.zz{
border-bottom:1px solid #ccc!important;
margin-left: 50px;
}
h2{
font-family:"S-Core Dream 6"!important;
}
.big{
border:1px solid #ccc!important;
margin:150px 100px 100px 150px;
}
</style>

</head>
<body class="w3-light-grey" style= "padding-top: 0px;">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
   <h1 class="w3-xxxlarge"><b>Banana Quick</b></h1>
   <h6><span class="w3-tag">delivery's world</span></h6>
</header>
<div class="big">
     <div class ="zz">
        <h2>글쓰기</h2>
        </div>
     <form action="/Board/RVBoardWrite" method="POST">
     <input type = "hidden" name = "menu_id" value = "${menu_id}"/>
     <input type = "hidden" name = "writer" value= "${writer}"/>
     <input type = "hidden" name = "pageNum" value =  "${cPageNum}"/>
     <input type=  "hidden" name = "contentNum" value = "${cContentNum}"/>
        <label for="title"></label>
         <input type="text" class="form-control wid1" name="title" id="title" placeholder="제목을 입력해 주세요">
      <div class="mb-3">
                        <label for="cont"></label>
                        <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" ></textarea>
                      </div>
     <div>
      <input class = "btn btn-sm btn-primary" type="submit" value="저장" />
     </form>
   </div>
   </div>

</body>
</html>