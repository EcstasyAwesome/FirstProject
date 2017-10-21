<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Пользователи</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/searchTable.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Пользователи</h1>
    <p>Поиск пользователей по параметрам</p>
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
                <th width="130" class="top">Фамилия</th>
                <th width="130" class="top">Имя</th>
                <th width="130" class="top">Отчество</th>
                <th width="130" class="top">Телефон</th>
                <th width="130" class="top">Должность</th>
            </tr>
            <c:if test="${users!=null}">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getSurname()}</td>
                        <td>${user.getFirstName()}</td>
                        <td>${user.getSecondName()}</td>
                        <td>${user.getPhoneNumber()}</td>
                        <c:if test="${positions!=null}">
                            <c:forEach items="${positions}" var="position">
                                <c:if test="${position.getId()==user.getPosition()}">
                                    <td>${position.getName()}</td>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${positions.isEmpty()}">
                            <td>${user.getPosition()}</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${users.isEmpty()}">
                <tr>
                    <td colspan="6">Данные отсуствуют</td>
                </tr>
            </c:if>
        </table>
        <br>
    </article>
    <aside>
        <h4>Меню:</h4>
        <menu>
            <li><a href="/company/users">Список/Поиск</a></li>
            <li><a href="/company/users/add">Добавить</a></li>
            <li><a href="/company/users/update">Изменить</a></li>
            <li><a href="/company/users/delete">Удалить</a></li>
        </menu>
        <form name="search">
            <h4>Поиск пользователей:</h4>
            <input type="radio" name="key" value="user_id" checked><span>по ID</span><br>
            <input type="radio" name="key" value="user_surname"><span>по фамилии</span><br>
            <input type="radio" name="key" value="user_firstName"><span>по имени</span><br>
            <input type="radio" name="key" value="user_secondName"><span>по отчеству</span><br>
            <input type="radio" name="key" value="user_phoneNumber"><span>по телефону</span><br>
            <input type="text" name="value" placeholder="Введите запрос" size="20" required autofocus>
            <input type="submit" value="Поиск">
        </form>
        <h4>Фильтр по должности:</h4>
        <form name="filter">
            <input type="hidden" name="key" value="position_id">
            <select name="value" required>
                <option selected disabled>Выберите должность</option>
                <c:forEach items="${positions}" var="position">
                    <option value="${position.getId()}">${position.getName()}</option>
                    <c:if test="${positions.isEmpty()}">
                        <option disabled>Cписок пуст</option>
                    </c:if>
                </c:forEach>
            </select>
            <input type="submit" value="Показать">
        </form>
        <c:if test="${button}">
            <hr>
            <p align="center">
                <button><a href="/company/users">Сбросить фильтр/показать всех</a></button>
            </p>
        </c:if>
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