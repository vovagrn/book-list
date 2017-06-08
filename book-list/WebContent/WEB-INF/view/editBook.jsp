<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="editBook.title"/></title>
</head>
<body>

<div id="content">
			<form action="edit" method="post">
				<label><fmt:message key="book.form.label.title"/></label>
				<input type="text" name="title" value="${book.title}">
				<br><br>
				
				<label><fmt:message key="book.form.label.description"/></label>
				<input type="text" name="description" value="${book.description}">
				<br><br>
				
				<label><fmt:message key="book.form.label.isbn"/></label>
				<input type="text" name="isbn" value="${book.isbn}">
				<br><br>
				
				<input type="hidden" name="id" value="${book.id}">
				
				<input type="submit" value="Submit">
			</form>	
		</div>
		
		<br>
		<div>${status}</div>

</body>
</html>