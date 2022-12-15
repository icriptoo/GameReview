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

.mypage{
  height: 800px;
  border: 1px solid #000;
  border-radius: 10px;
  text-align: center;
  margin: 50px 450px 0px 350px;
  background-color: #fff;

}
.mypagein{
  width: 500px;
  height: 600px;
  border: 1px solid #000;
  border-radius: 10px;
  text-align: left;
  padding: 40px 40px;
  font-family:'d2coding';
  float:left;
}
.profile{
  width: 100px;
  height: 100px;
  float:left;
}
</style>
<script>
function update(){
  var url = "/user/profilupdate?n_name="
  var name = $('input[name=name]').val();
  var email = $('input[name=email]').val();
  var genre1 = $('input[name=genre1]').val();
  var genre2 = $('input[name=genre2]').val();
  var genre3 = $('input[name=genre3]').val();
  var pq = $('input[name=pq]').val();
  var pa = $('input[name=pa]').val();
  var u_id = $('input[name=u_id]').val();;
  var pw = $('input[name=pw]').val();;
  location.href = url + name + "&email=" + email + "&genre1=" + genre1 + "&genre2=" + genre2 +"&genre3=" + genre3 + "&p_q=" + pq + "&p_a=" + pa + "&u_id=" + u_id + "&pw=" + pw;
}
function back(){
  location.href = "/user/mypage";
}
</script>
</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Game List</b></h1>
</header>
<div style="width: 100%; height: 500px;  ">
  <div>
    <aside class="leftAside">
      <h1>왼쪽사이드</h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <div class="mypage">
    <div class="profile">
      <p><img src="/img/userProfile/${login.u_id}/${login.img}" class="w3-circle" alt="UserProfile" style="width : 100%"/></p>
      <button name="update" onclick="update()">수정완료</a>
      <button name="update" onclick="back()">취소하기</a>
    </div>
    <div class="mypagein">
      <input type="hidden" name="pw" value="${login.pw}">
      <p>&nbsp;&nbsp;&nbsp;&nbsp;아이디 : <input type="text" name="u_id" value="${login.u_id}" disabled></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;닉네임 : <input type="text" name="name" value="${login.n_name}"> <button name="nameck" onclick="nameck()">중복확인</button></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;이메일 : <input type="text" name="email" value="${login.email}"> <button name="emailck" onclick="emailck()">인증번호전송</button></p>
      <p>&nbsp;&nbsp;인증번호 : <input type="text" name="emailcode"></p>
      <p>선호 장르1 : <input type="text" name="genre1" value="${login.genre1}"></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장르2 : <input type="text" name="genre2" value="${login.genre2}"></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장르3 : <input type="text" name="genre3" value="${login.genre3}"></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 찾기에 사용 할 질문 및 답변</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;질문 : <input type="text" name="pq" value="${login.p_q}"></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;답변 : <input type="text" name="pa" value="${login.p_a}"></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;가입일 : ${login.indate}</p>
    </div>
  </div>
</div>
<script>
console.log(${login});
</script>
</body>
</html>
