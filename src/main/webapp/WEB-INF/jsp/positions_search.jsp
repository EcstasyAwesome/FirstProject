<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Должностя</title>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/style.css"/>">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
        <table align="center">
            <tr>
                <th width="40" class="table-top">ID</th>
                <th width="200" class="table-top">Должность</th>
                <th width="400" class="table-top">Доп. информация</th>
            </tr>
            <%--@elvariable id="positions" type="java.util.List"--%>
            <c:if test="${positions!=null}">
                <c:forEach items="${positions}" var="position">
                    <tr>
                        <td class="table-main">${position.id}</td>
                        <td class="table-main">${position.name}</td>
                        <td class="table-main">${position.description}</td>
                        <td class="table-main">
                            <a href="<c:url value="/positions/update?id=${position.id}"/>">
                                <img src="<c:url value="/resources/img/edit_icon.png"/>">
                            </a>
                            <a href="<c:url value="/positions/delete?id=${position.id}"/>">
                                <img src="<c:url value="/resources/img/delete_icon.png"/>">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${positions==null || positions.isEmpty()}">
                <tr>
                    <td class="table-main" colspan="3">Данные отсуствуют</td>
                </tr>
            </c:if>
        </table>
    </article>
    <aside>
        <jsp:include page="/WEB-INF/jsp/static/positions_menu.jsp"/>
    </aside>
</main>
<jsp:include page="/WEB-INF/jsp/static/bottom.jsp"/>
</body>
</html>