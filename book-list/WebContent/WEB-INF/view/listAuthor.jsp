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
		<table id="authorTable">
			<tr>
				<th>№</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Middle name</th>
				<th>BOOKS</th>
			</tr>			
			
			<c:forEach var="author" items="${authors}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${author.firstName}</td>
					<td>${author.lastName}</td>
					<td>${author.middleName}</td>
					<td><a href="view?id=${author.id}">BOOKS</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>