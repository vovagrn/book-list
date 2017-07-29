<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="right-content">

	<jsp:include page="buttonsPanel.jsp" />

	<div class="box-sh">
		<form class="form-input-data" action="add" method="post" id="contact_form"
			accept-charset="UTF-8">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<div class="label">Назва жанру</div>
					<div class="inputGroupContainer">
						<div class="input-group">
							<span class="input-icon"></span> <input name="name"
								placeholder="Назва жанру" class="form-control form-input"
								type="text"">
						</div>
					</div>
				</div>				

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-warning">
							Send <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>

	<div class="box-sh">
		<h1>Знайдено жанрів: ${fn:length(genres)}</h1>
	</div>	

	<c:forEach var="genre" items="${genres}">

		<a href="#x" class="overlay" id="editGenre${genre.id}"></a>
		<div class="popup">
			<c:set var="genre" value="${genre}" scope="request" />
			<jsp:include page="genreForm.jsp" />
			<a class="close" title="Закрыть" href="#close"></a>
		</div>

		<div class="content-list-item">
			<h1>${genre.name}</h1>			
			<a class="mr delete-button" id="delete" href="delete?id=${genre.id}"><p class="delete">Удалить</p></a>
			<a class="mr" href="#editGenre${genre.id}"><p class="edit">Изменить</p></a>
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
