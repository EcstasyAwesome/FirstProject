<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Добавить пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addTable.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Пользователи</h1>
    <p>Добавить нового пользователя</p>
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
        <form id="add" method="post">
            <input type="hidden" name="method" value="PUT">
            <input type="hidden" name="form" value="addUser">
            <h4>Заполните форму<br>
                <small>Все поля обязательны к заполнению!</small>
            </h4>
            <table>
                <tr>
                    <th>Фамилия:</th>
                    <th><input type="text" name="user_surname" placeholder=" Введите фамилию" size="20" required
                               autofocus>
                    </th>
                </tr>
                <tr>
                    <th>Имя:</th>
                    <th><input type="text" name="user_firstName" placeholder=" Введите имя" size="20" required
                               autofocus>
                    </th>
                </tr>
                <tr>
                    <th>Отчество:</th>
                    <th><input type="text" name="user_secondName" placeholder=" Введите отчество" size="20" required
                               autofocus></th>
                </tr>
                <tr>
                    <th>Телефон:</th>
                    <th><input type="text" name="user_phoneNumber" placeholder=" Введите номер телефона" size="20"
                               required autofocus></th>
                </tr>
                <tr>
                    <th>Должность:</th>
                    <th>
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
                    </th>
                </tr>
                <tr>
                    <th colspan="2"><input type="submit" value="Добавить"></th>
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