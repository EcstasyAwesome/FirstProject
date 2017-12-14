<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Добавить пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Пользователи</h1>
    <p>Добавить нового пользователя</p>
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
                <a href="/company/profile">Профиль</a> |
                <a href="/company/edit">Редактировать</a> |
                <a href="#">Выйти</a>
                </ul>
            </td>
        </tr>
    </table>
</nav>
<main>
    <article>
        <form id="add" method="post">
            <input type="hidden" name="method" value="PUT">
            <input type="hidden" name="form" value="addUser">
            <h4>Заполните форму<br>
                <small>Все поля обязательны к заполнению!</small>
            </h4>
            <table>
                <tr>
                    <td class="add-table">Фамилия:</td>
                    <td class="add-table"><input type="text" name="user_surname" placeholder=" Введите фамилию" size="20" required autofocus></td>
                </tr>
                <tr>
                    <td class="add-table">Имя:</td>
                    <td class="add-table"><input type="text" name="user_firstName" placeholder=" Введите имя" size="20" required autofocus></td>
                </tr>
                <tr>
                    <td class="add-table">Отчество:</td>
                    <td class="add-table"><input type="text" name="user_secondName" placeholder=" Введите отчество" size="20" required autofocus></td>
                </tr>
                <tr>
                    <td class="add-table">Телефон:</td>
                    <td class="add-table"><input type="text" name="user_phoneNumber" placeholder=" Введите номер телефона" size="20" required autofocus></td>
                </tr>
                <tr>
                    <td class="add-table">Должность:</td>
                    <td class="add-table">
                        <select style="width: 100%" form="add" name="position_id" required>
                            <option value="0" selected disabled>Выберите должность</option>
                            <c:if test="${positions!=null}">
                                <c:forEach items="${positions}" var="position">
                                    <option value="${position.getId()}">${position.getName()}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${positions.isEmpty()}">
                                <option disabled>Список пуст</option>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="add-table" colspan="2"><input type="submit" value="Добавить"></td>
                </tr>
            </table>
        </form>
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