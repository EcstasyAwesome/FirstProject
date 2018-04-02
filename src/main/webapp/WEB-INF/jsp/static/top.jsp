<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <img src="<c:url value="/resources/img/ecstasy_logo.jpg"/>" alt="Логотип">
</header>
<nav>
    <div class="nav-menu">
        <a href="<c:url value="/"/>">Главная</a>
        <a href="<c:url value="/positions"/>">Должности</a>
        <a href="<c:url value="/users"/>">Пользователи</a>
    </div>
</nav>