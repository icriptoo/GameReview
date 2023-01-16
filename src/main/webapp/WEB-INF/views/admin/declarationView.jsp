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
	height: 2000px;
}
ul{
    list-style:none;
}
.eGName{
    color:#c0c0c0;
}
table.a {
  width: 800px;
  height: 500px;
  background-color: #c0c0c0;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
table.b {
  width: 800px;
  height: 100px;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
table.a td, th {
  border : 1px solid black;
  border-collapse : collapse;
}
table.b tr {
  border : 1px solid black;
  border-collapse : collapse;
}
table.b td {
  border : 1px solid black;
  border-collapse : collapse;
}
textarea {
  width: 50%;
  max-height: 500px;
  border: none;
  resize: none;
}
</style>

</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
  <h1 class="headerB"><b>Game List</b></h1>
</header>
<div>
  <div>
    <aside class="leftAside">
      <h1>left</h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <table class="a">
    <div>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">분류</th>
        <td>${title}</td>
      </tr>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">신고대상</th>
        <td>${detail.ue_id}</td>
      </tr>
      <tr>
        <th style= "width:8%; height:10%; text-align:center">관련게시글</th>
        <td>
          <button style="font-size:20px;" onClick="location.href='#'" >글보러가기</button>
        </td>
      </tr>
      <tr>
        <th style="text-align:center">신고내용</th>
        <td>${detail.cont}</td>
      </tr>
      <tr>
        <th style="width:8%; height:10%; text-align:center">신고자</th>
        <td>${detail.us_id}</td>
      </tr>
      <tr>
        <th style="width:8%; height:10%; text-align:center">신고처리</th>
        <td>
          <button style="font-size:20px;" onClick="location.href='/declarationList'" >접수</button>
          <button style="font-size:20px;" onClick="location.href='/declarationList'" >거부</button>
        </td>
      </tr>

      <tr>
        <td style="height:10%; text-align:right" colspan="2">
          <button style="font-size:20px;" onClick="location.href='/declarationList'" >목록으로</button>
        </td>
      </tr>
    </div>
  </table>
  <div id="replylist-box"></div>
    <div class="replyin_box" id="replyin_box">
      <div>${login.u_id}</div><br>
      <div><textarea type="textarea" id="replytext" placeholder="내용을 입력해 주세요."></textarea></div>
      <div style="float: center" id="replybtn"><button>작성</button></div>
    </div>
  <div id="replyP-box"></div>
</div>
</body>
<script>
document.getElementById('replylist-box').style.display = 'none'
document.getElementById('replyin_box').style.display = 'none'
if(${boardVo.menu_id} < 3){
  document.getElementById('replyin_box').style.display = 'block'
  document.getElementById('replylist-box').style.display = 'block'
  window.addEventListener('load',replyList);
  window.onload = replyP;
}
$("#replybtn").click(function(){
  let cont  = $("#replytext").val();
  let g_idx = "${boardVo.g_idx }";
  let menu_id = "${boardVo.menu_id}";
  let u_id = "${login.u_id}";
  let b_idx = "${boardVo.b_idx}";
  let param = {"cont":cont, "g_idx":g_idx, "b_idx":b_idx, "menu_id":menu_id, "u_id":u_id};

  if(u_id == ""){
    alert("로그인을 해주세요.");
    return false;
  }

  $.ajax({
    type: "post",
    url: "/replywrite",
    data: param,
    success: function(result){
      alert("댓글이 등록되었습니다");
      $("#replytext").val('');
      replyList();
      window.location.reload();
    }
  });
});
function replyList(){
  let b_idx = "${boardVo.b_idx}";
  let pageNum = "${pageNum}";
  let contentNum = "${contentNum}";
  let param = {"b_idx":b_idx, "pageNum":pageNum, "contentNum":contentNum};

  $.ajax({
    type: "post",
    url: "/replyselect",
    data: param,
    success: function(list){
      let replylen = list.length;
      let u_id = "${login.u_id}";
      let html = "";
      html += '<table class="b" id="b">';
      for(let i=0; i<replylen; i++){
        html += '<tr>';
        html += '<td rowspan="3" style="width:52px"><img src="/img/userProfile/'+list[i].u_id+'/'+list[i].img+'" class="w3-circle" alt="UserProfile" style="width:80%"/></td>';
        html += '<td colspan="2">'+list[i].u_id+'</td>';
        html += '</tr>';
        html += '<tr>';
        html += '<td colspan="2" id="replycont'+ list[i].r_idx +'">'+list[i].cont+'</td>';
        html += '</tr>';
        html += '<tr>';
        html += '<td>'+list[i].indate+'</td>';
        if(list[i].u_id === u_id){
          html += '<td><button id="replyUpdate" style="font-size:20px;" onclick="replyUpdateForm('+list[i].r_idx+')">수정</button>';
          html += '<button id="replyDelete" style="font-size:20px;" onclick="replyDelete('+list[i].r_idx+')">삭제</button></td>';
        }
        html += '</tr>';
      }
      html += '</table>';
      if (replylen == 0){
        document.getElementById('b').style.display = 'none'
      }
      $('#replylist-box').html(html);
    }
  });
};

function replyP(){
  let b_idx = "${boardVo.b_idx}";
  let pageNum = "${pageNum}";
  let contentNum = "${contentNum}";
  let param = {"b_idx":b_idx, "pageNum":pageNum, "contentNum":contentNum};

  $.ajax({
    type: "post",
    url: "/replyP",
    data: param,
    success: function(list){
      let replylen = list.length;
      let u_id = "${login.u_id}";
      let startP = list.Pager.startPage;
      let endP = list.Pager.endPage;
      let lastP = list.Pager.lastPageNum;
      let html = "";
      html += '<table><tr>';
      html += '<td class="page" id="page" colspan="2" style="text-align:center;"><div class="pager">';
      if (list.Pager.prev === true){
        html += '<a href="http://localhost:8080/View?pageNum='+startP-1+'&contentNum='+(startP-1)*30+'&menu_id=${menu_id}&b_idx='+list.b_idx+'">< 이전</a>';
        html += '<a class="firstPageNum" href="/View?pageNum=1&contentNum=30">1</a> ... ';
      }
      for (startP; startP <= endP; startP++){
        html += '<a class="pageNum" href="/View?pageNum='+startP+'&contentNum='+startP*30+'&menu_id=${menu_id}&b_idx='+list.b_idx+'">'+ startP +'</a>';
      }
      if(list.Pager.next === true){
        html += ' ... <a class="lastPageNum" href="/View?pageNum='+lastP+'&contentNum='+lastP*30+'&menu_id=${menu_id}&b_idx='+list.b_idx+'">'+lastP+'</a>';
        html += '<a href="http://localhost:8080/View?pageNum='+endP+1+'&contentNum='+(endP+1)*30+'&menu_id=${menu_id}&b_idx='+list.b_idx+'">다음 ></a>';
      }
      html += '</div></td></tr></table>';
      $('#replyP-box').html(html);
    }
  });
};

</script>
</html>
