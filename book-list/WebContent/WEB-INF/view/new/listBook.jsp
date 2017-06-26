<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="/message/message" />

<html>
<head>
<title><fmt:message key="listBook.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>

<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/main.css"/>">
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/style-modal.css"/>">
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/bookFormStyle.css"/>">
</head>
<body>

	<div id="wrap">
		<div class="content">
			<jsp:include page="templates/left_menu.jsp" />
			<jsp:include page="templates/right-content.jsp" />
		</div>
	</div>


</body>
</html>