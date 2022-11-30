<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banana Quick</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap');

.make-row {
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: -15px;
    margin-left: -15px;
}

*, body {
    font-family: 'Poppins', sans-serif;
    font-weight: 400;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

html, body {
    height: 100%;
    background-color: #152733;
    overflow: hidden;
}


.form-holder {
      background-color: rgb(30, 38, 78);
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      min-height: 100vh;
}

.form-holder .form-content {
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 60px;
}

.form-content .form-items {
    background-color: rgb(65, 80, 145);
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 540px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: left;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
    box-shadow: 1px 1px 50px rgb(131 193 221);
}

.form-content h3 {
    color: #fff;
    text-align: left;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 5px;
}

.form-content h3.form-title {
    margin-bottom: 30px;
}

.form-content p {
    color: #fff;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
    color: #fff;
}

.form-content input[type=text], .form-content input[type=password], .form-content input[type=email], .form-content select {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #fff;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
}

.form-content textarea {
    position: static !important;
    width: 100%;
    padding: 8px 20px;
    border-radius: 6px;
    text-align: left;
    background-color: #fff;
    border: 0;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    outline: none;
    resize: none;
    height: 120px;
    -webkit-transition: none;
    transition: none;
    margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
    border: 0;
    background-color: #ebeff8;
    color: #8D8D8D;
}

.mv-up{
    margin-top: -9px !important;
    margin-bottom: 8px !important;
}

.invalid-feedback{
    color: #ff606e;
}

.valid-feedback{
   color: #2acc80;
}

.idCheck-button{
  float: right;
  cursor: pointer;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  padding: 30px;
  margin: auto;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: rgba(0, 0, 0, 0.8);
  overflow: hidden;
  opacity: 0.4;
  box-shadow: 10px 10px 30px #000;}

.button{
  font-family: 'Open Sans Condensed', sans-serif;
  text-decoration: none;
  position: relative;
  width: 20%;
  display: block;
  margin-bottom: 9px;
  font-size: 17px;
  color: #fff;
  padding: 8px;
  border-radius: 6px;
  border: none;
  background: rgba(3,3,3,.1);
  -webkit-transition: all 2s ease-in-out;
  -moz-transition: all 2s ease-in-out;
  -o-transition: all 2s ease-in-out;
  transition: all 0.2s ease-in-out;
}

.button{
  font-family: 'Open Sans Condensed', sans-serif;
  text-align: center;
  padding: 4px 8px;
  background: rgba(107,255,3,0.3);
}

.button:hover{
  opacity: 0.7;
}
</style>
    <script>

    $(function () {
'use strict'
const forms = document.querySelectorAll('.requires-validation')
Array.from(forms)
  .forEach(function (form) {
    form.addEventListener('submit', function (event) {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})

function email_check( email ) {

    var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email));

}

const autoHyphen = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}


$(function(){

    $('[name=email]').on('focusout',function(){

            var email = $(this).val();

            if( email == '' || email == 'undefined') return;

            if(! email_check(email) ) {
                $('#emailCheck').html('잘못된 형식의 이메일 주소입니다.');
            } else {
                $('#emailCheck').html('정확한 이메일입니다.');
            }
        });

    $('form').on('submit',function(e){

        if($('[name=userid]').val()==''){
            alert('아이디를 입력하세요');
            return false;
        }

        if($('[name=idCheckResult]').html()== "중복된 아이디입니다."){
            alert('중복확인을 다시 해주세요');
            return false;
        }

        if($('[name=passwd]').val()==''){
            alert('비밀번호를 입력하세요');
            return false;
        }

        if($('#passwdCheck').html()== "비밀번호가 일치하지 않습니다."){
            alert('비밀번호가 일치 않네요!');
            return false;
        }

        if($('[name=nickname]').val()==''){
            alert('닉네임을 입력하세요');
            return false;
        }

        if($('[name=email]').val()==''){
            alert('이메일을 입력하세요');
            return false;
        }

        if($('#emailCheck').html()== "잘못된 형식의 이메일 주소입니다."){
            alert('이메일이 틀렸어요!');
            return false;
        }

        if($('[name=phoneNumber]').val() == ''){
            alert('전화번호를 입력해주세요');
            return false;
        }

        if($('[name=phoneNumber]').val().length != 13){
            alert('전화번호는 -포함 13자리어야 해요');
            return false;
        }

        if($('[name=user_local]').val()==''){
            alert('지역을 선택해주세요');
            return false;
        }

    });

    $('#idCheck').on('click', function(e){

        let userid = $('[name=userid]').val();

        $.ajax({
            type : 'POST',
            url : "useridCheck",
            dataType : "text",
            data : {
                userid : userid
            },
            success : function(useridCheck){
                $("#idCheckResult").html(useridCheck);
            }
        })
        e.preventDefault();
        e.stopPropagation();
    });

    $('[name=passwdCheck]').keyup(function(){
        let passwd = $('[name=passwd]').val();
        let passwdCheck = $('[name=passwdCheck]').val();

        if (passwd == passwdCheck){
            $('#passwdCheck').html("비밀번호가 일치합니다.")
        } else{
            $('#passwdCheck').html("비밀번호가 일치하지 않습니다.")
        }
    })

});
</script>


</head>
<body>
<div class="form-body">
  <div class="make-row">
    <div class="form-holder">
      <div class="form-content">
        <div class="form-items">
          <h3 style="text-align: center">회원가입</h3>
          <form action="/userInsert" class="requires-validation">
            <div class="col-md-12">
              <input class="form-control" name="userid" type="text" placeholder="ID"/>
              <table>
                <tr>
                  <td>
                    <button type="button"  id="idCheck" class="button"
                      style=" margin-top: 10px;padding-top: 4px;padding-bottom: 4px;padding-left: 8px;padding-right: 8px;width: 86px; font-size: 15px;">중복확인</button>
                  </td>
                  <td>
                    <span id="idCheckResult" name="idCheckResult" style="color:#efe2c9; font-size:15px;"></span>
                  </td>
                </tr>
              </table>
            </div>
            <div class="col-md-12">
              <input class="form-control" type="password" name="passwd" placeholder="password"/>
            </div>
            <div class="col-md-12">
              <input class="form-control" type="password" name="passwdCheck" placeholder="passwordCheck"/>
            </div>
            <div class="col-md-12">
              <span id="passwdCheck" style="color:#efe2c9; font-size:15px;"></span>
            </div>
            <div class="col-md-12">
              <input class="form-control" name="nickname" type="text" placeholder="NickName"/>
            </div>
            <div class="col-md-12">
              <input class="form-control" name="email" type="text" placeholder="EMail"/>
            </div>
            <div class="col-md-12">
              <span id="emailCheck" style="color:#efe2c9; font-size:15px;"></span>
            </div>
            <div class="col-md-12">
              <input class="form-control" name="phoneNumber" type="text" oninput="autoHyphen(this)" maxlength="13" placeholder="000-0000-0000" autofocus/>
            </div>
            <div class="col-md-12">
              <select class="form-select mt-3" id="LOACTION" name="user_local">
                <option value="">장르명</option>
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
            </div>
            <div class="col-md-12 mt-3">
              <input type="radio" class="btn-check" name="rider" value="normal" autocomplete="off" checked>
              <label style="color:#efe2c9; font-size:15px;">퀵을 맡기시나요?</label>
              <input type="radio" class="btn-check" name="rider" value="rider" autocomplete="off" required>
              <label style="color:#efe2c9; font-size:15px;">퀵을 가시나요?</label>
            </div>
            <div class="form-button mt-3">
              <button id="submit" type="submit" class="button" style="margin-left: 15px;">Register</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>