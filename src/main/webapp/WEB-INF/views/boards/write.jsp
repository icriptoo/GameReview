<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="main">
     <h2>글쓰기</h2>
     <form action="/board/Write" method="POST">
     <input type = "hidden" name = "menu_id" value = "menu_01"/>
     <div>
     제목:<input type="text" name="title" />
     </div>
     <div>
     작성자:<input type="text" name="writer"/>
     </div>
     <div>
     아이디:<input type="text" name="userid"/>
     </div>
     <div>
     내용:<input type="text" name="cont" />
     </div>
     <div>
       <input type="submit" value="저장" />
     </div
     >
     </form>
   </div>

</body>
</html>