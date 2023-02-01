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
</style>
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/myboard?pageNum=1&contentNum=30";
  url += "&keyword=" + $("#keyword").val();
  url += "&searchType=" + $("#searchType").val();
  url += "&menu_id=${menu_id}";
  if ($("#keyword").val() === ""){
    alert("키워드를 입력해 주세요.");
  }else{
    location.href = url;
  }
}
function btnSearchEnter(){
  if(window.event.keyCode == 13){
    var url = "/myboard?pageNum=1&contentNum=30";
    url += "&keyword=" + $("#keyword").val();
    url += "&searchType=" + $("#searchType").val();
    url += "&menu_id=${menu_id}";
    if ($("#keyword").val() === ""){
      alert("키워드를 입력해 주세요.");
    }else{
      location.href = url;
   }
  }
}
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
  <h1 class="headerB"><b>Game List</b></h1>
</header>
<div style="width: 100%; height: 500px; ">
  <div>
    <aside class="leftAside">
      <h1> </h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <table>
    <tr>
      <th colspan="6" style="text-align:center">
        <button style="font-size:20px;" onClick="location.href='/myboard?menu_id=1&pageNum=1&contentNum=30'" >리뷰게시판</button>
        <button style="font-size:20px;" onClick="location.href='/myboard?menu_id=2&pageNum=1&contentNum=30'" >자유게시판</button>
      </th>
    </tr>
    <tr>
      <th width="10%" style="text-align:center">번호</th>
      <th width="25%" style="text-align:center">제목</th>
      <th width="12%" style="text-align:center">게임</th>
      <c:if test= "${menu_id eq 1}">
        <th width="5%" style="text-align:center">평점</th>
      </c:if>
      <th width="10%" style="text-align:center">작성자</th>
      <th width="10%" style="text-align:center">작성일</th>
      <th width="5%" style="text-align:center">조회수</th>
    </tr>
    <c:forEach var="item" items="${boardList}" >
      <tr>
        <td width="10%" style="text-align:center">${item.b_idx}</td>
        <td width="25%" style="text-align:left"><a href="/View?b_idx=${item.b_idx}&menu_id=${menu_id}&pageNum=1&contentNum=30">${item.title}</a></td>
        <td width="12%" style="text-align:left">${item.g_name}</td>
        <c:if test="${menu_id eq 1}">
          <td width="5%" style="text-align:center">${item.r_score}</td>
        </c:if>
        <td width="5%" style="text-align:center">${item.n_name}</td>
        <td width="10%" style="text-align:center">${item.indate}</td>
        <td width="5%" style="text-align:center">${item.b_count}</td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="4">
        <c:set var="sT" value="${sT}"/>
        <c:choose>
          <c:when test="${sT eq 'a'}">
            <tr>
              <td class="page" id="page" colspan="5" style="text-align:center;">
                <div class="pager">
                  <c:if test="${Pager.prev}">
                    <a href="http://localhost:8080/myboard?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&menu_id=${menu_id}">< 이전</a>
                    <a class="firstPageNum" href="/myboard?pageNum=1&contentNum=30&menu_id=${menu_id}">1</a>
                    ...
                  </c:if>
                  <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                    <a class="pageNum" href="/myboard?pageNum=${idx}&contentNum=${idx*30}&menu_id=${menu_id}">${idx}</a>
                  </c:forEach>
                  <c:if test="${Pager.next}">
                    ...
                    <a class="lastPageNum" href="/myboard?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&menu_id=${menu_id}">${Pager.lastPageNum}</a>
                    <a href="http://localhost:8080/myboard?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&menu_id=${menu_id}">다음 ></a>
                  </c:if>
                </div>
              </td>
            </tr>
          </c:when>
          <c:otherwise>
            <tr>
              <td class="page" id="page" colspan="5" style="text-align:center;">
                <div class="pager">
                  <c:if test="${Pager.prev}">
                    <a href="http://localhost:8080/myboard?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">< 이전</a>
                    <a class="firstPageNum" href="/myboard?pageNum=1&contentNum=30&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">1</a>
                    ...
                  </c:if>
                  <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                    <a class="pageNum" href="/myboard?pageNum=${idx}&contentNum=${idx*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">${idx}</a>
                  </c:forEach>
                  <c:if test="${Pager.next}">
                    ...
                    <a class="lastPageNum" href="/myboard?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">${Pager.lastPageNum}</a>
                    <a href="http://localhost:8080/myboard?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">다음 ></a>
                  </c:if>
                </div>
              </td>
            </tr>
          </c:otherwise>
        </c:choose>
        <tr style="border-top: 1px solid #000">
          <td colspan="6" style="padding-left: 50px; border-radius: 4px; padding: 15px 0px 15px 20px;">
            <select class="search" id="searchType">
              <option value="title"><strong>제목</strong></option>
              <option value="g_name"><strong>게임명</strong></option>
            </select>
            <input id="keyword" class="keyword" type="text" onkeyup="btnSearchEnter()">
            <button id="btnSearch" class="searchB">검색</button>
          </td>
        </tr>
      </td>
    </tr>
  </table>
</div>
<script>
document.getElementById("btnSearch").addEventListener('click',btnSearch);
</script>
</body>
</html>
