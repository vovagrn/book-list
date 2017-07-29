<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="box-buttons">		
		<a href="#add">Додати книгу</a>
		<a href="<c:url value="/genre/list"/>">Додати жанр</a>
		<a href="<c:url value="/author/list"/>">Додати автора</a>		
		<a href="<c:url value="/publisher/list"/>">Додати видавництво</a>
	</div>
	
	<a href="#x" class="overlay" id="add"></a>
	<div class="popup">
		<jsp:include page="bookForm.jsp">
			<jsp:param name="tipeForm" value="add" />
		</jsp:include>
		<a class="close" title="Закрыть" href="#close"></a>
	</div>