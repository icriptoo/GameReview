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
  function check_onclick(){
  		theForm=document.form1;

  		if(theForm.type_idx.value=="none"){
  			alert("분류를 선택해 주세요.");
  			return false;
  		}
  		if(theForm.cont.value==""){
  			alert("내용을 입력해 주세요.");
  			return false;
  		}

        	var queryString = $("form[name=form1]").serialize() ; // 폼 데이터 가져오기

        	$.ajax({
        		url : "declarationInsert",
        		type : "POST",
        		data : queryString,
        		dataType : 'json',
        		success : function(data){
        		  alert(data);
  		          window.close();
        		},
        		error : function() {
        			alert("요청실패");
        		}
        	})

  	}
</script>
<title>신고하기</title>
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
table {
  width: 500px;
  height: 300px;
  background-color: #c0c0c0;
  border-collapse: collapse;
  border-radius: 10px;
  border-style: hidden;
  box-shadow: 0 0 0 1px #000;
}
td, th {
  border : 1px solid black;
  border-collapse : collapse;
};


</style>
</head>
<body class="w3-light-grey">
    <h3 style = "text-align:center"><b>신고하기</b></h3>

<div style="width: 100%; height: 500px; ">

  <form name="form1" id="form1">
    <input type="hidden" name="us_id" value="${us_id}" />
    <input type="hidden" name="ue_id" value="${ue_id}" />
    <input type="hidden" name="b_idx" value="${b_idx}" />
  <table>
      <tr>
        <th style= "width:10%; height:10%; text-align:center">분류</th>
        <td style="font-size:20px;">
                  <select name="type_idx" id="type_idx">
                    <option value="none" selected>선택</option>
                    <option value=1>불건전한 내용</option>
                    <option value=2>스팸 및 부적절한 홍보</option>
                    <option value=3>명예훼손 및 비방</option>
                    <option value=4>초상권 및 저작권 침해</option>
                    <option value=5>개인정보 도용</option>
                    <option value=6>기타</option>
                  </select>
                </td>
      </tr>
      <tr>
          <th style="text-align:center">내용</th>
          <td><input  type="text" name="cont" id="cont" style="width:90%;height:400px;font-size:15px;" /></td>
      </tr>

      <tr>
        <td style="height:10%; text-align:center" colspan="2">
          <button type="button" style="width:80px; height:40px; font-size:20px; float: center" onclick="check_onclick()">저장</button>
          </td>
      </tr>
  </table>
  </form>



</div>

</body>
</html>
