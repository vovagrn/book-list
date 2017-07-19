<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="logo">
        <a href="#"><img src="<c:url value="/resources/images/logo.png"/>" width="211" height="46" alt="" /></a>
    </div>

    <div class="menu">
        <ul>
            <li><a href="#">Новинки</a></li>
            <li><a href="#">Популярные</a></li>
            <li><a href="#">О компании</a></li>
            <li><a href="#">Контакты</a></li>
            <li><a href="#">Команда</a></li>
        </ul>
    </div>

    <a class="feedback" href="#">Обратная связь</a>
    <div class="clear"></div>

    <div class="search">
        <form action="list">
            <input type="text" class="search-text" name="search_string" placeholder="Поиск по книгам" />
            <input type="submit" class="button-text" />

            <select class="search-select" name="search_option">
               <option value="TITLE">По названию</option>
               <option value="AUTHOR">По автору</option>               
            </select>

            <input type="submit" class="button" value="Найти" />
        </form>
    </div>
    <div class="clear"></div>

    <div class="nav">
        <ul>
        	<c:forEach var="letter" items="${letters}">
        		<li><a href="<c:url value="/book/list?letter=${letter}"/>">${letter}</a></li>
        	</c:forEach>            
        </ul>
    </div>