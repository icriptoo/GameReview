<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
*{
    margin:0;
    padding:0;
}
ul{
    list-style-type: none;
}
body{
    font-family: "맑은 고딕","돋움";
    font-size:12px;
    color:#444444;
}
#login_box{
    width:230px;
    height:270px;
    border:solid 1px #bbbbbb;
    border-radius: 15px;
    margin-top: 15%;
    margin-left: 45%;
    padding:10px 0 0 15px;
}
h2{
    font-family:"Arial";
    margin-bottom:10px;
}
#login_box input{
    width:100px;
    height:18px;
}
#id{
    display:inline-block;
    vertical-align:top;
}
#login_btn {
    padding-left: 25px;
}
#input_login {
    padding-left: 10px;
}
#id span{
    display: inline-block;
    width:20px;
}
#pw{
    margin-top:3px;
}
.login{
    margin-left:5px;
    padding:5px;
    border-radius: 5px;
}
#btns{
    margin:12px 0 0 0;
    text-decoration: underline;
}
#btns li{
    margin-left: 10px;
    display:inline;
}
#box {
    width: 100%;
    height: 100%;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
function checkSpacebar(){
  let kcode = event.keyCode;
  if(kcode == 32) event.returnValue = false;
}
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
    if($('[name=u_id]').val()==''){
      alert('아이디를 입력하세요');
      return false;
    }
    if($('[name=pw]').val()==''){
      alert('비밀번호를 입력하세요');
      return false;
    }
  });
});

</script>
</head>
<body>
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Game List</b></h1>
</header>
<div id="box">
  <div id="login_box">
    <h2>Member-Login</h2>
    <form action="/loginProcess" method="POST" onsubmit="return ture">
      <ul id="input_login">
        <li id="u_id">
          <ul>
            <li>
              <input type="text" name="u_id" placeholder="ID" style="width:180px;height:30px;font-size:15px;" maxlength="20" onkeydown="checkSpacebar();"/>
            </li>
            <li id="pw">
              <input type="password" name="pw" placeholder="PW" style="width:180px;height:30px;font-size:15px;" maxlength="15" onkeydown="checkSpacebar();"/>
            </li>
          </ul>
        </li>
        <br>
      </ul>
      <p id="login_btn">
        <button onclick="loginbtn()" class="login" style="font-size:15px;">로그인</button>
        <a class="signup" href="/signupform" style="font-size:15px;">회원가입</a>
      </p>
      <ul id="btns" style="text-decoration-line: none;">
        <a href="javascript:void(window.open('/findUseridform', '아이디 찾기','width=600, height=400'))" style="font-size:15px;">아이디 찾기</a> /
        <a href="javascript:void(window.open('/findPasswordform', '비밀번호 변경','width=750, height=550'))" style="font-size:15px;">비밀번호 찾기</a>
      </ul>
    </form>
  </div>
</div>
<script>
</script>
</body>
</html>