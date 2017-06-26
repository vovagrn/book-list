<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class=left-menu>
	<div class="box-sh">		
		<a href="#"><p>Добавить</p></a>
	</div>
	<ul>
		<c:forEach var="author" items="${authors}" varStatus="status">
			<li><a href="<c:url value="/author/view?id=${author.id}"/>">
					${author.firstName} ${author.lastName} ${author.middleName} </a></li>
		</c:forEach>
	</ul>
</div>