<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="right-content">
	<div class="box-sh">
		<h1>Найдено ${fn:length(books)} книги</h1>
		<a href="#add"><p>Добавить</p></a>
	</div>
	
	<a href="#x" class="overlay" id="add"></a>	
	<div class="popup">
            <jsp:include page="newBookForm.jsp" />
			<a class="close" title="Закрыть" href="#close"></a>
        </div>	

	<c:forEach var="book" items="${books}" varStatus="status">
		<div class="item">
			<img src="<c:url value="/image?bookId=${book.id}"/>" width="100" height="147" alt="" />

			<div class="info">
				<a class="title" href="<c:url value="/book/view?id=${book.id}"/>">${book.title}</a> <br>
				<c:forEach var="author" items="${book.authors}" varStatus="status">
				<span>${author.firstName} ${author.lastName} ${author.middleName}</span>
				</c:forEach>
				<p>${book.pageCount} страниц</p>
				<p>Язык: ${book.language}</p>
				<p>Год издания: ${book.publishYear}</p>
				<p>ISBN: ${book.isbn}</p>
			</div>
			<div class="clear"></div>
			<a class="mr" href="#"><p class="read">Читать</p></a>
			<a class="mr" href="#"><p class="download">Скачать</p></a>
			<a class="mr" href="edit?id=${book.id}"><p class="edit">Изменить</p></a>
			<a class="mr" id="delete" href="delete?id=${book.id}"><p class="delete">Удалить</p></a>
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