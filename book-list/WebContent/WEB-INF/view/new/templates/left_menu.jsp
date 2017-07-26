<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="left-menu">
	<ul>
		<li><a href="<c:url value="/"/>">Всі книги</a></li>
		<c:forEach var="genre" items="${genres}">
			<li><a href="<c:url value="/book/list?genre=${genre.id}"/>">${genre.name}</a></li>
		</c:forEach>
	</ul>
</div>