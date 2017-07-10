<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">

	<form class="well" action=" " method="post"
		id="contact_form">
		<fieldset>

			<!-- Form Name -->
			<legend>Contact Us Today!</legend>

			<!-- Text input-->

			<div class="form-group">
				<label class="control-label">Название</label>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-book"></i></span> <input name="title"
							placeholder="Название" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Количество страниц</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span> <input name="page_сount"
							placeholder="Количество страниц" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">Год издания</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span> <input
							name="publish_year" placeholder="Год издания"
							class="form-control" type="text">
					</div>
				</div>
			</div>


			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">ISBN</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span> <input name="isbn"
							placeholder="ISBN" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- File input-->
			<div class="form-group">
				<label class="col-md-4 control-label">Изображение</label>
				<div class="col-md-4 inputGroupContainer">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-picture"></i></span> <input name="image"
						type="file">
				</div>
			</div>
			
			<!-- File input-->
			<div class="form-group">
				<label class="col-md-4 control-label">Файл</label>
				<div class="col-md-4 inputGroupContainer">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-plus"></i></span> <input name="file"
						type="file">
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">City</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input name="city"
							placeholder="city" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Select Basic -->

			<div class="form-group">
				<label class="col-md-4 control-label">Язык</label>
				<div class="col-md-4 selectContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-list"></i></span> <select name="language"
							class="form-control selectpicker">
							<option value=" ">Please select language</option>
							<option>English</option>
							<option>Russian</option>
						</select>
					</div>
				</div>
			</div>			

			<!-- radio checks -->
			<div class="form-group">
				<label class="col-md-4 control-label">Do you have hosting?</label>
				<div class="col-md-4">
					<div class="radio">
						<label> <input type="radio" name="hosting" value="yes" />
							Yes
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="hosting" value="no" />
							No
						</label>
					</div>
				</div>
			</div>

			<!-- Text area -->

			<div class="form-group">
				<label class="col-md-4 control-label">Project Description</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span>
						<textarea class="form-control" name="comment"
							placeholder="Project Description"></textarea>
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

<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

<script src="<c:url value="/resources/js/index.js"/>"></script>