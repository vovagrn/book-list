<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/main.css"/>">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<table id="table">
			<tr>
				<th class="tableCell">№</th>
				<th class="tableCell">First name</th>
				<th class="tableCell">Last name</th>
				<th class="tableCell">Middle name</th>
				<th class="tableCell">BOOKS</th>
			</tr>

			<c:forEach var="author" items="${authors}" varStatus="status">
				<tr>
					<td class="tableCell">${status.count}</td>
					<td class="tableCell">${author.firstName}</td>
					<td class="tableCell">${author.lastName}</td>
					<td class="tableCell">${author.middleName}</td>
					<td class="tableCell"><a href="view?id=${author.id}">BOOKS</a></td>
					<td class="tableCell">
						<a class="tableAction" href="edit?id=${author.id}">Edit</a> 
						<br>
						<a class="tableAction" href="delete?id=${author.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>