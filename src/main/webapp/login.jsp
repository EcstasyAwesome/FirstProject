<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Авторизация</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post">
            <input type="text" name="login" placeholder="логин" required autofocus/>
            <input type="password" name="password" placeholder="пароль" required/>
            <button>войти</button>
            <p class="error">${login_error}</p>
            <p class="message">Не зарегистрированы? <a href="#">Создать аккаунт</a></p>
        </form>
    </div>
</div>
</body>
</html>