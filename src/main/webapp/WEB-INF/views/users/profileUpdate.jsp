<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>


<style>
html {
   background-color: rgb(30, 38, 78);
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  overflow: hidden;
}

/* Login container */
#container{
  text-align:center;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  width: 400px;
  height: 150px;
  border-radius: 5px;
  background: rgb(65, 80, 145);
  box-shadow: 1px 1px 50px rgb(131 193 221);
}
/* Heading */
h1{
  font-family: 'Open Sans Condensed', sans-serif;
  position: relative;
  margin-top: 0px;
  text-align: center;
  font-size: 30px;
  color: #ddd;
}

/* Inputs */
input{
  font-family: 'Open Sans Condensed', sans-serif;
  text-decoration: none;
  position: relative;
  width: 80%;
  display: block;
  margin: 9px auto;
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

input:focus{
  outline: none;
  box-shadow: 3px 3px 10px #333;
  background: rgba(3,3,3,.18);
}

.button-profile:hover{
  opacity: 0.7;
}

.button-profile{
        text-align: center;
        margin: auto 3px;
        font-size: 15px;
        background-color: rgba(107,255,3,0.3);
        color: #212529;
        border: none;
        border-width: 1px;
        border-radius: 15px;
        padding: 5px;
            width: 110px;
            height: 40px;
     }



</style>


</head>
<body>
    <div id="container">
    <header >
            <h1>프로필 추가</h1>
        </header>
        <form action="/profileUpdate" method="POST" encType = "multipart/form-data">
            <input type="file" id="image" accept="image/*" onchange="setThumbnail(event);"
                name="upfile" class="upfile"/>
            <button type="submit" class="button-profile">프로필 업로드</button>
        </form>
    </div>

</body>
</html>
