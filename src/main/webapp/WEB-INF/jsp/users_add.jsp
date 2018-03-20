<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Добавить пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheet/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
        <form method="post">
            <table align="center">
                <tr>
                    <th width="130" class="table-top">Фамилия</th>
                    <th width="130" class="table-top">Имя</th>
                    <th width="130" class="table-top">Отчество</th>
                    <th width="130" class="table-top">Телефон</th>
                    <th width="130" class="table-top">Должность</th>
                </tr>
                <tr>
                    <td class="table-main"><input class="transparent-input" name="surname" required autofocus></td>
                    <td class="table-main"><input class="transparent-input" name="firstName" required></td>
                    <td class="table-main"><input class="transparent-input" name="middleName" required></td>
                    <td class="table-main">
                        <input class="transparent-input" name="phone" pattern="380[0-9]{9}" required>
                    </td>
                    <td class="table-main">
                        <select class="transparent-input" name="position" required>
                            <option selected disabled>Выберите должность</option>
                            <c:forEach items="${positions}" var="that">
                                <option value="${that.id}">${that.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="center">
                        <br><input type="submit" value="Добавить"></td>
                </tr>
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