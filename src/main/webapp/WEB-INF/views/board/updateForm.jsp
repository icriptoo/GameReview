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
	width: 20%;
	height: 100%;
}
.leftAside {
	float: left;
	width: 20%;
	height: 100%;
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
<body>
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
  <form action = "/boardUpdate?place=${place}" method="POST" id="form1">
    <input type="hidden" name="menu_id" value="${boardVo.menu_id}" />
    <input type="hidden" name="u_id" value="${login.u_id}" />
    <input type="hidden" name="g_idx" value="${boardVo.g_idx}" />
    <input type="hidden" name="b_idx" value="${boardVo.b_idx}" />
    <input type="hidden" name="authority" value="${authority}" />
  <table >
      <c:choose>
        <c:when test="${menu_id eq 4}">
          <c:choose>
            <c:when test="${login.authority eq 0}">
            <tr>
              <th style= "width:6%; height:10%; text-align:center">제목</th>
              <td>${boardVo.title}</td>
              <input  type="hidden" name="title" id="title" style="width:1000px ;font-size:15px;" value="${boardVo.title}" />
            </tr>
            <tr>
              <th style="text-align:center">내용</th>
              <td>${boardVo.cont}</td>
              <input  type="hidden" name="cont" id="cont" style="width:1000px;height:400px;font-size:15px;" value="${boardVo.cont}" />
            </tr>
            <tr>
              <th style="text-align:center">답변내용</th>
              <td><input  type="text" name="a_cont" id="a_cont" style="width:1000px;height:400px;font-size:15px;"/></td>
            </tr>
            </c:when>
            <c:otherwise>
              <tr>
                <th style= "width:6%; height:10%; text-align:center">제목</th>
                <td>${boardVo.title}</td>
                <input  type="hidden" name="title" id="title" style="width:1000px ;font-size:15px;" value="${boardVo.title}" />
              </tr>
              <tr>
                <th style="text-align:center">내용</th>
                <td><input  type="text" name="cont" id="cont" style="width:1000px;height:400px;font-size:15px;" value="${boardVo.cont}" /></td>
              </tr>
            </c:otherwise>
          </c:choose>
        </c:when>
        <c:otherwise>
          <tr>
            <th style= "width:6%; height:10%; text-align:center">제목</th>
            <td><input  type="text" name="title" id="title" style="width:1000px ;font-size:15px;" value="${boardVo.title}" /></td>
          </tr>
          <tr>
            <th style="text-align:center">내용</th>
            <td><input  type="text" name="cont" id="cont" style="width:1000px;height:400px;font-size:15px;" value="${boardVo.cont}" /></td>
          </tr>
        </c:otherwise>
      </c:choose>
      <c:choose>
      <c:when test="${menu_id eq 1}">
      <tr>
        <th style=" height:10%; text-align:center">평점</th>
        <td style="font-size:20px;">
          <select name="r_score" id="r_score">
            <option value="${boardVo.r_score}" selected>${boardVo.r_score}</option>
            <option value=1.0>1.0</option>
            <option value=2.0>2.0</option>
            <option value=3.0>3.0</option>
            <option value=4.0>4.0</option>
            <option value=5.0>5.0</option>
            <option value=6.0>6.0</option>
            <option value=7.0>7.0</option>
            <option value=8.0>8.0</option>
            <option value=9.0>9.0</option>
            <option value=10.0>10.0</option>
          </select>
        </td>
      </tr>
      </c:when>
      <c:otherwise>
        <input type="hidden" name="r_score" value="0" />
      </c:otherwise>
      </c:choose>
      <tr>
        <td style="height:10%; text-align:center" colspan="2">
          <input type="submit" value="저장" style="width:80px; height:40px; font-size:20px; float: center" />
          </td>
      </tr>
  </table>
  </form>
</div>
</body>
</html>
