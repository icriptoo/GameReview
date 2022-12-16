<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(function(){
  $('#findUserid').on('click', function(e){
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
      }
    })
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
    닉네임 <input id="n_name" name="n_name" type="text" style="width:50%">
  </p>
  <p>
    이메일 <input id="email" name="email" type="text" style="width:50%">
  </p>
  <p>
    <span id="useridCheck" name="useridCheck"></span>
  </p>
  <p>
    <button id="findUserid">아이디 찾기</button>
  </p>
</div>
</body>
</html>


