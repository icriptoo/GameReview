<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/common.css">
<style>
form{
    display:inline
}

.button-getUser:hover{
  opacity: 0.7;
}

.button-getUser{
        text-align: center;
        margin: auto 3px;
        font-size: 15px;
        background-color: rgba(107,255,3,0.3);
        color: #212529;
        border: none;
        border-width: 1px;
        border-radius: 15px;
        padding: 5px;
     }

html{
   background-color: rgb(30, 38, 78);
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  overflow: hidden;
}

p {
    color:#efe2c9;
    font-family : "Segoe UI",Arial,sans-serif;
    font-size : 18px;
}

#container{
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  width: 400px;
  height: 300px;
  border-radius: 5px;
  background: rgb(65, 80, 145);
  box-shadow: 1px 1px 50px rgb(131 193 221);
}
.button-getUser:link{color:#efe2c9; text-decoration:none;}
.button-getUser:visited{color:#efe2c9; text-decoration:none;}
.button-getUser:hover{color:#efe2c9; text-decoration:none;}
.button-getUser:active{color:#efe2c9; text-decoration:none;}
</style>

</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="w3-xxxlarge"><b>Banana Quick</b></h1>
    <h6><span class="w3-tag">delivery's world</span></h6>
</header>

<div id="container" style="text-align:center;width: 900px;height: 450px;">

    <div class="w3-row-padding">

        <div class="w3-third">
        <img src="/img/userProfile/${userVo.userid}/${filesVo.sFileName}" alt="UserProfile" style="height: 300px;width: 300px;border-radius: 50%;border: 1px solid #272133;margin-top: 40px;margin-left: 40px;margin-bottom: 40px;margin-right: 40px;">
        </div>

        <div class="w3-twothird">
            <p> ID : ${userVo.userid} </p>
            <p> NICKNAME : ${userVo.nickname}</p>
            <p> EMAIL : ${userVo.email}</p>
            <p> LOCAL : ${userVo.user_local}</p>
            <p> RIDER : ${userVo.rider}</p>
            <p> INDATE : ${userVo.indate}</p>
            <p> PHONENUMBER : ${userVo.phoneNumber}</p>
            <p>
                <a href="/updateForm" class="button-getUser"
                  enc-type="multipart/form-data"> <strong>회원정보 수정</strong> </a>
                <a href="/delete" class="button-getUser"><strong>회원탈퇴</strong</a>
                <a href="javascript:void(window.open('pds/profileUpdateForm', '아이디 찾기','width=500, height=500'))" class="button-getUser"><strong> 프로필 사진 업데이트</strong></a>
            </p>
            <div>
                <form action="/myWritePage" method="GET">
                    <input type="hidden" name="nickname" value="하늘">
                    <button type="submit" class="button-getUser" style="color:#efe2c9;"><strong>내 게시글 보기 </strong></button>
                </form>
                <form action="/myReplyPage" method="GET">
                    <input type="hidden" name="nickname" value="하늘">
                    <button type="submit" class="button-getUser" style="color:#efe2c9;"> <strong>내 댓글 보기</strong> </button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
