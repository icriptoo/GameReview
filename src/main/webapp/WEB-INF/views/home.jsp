<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<title>게임리뷰</title>
<head>
<meta charset="UTF-8">
<!-- css -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.rightAside {
	float: right;
	width: 350px;
}
.leftAside {
	float: left;
	width: 350px;
	height: 2000px;
}
td {
    border: 1px solid;
}
.boardBox {
    width: 250px;
    height: 250px;
}
.GameListIn {
    border: 1px solid;
}
.genre a {
    border: 1px solid;
}
</style>
<script>
</script>
</head>
<!-- html 시작 -->
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-white" style="padding-top: 80px; padding-bottom: 80px;">
  <h1 class="headerB"><b>게임 리뷰 사이트</b></h1>
</header>
<div style="width: 100%; height: 500px;">
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
  <div style="width: 50%;">
    <table>
      <tr>
        <td class="boardBox">게임목록 <a class="plus" href="/Board/GameList?pageNum=1&contentNum=30">+더 보기</a>
          <div class="GameListIn">
            <select id="platform" name="platform" onchange="if(this.value) location.href=(this.value);">
              <option value="/Board/GameList?pageNum=1&contentNum=30" ${so == '0' ? 'selected="selected"' : '' }>플랫폼</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=1" ${so == '1' ? 'selected="selected"' : '' }>PC패키지</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=2" ${so == '2' ? 'selected="selected"' : '' }>PC온라인</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=3" ${so == '3' ? 'selected="selected"' : '' }>모바일</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=4" ${so == '4' ? 'selected="selected"' : '' }>PS</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=5" ${so == '5' ? 'selected="selected"' : '' }>XBOX</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=6" ${so == '6' ? 'selected="selected"' : '' }>switch</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=7" ${so == '7' ? 'selected="selected"' : '' }>AR/VR</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=8" ${so == '8' ? 'selected="selected"' : '' }>인디</option>
              <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=9" ${so == '9' ? 'selected="selected"' : '' }>HTML5</option>
            </select>
          </div>
          <div class="genre">
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=51">RPG</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=52">어드벤쳐</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=53">FPS</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=54">스포츠</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=55">TCG</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=56">보드</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=57">레이싱</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=58">슈팅</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=59">액션</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=60">시뮬레이션</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=61">RTS</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=62">퍼즐</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=63">리듬액션</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=64">SNG</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=65">AOS</a>
            <a href="/Board/GameList?pageNum=1&contentNum=30&searchType=66">기타</a>
          </div>
        </td>
        <td class="boardBox">공지사항 <a class="plus" href="/managementList?menu_id=3&pageNum=1&contentNum=30">+더 보기</a>
          <ul>
            <c:forEach begin="0" end="9" var="idx">
              <li><a href="/View?b_idx=${MList[idx].b_idx}&menu_id=${MList[idx].menu_id}&pageNum=1&contentNum=30">${MList[idx].title}</a></li>
            </c:forEach>
          </ul>
        </td>
      </tr>
      <tr>
        <td class="boardBox">전체리뷰게시판 <a class="plus" href="/totalList?menu_id=1&pageNum=1&contentNum=30">+더 보기</a>
          <ul>
            <c:forEach begin="0" end="9" var="idx">
              <li><a href="/View?b_idx=${T1ist[idx].b_idx}&menu_id=${T1ist[idx].menu_id}&pageNum=1&contentNum=30">${T1ist[idx].title}</a></li>
            </c:forEach>
          </ul>
        </td>
        <td class="boardBox">전체자유게시판 <a class="plus" href="/totalList?menu_id=2&pageNum=1&contentNum=30">+더 보기</a>
          <ul>
            <c:forEach begin="0" end="9" var="idx">
              <li><a href="/View?b_idx=${T2List[idx].b_idx}&menu_id=${T2List[idx].menu_id}&pageNum=1&contentNum=30">${T2List[idx].title}</a></li>
            </c:forEach>
          </ul>
        </td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
