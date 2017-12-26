<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
</head>
<body>
<div class="page">
    <div class="form">
    <form id="add" method="post">
        <input type="hidden" name="method" value="PUT">
        <input type="hidden" name="form" value="addUser">
        <h4>Заполните форму<br>
            <small>Все поля обязательны к заполнению!</small>
        </h4>
        <table align="center">
            <tr>
                <td class="add-table">Логин:</td>
                <td class="add-table"><input type="text" name="user_login" placeholder=" Придумайте логин"
                                             size="20" required autofocus></td>
            </tr>
            <tr>
                <td class="add-table">Пароль:</td>
                <td class="add-table"><input type="password" name="user_password" placeholder=" Придумайте пароль"
                                             size="20" required></td>
            </tr>
            <tr>
                <td class="add-table">Фамилия:</td>
                <td class="add-table"><input type="text" name="user_surname" placeholder=" Введите фамилию"
                                             size="20" required></td>
            </tr>
            <tr>
                <td class="add-table">Имя:</td>
                <td class="add-table"><input type="text" name="user_firstName" placeholder=" Введите имя" size="20"
                                             required></td>
            </tr>
            <tr>
                <td class="add-table">Отчество:</td>
                <td class="add-table"><input type="text" name="user_secondName" placeholder=" Введите отчество"
                                             size="20" required></td>
            </tr>
            <tr>
                <td class="add-table">Телефон:</td>
                <td class="add-table"><input type="text" name="user_phoneNumber"
                                             placeholder=" Введите номер телефона" size="20" required>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button>Регистрация</button></td>
            </tr>
        </table>
    </form>
    </div>
</div>
</body>
</html>