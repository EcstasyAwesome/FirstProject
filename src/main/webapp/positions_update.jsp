<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Изменить должность</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Должностя</h1>
    <p>Изменить существующую должность</p>
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
        <c:if test="${button eq false}">
            <form>
                <input type="hidden" name="key" value="position_id">
                <select name="value" required>
                    <option selected disabled>Выберите ID</option>
                    <c:if test="${positions!=null}">
                        <c:forEach items="${positions}" var="position">
                            <option value="${position.getId()}">ID${position.getId()} - ${position.getName()}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${positions.isEmpty()}">
                        <option disabled>список пуст</option>
                    </c:if>
                </select>
                <input type="submit" value="Редактировать">
            </form>
        </c:if>
        <c:if test="${button}">
            <form id="update" method="post">
                <input type="hidden" name="method" value="PUT">
                <input type="hidden" name="form" value="updatePosition">
                <table>
                    <tr>
                        <td class="update-table">Должность</td>
                        <td class="update-table">Доп. информация</td>
                    </tr>
                    <tr>
                        <td class="update-table"><input type="text" size="15" value="${positions.get(0).getName()}" placeholder="Выберите ID"
                                   name="position_name" required></td>
                        <td class="update-table"><textarea name="position_description" rows="5"
                                      required>${positions.get(0).getDescription()}</textarea></td>
                    </tr>
                </table>
                <input type="hidden" name="position_id" value="${positions.get(0).getId()}">
                <input type="submit" value="Сохранить изменения">
            </form>
        </c:if>
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