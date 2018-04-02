<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Пользователи</title>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/style.css"/>">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
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
            <%--@elvariable id="users" type="java.util.List"--%>
            <c:if test="${users!=null}">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td class="table-main">${user.id}</td>
                        <td class="table-main">${user.surname}</td>
                        <td class="table-main">${user.firstName}</td>
                        <td class="table-main">${user.middleName}</td>
                        <td class="table-main">${user.phone}</td>
                        <td class="table-main">
                            <%--@elvariable id="positions" type="java.util.List"--%>
                            <c:forEach items="${positions}" var="that">
                                <c:if test="${that.id==user.position}">
                                    ${that.name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td class="table-main">${user.date}</td>
                        <td class="table-main">
                            <a href="<c:url value="/users/update?id=${user.id}"/>">
                                <img src="<c:url value="/resources/img/edit_icon.png"/>">
                            </a>
                            <a href="<c:url value="/users/delete?id=${user.id}"/>">
                                <img src="<c:url value="/resources/img/delete_icon.png"/>">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${users==null || users.isEmpty()}">
                <tr>
                    <td class="table-main" colspan="7">Данные отсуствуют</td>
                </tr>
            </c:if>
        </table>
    </article>
    <aside>
        <jsp:include page="/WEB-INF/jsp/static/users_menu.jsp"/>
    </aside>
</main>
<jsp:include page="/WEB-INF/jsp/static/bottom.jsp"/>
</body>
</html>