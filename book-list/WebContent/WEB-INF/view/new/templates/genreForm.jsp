<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="/message/message" />

<div class="container">

	<form class="form" action="edit" method="post" id="contact_form"  accept-charset="UTF-8">
		<fieldset>

			<!-- Form Name -->
			<legend>Contact Us Today!!!</legend>
			 
			<!-- Text hidden--> 
			<input type="hidden" name="id" value="${genre.id}">

			<!-- Text input-->
			<div class="form-group">
				<div class="label"><fmt:message key="genreForm.label.name"/></div>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-icon"></span> <input name="name"
							placeholder="<fmt:message key="genreForm.input.name.placeholder"/>" class="form-control form-input" type="text" value="${genre.name}">
					</div>
				</div>
			</div>			
			
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-warning">
						<fmt:message key="genreForm.label.button"/><span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>

		</fieldset>
	</form>
</div>

