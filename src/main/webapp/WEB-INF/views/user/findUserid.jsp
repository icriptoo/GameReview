<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>아이디 찾기</title>
<script>
//인증 완료하면 시간 멈추게 하고 번호 다시 보내면 시간 새롭게 갱신 되도록 하기
//이메일 인증 타이머
let timer = null;
let isRunning = false;
function startTimer(count, display) {
  let minutes, seconds;
  timer = setInterval(function () {
    minutes = parseInt(count / 60, 10);
    seconds = parseInt(count % 60, 10);

    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    display.html(minutes + ":" + seconds);

    if($('#enumckResult').text() == "인증번호가 일치합니다."){
      isRunning = false;
      $("#timer").html("");
      return true;
    } else{
      // 타이머 끝
      if (--count < 0) {
        clearInterval(timer);
        display.html("시간초과");
        $("#enumck").attr("disabled", true);
        isRunning = false;
      }
    }
  }, 1000);
  isRunning = true;
}
function checkSpacebar(){
  let kcode = event.keyCode;
  if(kcode == 32) event.returnValue = false;
}
function enumsendEnter(){
  if(window.event.keyCode == 13){
    $("#enumsendResult").text("");
    let regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    let n_name = $('input[name=n_name]').val();
    let email = $('input[name=email]').val();
    if (n_name == ""){
      alert("닉네임을 입력해 주세요.");
      return false;
    }
    if (email == ""){
      alert("이메일을 입력해 주세요.");
      return false;
    }
    if(email.match(regExp) != null){
      $("#enumckResult").text("");
      $.ajax({
        type : 'POST',
        url : "findemailck",
        dataType : "text",
        data : {
          "n_name" : n_name,
          "email" : email
        },
        success : function(u_id){
          $("#enumsendResult").text(u_id);
        }
      });
    }else {
      $("#enumsendResult").text("올바른 이메일 형식이 아닙니다.");
    }
  }
};
$(function(){

  $('#enumsend').on('click',function(){
    $("#enumsendResult").text("");
    let regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    let n_name = $('input[name=n_name]').val();
    let email = $('input[name=email]').val();
    if (n_name == ""){
      alert("닉네임을 입력해 주세요.");
      return false;
    }
    if (email == ""){
      alert("이메일을 입력해 주세요.");
      return false;
    }
    if(email.match(regExp) != null){
      $("#enumckResult").text("");
      $.ajax({
        type : 'POST',
        url : "findemailck",
        dataType : "text",
        data : {
          "n_name" : n_name,
          "email" : email
        },
        success : function(u_id){
          $("#enumsendResult").text(u_id);
          $("#enumck").attr("disabled", false);
          $("#enumckResult").empty();

          let display = $("#timer");
          // 유효시간 설정
          let leftSec = 180;
          // 버튼 클릭 시 시간 연장
          if(isRunning){
            clearInterval(timer);
            display.html("");
            startTimer(leftSec, display);
          }else{
            startTimer(leftSec, display);
          }
        }
      });
    }else {
      $("#enumsendResult").text("올바른 이메일 형식이 아닙니다.");
    }
  });

  $('#enumck').on('click',function(){
    $("#enumckResult").text("");
    let ecodeck = $('input[name=emailcode]').val();
    if($('#enumsendResult').text() != "인증번호가 전송 됐습니다."){
      $("#enumckResult").text("인증번호전송 버튼을 클릭해 주세요.");
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
      }
    });
  });

  $('#findu_id').on('click', function(e){
    if($('[name=n_name]').val() == ""){
      alert('닉네임을 입력해 주세요.');
      return false;
    }
    if($('[name=email]').val() == ""){
      alert('이메일을 입력해 주세요.');
      return false;
    }
    if($('[name=enumsendResult]').text() == ""){
      alert("이메일 인증을 해주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "아이디와 이메일을 확인해 주세요."){
      alert("아이디와 이메일을 확인해 주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "닉네임과 이메일을 확인해 주세요."){
      alert("닉네임과 이메일을 확인해 주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "인증번호가 전송 됐습니다."){
      if($('[name=enumckResult]').text() == "인증번호가 일치하지 않습니다."){
        alert("인증번호를 확인해 주세요.");
        return false;
      }
      if($('[name=enumckResult]').text() == ""){
        alert("인증번호를 입력해 주세요.");
        return false;
      }
    }
    if($('[name=enumckResult]').text() == "인증번호가 일치합니다."){
      let n_name = $('input[name=n_name]').val();
      let email = $('input[name=email]').val();
      $.ajax({
        type : 'POST',
        url : "getUserid",
        dataType : "text",
        data : {
          "n_name" : n_name,
          "email" : email
        },
        success : function(getUserid){
          $("#useridCheck").html(getUserid);
          document.getElementById("findu_id").style.display = "none";
        }
      });
    }
    e.preventDefault();
    e.stopPropagation();
  });
});
</script>
</head>
<body>
<header>
    <h1>아이디 찾기</h1>
</header>
<div style="height:70%">
  <p>
    닉네임 <input id="n_name" name="n_name" type="text" style="width:50%" maxlength="12" onkeydown="checkSpacebar();" onkeyup="enumsendEnter()"/>
  </p>
  <p>
    이메일 <input id="email" name="email" type="text" style="width:50%" onkeydown="checkSpacebar();" onkeyup="enumsendEnter()"/>
    <button id="enumsend" name="enumsend">인증번호전송</button>
  </p>
  <p>
    <span id="enumsendResult" name="enumsendResult"></span>
  </p>
  <p>
    인증번호 <input type="text" id="emailcode" name="emailcode" placeholder="인증번호 6자리를 입력해 주세요." style="width:50%" maxlength="6" onkeydown="checkSpacebar();"/>
    <span id="timer" name="timer"></span>
    <button id="enumck" name="enumck" type="button" >인증번호확인</button>
  </p>
  <p>
    <span id="enumckResult" name="enumckResult"></span>
  </p>
  <p>
    <span id="useridCheck" name="useridCheck"></span>
  </p>
  <p>
    <a id="findu_id" href=''>찾기</a>
    <a id="close" href='javascript:window.close();'>닫기</a>
  </p>
</div>
</body>
</html>


