<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="header">
    <div class="header-wrap">
        <div class="language">
            <a href="<c:url value="/language?language=uk"/>"><img src="<c:url value="/resources/images/rus.png"/>" width="16" height="13" alt="" /></a>
            <a href="<c:url value="/language?language=en"/>"><img src="<c:url value="/resources/images/usa.png"/>" width="16" height="13" alt="" /></a>
        </div>

        <div class="social">
            <a href="#"><img src="<c:url value="/resources/images/vk.jpg"/>" width="16" height="16" alt="" /></a>
            <a href="#"><img src="<c:url value="/resources/images/facebook.jpg"/>" width="16" height="16" alt="" /></a>
        </div>

        <div class="aut">
            <p>User</p>
            <a href="#">Выход</a>
        </div>
    </div>
</div>
