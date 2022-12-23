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
$(function(){
  $('#enumsend').on('click', function(e){
    $("#enumsendResult").text("");
    const regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const u_id = $('input[name=u_id]').val();
    const email = $('input[name=email]').val();

    if(email.match(regExp) != null){
      $.ajax({
        type : 'POST',
        url : "findemailck",
        dataType : "text",
        data : {
          "u_id" : u_id,
          "email" : email
        },
        success : function(pw){
          $("#enumsendResult").text(pw);
        }
      });
    }else {
      $("#enumsendResult").text("올바른 이메일 형식이 아닙니다.");
    }
    e.preventDefault();
    e.stopPropagation();
  });

  $('#emailcode').keyup(function(){
    $("#enumckResult").text("");
    const ecodeck = $('input[name=emailcode]').val();
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

  $('#findwd').on('click', function(e){
    if($('[name=u_id]').val() == ""){
      alert('아이디을 입력 해주세요.');
      return false;
    }
    if($('[name=email]').val() == ""){
      alert('이메일을 입력 해주세요.');
      return false;
    }
    if($('[name=enumsendResult]').text() == ""){
      alert("이메일인증을 해주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "아이디와 이메일을 확인해주세요."){
      alert("아이디와 이메일을 확인해주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "닉네임과 이메일을 확인해주세요."){
      alert("닉네임과 이메일을 확인해주세요.");
      return false;
    }
    if($('[name=enumsendResult]').text() == "인증번호가 발송 됐습니다."){
      if($('[name=enumckResult]').text() == "인증번호가 일치하지 않습니다."){
        alert("인증번호를 확인 해주세요.");
        return false;
      }
      if($('[name=enumckResult]').text() == ""){
        alert("인증번호를 입력 해주세요.");
        return false;
      }
    }
    if($('[name=enumckResult]').text() == "인증번호가 일치합니다."){
      const u_id = $('input[name=u_id]').val();
      const email = $('input[name=email]').val();
      $.ajax({
        type : 'POST',
        url : "getPassword",
        dataType : "text",
        data : {
          "u_id" : u_id,
          "email" : email
        },
        success : function(pw){
          $("#useridCheck").html(pw);
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
    <h1>비밀번호 찾기</h1>
</header>
<div style="height:70%">
  <p>
    아이디 <input id="u_id" name="u_id"" type="text" style="width:50%"/>
  </p>
  <p>
    이메일 <input id="email" name="email" type="text" style="width:50%"/>
    <button id="enumsend" name="enumsend">인증번호전송</button>
    <span id="enumsendResult" name="enumsendResult"></span>
  </p>
  <p>
    인증번호 <input type="text" id="emailcode" name="emailcode" placeholder="인증번호 6자리를 입력해주세요." style="width:50%"/>
    <span id="enumckResult" name="enumckResult"></span>
  </p>
  <p>
    <span id="useridCheck" name="useridCheck"></span>
  </p>
  <p>
    <button id="findwd">찾기</button>
  </p>
</div>
</body>
</html>


