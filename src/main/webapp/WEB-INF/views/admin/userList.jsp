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

td{
    padding: 8px 16px;
}

</style>
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/GameReviewList?pageNum=1&contentNum=30";
  url += "&keyword=" + $("#keyword").val();
  url += "&searchType=" + $("#searchType").val();
  url += "&menu_id=${menu_id}";
  url += "&g_idx=${gameListVo.g_idx}"
  if ($("#keyword").val() === ""){
    alert("키워드를 입력해 주세요.");
    return false;
  }else{
    location.href = url;
  }
}
function btnSearchEnter(){
  if(window.event.keyCode == 13){
    var url = "/GameReviewList?pageNum=1&contentNum=30";
    url += "&keyword=" + $("#keyword").val();
    url += "&searchType=" + $("#searchType").val();
    url += "&menu_id=${menu_id}";
    url += "&g_idx=${gameListVo.g_idx}"
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
      <h1>왼쪽</h1>
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
        <button style="font-size:20px;" onClick="location.href='/declarationList'" >Q&A</button>
        <button style="font-size:20px;" onClick="location.href='/declarationList'" >신고목록</button>
        <button style="font-size:20px;" onClick="location.href='/userList'" >유저목록</button>
      </th>
    </tr>
    <tr>
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

  </table>
</div>
<script>
document.getElementById("btnSearch").addEventListener('click',btnSearch);
</script>
</body>

</html>