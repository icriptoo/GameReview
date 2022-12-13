<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
        #ID,#login_btn{
            display:inline-block;
            vertical-align:top;
        }
        #ID span{
            display: inline-block;
            width:20px;
        }
        #PW{
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
</head>
<body>
    <form>
        <div id="login_box">
            <h2>Member-Login</h2>
            <ul id="input_button">
                <li id="ID">
                    <ul>
                        <li>
                            <input type="text" placeholder=" ID" style="width:180px;height:30px;font-size:15px;">
                        </li>
                        <li id="PW">
                            <input type="text" placeholder=" PW" style="width:180px;height:30px;font-size:15px;">
                        </li>
                    </ul>
                </li>
                <br><br>
                <li id="login_btn">
                <button style="font-size:15px;">로그인</button>
                <button style="font-size:15px;">회원가입</button>
                </li>
            </ul>
            <ul id="btns">
                <a href="javascript:void(window.open('findUserid', '아이디 찾기','width=500, height=500'))" style="font-size:15px;">아이디찾기 / 비밀번호 변경</a>
            </ul>

        </div>
    </form>
</body>
</html>