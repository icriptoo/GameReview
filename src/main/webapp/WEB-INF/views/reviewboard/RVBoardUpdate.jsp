<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<link rel="stylesheet" href="/css/common.css" />
<style>
  body {

      padding-top: 70px;

      padding-bottom: 30px;

    }

    #title{
      width: 1000px;
      margin-left: 100px;
    }

    #c_start{
      width: 300px;
      margin-left:100px;
      display: inline-block

    }
    #c_end{
      width:300px;

      display: inline-block
    }
    #delivery_indate{
      width:300px;
      display: inline-block

    }
    #money{
      width: 300px;
      margin-left:100px;
      display: inline-block

    }
    #luggage{
      width: 300px;
      display: inline-block
    }
    #cont{
      margin-left:100px;
      width: 1500px;
      height: 500px;
    }
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div id="main">
    <form action="/Board/RVBoardUpdate" method="POST">
    <input type="hidden" name="board_number" value="${ reviewVo.board_number}" />
    <input type="hidden" name="menu_id" value="${ menu_id } " />

    <table  id="boardUpdate">
    <label for="title"></label>

         <input type="text" class="form-control wid1" name="title" id="title" value="${ reviewVo.title}" placeholder="제목을 입력해 주세요">
          </div>
          <div class="mb-3">

        <label for="cont"></label>

        <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" >${ reviewVo.cont}</textarea>

        </div>
         <div>
          <input class = "btn btn-sm btn-primary" type="submit" value="저장" />
         </div>
         </form>
       </div>
</body>
</html>














