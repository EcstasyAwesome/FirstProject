<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Главная</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Профиль пользователя</h1>
</header>
<nav>
    <form id="LOGOUT" method="post">
        <input type="hidden" name="method" value="LOGOUT">
    </form>
    <table class="nav-menu">
        <tr>
            <td id="nav-menu-left">
                <a href="/company">Главная</a> |
                <a href="/company/positions">Должностя</a> |
                <a href="/company/users">Пользователи</a> |
                <a href="/company/about">О нас</a>
            </td>
            <td id="nav-menu-right">
                <a href="/company/profile">Профиль</a> |
                <a href="/company/edit">Редактировать</a> |
                <input type="submit" form="LOGOUT" class="logout" value="Выход">
            </td>
        </tr>
    </table>
</nav>
<main>
    <div align="center">
        <p>Логин: ${sessionUser.getLogin()}</p>
        <p>Фамилия: ${sessionUser.getSurname()}</p>
        <p>Имя: ${sessionUser.getFirstName()}</p>
        <p>Отчество: ${sessionUser.getSecondName()}</p>
        <p>Телефон: ${sessionUser.getPhoneNumber()}</p>
        <p>Должность: <c:forEach items="${positions}" var="position">
            <c:if test="${sessionUser.getPosition()==position.getId()}">
                ${position.getName()}
            </c:if>
        </c:forEach></p>
        <p>Дата регистрации: ${sessionUser.getRegisterDate()}</p>
    </div>
</main>
<footer>
    <address>
        <a href="mailto:ecstasy.awesome@gmail.com">Написать письмо</a>
    </address>
    <p>
        <small>Ecstasy © 2017</small>
    </p>
</footer>
</body>
</html>