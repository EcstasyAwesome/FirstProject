<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Удалить пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheet/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
        <form method="post">
            <input type="hidden" name="id" value="${user.id}">
            <table align="center">
                <tr>
                    <th width="40" class="table-top">ID</th>
                    <th width="130" class="table-top">Фамилия</th>
                    <th width="130" class="table-top">Имя</th>
                    <th width="130" class="table-top">Отчество</th>
                    <th width="130" class="table-top">Телефон</th>
                    <th width="130" class="table-top">Должность</th>
                    <th width="130" class="table-top">Регистрация</th>
                </tr>
                <c:if test="${user!=null}">
                    <tr>
                        <td class="table-main">${user.id}</td>
                        <td class="table-main">${user.surname}</td>
                        <td class="table-main">${user.firstName}</td>
                        <td class="table-main">${user.middleName}</td>
                        <td class="table-main">${user.phone}</td>
                        <td class="table-main">${position.name}</td>
                        <td class="table-main">${user.date}</td>
                    </tr>
                    <tr>
                        <td colspan="7" align="center">
                            <br>Удалить данного пользователя?
                        </td>
                    </tr>
                    <tr>
                        <td colspan="7" align="center">
                            <br><input type="submit" value="Удалить"></td>
                    </tr>
                </c:if>
                <c:if test="${user==null}">
                    <tr>
                        <td class="table-main" colspan="7">Запись уже не существует</td>
                    </tr>
                </c:if>
            </table>
        </form>
    </article>
    <aside>
        <jsp:include page="/WEB-INF/jsp/static/users_menu.jsp"/>
    </aside>
</main>
<jsp:include page="/WEB-INF/jsp/static/bottom.jsp"/>
</body>
</html>