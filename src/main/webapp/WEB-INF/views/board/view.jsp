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
table {
  width: 1100px;
  height: 500px;
  background-color: #c0c0c0;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
td, th {
  border : 1px solid black;
  border-collapse : collapse;
};


</style>
</head>

<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Game List</b></h1>
</header>

<div style="width: 100%; height: 500px; ">
  <div>
    <aside class="leftAside">
      <h1></h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>

  <table >

      <tr>
        <th style= "width:6%; height:10%; text-align:center">제목</th>
        <td>${boardVo.title}</td>
      </tr>
      <tr>
        <th style= "width:6%; height:10%; text-align:center">작성자</th>
        <td>${boardVo.u_id}</td>
      </tr>
      <tr>
          <th style="text-align:center">내용</th>
          <td>${boardVo.cont}</td>
      </tr>
      <c:if test="${menu_id eq 1}">
        <tr>
          <th style=" height:10%; text-align:center">평점</th>
          <td style="font-size:20px;">${boardVo.r_score}</td>
        </tr>
      </c:if>
      <tr>
        <td style="height:10%; text-align:right" colspan="2">
          <c:if test="${boardVo.u_id eq sessionScope.login.u_id}">
            <button style="font-size:20px;" onClick="location.href='/updateForm?menu_id=${boardVo.menu_id}&b_idx=${boardVo.b_idx}'" >수정</button>
            <button style="font-size:20px;" onClick="location.href='/boardDelete?g_idx=${boardVo.g_idx}&menu_id=${boardVo.menu_id}&b_idx=${boardVo.b_idx}'" >삭제</button>
          </c:if>
          <button style="font-size:20px;" onClick="location.href='/GameReviewList?g_idx=${boardVo.g_idx}&menu_id=${boardVo.menu_id}'" >목록으로</button>
          </td>
      </tr>
  </table>

</div>

</body>
</html>
