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
	height: 2000px;
}
ul{
    list-style:none;
}
.eGName{
    color:#c0c0c0;
}
table.a {
  width: 800px;
  height: 500px;
  background-color: #c0c0c0;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
table.b {
  width: 800px;
  height: 100px;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
table.a td, th {
  border : 1px solid black;
  border-collapse : collapse;
}
table.b tr {
  border : 1px solid black;
  border-collapse : collapse;
}
table.b td {
  border : 1px solid black;
  border-collapse : collapse;
}
textarea {
  width: 50%;
  max-height: 500px;
  border: none;
  resize: none;
}
</style>

</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
  <h1 class="headerB"><b>Game List</b></h1>
</header>
<div>
  <div>
    <aside class="leftAside">
      <h1>left</h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <table class="a">
    <div>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">분류</th>
        <td>${title}</td>
      </tr>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">신고대상</th>
        <td>${detail.ue_id}</td>
      </tr>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">관련게시글</th>
        <td>
          <a  href="/View?b_idx=${detail.b_idx}&pageNum=1&contentNum=30" target='_blank' style="font-size:15px;" >게시글보기</button>
        </td>
      </tr>
      <tr>
        <th style="text-align:center">신고내용</th>
        <td>${detail.cont}</td>
      </tr>
      <tr>
        <th style="width:8%; height:10%; text-align:center">신고자</th>
        <td>${detail.us_id}</td>
      </tr>
      <tr>
        <th style="width:8%; height:10%; text-align:center">신고처리</th>
        <td>
          <button style="font-size:20px;" onClick="location.href='/declarationProcess?d_idx=${detail.d_idx}&process=1'" >접수</button>
          <button style="font-size:20px;" onClick="location.href='/declarationProcess?d_idx=${detail.d_idx}&process=2'" >거부</button>
        </td>
      </tr>

      <tr>
        <td style="height:10%; text-align:right" colspan="2">
          <button style="font-size:20px;" onClick="location.href='/declarationList'" >목록으로</button>
        </td>
      </tr>
    </div>
  </table>
</div>
</body>
<script>
</script>
</html>
