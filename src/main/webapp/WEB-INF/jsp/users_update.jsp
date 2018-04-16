<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Изменить пользователя</title>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/style.css"/>">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
        <form method="post">
            <input type="hidden" name="id" value="${user.id}">
            <p>* - поля, доступные для изменения</p>
            <table align="center">
                <tr>
                    <th width="40" class="table-top">ID</th>
                    <th width="130" class="table-top">Фамилия*</th>
                    <th width="130" class="table-top">Имя*</th>
                    <th width="130" class="table-top">Отчество*</th>
                    <th width="130" class="table-top">Телефон*</th>
                    <th width="130" class="table-top">Должность*</th>
                </tr>
                <%--@elvariable id="user" type="com.github.firstproject.dao.entity.User"--%>
                <c:if test="${user!=null}">
                    <tr>
                        <td class="table-main">${user.id}</td>
                        <td class="table-main">
                            <input class="transparent-input" title="Фамилия" value="${user.surname}" name="surname"
                                   autofocus required>
                        </td>
                        <td class="table-main">
                            <input class="transparent-input" title="Имя" value="${user.firstName}" name="firstName"
                                   required>
                        </td>
                        <td class="table-main">
                            <input class="transparent-input" title="Отчество" value="${user.middleName}"
                                   name="middleName" required>
                        </td>
                        <td class="table-main">
                            <input class="transparent-input" title="Телефон" value="${user.phone}" pattern="380[0-9]{9}"
                                   name="phone" required>
                        </td>
                        <td class="table-main">
                            <select class="transparent-input" title="Должность" name="position" required>
                                <option disabled>Выберите должность</option>
                                <%--@elvariable id="positions" type="java.util.List"--%>
                                <c:forEach items="${positions}" var="that">
                                    <c:if test="${that.id==user.id}">
                                        <option selected value="${that.id}">${that.name}</option>
                                    </c:if>
                                    <c:if test="${that.id!=user.id}">
                                        <option value="${that.id}">${that.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <br><input type="submit" value="Сохранить изменения">
                        </td>
                    </tr>
                </c:if>
                <c:if test="${user==null}">
                    <tr>
                        <td class="table-main" colspan="6">Запись уже не существует</td>
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