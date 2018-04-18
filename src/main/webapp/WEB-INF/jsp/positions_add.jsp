<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Добавить должность</title>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/style.css"/>">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/static/top.jsp"/>
<main>
    <article>
        <form method="post">
            <table align="center">
                <tr>
                    <th width="200" class="table-top">Должность</th>
                    <th width="400" class="table-top">Доп. информация</th>
                </tr>
                <tr>
                    <td class="table-main">
                        <input class="transparent-input" type="text" name="name" placeholder="Введите название"
                               required autofocus>
                    </td>
                    <td class="table-main">
                        <input class="transparent-input" type="text" name="description" placeholder="Ведите описание"
                               required>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <br><input type="submit" value="Добавить"></td>
                </tr>
            </table>
        </form>
    </article>
    <aside>
        <jsp:include page="/WEB-INF/jsp/static/positions_menu.jsp"/>
    </aside>
</main>
<jsp:include page="/WEB-INF/jsp/static/bottom.jsp"/>
</body>
</html>