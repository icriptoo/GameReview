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

td{
    padding: 8px 16px;
}

</style>
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/userList?pageNum=1&contentNum=30";
  url += "&keyword=" + $("#keyword").val();
  url += "&searchType=" + $("#searchType").val();
  if ($("#keyword").val() === ""){
    alert("키워드를 입력해 주세요.");
    return false;
  }else{
    location.href = url;
  }
}
function btnSearchEnter(){
  if(window.event.keyCode == 13){
    var url = "/userList?pageNum=1&contentNum=30";
    url += "&keyword=" + $("#keyword").val();
    url += "&searchType=" + $("#searchType").val();
    if ($("#keyword").val() === ""){
      alert("키워드를 입력해 주세요.");
      return false;
    }else{
      location.href = url;
    }
  }
}

function chk(u_id){
  var u_id = u_id;
  let out = confirm("정말 탈퇴시키시겠습니까?");
  if (out){
    location.href = "/user/Wirthdrwal?u_id=" + u_id + "&path=1";
  }
}
</script>
<style>
    .type a{cursor:pointer;}
    .cont {display:none;}
    #btn1 {
      display : none;
    }
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
      <th colspan="9" style="text-align:center">
        <button style="font-size:20px;" onClick="location.href='/managementList?menu_id=4&u_id=${login.u_id}&pageNum=1&contentNum=30'" >Q&A</button>
        <button style="font-size:20px;" onClick="location.href='/declarationList?pageNum=1&contentNum=30'" >신고목록</button>
        <button style="font-size:20px;" onClick="location.href='/userList?pageNum=1&contentNum=30'" >유저목록</button>
      </th>
    </tr>
    <tr style="border-bottom: 1px solid #000000">
      <th width="10%" style="text-align:center">가입일</th>
      <th width="10%" style="text-align:center">아이디</th>
      <th width="10%" style="text-align:center">닉네임</th>
      <th width="10%" style="text-align:center">이메일</th>
      <th width="5%" style="text-align:center">선호장르1</th>
      <th width="5%" style="text-align:center">선호장르2</th>
      <th width="5%" style="text-align:center">선호장르3</th>
      <th width="5%" style="text-align:center">신고횟수</th>
      <th width="5%" style="text-align:center">관리</th>

    </tr>
    <c:forEach var="list" items="${list}" varStatus="status" >
      <tr>
        <td width="10%" style="text-align:center">${list.indate}</td>
        <td width="10%" style="text-align:center">${list.u_id}</td>
        <td width="10%" style="text-align:center">${list.n_name}</td>
        <td width="10%" style="text-align:center">${list.email}</td>
        <td width="5%" style="text-align:center">${list.genre1}</td>
        <td width="5%" style="text-align:center">${list.genre2}</td>
        <td width="5%" style="text-align:center">${list.genre3}</td>
        <td width="5%" style="text-align:center">${list.declaration}</td>
        <td width="5%" style="text-align:center"><button style="font-size:15px;" onClick="chk('${list.u_id}');" >탈퇴</button></td>
      </tr>
      <tr style="border-top: 1px solid #999999">
      </tr>
    </c:forEach>
    <tr>
      <td colspan="9">
        <c:set var="sT" value="${sT}"/>
        <c:choose>
          <c:when test="${sT eq 'a'}">
            <tr>
              <td class="page" id="page" colspan="9" style="text-align:center;">
                <div class="pager">
                  <c:if test="${Pager.prev}">
                    <a href="http://localhost:8080/userList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&menu_id=${menu_id}">< 이전</a>
                    <a class="firstPageNum" href="/userList?pageNum=1&contentNum=30&menu_id=${menu_id}">1</a>
                    ...
                  </c:if>
                  <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                    <a class="pageNum" href="/userList?pageNum=${idx}&contentNum=${idx*30}&menu_id=${menu_id}">${idx}</a>
                  </c:forEach>
                  <c:if test="${Pager.next}">
                    ...
                    <a class="lastPageNum" href="/userList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&menu_id=${menu_id}">${Pager.lastPageNum}</a>
                    <a href="http://localhost:8080/userList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&menu_id=${menu_id}">다음 ></a>
                  </c:if>
                </div>
              </td>
            </tr>
          </c:when>
          <c:otherwise>
            <tr>
              <td class="page" id="page" colspan="9" style="text-align:center;">
                <div class="pager">
                  <c:if test="${Pager.prev}">
                    <a href="http://localhost:8080/userList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">< 이전</a>
                    <a class="firstPageNum" href="/userList?pageNum=1&contentNum=30&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">1</a>
                    ...
                  </c:if>
                  <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                  <a class="pageNum" href="/userList?pageNum=${idx}&contentNum=${idx*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">${idx}</a>
                  </c:forEach>
                  <c:if test="${Pager.next}">
                    ...
                    <a class="lastPageNum" href="/userList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">${Pager.lastPageNum}</a>
                    <a href="http://localhost:8080/userList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&searchType=${sT}&keyword=${kw}&menu_id=${menu_id}">다음 ></a>
                  </c:if>
                </div>
              </td>
            </tr>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
    <tr style="border-top: 1px solid #000">
      <td colspan="3" style="padding-left: 50px; border-radius: 4px; padding: 15px 0px 15px 20px;">
        <select class="search" id="searchType">
          <option value="u_id"><strong>아이디</strong></option>
          <option value="n_name"><strong>닉네임</strong></option>
          <option value="email"><strong>이메일</strong></option>
        </select>
        <input id="keyword" class="keyword" type="text" onkeyup="btnSearchEnter()">
        <button id="btnSearch" class="searchB">검색</button>
      </td>
    </tr>
  </table>
</div>
<script>
document.getElementById("btnSearch").addEventListener('click',btnSearch);
</script>
</body>

</html>