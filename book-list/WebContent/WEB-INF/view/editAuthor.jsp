<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="content">
			<form action="edit" method="post">
				<label><fmt:message key="author.form.label.firstName"/></label>
				<input type="text" name="firstName" value="${author.firstName}">
				<br><br>
				
				<label><fmt:message key="author.form.label.lastName"/></label>
				<input type="text" name="lastName" value="${author.lastName}">
				<br><br>
				
				<label><fmt:message key="author.form.label.birthDate"/></label>
				<input type="text" name="birthDate" value="<fmt:formatDate value="${person.birthDate}" pattern="${dateFormat}"/>">
				<br><br>
				
				<input type="hidden" name="id" value="${author.id}">
				
				<input type="submit" value="Submit">
			</form>	
		</div>
		
		<br>
		<div>${status}</div>

</body>
</html>