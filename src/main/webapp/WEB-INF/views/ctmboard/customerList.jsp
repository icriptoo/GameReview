<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/common.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>Insert title here</title>
<style>
.pickup{
text-align:left;
font-family:"S-Core Dream 6";
font-size:38px;
}
.oooo{
border:1px solid #ccc!important;
margin:40px 40px 40px 40px;
}

.search {
  width: 120px;
  height: 35px;
  background: url('https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png') calc(100% - 5px) center no-repeat;
  background-color: #fff;
  background-size: 20px;
  padding: 5px 10px 5px 10px;
  border-radius: 4px;
  outline: 0 none;
}
.search option { background: #fff; color: #000; padding: 3px 0; }
.keyword {
  width: 200px;
  height: 35px;
  border-radius: 4px;
  padding-left: 10px;
  border: 1px solid #000;
}
.write {
  padding: 10px 10px;
  border-radius: 4px;
  border: 1px solid #000;
  background: #fff;
}
.searchB { height: 35px; border-radius: 4px; border: 1px solid #000; background: #fff; }
.headerB{ font-size: 80px!important }

.BoardPa { text-align: center; margin: 10px 0px; }
.PageNum { color: #4c72db; font-weight: bold;}

.page-linkA {
    position: relative;
    padding: 10px 15px;
    margin-left: 5px;
    line-height: 1.25;
    color: #000;
    background-color: #fff;
    border: 1px solid #a0a0a0;
    text-decoration: none;
    text-align:center;
    font-size: 15px!important;
    border-radius: 10%;
}

.ta {
  width: 100%;
  max-width: 100%;
  margin-bottom: 1rem;
  background-color: transparent;
}

a.page-linkA:hover { font-weight: bold; text-decoration: none; background: rgba(210,210,210,1); color: #4c72db; border: 1px solid #000; }

</style>
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";
  url += "&searchType=" + $("#searchType").val();
  url += "&keyword=" + $("#keyword").val();
  if ($("#keyword").val() === ""){
    alert("검색 할 키워드를 입력해주세요.");
  }else{
    location.href = url;
  }
}

</script>
</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Banana Quick</b></h1>
    <h6><span class="w3-tag">delivery's world</span></h6>
</header>
  <div style="margin: 50px;">
<div class="oooo"style="max-width:1800px; margin:auto;">
  <div class="w3-container w3-white w3-margin w3-padding-large" style="border: 1px solid #ccc;">
  <div id="main" >
    <div class="pickup" style="padding: 10px 20px;">픽업 해주세요</div>
  </div>
  <div class="w3-container">
       <table class="w3 table w3-bordered">
            <tr>
              <th width="10%" style="text-align:center;">번호</th>
              <th width="30%" style="text-align:left;">제목</th>
              <th width="10%" style="text-align:center;">작성자</th>
              <th width="10%" style="text-align:center;">작성일</th>
              <th width="5%" style="text-align:center;">지역</th>
              <th width="7%" style="text-align:center;">접수상태</th>
            </tr>
            <c:forEach var="board" items="${customerList}">
              <tr>
                <td width="10%" style="text-align:center;">${board.board_number}</td>
                <td width="30%" style="text-align:left;"><a href="/Board/CustomerDetail?board_number=${board.board_number}&menu_id=${board.menu_id}&pageNum=1&contentNum=10">${board.title}</a></td>
                <td width="10%" style="text-align:center;">${board.writer}</td>
                <td width="10%" style="text-align:center;">${board.indate}</td>
                <td width="5%" style="text-align:center;">${board.board_local}</td>
                <c:set var="check" value="${board.board_check}"/>
                <c:if test="${check == 0}">
                  <td width="10%" style="text-align:center;">접수대기</td>
                </c:if>
                <c:if test="${check == 1}">
                  <td width="10%" style="text-align:center;">접수중</td>
                </c:if>
                <c:if test="${check == 2}">
                  <td width="10%" style="text-align:center;">접수완료</td>
                </c:if>
              </tr>
            </c:forEach>
            <tr>
            <td colspan="6">
              <c:set var="url" value="http://localhost:8080/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10"/>
              <c:choose>
                <c:when test="${ url eq 'window.location.href'}">
                  <div id="BoardPa" class="BoardPa">
                    <c:if test="${boardPager.prev}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}" class="w3-button">< 이전</a>
                    </c:if>
                    <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}" class="w3-button">${idx}</a>
                    </c:forEach>
                    <c:if test="${boardPager.next}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}" class="w3-button">다음 ></a>
                    </c:if>
                  </div>
                </c:when>
                <c:otherwise>
                  <div id="BoardPa" class="BoardPa">
                    <c:if test="${boardPager.prev}">
                      <a class="page-linkA" href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">< 이전</a>
                    </c:if>
                    <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                      <a class="page-linkA" href="/Board/customerList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">${idx}</a>
                    </c:forEach>
                    <c:if test="${boardPager.next}">
                      <a class="page-linkA" href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">다음 ></a>
                    </c:if>
                  </div>
                </c:otherwise>
              </c:choose>
            </td>
            </tr>
        </table>
        <table class="ta">
              <tr style="border-top: 1px solid #000">
              <td style="padding-left: 50px; border-radius: 4px; background: #f1f1f1; padding: 15px 0px 15px 20px;">
                <select class="search" id="searchType">
                  <option value="title"><strong>제목</strong></option>
                  <option value="board_local"><strong>지역</strong></option>
                  <option value="writer"><strong>작성자</strong></option>
                  <option value="board_check"><strong>접수상태</strong></option>
                  </select>
                  <input id="keyword" class="keyword" type="text">
                  <button id="btnSearch" class="searchB">검색</button>
                </td>
                <td style="text-align: right; padding-right: 50px; padding-top: 18px; border-radius: 4px; background: #f1f1f1; padding: 15px 20px 15px 0px;">
                  <a href="/Board/CBoardWriteForm?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}"
                    class="write">해주세요 새글쓰기</a>
                </td>
              </tr>
            </table>
    </div>
    </div>
</div>
</div>
</div>
<script>
document.getElementById("btnSearch").addEventListener('click',btnSearch);

</script>

 <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; BananaQuick Website 2022</div>

                        </div>
                    </div>
                </footer>


</body>
</html>
