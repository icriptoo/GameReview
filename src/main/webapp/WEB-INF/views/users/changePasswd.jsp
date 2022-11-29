<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<style>
html {
   background-color: rgb(30, 38, 78);
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  overflow: hidden;
}

#login-button{
  cursor: pointer;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  padding: 30px;
  margin: auto;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: rgba(0, 0, 0, 0.8);
  overflow: hidden;
  opacity: 0.4;
  box-shadow: 10px 10px 30px #000;}

/* Login container */
#container{
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  width: 400px;
  height: 400px;
  border-radius: 5px;
  background: rgb(65, 80, 145);
  box-shadow: 1px 1px 50px rgb(131 193 221);
}
/* Heading */
h1{
  font-family: 'Open Sans Condensed', sans-serif;
  position: relative;
  margin-top: 0px;
  text-align: center;
  font-size: 30px;
  color: #ddd;
}

/* Inputs */
input{
  font-family: 'Open Sans Condensed', sans-serif;
  text-decoration: none;
  position: relative;
  width: 80%;
  display: block;
  margin: 9px 40px;
  font-size: 17px;
  color: #fff;
  padding: 8px;
  border-radius: 6px;
  border: none;
  background: rgba(3,3,3,.1);
  -webkit-transition: all 2s ease-in-out;
  -moz-transition: all 2s ease-in-out;
  -o-transition: all 2s ease-in-out;
  transition: all 0.2s ease-in-out;
}

input:focus{
  outline: none;
  box-shadow: 3px 3px 10px #333;
  background: rgba(3,3,3,.18);
}

/* Placeholders */
::-webkit-input-placeholder {
   color: #ddd;  }
:-moz-placeholder { /* Firefox 18- */
   color: red;  }
::-moz-placeholder {  /* Firefox 19+ */
   color: red;  }
:-ms-input-placeholder {
   color: #333;  }

/* Link */
.login{
  font-family: 'Open Sans Condensed', sans-serif;
  text-align: center;
  padding: 4px 8px;
  background: rgba(107,255,3,0.3);
}

.login:hover{
  opacity: 0.7;
}

#remember-container{
  position: relative;
  text-align: center;
  margin: -5px 20px;
}

#remember{
  position: absolute;
  font-size: 13px;
  font-family: 'Hind', sans-serif;
  color: rgba(255,255,255,.5);
  top: 7px;
  left: 20px;
}


.button{
  font-family: 'Open Sans Condensed', sans-serif;
  text-decoration: none;
  position: relative;
  width: 40%;
  display: block;
  margin-bottom: 9px;
  font-size: 17px;
  color: #fff;
  padding: 8px;
  border-radius: 6px;
  border: none;
  background: rgba(3,3,3,.1);
  -webkit-transition: all 2s ease-in-out;
  -moz-transition: all 2s ease-in-out;
  -o-transition: all 2s ease-in-out;
  transition: all 0.2s ease-in-out;
}

.button{
  font-family: 'Open Sans Condensed', sans-serif;
  text-align: center;
  padding: 4px 8px;
  background: rgba(107,255,3,0.3);
}

.button:hover{
  opacity: 0.7;
}

</style>
<script>
let a = 0;

function sendPhoneNumber(){
    let phoneNumber =$('#phoneNumber').val();
    let ac = "${numStr}";

   console.log(phoneNumber);
   let param = {"to":phoneNumber, "text":ac}
     $.ajax({
       type:"post",
       url:"YA",
       data:param,
       success:function(result){
         $('#check').click(function(){
           let certification =$('#certification').val();

           if(ac == certification){
            alert("인증 성공함");
            a=1;
            }else{
            alert("인증 실패함")
            a=2;
            }
         })
       }
     })

}



$(function (){

    $('#passwd').keyup(function(){
        $("#passwdDoubleCheck").empty();
    })

    $('#passwdCheck').on('focusout', function(e){
        let passwd = $('#passwd').val();
        let passwdCheck = $('#passwdCheck').val();
        let userid = $('[name=userid]').val();


        let passwdChange = ""
        if( a==0){
        alert('당신! 인증번호 체크는 하셨나요?')}
        if( a==2){
        alert('거 인증번호 체크 다시 하고 오랑께')}

        if( a==1){
            if(passwdCheck != ""){
                if (passwd == passwdCheck){
                    passwdChange += "<div>";
                    passwdChange += "<p>비밀번호 확인 완료</p>";
                    passwdChange += "</div>";
                    passwdChange += '<input type="hidden" name="userid" value=' + userid + '></input>';
                    passwdChange += '<button class="button" type="submit" id="send">비밀번호변경</input>';
                    passwdChange += '</form>';
                    $("#passwdDoubleCheck").html(passwdChange);
                } else {
                    alert('비밀번호를 다시 확인하세요.')
                    return false;
                }
            }
        }
    })
});

</script>
</head>
<body>
<div id="container">
    <header>
        <h1>비밀번호 변경</h1>
    </header>
    <c:if test="${userVo.userid != null}">
        <input type="hidden" name="userid" value="${userVo.userid}" placeholder="userid"></input>
    </c:if>
    <c:if test="${userVo.userid == null}">
        <input type="text" name="userid" placeholder="userid"></input>
    </c:if>
    <div>
        <div style="height: 40px;">
            <input id="phoneNumber" type="text" placeholder="휴대전화" style="width:200px;margin-right: 0px;">
            <button class="button" type="submit" onclick="sendPhoneNumber()" style="width: 113px;font-size:15px;margin-right: 40px;margin-left: 250px;bottom: 45px;">인증번호 발송</button>
        </div>
        <div style="height: 40px;">
            <input id="certification" type="text" placeholder="인증번호" style="width:200px;margin-right: 0px;"></input>
            <button class="button" type="submit" id="check" onclick="CheckPhoneNumber()" style="width: 113px;font-size:15px;margin-right: 40px;margin-left: 250px;bottom: 45px;">인증번호 확인</button>
        </div>
        <form action="/changePasswd" id="changePasswd">
        <input id="passwd" name="passwd" type="password" placeholder="password"></input>
        <input id="passwdCheck" type="password" placeholder="password check"></input>
        <div id="passwdDoubleCheck" style="margin-bottom:10px; margin-left:40px; color:#efe2c9; font-size:15px;"></div>
    </div>
</div>
</body>
</html>