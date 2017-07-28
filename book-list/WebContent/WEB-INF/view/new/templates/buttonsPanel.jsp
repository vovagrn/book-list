<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="box-buttons">		
		<a href="#add"><p>Додати книгу</p></a>
		<a href="<c:url value="/genre/list"/>"><p>Додати жанр</p></a>
		<a href="<c:url value="/author/list"/>"><p>Додати автора</p></a>		
		<a href="#add"><p>Додати видавництво</p></a>
	</div>