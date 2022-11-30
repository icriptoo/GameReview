<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>


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
#c_start{
  width: 1000px;
  margin-left: 50px;
  margin-top:8px;
  display: inline-block
}
#c_end{
  width: 1000px;
  margin-left: 50px;
  margin-top:8px;
  display: inline-block
}
#delivery_indate{
  width: 1000px;
  margin-left: 50px;
  margin-top:8px;
}
#money{
  width: 1000px;
  margin-left: 50px;
  margin-top:8px;
  display: inline-block
}
#luggage{
  width: 1000px;
  margin-left: 50px;
  margin-top:8px;
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

<head>
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
                <form action="/Board/CBoardWrite" method="POST">
                <input type = "hidden" name = "menu_id" value = "${menu_id}"/>
                <input type = "hidden" name = "pageNum" value =  "${cPageNum}"/>
                <input type=  "hidden" name = "contentNum" value = "${cContentNum}"/>
                <input type = "hidden" name = "writer" value ="${writer}"/>
                <input type = "hidden" name = "board_local" value = "${board_local}"/>
              <label for="title"></label>
                <input type="text" class="form-control wid1" name="title" id="title" placeholder="제목을 입력해 주세요">
                <input type="text" class="form-control" name="c_start" id="c_start" placeholder="출발지:부산 북구"><br>
                <input type="text" class="form-control" name="c_end" id="c_end" placeholder="목적지:부산 진구"><br>
                <input type="text" class="form-control" name="delivery_indate" id="delivery_indate" placeholder="2012-12-12" >
                <input type="text" class="form-control" name="money" id="money" placeholder="비용">
                <input type="text" class="form-control" name="luggage" id="luggage" placeholder="컴퓨터" >
              <br>
              <br>
              <br>
               <div class="mb-3">
              <label for="cont"></label>
              <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" ></textarea>
               </div>
                 </br>
                   <input class = "w3-button w3-right w3-border w3-white" id = "boardwrite" type="submit" value="저장" />
                 </form>
               </div>

               <script>
               $(function(){
                   $('form').on('submit',function(e){

                       if($('[name=title]').val()==''){
                           alert('제목을 입력하세요');
                           return false;
                       }
                       if($('[name=c_start]').val()==''){
                           alert('출발지를 입력하세욧');
                           return false;
                       }
                       if($('[name=c_end]').val()==''){
                           alert('목적지를 입력하세요');
                           return false;
                       }
                       if($('[name=delivery_indate]').val()==''){
                            alert('일자를 입력하세요');
                            return false;
                                               }

                      if($('[name=cont]').val()==''){
                            alert('내용을 입력하세요');
                            return false;
                                                                                              }
                        if($('[name=money]').val()==''){
                             alert('비용을 입력하세요');
                             return false;
                                                }

                        if($('[name=luggage]').val()==''){
                              alert('수화물을 입력하세요');
                              return false;
                                          }
                   });
                   });
               </script>
</body>
</html>