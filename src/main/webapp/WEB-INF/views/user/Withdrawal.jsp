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

.mypage{
  height: 800px;
  border: 1px solid #000;
  border-radius: 10px;
  text-align: center;
  margin: 50px 450px 0px 350px;
  background-color: #fff;
}
.withdrawalin{
  width: 800px;
  height: 800px;
  border: 1px solid #000;
  border-radius: 10px;
  margin-left: 100px;
  text-align: left;
  padding: 40px 40px;
  font-family:'d2coding';
  float:left;
}
.profile{
  width: 100px;
  height: 100px;
  float:left;
}
.btn_w .btn_c{
  border: 1px solid #bfbfbf;
  background: #fff;
}
.btn_w{
  font-size: 12px;
  line-height: 14px;
  display: inline-block;
  vertical-align: top;
  text-decoration: none!important;
}
</style>
<script>


</script>
</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="headerB"><b>Game List</b></h1>
</header>
<div style="width: 100%; height: 500px;  ">
  <div>
    <aside class="leftAside">
      <h1>왼쪽사이드</h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <div class="mypage">

    <div class="withdrawalin">
      <p>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.</p>
      <p>삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.</p>
      <br><br><br>
      <p>1. 탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</p>
      <p>회원정보등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.</p>
      <br><br><br><br><br>
      <p>2. 탈퇴 후에도 게시판형 서비스에 등록된 게시물은 그대로 남아있습니다.</p>
      <p>삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.</p>
      <p>탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.</p>
      <p>(자유게시글, 리뷰게시글, 댓글)</p>
      <br><br><br><br><br>
      <p><input type="checkbox" id="chb"/> 안내 사항을 모두 확인하였으며, 이에 동의합니다.</p>
      <p><button class="btn_w" id="btn_w" name="btn_w"><b class="btn_c">탈퇴하기</b></button><a href="/mypage">취소하기</a></p>
    </div>
  </div>
</div>
<script>
$('#btn_w').on('click', function(){
  if ($('#chb').prop("checked") === true){
    let out = confirm("탈퇴하시겠습니까?");
    if (out){
      var url = "/user/Wirthdrwal?u_id=${login.u_id}";
      location.href = url;
    }
  }
  if ($('#chb').prop("checked") === false){
    alert("탈퇴 안내를 확인하고 동의해 주세요.");
    return false;
  }
});
</script>
</body>
</html>
