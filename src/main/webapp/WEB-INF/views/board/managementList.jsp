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
<script>

function boardCheck(){
  console.log('${ sessionScope.login.u_id }');
  console.log('${gameListVo.g_idx}');
  let u_id = '${ sessionScope.login.u_id }'; // 유저아이디 들고오기
  let g_idx = '${gameListVo.g_idx}'; // 게임idx 들고오기

  let obj={ // 넘겨줄 데이터
      			"u_id" : u_id,
      			"g_idx" : g_idx
      		};

  if('${menu_id}' == 1){
      $.ajax({
            url : "boardCheck",
            type : "POST",
            data : obj,
            success : function(chk){
                if(chk>0){ // 작성리뷰 있음 --> false
                    alert('이미 리뷰를 작성하였습니다.');
                    return false;
                } else { // 작성리뷰 없음 --> 작성화면
                    location.href = "/boardWrite?g_idx=${gameListVo.g_idx}&menu_id=${menu_id}";
                }
            },
            error : function() {
                alert("요청실패");
            }
        })
  } else{
     location.href = "/boardWrite?g_idx=${gameListVo.g_idx}&menu_id=${menu_id}";
  }
}

</script>
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
      <h1></h1>
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
      <th colspan="4" style="font-size:20px; text-align:center;">
      <c:if test="${menu_id eq 3}">
        공지사항
      </c:if>
      <c:if test="${menu_id eq 4}">
        Q & A
      </c:if>
      </th>
    </tr>

          <tr>
          <th width="10%" style="text-align:center">번호</th>
          <th width="25%" style="text-align:center">제목</th>
          <th width="10%" style="text-align:center">작성일</th>
          <c:if test= "${menu_id eq 3}">
            <th width="5%" style="text-align:center">조회수</th>
          </c:if>
          <c:if test= "${menu_id eq 4}">
            <th width="5%" style="text-align:center">답변상태</th>
          </c:if>
          </tr>

          <c:forEach var="item" items="${boardList}" >
            <tr>
              <td width="10%" style="text-align:center">${item.b_idx}</td>
              <td width="25%" style="text-align:left"><a href="/View?b_idx=${item.b_idx}&menu_id=${menu_id}">${item.title}</a></td>
              <td width="10%" style="text-align:center">${item.indate}</td>
              <c:if test= "${menu_id eq 3}">
                <td width="5%" style="text-align:center">${item.b_count}</td>
              </c:if>
              <c:if test="${menu_id eq 4}">
                <td width="5%" style="text-align:center">대기</td>
              </c:if>
            </tr>
          </c:forEach>

          <tr>
            <td colspan="4">
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
              </td >
              <td colspan="5" style="text-align: right; border-radius: 4px; background: #f1f1f1; padding: 15px 20px 15px 0px;">
              <c:if test="${sessionScope.login.u_id ne null}">
              <button style="font-size:20px;" onClick="location.href='/boardWrite?menu_id=${menu_id}&pageNum=1&contentNum=30'" >글쓰기</button>
              </c:if>
              </td>
            </tr>

  </table>

</div>
<script>
console.log(${Pager});
</script>
</body>
</html>
