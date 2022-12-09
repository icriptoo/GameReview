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
</style>
<script>
console.log(${sT});
function btnGSearch(e){
  e.preventDefault();
  var url = "/Board/GameList?pageNum=1&contentNum=30";
  url += "&gameName=" + $("#gameName").val();
  if ($("#gameName").val() === ""){
    alert("게임명을 입력해주세요.");
  }else{
    location.href = url;
  }
}
</script>
</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus2.jsp" %>
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
      <%@ include file="/WEB-INF/include/login2.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <div>
    <table>
      <tr>
        <td>
          <select id="platform" name="platform" onchange="if(this.value) location.href=(this.value);">
          <option value="/Board/GameList?pageNum=1&contentNum=30" ${so == '0' ? 'selected="selected"' : '' }>플랫폼</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=1" ${so == '1' ? 'selected="selected"' : '' }>PC패키지</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=2" ${so == '2' ? 'selected="selected"' : '' }>PC온라인</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=3" ${so == '3' ? 'selected="selected"' : '' }>모바일</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=4" ${so == '4' ? 'selected="selected"' : '' }>PS</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=5" ${so == '5' ? 'selected="selected"' : '' }>XBOX</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=6" ${so == '6' ? 'selected="selected"' : '' }>switch</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=7" ${so == '7' ? 'selected="selected"' : '' }>AR/VR</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=8" ${so == '8' ? 'selected="selected"' : '' }>인디</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=9" ${so == '9' ? 'selected="selected"' : '' }>HTML5</option>
        </td>
        <td>
          <select id="genre" name="genre" onchange="if(this.value) location.href=(this.value);">
          <option value="/Board/GameList?pageNum=1&contentNum=30" ${so == '0' ? 'selected="selected"' : '' }>장르</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=51" ${so == '51' ? 'selected="selected"' : '' }>RPG</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=52" ${so == '52' ? 'selected="selected"' : '' }>어드벤쳐</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=53" ${so == '53' ? 'selected="selected"' : '' }>FPS</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=54" ${so == '54' ? 'selected="selected"' : '' }>스포츠</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=55" ${so == '55' ? 'selected="selected"' : '' }>TCG</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=56" ${so == '56' ? 'selected="selected"' : '' }>보드</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=57" ${so == '57' ? 'selected="selected"' : '' }>레이싱</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=58" ${so == '58' ? 'selected="selected"' : '' }>슈팅</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=59" ${so == '59' ? 'selected="selected"' : '' }>액션</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=60" ${so == '60' ? 'selected="selected"' : '' }>시뮬레이션</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=61" ${so == '61' ? 'selected="selected"' : '' }>RTS</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=62" ${so == '62' ? 'selected="selected"' : '' }>퍼즐</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=63" ${so == '63' ? 'selected="selected"' : '' }>리듬액션</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=64" ${so == '64' ? 'selected="selected"' : '' }>SNG</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=65" ${so == '65' ? 'selected="selected"' : '' }>AOS</option>
          <option value="/Board/GameList?pageNum=1&contentNum=30&searchType=66" ${so == '66' ? 'selected="selected"' : '' }>기타</option>
        </td>
        <td>
          <input id="gameName" class="gameName" type="text">
          <button id="btnGSearch" class="btnGSearch">검색</button>
        </td>
      </tr>
      <c:forEach var="list" items="${GameList}">
        <tr>
          <td>
            <img src="${list.g_img}" alt="${list.g_name}" style="width: 165px; height: 115px;">
          </td>
          <td colspan="2">
            <ul class="gList">
              <li><strong>게임명 : </strong><span class="gName">${list.g_name}</span> <span class="eGName">${list.g_ename}</span></li>
              <li><strong>장르명 : </strong>${list.g_genre}</li>
              <li><strong>개발사 : </strong>${list.g_company}</li>
              <li><strong>서비스 : </strong>${list.g_service}</li>
              <li><strong>플랫폼 : </strong>${list.g_platform}</li>
              <li><strong>출시일 : </strong>${list.g_date}</li>
            </ul>
          </td>
        </tr>
      </c:forEach>
      <c:choose>
        <c:when test="${sT eq 0}">
          <tr>
            <td class="page" id="page" colspan="2" style="text-align:center;">
              <div class="pager">
                <c:if test="${Pager.prev}">
                  <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}">< 이전</a>
                  <a class="firstPageNum" href="/Board/GameList?pageNum=1&contentNum=30">1</a>
                  ...
                </c:if>
                <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                  <a class="pageNum" href="/Board/GameList?pageNum=${idx}&contentNum=${idx*30}">${idx}</a>
                </c:forEach>
                <c:if test="${Pager.next}">
                  ...
                  <a class="lastPageNum" href="/Board/GameList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}">${Pager.lastPageNum}</a>
                  <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}">다음 ></a>
                </c:if>
              </div>
            </td>
          </tr>
        </c:when>
        <c:when test="${sT eq 101}">
          <td class="page" id="page" colspan="2" style="text-align:center;">
            <div class="pager">
              <c:if test="${Pager.prev}">
                <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&gameName=${gN}">< 이전</a>
                <a class="firstPageNum" href="/Board/GameList?pageNum=1&contentNum=30&gameName=${gN}">1</a>
                ...
              </c:if>
              <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                <a class="pageNum" href="/Board/GameList?pageNum=${idx}&contentNum=${idx*30}&gameName=${gN}">${idx}</a>
              </c:forEach>
              <c:if test="${Pager.next}">
                ...
                <a class="lastPageNum" href="/Board/GameList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&gameName=${gN}">${Pager.lastPageNum}</a>
                <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&gameName=${gN}">다음 ></a>
              </c:if>
            </div>
          </td>
        </c:when>
        <c:otherwise>
          <tr>
            <td class="page" id="page" colspan="2" style="text-align:center;">
              <div class="pager">
                <c:if test="${Pager.prev}">
                  <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.startPage-1}&contentNum=${(Pager.startPage-1)*30}&searchType=${sT}">< 이전</a>
                  <a class="firstPageNum" href="/Board/GameList?pageNum=1&contentNum=30&searchType=${sT}">1</a>
                  ...
                </c:if>
                <c:forEach begin="${Pager.startPage}" end="${Pager.endPage}" var="idx">
                  <a class="pageNum" href="/Board/GameList?pageNum=${idx}&contentNum=${idx*30}&searchType=${sT}">${idx}</a>
                </c:forEach>
                <c:if test="${Pager.next}">
                  ...
                  <a class="lastPageNum" href="/Board/GameList?pageNum=${Pager.lastPageNum}&contentNum=${Pager.lastPageNum*30}&searchType=${sT}">${Pager.lastPageNum}</a>
                  <a href="http://localhost:8080/Board/GameList?pageNum=${Pager.endPage+1}&contentNum=${(Pager.endPage+1)*30}&searchType=${sT}">다음 ></a>
                </c:if>
              </div>
            </td>
          </tr>
        </c:otherwise>
      </c:choose>
    </table>
  </div>
</div>
<script>
document.getElementById("btnGSearch").addEventListener('click',btnGSearch);
</script>
</body>
</html>
