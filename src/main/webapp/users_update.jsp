<%@ page contentType="text/html;charset=UTF-8" language=" java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Изменить пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/updateTable.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Пользователи</h1>
    <p>Изменить существующего пользователя</p>
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
                <input type="hidden" name="key" value="user_id">
                <select name="value" required>
                    <option selected disabled>Выберите ID</option>
                    <c:if test="${users!=null}">
                        <c:forEach items="${users}" var="user">
                            <option value="${user.getId()}">ID${user.getId()}
                                - ${user.getSurname()} ${user.getFirstName()} ${user.getSecondName()}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${users.isEmpty()}">
                        <option disabled>список пуст</option>
                    </c:if>
                </select>
                <input type="submit" value="Редактировать">
            </form>
        </c:if>
        <c:if test="${button}">
            <form id="update" method="post">
                <input type="hidden" name="method" value="PUT">
                <input type="hidden" name="form" value="updateUser">
                <table>
                    <tr>
                        <td>Фамилия</td>
                        <td>Имя</td>
                        <td>Отчество</td>
                        <td>Телефон</td>
                        <td>Должность</td>
                    </tr>
                    <tr>
                        <td><input type="text" size="15" value="${users.get(0).getSurname()}" placeholder="Выберите ID"
                                   name="user_surname" required></td>
                        <td><input type="text" size="15" value="${users.get(0).getFirstName()}"
                                   placeholder="Выберите ID" name="user_firstName" required></td>
                        <td><input type="text" size="15" value="${users.get(0).getSecondName()}"
                                   placeholder="Выберите ID" name="user_secondName" required></td>
                        <td><input type="text" size="15" value="${users.get(0).getPhoneNumber()}"
                                   placeholder="Выберите ID" name="user_phoneNumber" required></td>
                        <td><select form="update" name="position_id">
                            <c:if test="${positions!=null}">
                                <c:forEach items="${positions}" var="position">
                                    <c:if test="${users.get(0).getPosition()==position.getId()}">
                                        <option value="${position.getId()}" selected>${position.getName()}</option>
                                    </c:if>
                                    <c:if test="${users.get(0).getPosition()!=position.getId()}">
                                        <option value="${position.getId()}">${position.getName()}</option>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <c:if test="${positions.isEmpty()}">
                                <option value="${users.get(0).getPosition()}"
                                        selected>${users.get(0).getPosition()}</option>
                            </c:if>
                        </select></td>
                    </tr>
                </table>
                <input type="hidden" name="user_id" value="${users.get(0).getId()}">
                <input type="submit" value="Сохранить изменения">
            </form>
        </c:if>
    </article>
    <aside>
        <h4>Меню:</h4>
        <menu>
            <li><a href="/company/users">Список/Поиск</a></li>
            <li><a href="/company/users/add">Добавить</a></li>
            <li><a href="/company/users/update">Изменить</a></li>
            <li><a href="/company/users/delete">Удалить</a></li>
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