<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Добавить должность</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
<header>
    <img src="${pageContext.request.contextPath}/img/ecstasy_logo.jpg" alt="Логотип" height="200" width="200">
    <h1>Должностя</h1>
    <p>Добавить новую должность</p>
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
            <input type="hidden" name="form" value="addPosition">
            <h4>Заполните форму</h4>
            <table>
                <tr>
                    <td class="add-table">Должность:</td>
                    <td class="add-table"><input type="text" name="position_name" placeholder=" Введите название" size="18" required
                               autofocus>
                    </td>
                </tr>
                <tr>
                    <td class="add-table">Доп. информация:</td>
                    <td class="add-table"><textarea name="position_description" placeholder=" Ведите описание" rows="5"></textarea></td>
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