<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form action="/loginProcess" method="POST">
id<input type="text" id="userid"></input><br>
passwd<input type="text" id="passwd"></input><br>
<input type="submit" class="btn btn-primary" value="로그인"></a>
</form>
<a href="/writeForm" class="btn btn-primary">회원가입</a>
</body>
</html>