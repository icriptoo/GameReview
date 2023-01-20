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
</script>

<style>
    .type a{cursor:pointer;}
    .cont {display:none;}
    #btn1 {
      display : none;
    }
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
      <th colspan="6" style="text-align:center">
        <button style="font-size:20px;" onClick="location.href='/declarationList'" >신고관리</button>
        <button style="font-size:20px;" onClick="location.href='userList'" >유저관리</button>
      </th>
    </tr>
    <tr>
      <th width="10%" style="text-align:center">신고대상 아이디</th>
      <th width="10%" style="text-align:center">분류</th>
      <th width="10%" style="text-align:center">신고자 아이디</th>
      <th width="10%" style="text-align:center">신고일</th>

    </tr>
    <c:forEach var="list" items="${list}" varStatus="status" >
      <tr>
        <td width="10%" style="text-align:center">${list.ue_name}</td>
        <c:choose>
          <c:when test="${list.type_idx eq 1}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=불건전한 내용">불건전한 내용</a></td>
          </c:when>
          <c:when test="${list.type_idx eq 2}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=스팸 및 부적절한 홍보">스팸 및 부적절한 홍보</a></td>
          </c:when>
          <c:when test="${list.type_idx eq 3}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=명예훼손 및 비방">명예훼손 및 비방</a></td>
          </c:when>
          <c:when test="${list.type_idx eq 4}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=초상권 및 저작권 침해">초상권 및 저작권 침해</a></td>
          </c:when>
          <c:when test="${list.type_idx eq 5}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=개인정보 도용">개인정보 도용</a></td>
          </c:when>
          <c:when test="${list.type_idx eq 6}">
            <td width="10%" style="text-align:left"><a href="/declarationView?d_idx=${list.d_idx}&title=기타">기타</a></td>
          </c:when>
        </c:choose>
        <td width="10%" style="text-align:center">${list.us_name}</td>
        <td width="10%" style="text-align:center">${list.indate}</td>
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