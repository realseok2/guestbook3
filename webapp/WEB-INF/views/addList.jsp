<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<%--------------------------------------------------------------------------------%>
	<h1>Guestbook List</h1>
	<p>작성된 방명록의 목록입니다.</p>
	<%--------------------------------------------------------------------------------%>

	<form action = "${pageContext.request.contextPath }/guestbook/insert" method = "get">
		<table border="1" width="565">
	
			<tbody>
				<tr>
					<td width="45">이름</td>
	
					<td><input type="text" name="name"></td>
	
					<td width="70">비밀번호</td>
	
					<td><input type="password" name="pw"></td>
				</tr>
	
				<tr>
					<td colspan="4"><textarea rows="11" cols="76" name="content"></textarea></td>
				</tr>
	
				<tr>
					<td width="45"><button type="submit">확인</button></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
	
		</table>

	</form>
	
	
	<br>


	<c:forEach items="${pList }" var="personVo">

		<table border="1" width="565">
			<tbody>
				<tr>
					<td width="20">${personVo.no }</td>
					<td width="80">${personVo.name }</td>
					<td width=auto>${personVo.date }</td>
					<td width="45"><a
						href="${pageContext.request.contextPath }/guestbook/pwconform/${personVo.no }"><button type="button">수정</button></a></td>
					<td width="45"><a
						href="${pageContext.request.contextPath }/guestbook/deleteForm/${personVo.no }"><button type="button">삭제</button></a></td>
				</tr>

				<tr height="120">
					<td colspan="5">${personVo.content }</td>
				</tr>
			</tbody>

		</table>
		
	</c:forEach>


	<br>



</body>
</html>