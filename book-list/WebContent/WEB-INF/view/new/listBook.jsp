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

<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/main.css"/>">
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/style-modal.css"/>">
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/FormStyle.css"/>">

<script type="text/javascript"	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.selectBox.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".search-select").selectBox();
});
</script>
</head>
<body>

	<jsp:include page="templates/header.jsp" />

	<div id="wrap">
	
		<jsp:include page="templates/search.jsp" />
		
		<div class="content">
			<jsp:include page="templates/left_menu.jsp" />
			<jsp:include page="templates/bookRightContent.jsp" />
		</div>
	
	<jsp:include page="templates/footer.jsp" />


</body>
</html>