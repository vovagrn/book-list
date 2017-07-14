<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">

	<form class="form" action="add" method="post" id="contact_form" enctype="multipart/form-data">
		<fieldset>

			<!-- Form Name -->
			<legend>Contact Us Today!</legend>

			<!-- Text input-->
			<div class="form-group">
				<div class="label">Название</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="title"
							placeholder="Название" class="form-control" type="text" value="${book.title}">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<div class="label">Количество страниц</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="page_count"
							placeholder="Количество страниц" class="form-control" type="text" value="${book.pageCount}">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<div class="label">Год издания</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="publish_year"
							placeholder="Год издания" class="form-control" type="text" value="${book.publishYear}">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<div class="label">ISBN</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="isbn"
							placeholder="ISBN" class="form-control" type="text" value="${book.isbn}">
					</div>
				</div>
			</div>

			<!-- Select-->
			<div class="form-group">
				<div class="label">Язык</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <select name="language"
							class="form-select">
							<option value=" ">Please select language</option>
							<option>English</option>
							<option>Russian</option>
						</select>
					</div>
				</div>
			</div>

			<!-- Box input-->
			<div class="form-group">
				<div class="label">Автор</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span>
						<div class="box-checkbox">
							<c:forEach var="author" items="${authors}" varStatus="status">
								<div class="checkbox-content">
									<input class="checkbox" type="checkbox" name="id"
										value="${author.id}"
										<c:forEach var="bookAuthor" items="${book.authors}" varStatus="status">						
							<c:if test="${bookAuthor.id == author.id}">checked</c:if>					
						</c:forEach>>
									<span class="checkbox-label">${author.firstName}
										${author.lastName} ${author.middleName}</span><br>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>

			<!-- File input-->
			<div class="form-group">
				<div class="label">Изображение</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="image"
							class="form-control" type="file">
					</div>
				</div>
			</div>

			<!-- File input-->
			<div class="form-group">
				<div class="label">Файл</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="file"
							class="form-control" type="file">
					</div>
				</div>
			</div>

			<!-- Text area -->

			<div class="form-group">
				<div class="label">Description</div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span>
						<textarea class="form-control" name="description"
							placeholder="Description" >${book.description}</textarea>
					</div>
				</div>
			</div>

			<!-- Success message -->
			<div class="alert alert-success" role="alert" id="success_message">
				Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for
				contacting us, we will get back to you shortly.
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

<!-- <script -->
<!-- 	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script> -->
<!-- <script -->
<!-- 	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script> -->
<!-- <script -->
<!-- 	src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script> -->

<script src="<c:url value="/resources/js/index.js"/>"></script>