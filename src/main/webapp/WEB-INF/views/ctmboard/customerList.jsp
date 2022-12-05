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

.headerB{ font-size: 80px!important }

aside {
	float: right;
	width: 350px;
}

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
    <h1 class="headerB"><b>Game Review</b></h1>
</header>
<div style="width: 100%; height: 500px; ">
  <div>
  <table>
    <tr>
      <td>
        <h2>확인</h2>
      </td>
    </tr>
  </table>
  </div>
  <div>
    <aside>
      <%@ include file="/WEB-INF/include/login.jsp" %>
    </aside>
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
