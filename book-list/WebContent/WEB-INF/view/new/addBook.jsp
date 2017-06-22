<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message"/>

<html>
<head>
<title><fmt:message key="addBook.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"	href="<c:url value="/css/main.css"/>">
</head>
<body>
	<div id="content">
			<form action="add" method="post">
				<label><fmt:message key="book.form.label.title"/></label>
				<input type="text" name="title">
				<br><br>
				
				<label><fmt:message key="book.form.label.description"/></label>
				<input type="text" name="description">
				<br><br>
				
				<label><fmt:message key="book.form.label.isbn"/></label>
				<input type="text" name="isbn">
				<br><br>
				
				<div>
					<c:forEach var="author" items="${authors}" varStatus="status">	
					<input type="checkbox" name="id" value="${author.id}"> ${author.firstName} ${author.lastName} ${author.middleName}<br>						
					</c:forEach>
				</div>
				
				<input type="submit" value="Submit">
							
			</form>	
		</div>
</body>
</html>