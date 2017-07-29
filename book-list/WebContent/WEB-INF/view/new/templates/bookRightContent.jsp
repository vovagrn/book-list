<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="/message/message"/>

<div class="right-content">

	<jsp:include page="buttonsPanel.jsp" />
	
	<div class="box-sh">
		<h1>Знайдено книг: ${fn:length(books)}</h1>		
	</div>

	<c:forEach var="book" items="${books}">
		<a href="#x" class="overlay" id="editBook${book.id}"></a>
		<div class="popup">
			<c:set var="book" value="${book}" scope="request"/>
			<jsp:include page="bookForm.jsp">
				<jsp:param name="tipeForm" value="edit"/>
			</jsp:include>
			<a class="close" title="Закрыть" href="#close"></a>
		</div>

		<div class="item">
			<img src="<c:url value="/image?bookId=${book.id}"/>" width="100"
				height="147" alt="" />

			<div class="info">
				<a class="title" href="<c:url value="/book/view?id=${book.id}"/>">${book.title}</a>
				<br>
				<c:forEach var="author" items="${book.authors}">
					<span>${author.fullName}</span>
				</c:forEach>
				<p><fmt:message key="bookItem.label.pages"/>: ${book.pageCount}</p>
				<p><fmt:message key="bookItem.label.language"/>: ${book.language}</p>
				<p><fmt:message key="bookItem.label.publishYear"/>: ${book.publishYear}</p>
				<p><fmt:message key="bookItem.label.isbn"/>: ${book.isbn}</p>
			</div>
			<div class="clear"></div>
			<a class="mr" href="#"><p class="read"><fmt:message key="bookItem.button.label.read"/></p></a> 
			<a class="mr" href="#"><p class="download"><fmt:message key="bookItem.button.label.download"/></p></a> 
			<a class="mr" href="#editBook${book.id}"><p class="edit"><fmt:message key="bookItem.button.label.edit"/></p></a> 
			<a class="mr delete-button" id="delete" href="delete?id=${book.id}">
				<p class="delete"><fmt:message key="bookItem.button.label.delete"/></p></a>
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