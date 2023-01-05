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
      <c:set var="img" value="${user.img}"/>
      <c:choose>
        <c:when test="${img eq null}">
          <p><img src="/img/userProfile/default/default.png" class="w3-circle" alt="UserProfile" style="width : 100%"/></p>
        </c:when>
        <c:otherwise>
          <p><img src="/img/userProfile/${user.u_id}/${user.img}" class="w3-circle" alt="UserProfile" style="width : 100%"/></p>
        </c:otherwise>
      </c:choose>
      <p><a href="/user/profilupdateform">내 정보 수정</a></p>
      <p><a href="javascript:void(window.open('/findPasswordform', '비밀번호 변경','width=700, height=700'))">비밀번호 변경</a></p>
      <p><a href="javascript:void(window.open('/user/profileupdateform', '프로필 사진 수정','width=700, height=700'))">프로필 사진 수정</a></p>
      <p><a href="/myboard?pageNum=1&contentNum=30&menu_id=1">내 게시글보기</a></p>
      <p><a href="/user/WithdrawalForm">회원탈퇴</a></p>
    </div>
    <div class="mypagein">
      <p>&nbsp;&nbsp;&nbsp;&nbsp;아이디 : ${user.u_id}</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;닉네임 : ${user.n_name}</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;이메일 : ${user.email}</p>
      <p>선호 장르1 : ${login.genre1}</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장르2 : ${user.genre2}</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장르3 : ${user.genre3}</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;가입일 : ${user.indate}</p>
    </div>
  </div>
</div>
<script>
console.log(${user});
</script>
</body>
</html>
