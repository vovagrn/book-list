<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="right-content">
	<div class="box-sh">
		<h1>Найдено ${fn:length(books)} книги</h1>
		<a href="#"><p>Редактировать</p></a> <a href="#"><p>Добавить</p></a>
	</div>

	<c:forEach var="book" items="${books}" varStatus="status">
		<div class="item">
			<img src="<c:url value="/resources/images/prev.jpg"/>" width="100" height="147" alt="" />

			<div class="info">
				<a class="title" href="view?id=${book.id}">Бородино</a> 
				<span>М. Ю. Лермонтов</span>
				<p>${book.pageCount}страниц</p>
				<p>Издательство: ${book.publisher}</p>
				<p>Год издания: ${book.publishYear}</p>
				<p>${book.isbn}</p>
			</div>
			<div class="clear"></div>

			<a class="mr" href="#"><p class="read">Читать</p></a> <a class="mr"
				href="#"><p class="download">Скачать</p></a>
		</div>
	</c:forEach>

	<div class="clear"></div>

	<div class="pagination">
		<ul>
			<li><a class="active" href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">...</a></li>
			<li><a href="#">Последняя страница</a></li>
		</ul>
	</div>
</div>