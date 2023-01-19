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
<script>

$(document).ready(function() {
    $.ajax({
        url : "/topGame",
        type : "POST",
        data : "",
        success : function(data){
            var text = "";
            console.log(data);
            var g_idx =  JSON.stringify(data[0].g_idx);
            var g_name =  JSON.stringify(data[0].g_name);
            console.log(g_idx + g_name);
            for (var i = 1; i < 11; i++){
                text += "<a href='/GameReviewList?g_idx=" + data[i-1].g_idx +"&menu_id=1&pageNum=1&contentNum=30'>"+ i + ".  " + data[i-1].g_name + "</a><br>"
            }
            $('#show').html( text );
        },
        error : function() {
            alert("요청실패");
        }
    })
});

</script>
<body>
    <form>
        <div id="top_box">
            <h3>인기순위 Top10</h3>
            <p id="show"></p>
        </div>
    </form>
</body>
</html>