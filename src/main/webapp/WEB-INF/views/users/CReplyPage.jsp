<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tables - SB Admin</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</head>


<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
<h1 class="w3-xxxlarge"><b>Banana Quick</b></h1>
<h6><span class="w3-tag">delivery's world</span></h6>
</header>



<div class="card mb-4">
 <div class="card-header">
  <i class="fas fa-table me-1"></i>
  <strong style="font-size:20px;">내 댓글 보기</strong>
 </div>

  <div class="w3-container">
   <table class="w3 table w3-bordered">

   <tr>
    <th style="width: 215px;">작성자</th>
    <th>댓글내용</th>
    <th>게시글 제목</th>
    <th>카테고리</th>
   </tr>

    <c:forEach var="Creplypage" items="${Creplypage}">
     <tr>
      <td>${Creplypage.writer}</td>
      <td>${Creplypage.cont}</td>
      <td><a href="/Board/CustomerDetail?board_number=${Creplypage.board_number}&menu_id=${Creplypage.menu_id}&pageNum=1&contentNum=10&board_check=0">${Creplypage.title}</a></td>
       <c:set var="Creplypage" value="${Creplypage.menu_id}"/>
       <c:if test="${Creplypage == 'MENU_01'}">
                              <td>해주세요<td>
                          </c:if>
    </tr>
    </c:forEach>
    <c:forEach var="RreplyPage" items="${RreplyPage}">
      <tr>
     <td>${RreplyPage.writer}</td>
     <td>${RreplyPage.cont}</td>
     <td><a href="/Board/riderDetail?board_number=${RreplyPage.board_number}&menu_id=${RreplyPage.menu_id}&pageNum=1&contentNum=10">${RreplyPage.title}</a></td>
     <c:set var="RreplyPage" value="${RreplyPage.menu_id}"/>
       <c:if test= "${RreplyPage == 'MENU_02'}">
                                   <td>할게요<td>
                                 </c:if>
      </tr>
     </c:forEach>
    </table>
    </div>
     </div>
      </div>


<footer class="py-4 bg-light mt-auto">
<div class="container-fluid px-4">
<div class="d-flex align-items-center justify-content-between small">
<div class="text-muted">Copyright &copy; Your BananaQuick 2022</div>
</div>
</div>
</footer>
</div>
</div>

</body>
</html>
