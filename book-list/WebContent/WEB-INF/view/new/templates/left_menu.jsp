<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id=left_menu>
	<c:forEach var="author" items="${authors}" varStatus="status">				
					${status.count}					
					<a href="<c:url value="/author/view?id=${author.id}"/>">
			${author.firstName} ${author.lastName} ${author.middleName} </a>
	</c:forEach>
</div>