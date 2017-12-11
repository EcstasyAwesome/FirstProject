<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>О нас</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>О нас</h1>
    <p>Контактная и др информация</p>
</header>
<nav>
    <table class="nav-menu">
        <tr>
            <td id="nav-menu-left">
                <a href="/company">Главная</a> |
                <a href="/company/positions">Должностя</a> |
                <a href="/company/users">Пользователи</a> |
                <a href="/company/about">О нас</a>
            </td>
            <td id="nav-menu-right">
                <a href="/profile">Профиль</a> |
                <a href="/register">Редактировать</a> |
                <a href="#">Выйти</a>
                </ul>
            </td>
        </tr>
    </table>
</nav>
<main>
    <article>
        <h2 style="text-align: center">какая-то информация</h2>
    </article>
    <aside>
        <h4>Профиль</h4>
        <table border="0">
            <tr>
                <td>Фамилия: ${sessionMember.getSurname()}</td>
            </tr>
            <tr>
                <td>Имя: ${sessionMember.getFirstName()}</td>
            </tr>
            <tr>
                <td>Отчество: ${sessionMember.getLastName()}</td>
            </tr>
            <tr>
                <td>Регистрация: ${sessionMember.getRegisterDate()}</td>
            </tr>
            <tr>
                <td><a href="#" style="color: #EF3B3A">Редактировать</a></td>
            </tr>
            <tr>
                <td><a href="#" style="color: #EF3B3A">Выйти</a></td>
            </tr>
        </table>
    </aside>
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