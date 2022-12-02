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
    <h1 class="headerB"><b>Banana Quick</b></h1>
    <h6><span class="w3-tag">delivery's world</span></h6>
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
