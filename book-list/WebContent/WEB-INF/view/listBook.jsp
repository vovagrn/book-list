<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message"/>

<html>
<head>
<title><fmt:message key="listBook.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"	href="<c:url value="/css/main.css"/>">
</head>
<body>
	<div id="content">
		<table id="table">
			<tr>
				<th class="tableCell"><fmt:message key="list.book.table.header.number"/></th>
				<th class="tableCell"><fmt:message key="list.book.table.header.title"/></th>
				<th class="tableCell"><fmt:message key="list.book.table.header.description"/></th>
				<th class="tableCell"><fmt:message key="list.book.table.header.isbn"/></th>
				<th class="tableCell"><fmt:message key="list.book.table.header.authors"/></th>
				<th class="tableCell"><fmt:message key="list.book.table.header.actions"/></th>
			</tr>

			<c:forEach var="book" items="${books}" varStatus="status">
				<tr>
					<td class="tableCell">${status.count}</td>
					<td class="tableCell">${book.title}</td>
					<td class="tableCell">${book.description}</td>
					<td class="tableCell">${book.isbn}</td>
					<td class="tableCell"><a href="view?id=${book.id}">Authors</a></td>
					<td class="tableCell">
						<a class="tableAction" href="edit?id=${book.id}">Edit</a> 
						<br>
						<a class="tableAction" href="delete?id=${book.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="add">Add</a>
		
	</div>
</body>
</html>






