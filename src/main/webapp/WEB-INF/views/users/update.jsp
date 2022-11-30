<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/common.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(function(){

    $('form').on('submit',function(e){
        if($('[name=nickname]').val()==''){
            alert('닉네임을 입력하세요');
            return false;
        }
        if($('[name=phoneNumber]').val()==''){
            alert('전화번호를 입력해주세요');
            return false;
        }
        if($('[name=user_local]').val()==''){
            alert('지역을 선택해주세요');
            return false;
        }

    });
});
</script>
</head>
<body>
    <%@ include file="/WEB-INF/include/menus.jsp" %>
<div id="main">
    <div class="w3-teal1">
            <table>
                <tr>
                    <td>
                        <button id="openNav" class="w3-button w3-teal1 w3-xlarge" onclick="w3_open()">&#9776;</button>
                    </td>
                    <td>
                        <div class="w3-container w3-center">
                            <h1>회원정보 수정</h1>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    <div class="w3-container w3-half w3-margin-top w3-display-middle" style="height:70%">
        <form action="/update" class="w3-container w3-card">
            <input type="hidden" name="userid" value="${userVo.userid}"></input>
            <p>
                <input type="text" name="nickname" placeholder="nickname" value="${userVo.nickname}" class="w3-input"></input>
                <label>nickname</label>
            </p>
            <p>
                <input type="text" name="phoneNumber" placeholder="000-0000-0000" value="${userVo.phoneNumber}" class="w3-input"></input>
                <label>phoneNumber</label>
            </p>
            <p>
                <select class="w3-select" id="LOACTION" name="user_local">
                    <option value="">LOCATION</option>
                        <option value="기장군">기장군</option>
                        <option value="금정구">금정구</option>
                        <option value="동래구">동래구</option>
                        <option value="연제구">연제구</option>
                        <option value="해운대구">해운대구</option>
                        <option value="수영구">수영구</option>
                        <option value="사상구">사상구</option>
                        <option value="부산진구">부산진구</option>
                        <option value="동구">동구</option>
                        <option value="서구">서구</option>
                        <option value="남구">남구</option>
                        <option value="북구">북구</option>
                        <option value="중구">중구</option>
                        <option value="영도구">영도구</option>
                        <option value="사하구">사하구</option>
                        <option value="강서구">강서구</option>
                </select>
            </p>
            <input type="radio" class="btn-check" name="rider" value="normal" autocomplete="off" checked>
            <label style="color:#efe2c9; font-size:15px;">퀵을 맡기시나요?</label>

            <input type="radio" class="btn-check" name="rider" value="rider" autocomplete="off" required>
            <label style="color:#efe2c9; font-size:15px;">퀵을 가시나요?</label>
    <button class="w3-button w3-section w3-light-green w3-ripple w3-text-white w3-right">수정 완료</a>
    </form>
</div>
</div>

<script>
</script>
</body>
</html>
