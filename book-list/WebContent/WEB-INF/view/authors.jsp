<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="content">
		<table id="bookTable">
			<tr>
				<th>№</th>
				<th>Title</th>
				<th>description</th>
				<th>isbn</th>
				<th>AUTHORS</th>
			</tr>
			<c:forEach var="book" items="${books}" varStatus="status2">
				<tr>
					<td>${status2.count}</td>
					<td>${book.title}</td>
					<td>${book.description}</td>
					<td>${book.isbn}</td>
					<td><a href="book?id=${book.id}">AUTHORS</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>