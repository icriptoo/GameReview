<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <script>
        </script>
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
                                <strong style="font-size:20px;">내 게시글 보기</strong>
                            </div>

                             <div class="w3-container">
                                    <table class="w3 table w3-bordered">

                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>내용</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>카테고리</th>
                                            <th>접수상태</th>
                                        </tr>
                                      <c:forEach var="writePage" items="${writePage}">
                                      <tr>
                                      <td>${writePage.board_number}</td>
                                      <td><a href="/Board/CustomerDetail?board_number=${writePage.board_number}&menu_id=${writePage.menu_id}&pageNum=1&contentNum=10&board_check=0">${writePage.title}</a></td>
                                      <td>${writePage.cont}</td>
                                      <td>${writePage.writer}</td>
                                      <td>${writePage.indate}</td>
                                       <c:set var="menu_id" value="${writePage.menu_id}"/>
                                             <c:if test="${menu_id == 'MENU_01'}">
                                             <td>해주세요</td>
                                             </c:if>
                                       <c:set var="check" value="${writePage.board_check}"/>
                                                          <c:if test="${check == 0}">
                                                              <td>접수대기<td>
                                                          </c:if>
                                                          <c:if test="${check == 1}">
                                                                  <td>접수중<td>
                                                                </c:if>
                                                          <c:if test="${check == 2}">
                                                              <td>접수완료<td>
                                                          </c:if>
                                      </tr>
                                      </c:forEach>
                                      <c:forEach var="RwritePqage" items="${RwritePqage}">
                                      <tr>
                                       <td>${RwritePqage.board_number}</td>
                                       <td><a href="/Board/riderDetail?board_number=${RwritePqage.board_number}&menu_id=${RwritePqage.menu_id}&pageNum=1&contentNum=10&board_check=0">${RwritePqage.title}</a></td>
                                       <td>${RwritePqage.cont}</td>
                                       <td>${RwritePqage.writer}</td>
                                       <td>${RwritePqage.indate}</td>
                                        <c:set var="Rmenu_id" value="${RwritePqage.menu_id}"/>
                                            <c:if test="${Rmenu_id == 'MENU_02'}">
                                            <td>할게요</td>
                                            </c:if>
                                      <c:set var="Rcheck" value="${RwritePqage.board_check}"/>
                                                         <c:if test="${Rcheck == 0}">
                                                             <td>접수대기<td>
                                                         </c:if>
                                                         <c:if test="${Rcheck == 1}">
                                                                 <td>접수중<td>
                                                               </c:if>
                                                         <c:if test="${Rcheck == 2}">
                                                             <td>접수완료<td>
                                                         </c:if>
                                      </tr>
                                      </c:forEach>
                                      <c:forEach var = "RVwritePage" items ="${RVwritePage}">
                                      <tr>
                                  <td>${RVwritePage.board_number}</td>
                                  <td><a href="/Board/ReviewDetail?board_number=${RVwritePage.board_number}&menu_id=${RVwritePage.menu_id}&pageNum=1&contentNum=10&board_check=0">${RVwritePage.title}</a></td>
                                  <td>${RVwritePage.cont}</td>
                                  <td>${RVwritePage.writer}</td>
                                  <td>${RVwritePage.indate}</td>
                                  <c:set var="RVmenu_id" value="${RVwritePage.menu_id}"/>
                                     <c:if test="${RVmenu_id == 'MENU_03'}">
                                     <td>후기</td>
                                     </c:if>
                                       </tr>
                                 </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; BananaQuick Website 2022</div>

                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>

    <script>

    function w3_open() {
      document.getElementById("main").style.marginLeft = "15%";
      document.getElementById("mySidebar").style.width = "15%";
      document.getElementById("mySidebar").style.display = "block";
      document.getElementById("openNav").style.display = 'none';
    }
    function w3_close() {
      document.getElementById("main").style.marginLeft = "0%";
      document.getElementById("mySidebar").style.display = "none";
      document.getElementById("openNav").style.display = "inline-block";
    }

</html>
