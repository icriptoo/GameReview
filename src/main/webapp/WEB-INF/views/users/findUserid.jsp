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
  height: 280px;
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
  margin: 9px auto;
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
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

function goChangePasswd(){}

$(function(){

    $('#findUserid').on('click', function(e){

        let nickname = $('#nickname').val();
        let email = $('#email').val();

        $.ajax({
            type : 'POST',
            url : "getUserid",
            dataType : "text",
            data : {
                nickname : nickname,
                email : email},
            success : function(getUserid){
            console.log(getUserid)
                if (getUserid =="닉네임과 이메일을 다시 확인해주세요"){
                    $("#userid_check").html(getUserid);
                } else {
                    let changePasswd = "";
                    changePasswd += '<input type="hidden" name="userid" value=' + getUserid + '></input>';
                    changePasswd += "userid: " + getUserid;
                    $("#userid_check").html(changePasswd);
                }
            }
        })
        e.preventDefault();
        e.stopPropagation();
    })
});

</script>
</head>
<body>
<div id="container">
    <header >
        <h1>ID 찾기</h1>
    </header>
        <form>
            <input id="nickname" name="nickname" type="text" placeholder="NickName">
            <input id="email" name="email" type="text" placeholder="Email">
            <input type="button" class="button"id="findUserid" value="아이디 찾기">
        </form>
        <form action="/changePasswdForm" method="POST">
            <button type="submit" class="button" id="changePasswd" style="margin: 9px auto;">비밀번호 변경</button>
            <span id="userid_check" style="margin-bottom:10px; margin-left:40px; color:#efe2c9; font-size:15px;"></span>
        </form>
</div>


</body>
</html>


