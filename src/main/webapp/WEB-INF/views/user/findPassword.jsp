<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>비밀번호 찾기</title>
<script>
function enumsendEnter(){
  if(window.event.keyCode == 13){
    $("#enumsendResult").text("");
    let regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    let u_id = $('input[name=u_id]').val();
    let email = $('input[name=email]').val();
    if (u_id == ""){
      alert("아이디를 입력해 주세요.");
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
  }
};
$(function(){
  $('#enumsend').on('click', function(e){
    $("#enumsendResult").text("");
    let regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    let u_id = $('input[name=u_id]').val();
    let email = $('input[name=email]').val();
    if(u_id == ""){
      alert("아이디를 입력해 주세요.");
      return;
    }
    if(email == ""){
      alert("이메일을 입력해 주세요.");
      return;
    }
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



  $('#findpw').on('click', function(e){
    if($('[name=u_id]').val() == ""){
      alert('아이디을 입력해 주세요.');
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
    if($('[name=enumsendResult]').text() == "인증번호가 발송 됐습니다."){
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
      let u_id = $('input[name=u_id]').val();
      let email = $('input[name=email]').val();
      let param = {"u_id" : u_id, "email" : email}
      $.ajax({
        type : 'POST',
        url : "changePwIdCk",
        dataType : "text",
        data : param,
        success : function(pw){
          if(pw === "y"){
            document.getElementById("changePw").style.display = "";
            document.getElementById("findpw").style.display = "none";
          }
        }
      });
    }
    e.preventDefault();
    e.stopPropagation();
  });

  $('#emailcode').keyup(function(){
    $("#enumckResult").text("");
    let ecodeck = $('input[name=emailcode]').val();
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

  $('#chPw').keyup(function(e){
    let pw = $('input[name=chPw]').val();
    let u_id = $('[name=u_id]').val();
    let email = $('input[name=email]').val();
    let ck = "ck";
    let param = {"pw":pw, "u_id":u_id, "ck":ck, "email":email};

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

  $('#chPwCk').keyup(function(e){
    let passwd = $('[name=chPw]').val();
    let passwdCheck = $('[name=chPwCk]').val();

    if (passwd == passwdCheck){
      $('#pwCheckResult').html("비밀번호가 일치합니다.")
    } else{
      $('#pwCheckResult').html("비밀번호가 일치하지 않습니다.")
    }
  });
});
</script>
</head>
<body>
<header>
    <h1>비밀번호 변경</h1>
</header>
<div style="height:70%">
  <p>
    아이디 <input id="u_id" name="u_id" type="text" style="width:50%" onkeyup="enumsendEnter()">
  </p>
  <p>
    이메일 <input id="email" name="email" type="text" style="width:50%" onkeyup="enumsendEnter()">
    <button id="enumsend" name="enumsend">인증번호전송</button>
    <span id="enumsendResult" name="enumsendResult"></span>
  </p>
  <p>
    인증번호 <input type="text" id="emailcode" name="emailcode" placeholder="인증번호 6자리를 입력해 주세요." style="width:50%">
    <span id="enumckResult" name="enumckResult"></span>
  </p>
  <div id="changePw">
    <p>변경할 비밀번호 <input type="password" id="chPw" name="chPw"><span id="pwJCheckResult" name="pwJCheckResult"></span></p>
    <p>변경할 비밀번호 확인 <input type="password" id="chPwCk" name="chPwCk"><span id="pwCheckResult" name="pwCheckResult"></p>
    <p><button id="changePwbtn" onclick="chpwbtn()">변경하기</button></p>
  </div>
  <p><span id="userpwCheck" name="userpwCheck"></span></p>
  <p>
   <a id="findpw" href=''>인증</a>
    <a id="close" href='javascript:window.close();'>닫기</a>
  </p>
</div>
</body>
<script>
document.getElementById("changePw").style.display = "none";

function chpwbtn(){
  if($('#chPw').val() == ""){
    alert('변경할 비밀번호를 입력해 주세요.');
    return false;
  }
  if($('#chPwCk').val() == ""){
    alert('변경할 비밀번호 확인을 입력해 주세요.');
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
  if($('#pwJCheckResult').text()== "기존 비밀번호와 동일합니다."){
    alert('기존 비밀번호와 동일합니다.');
    return false;
  }
  if($('#pwJCheckResult').text()== "특수문자는 !@#$^*+=-만 사용 가능합니다."){
    alert('특수문자는 !@#$^*+=-만 사용 가능합니다.');
    return false;
  }
  if($('#pwCheckResult').html()== "비밀번호가 일치하지 않습니다."){
    alert('입력한 비밀번호가 일치하지 않습니다.');
    return false;
  }
  if($('[name=pwCheckResult]').text() == "비밀번호가 일치합니다."){
    let u_id = $('input[name=u_id]').val();
    let changePw = $('#chPwCk').val();
    let param = {"u_id":u_id, "pw":changePw}
    alert("비밀번호가 변경됐습니다.");
    location.href = "/changePw?u_id="+u_id+"&pw="+changePw;
  }
}
</script>
</html>


