<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="/message/message" />

<div class="right-content">

	<jsp:include page="buttonsPanel.jsp" />

	<div class="box-sh">
		<form class="form-input-data" action="add" method="post" id="contact_form"
			accept-charset="UTF-8">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<div class="label"><fmt:message key="authorForm.label.fullName"/></div>
					<div class="inputGroupContainer">
						<div class="input-group">
							<span class="input-icon"></span> <input name="fullName"
								placeholder="<fmt:message key="authorForm.input.fullName.placeholder"/>" class="form-control form-input"
								type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<div class="label"><fmt:message key="authorForm.label.yearOfBirth"/></div>
					<div class="inputGroupContainer">
						<div class="input-group">
							<span class="input-icon"></span> <input name="publish_year"
								placeholder="<fmt:message key="authorForm.input.yearOfBirth.placeholder"/>" class="form-control form-input"
								type="text">
						</div>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-warning">
							<fmt:message key="authorForm.label.button"/><span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>

	<div class="box-sh">
		<h1>Знайдено авторів: ${fn:length(authors)}</h1>
	</div>

	<c:forEach var="author" items="${authors}">

		<a href="#x" class="overlay" id="editAuthor${author.id}"></a>
		<div class="popup">
			<c:set var="author" value="${author}" scope="request" />
			<jsp:include page="authorForm.jsp" />
			<a class="close" title="Закрыть" href="#close"></a>
		</div>

		<div class="content-list-item">
			<h1>${author.fullName}(${author.birthday})</h1>			
			<a class="mr delete-button" id="delete" href="delete?id=${author.id}"><p class="delete"><fmt:message key="author.button.label.delete"/></p></a>
			<a class="mr" href="#editAuthor${author.id}"><p class="edit"><fmt:message key="author.button.label.edit"/></p></a>
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
