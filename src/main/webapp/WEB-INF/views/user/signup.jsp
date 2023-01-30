<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>회원가입</title>
<style>
.rightAside {
	float: right;
	width: 20%;
	height: 100%;
}
.leftAside {
	float: left;
	width: 20%;
	height: 100%;
}
div.signup{
  width: 600px;
  height: 600px;
  border: 1px solid #000;
  border-radius: 10px;
  text-align: left;
  padding: 40px 40px;
  font-family:'d2coding';
  float:left;
}
</style>
<script>
function checkSpacebar(){
  let kcode = event.keyCode;
  if(kcode == 32) event.returnValue = false;
}
$(function(){
  let lastId = "";
  let lastName = "";
  let lastPw = "";
  let lastPwCk = "";
  let lastEmail = "";
  let lastEmailCode = "";
  let timer = null;
  let isRunning = false;
  $('form').on('submit',function(e){
    let g1 = $('[name=genre1]').val();
    let g2 = $('[name=genre2]').val();
    let g3 = $('[name=genre3]').val();
    let email = "${user.email}";
    if($('[name=u_id]').val()==''){
      alert('아이디를 입력하세요.');
      return false;
    }
    if($('[name=idCheckResult]').html()== ""){
      alert('아이디 중복확인을 해주세요.');
      return false;
    }
    if($('[name=idCheckResult]').html()== "중복된 아이디입니다."){
      alert('중복된 아이디 입니다. 다시 확인해 주세요.');
      return false;
    }
    if($('[name=u_id]').val()!=lastId){
      $("#idCheckResult").empty();
      alert('아이디 중복확인을 다시 해주세요.');
      return false;
    }
    if($('[name=n_name]').val()==''){
      alert('닉네임을 입력하세요.');
      return false;
    }
    if($('[name=nnCheckResult]').text()== ""){
      alert('닉네임 중복확인을 해주세요.');
      return false;
    }
    if($('[name=n_name]').val()!=lastName){
      $("#nnCheckResult").empty();
      alert('닉네임 중복확인을 다시 해주세요.');
      return false;
    }
    if($('[name=nnCheckResult]').text()== "중복된 닉네임입니다."){
      alert('중복된 닉네임입니다.');
      return false;
    }
    if($('[name=pw]').val()==''){
      alert('비밀번호를 입력하세요.');
      return false;
    }
    if($('[name=pw]').val()!=lastPw){
      $("#pwJCheckResult").empty();
      alert('비밀번호를 확인해 주세요.');
      return false;
    }
    if($('[name=pwck]').val()!=lastPwCk){
      $("#pwCheckResult").empty();
      alert('비밀번호 확인을 확인해 주세요.');
      return false;
    }
    if($('#pwCheckResult').html()== ""){
      alert('비밀번호확인을 확인해 주세요.');
      return false;
    }
    if($('#pwCheckResult').html()== "비밀번호가 일치하지 않습니다."){
      alert('비밀번호가 일치하지 않습니다.');
      return false;
    }
    if($('#pwJCheckResult').text()== "영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다."){
      alert('비밀번호는 영문과 특수문자, 숫자를 포함한 8자 이상이어야 합니다.');
      return false;
    }
    if($('#pwJCheckResult').text()== "동일한 문자를 연속해서 사용할 수 없습니다."){
      alert('동일한 문자를 연속해서 사용할 수 없습니다.');
      return false;
    }
    if($('#pwJCheckResult').text()== "ID를 포함할 수 없습니다."){
      alert('ID를 포함할 수 없습니다.');
      return false;
    }
    if($('#pwJCheckResult').text()== "특수문자는 !@#$^*+=-만 사용 가능합니다."){
      alert('특수문자는 !@#$^*+=-만 사용 가능합니다.');
      return false;
    }
    if($('[name=email]').val()== ""){
      alert('이메일을 입력해 주세요.');
      return false;
    }
    if($('[name=email]').val() != lastEmail){
      $("#enumsendResult").empty();
      alert('입력한 이메일이 변경 됐습니다. 확인해 주세요.');
      return false;
    }
    if($('[name=enumsendResult]').text()== "인증번호가 발송 됐습니다."){
      if($('[name=emailcode]').val() != lastEmailCode){
        $("#enumckResult").empty();
        alert('입력한 인증번호가 변경 됐습니다. 확인해 주세요.');
        return false;
      }
      if($('[name=emailcode]').val()== ""){
        alert('인증번호를 입력해 주세요.');
        return false;
      }
      if($('[name=enumckResult]').text()== "인증번호가 일치하지 않습니다."){
        alert('인증번호를 확인해 주세요.');
        return false;
      }
      if($('[name=enumckResult]').text()== ""){
        alert('인증번호 확인을 해주세요.');
        return false;
      }
    }
    if(g1==''){
      alert('첫번째 장르를 선택해 주세요.');
      return false;
    }
    if(g2==''){
      alert('두번째 장르를 선택해 주세요.');
      return false;
    }
    if(g3==''){
      alert('세번째 장르를 선택해 주세요.');
      return false;
    }
    if(g1==g2 || g1==g3 || g2==g3){
      alert('장르가 중복입니다.');
      return false;
    }
  });

  $('#idCheck').on('click', function(e){
    let u_id = $('[name=u_id]').val();
    lastId = u_id;
    let regx = /^[a-zA-Z0-9]*$/;
    if(!regx.test(u_id)){
      $("#idCheckResult").text('아이디는 영문 대소문자, 숫자만 입력 가능합니다.');
      return false;
    }
    $.ajax({
      type : 'POST',
      url : "useridCheck",
      dataType : "text",
      data : {
        "u_id" : u_id
      },
      success : function(useridCheck){
        $("#idCheckResult").html(useridCheck);
      }
    })
    e.preventDefault();
    e.stopPropagation();
  });

  $('#nnCheck').on('click', function(e){
    let n_name = $('[name=n_name]').val();
    lastName = n_name;
    $.ajax({
      type : 'POST',
      url : "nnCheck",
      dataType : "text",
      data : {
        "n_name" : n_name
      },
      success : function(nnCheck){
        $("#nnCheckResult").html(nnCheck);
      }
    })
    e.preventDefault();
    e.stopPropagation();
  });

  $('[name=pw]').focusout(function(e){
    let pw = $('[name=pw]').val();
    let u_id = $('input[name=u_id]').val();
    let ck = "ck";
    let param = {"pw":pw, "u_id":u_id, "ck":ck};
    lastPw = pw;
    $.ajax({
      type : 'POST',
      url : "ckPwJ",
      dataType : "text",
      data : param,
      success : function(nnCheck){
        $("#pwJCheckResult").text(nnCheck);
        $("#pwCheckResult").text("");
      }
    })
  });

  $('[name=pwck]').focusout(function(e){
    let passwd = $('[name=pw]').val();
    let passwdCheck = $('[name=pwck]').val();
    lastPwCk = passwdCheck;
    if (passwd == passwdCheck){
      $('#pwCheckResult').html("비밀번호가 일치합니다.")
    } else{
      $('#pwCheckResult').html("비밀번호가 일치하지 않습니다.")
    }
  });

  $('#enumck').on('click', function(){
    $("#enumckResult").text("");
    let ecodeck = $('input[name=emailcode]').val();
    lastEmailCode = ecodeck;
    if($('#enumsendResult').text() != "인증번호가 발송 됐습니다."){
      $("#enumckResult").text("인증번호발송 버튼을 클릭해 주세요.");
      return false;
    }
    if(ecodeck == ""){
      $("#enumckResult").text("인증번호를 입력해 주세요.");
    }
    $.ajax({
      type : 'POST',
      url : "findecodeck",
      dataType : "text",
      data : {
        "ecodeck" : ecodeck
      },
      success : function(en){
        $("#enumckResult").text(en);
        $("#timer").empty();
        isRunning = false;
      }
    });
  });

  $('#enumsend').on('click', function(e){
    $("#enumsendResult").text("");
    // let regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    let regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    let email = $('input[name=email]').val();
    lastEmail = email;
    if(email == ""){
      $("#enumsendResult").text("이메일을 입력 주세요.");
      return false;
    }
    if(email == '' || email == 'undefined') return false;
    if(email.match(regExp) != null){
      $("#enumsendResult").text("");
        $.ajax({
          type : 'POST',
          url : "user/email",
          dataType : "text",
          data : {
            "email" : email
          },
          success : function(enumsend){
            $("#enumsendResult").text(enumsend);
            $("#enumck").attr("disabled", false);
            $("#enumckResult").empty();
            /*
            let display = $("#timer");
            // 유효시간 설정
            let leftSec = 15;
            // 버튼 클릭 시 시간 연장
            if(isRunning){
              clearInterval(timer);
              display.html("");
              startTimer(leftSec, display);
            }else{
            	startTimer(leftSec, display);
            }
            */
          }
        });
        return false;
    } else {
        $("#enumsendResult").text("올바른 이메일 형식이 아닙니다.");
        return false;
      }
  });
/*
  //인증 완료하면 시간 멈추게 하고 번호 다시 보내면 시간 새롭게 갱신 되도록 하기
  //이메일 인증 타이머
  function startTimer(count, display) {
    let minutes, seconds;
    timer = setInterval(function () {
      minutes = parseInt(count / 60, 10);
      seconds = parseInt(count % 60, 10);

      minutes = minutes < 10 ? "0" + minutes : minutes;
      seconds = seconds < 10 ? "0" + seconds : seconds;

      display.html(minutes + ":" + seconds);

      // 타이머 끝
      if (--count < 0) {
        clearInterval(timer);
        display.html("시간초과");
        $("#enumck").attr("disabled", true);
        isRunning = false;
      }
    }, 1000);
    isRunning = true;
  }
*/
});

</script>
</head>
<body>
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
  <h1 class="headerB"><b>Game List</b></h1>
</header>
<div style="width: 100%; height: 500px;  ">
  <div>
    <aside class="leftAside">
      <h1> </h1>
    </aside>
  </div>
  <div>
    <aside class="rightAside">
      <%@ include file="/WEB-INF/include/loginbox.jsp" %>
      <br><br>
      <%@ include file="/WEB-INF/include/topgame.jsp" %>
    </aside>
  </div>
  <div class="signup">
    <form action="/signup" method="POST" encType = "multipart/form-data">
      <p>아이디 : <input type="text" name="u_id" maxlength="20" onkeydown="checkSpacebar();"/>
        <button id="idCheck" type="button">중복확인</button>
        <span id="idCheckResult" name="idCheckResult"></span>
      </p>
      <p>닉네임 : <input type="text" name="n_name" maxlength="12" onkeydown="checkSpacebar();"/>
        <button id="nnCheck" type="button">중복확인</button>
        <span id="nnCheckResult" name="nnCheckResult"></span>
      </p>
      <p>비밀번호 : <input type="password" name="pw" maxlength="15" onkeydown="checkSpacebar();"/><span id="pwJCheckResult" name="pwJCheckResult"></span></p>
      <p>비밀번호 확인 : <input type="password" name="pwck" maxlength="15" onkeydown="checkSpacebar();"/><span id="pwCheckResult" name="pwCheckResult"></span></p>
      <p>8~15자 영문 대 소문자, 숫자, 특수문자를 사용해 주세요.</p>
      <p>이메일 : <input type="text" name="email" onkeydown="checkSpacebar();"/><button id="enumsend" name="enumsend" type="button">인증번호전송</button>
        <span id="enumsendResult" name="enumsendResult"></span>
      </p>
      <p>인증번호 : <input type="text" placeholder="인증번호 6자리를 입력해 주세요." name="emailcode" id="emailcode" maxlength="6" onkeydown="checkSpacebar();"/>
        <span id="timer" name="timer"></span>
        <button id="enumck" name="enumck" type="button" >인증번호확인</button><span id="enumckResult" name="enumckResult"></span>
      </p>
      <p>선호 장르1 :
        <select name="genre1">
          <option value="">선호 장르1</option>
          <option value="RPG">RPG</option>
          <option value="어드벤쳐">어드벤쳐</option>
          <option value="FPS">FPS</option>
          <option value="스포츠">스포츠</option>
          <option value="TCG">TCG</option>
          <option value="보드">보드</option>
          <option value="레이싱">레이싱</option>
          <option value="슈팅">슈팅</option>
          <option value="액션">액션</option>
          <option value="시뮬레이션">시뮬레이션</option>
          <option value="RTS">RTS</option>
          <option value="퍼즐">퍼즐</option>
          <option value="리듬액션">리듬액션</option>
          <option value="SNG">SNG</option>
          <option value="AOS">AOS</option>
          <option value="기타">기타</option>
        </select>
      </p>
      <p>선호 장르2 :
        <select name="genre2">
          <option value="">선호 장르2</option>
          <option value="RPG">RPG</option>
          <option value="어드벤쳐">어드벤쳐</option>
          <option value="FPS">FPS</option>
          <option value="스포츠">스포츠</option>
          <option value="TCG">TCG</option>
          <option value="보드">보드</option>
          <option value="레이싱">레이싱</option>
          <option value="슈팅">슈팅</option>
          <option value="액션">액션</option>
          <option value="시뮬레이션">시뮬레이션</option>
          <option value="RTS">RTS</option>
          <option value="퍼즐">퍼즐</option>
          <option value="리듬액션">리듬액션</option>
          <option value="SNG">SNG</option>
          <option value="AOS">AOS</option>
          <option value="기타">기타</option>
        </select>
      </p>
      <p>선호 장르3 :
        <select name="genre3">
          <option value="">선호 장르3</option>
          <option value="RPG">RPG</option>
          <option value="어드벤쳐">어드벤쳐</option>
          <option value="FPS">FPS</option>
          <option value="스포츠">스포츠</option>
          <option value="TCG">TCG</option>
          <option value="보드">보드</option>
          <option value="레이싱">레이싱</option>
          <option value="슈팅">슈팅</option>
          <option value="액션">액션</option>
          <option value="시뮬레이션">시뮬레이션</option>
          <option value="RTS">RTS</option>
          <option value="퍼즐">퍼즐</option>
          <option value="리듬액션">리듬액션</option>
          <option value="SNG">SNG</option>
          <option value="AOS">AOS</option>
          <option value="기타">기타</option>
        </select>
      </p>
      <p>중복되지 않도록 선택해 주세요.</p>
      <p><button>가입하기</button></p>
    </form>
  <div>
</div>
</body>
<script>
</script>
</html>
