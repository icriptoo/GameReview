<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>Banana Quick</title>
<style>

</style>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function() {
    let message = "${fail}";
    if (message != "") {
        alert(message);
    }else {
        pass;
    }
})

$(function(){
    $('form').on('submit',function(e){

        if($('[name=userid]').val()==''){
            alert('아이디를 입력하세요');
            return false;
        }
        if($('[name=passwd]').val()==''){
            alert('비밀번호를 입력하세요');
            return false;
        }
    });
});

</script>
</head>
<body>
<ul>
  <h1>Log In</h1>
  <form action="/loginProcess" method="POST">
    <li><input type="text" id="userid" name="userid" placeholder="id"></li>
    <li><input type="password" id="passwd" name="passwd"  placeholder="Password"></li>
    <li><button class="login"> Log In </button></li>
    <div id="remember-container">
      <span class="forgotten">
        <li>
          <a class="forgotten" href="/writeForm">회원가입하기</a>
          <a class="forgotten" href="javascript:void(window.open('findUserid', '아이디 찾기','width=500, height=500'))">아이디 찾기/비밀번호 변경</a>
        </li>
      </span>
    </div>
  </form>
</ul>
</body>
</html>