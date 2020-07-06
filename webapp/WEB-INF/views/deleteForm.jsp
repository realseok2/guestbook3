<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
</head>
<body>
	<h4>방명록 삭제</h4>

	<form action = "${pageContext.request.contextPath }/guestbook/delete/${num }" method = "post">
	
		비밀번호(Password)	:	<input type = "password"	name = "password">
		<button type = "submit">확인</button><br>

	</form>

	<a href="${pageContext.request.contextPath }/guestbook/list">메인으로 돌아가기</a>
	
</body>
</html>