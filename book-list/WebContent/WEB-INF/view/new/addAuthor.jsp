<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message"/>

<html>
<head>
<title><fmt:message key="addAuthor.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"	href="<c:url value="/css/main.css"/>">
</head>
<body>
	<div id="content">
			<form action="add" method="post">
				<label><fmt:message key="author.form.label.firstName"/></label>
				<input type="text" name="firstName">
				<br><br>
				
				<label><fmt:message key="author.form.label.lastName"/></label>
				<input type="text" name="lastName">
				<br><br>
				
				<label><fmt:message key="author.form.label.middleName"/></label>
				<input type="text" name="middleName">
				<br><br>
				
				<input type="submit" value="Submit">
							
			</form>	
		</div>
</body>
</html>