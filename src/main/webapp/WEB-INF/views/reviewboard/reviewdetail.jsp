<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.headerB{ font-size: 80px!important }
.headerD{ font-size: 25px!important; background-color: #000; color: #fff; padding: 0px 8px 4px 8px; text-align: center; }
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

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

function DeleteBoard(){
let ans = confirm("삭제하시겠습니까?");
if(ans){
if("${nickName}" != "${reviewBoardVo.writer}"){
alert("본인이 작성한 게시글만 삭제 가능합니다");
}
else{
$.ajax({
type:"get",
url:"/Board/RVBoardDelete?board_number=${reviewBoardVo.board_number}&menu_id=${menu_id}",

success:function(result){
alert("삭제되었습니다");
location.href='/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10';
}

});
}
}
}
</script>
</head>
<%@ include file="/WEB-INF/include/menus.jsp" %>
<body class="w3-light-grey">
<header class="w3-container w3-center w3-white" style="padding-top: 80px; padding-bottom: 80px;">
  <h1 class="headerB" ><b>Banana Quick</b></h1>
  <h6><span class="headerD">delivery's world</span></h6>
</header>
<div class="w3-content" style="max-width:1600px; margin:auto;">
  <div class="w3-row w3-padding w3-border" style="margin: 50px 0px;">
    <div>
      <div class="w3-container w3-white w3-margin w3-padding-large" style="border: 1px solid #ccc;">
        <div class="w3-center">
          <h3 style="font-size:40px; border:1px solid #ccc!important"> 제목: ${ reviewBoardVo.title }</h3>
          <table style="border:1px solid #ccc!important">
            <tr style="border:1px solid #ccc!important">
              <td width= 300px; style="text-align: left; padding: 10px 15px;"><strong>작성자:</strong> &nbsp; ${ reviewBoardVo.writer }</td>
              <td width= 300px; style="text-align: left"><strong>지역:</strong></td>
              <td style="text-align: left; padding-right: 644px;"><strong>작성일:</strong> &nbsp; ${ reviewBoardVo.indate } </td>
             </tr>
          </table>
        </div>
        <div class="w3-justify" >
          <p style="padding: 20px 20px; border: 1px solid #ccc; ">${ reviewBoardVo.cont }</p>
          <div style="height: 45px; padding-bottom: 50px; border-width: 0px 0px 2px 0px; border-style: solid; border-color: rgba(224, 221, 221, 0.8);">
            <table class="w3-right">
              <tr>
                <td>
                  <form name = "RVUpdateBoard" method = "get">
                    <input type = "hidden" name ="board_number" value= "${reviewBoardVo.board_number}"/>
                    <input type = "hidden" name = "menu_id" value= "${menu_id}"/>
                    <input type = "hidden" name=  "writer"  value = "${reviewBoardVo.writer}"/>
                    <button type = "button" id = "update" onClick = "UpdateBoard_()" style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px;border-radius: 10%"><b>수정</b></button>
                  </form>
                </td>
                <td>
                  <input type = "button" style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%" id = "delete" value= "삭제" onclick = "DeleteBoard()"</button>
                  <a href="/Board/reviewList?menu_id=MENU_02&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>
                  <a href="javascript:history.back()">이전으로</a>
                  <a href="/">Home</a>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
function UpdateBoard_(){
if("${nickName}" != "${reviewBoardVo.writer}"){
alert("본인이 작성한 게시글만 수정 가능합니다");
}
else{
$("#update").on("click", function(){
let formobj = $("form[name='RVUpdateBoard']");
formobj.attr("action", "/Board/RVUpdateForm");
formobj.submit();
});
}
}
</script>


</body>
</html>