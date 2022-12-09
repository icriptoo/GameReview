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
        #top_box{
            width:230px;
            height:250px;
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
        #id_pass,#login_btn{
            display:inline-block;
            vertical-align:top;
        }
        #id_pass span{
            display: inline-block;
            width:20px;
        }
        #pass{
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
        <div id="top_box">
            <h3>인기순위 Top10</h3>
            <a href="">1.  리그오브레전드 </a><br>
            <a href="">2.  리그오브레전드 </a><br>
            <a href="">3.  리그오브레전드 </a><br>
            <a href="">4.  리그오브레전드 </a><br>
            <a href="">5.  리그오브레전드 </a><br>
            <a href="">6.  리그오브레전드 </a><br>
            <a href="">7.  리그오브레전드 </a><br>
            <a href="">8.  리그오브레전드 </a><br>
            <a href="">9.  리그오브레전드 </a><br>
            <a href="">10. 리그오브레전드 </a>

        </div>
    </form>
</body>
</html>