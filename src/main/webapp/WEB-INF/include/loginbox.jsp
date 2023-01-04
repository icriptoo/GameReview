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
    margin:10px 0 0 10px;
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
#id,#login_btn{
    display:inline-block;
    vertical-align:top;
}
#id span{
    display: inline-block;
    width:20px;
}
#pw{
    margin-top:3px;
}
#login_btn button{
    margin-left:5px;
    padding:12px;
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
</style>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

var next = document.location.href;

function loginbtn(){
  var url = "/login?next=" + next;
  location.href = url;
}

function logoutbtn(){
  let out = confirm("로그아웃을 하시겠습니까?");
  if (out){
    var url = "/logout?next=" + next;
    location.href = url;
  }
}

</script>
</head>
<body>
<div id="login_box">
  <c:set var="img" value="${login.img}"/>
  <c:choose>
    <c:when test="${empty login}">
      <h2>Member-Login</h2>
      <ul id="input_button">
        <br>
        <li id="login_btn">
          <input type="hidden" name="next" value="">
          <button class="login" onclick="loginbtn()" style="font-size:15px;">로그인</button>
          <a class="signup" href="/signupform" style="font-size:15px;">회원가입</a>
        </li>
      </ul>
      <ul id="btns">
        <a href="javascript:void(window.open('/findUseridform', '아이디 찾기','width=700, height=700'))" style="font-size:15px;">아이디 찾기</a> /
        <a href="javascript:void(window.open('/findPasswordform', '비밀번호 변경','width=700, height=700'))" style="font-size:15px;">비밀번호 변경</a>
      </ul>
    </c:when>
    <c:otherwise>
      <c:choose>
        <c:when test="${img eq null}">
          <p><img src="/img/userProfile/default/default.png" class="w3-circle" alt="UserProfile" style="width : 50%"/></p>
        </c:when>
        <c:otherwise>
          <p><img src="/img/userProfile/${login.u_id}/${login.img}" class="w3-circle" alt="UserProfile" style="width : 50%"/></p>
        </c:otherwise>
      </c:choose>
      <h4>${login.n_name}님</h4>
      <ul>
        <li>
          <button class="logout" onclick="logoutbtn()" style="font-size:15px;">로그아웃</button>
        </li>
          <a class="mypagebt" href="/mypage" style="font-size:15px;">마이페이지</a>
      </ul>
    </c:otherwise>
  </c:choose>
</div>
<script>
</script>
</body>
</html>