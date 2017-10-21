<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Должностя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/searchTable.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Должностя</h1>
    <p>Просмотр всех должностей</p>
</header>
<nav>
    <ul>
        <li><a href="/company">Главная</a></li>
        <li><a href="/company/positions">Должностя</a></li>
        <li><a href="/company/users">Пользователи</a></li>
        <li><a href="/company/about">О нас</a></li>
    </ul>
</nav>
<main>
    <article>
        <br>
        <table align="center">
            <tr>
                <th width="40" class="top">ID</th>
                <th width="200" class="top">Должность</th>
                <th width="400" class="top">Доп. информация</th>
            </tr>
            <c:if test="${positions!=null}">
                <c:forEach items="${positions}" var="position">
                    <tr>
                        <td>${position.getId()}</td>
                        <td>${position.getName()}</td>
                        <td>${position.getDescription()}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${positions.isEmpty()}">
                <tr>
                    <td colspan="3">Данные отсуствуют</td>
                </tr>
            </c:if>
        </table>
        <br>
    </article>
    <aside>
        <h4>Меню:</h4>
        <menu>
            <li><a href="/company/positions">Список</a></li>
            <li><a href="/company/positions/add">Добавить</a></li>
            <li><a href="/company/positions/update">Изменить</a></li>
            <li><a href="/company/positions/delete">Удалить</a></li>
        </menu>
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