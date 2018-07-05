<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.07.2018
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Получите, распишитесь</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<c:set var="var_year" value="${year == null ? '2016' : year}"/>
<c:set var="var_sum" value="${sum == null ? 0 : Integer.valueOf(sum)}"/>
<c:set var="res_sum" value="0"/>
<sql:setDataSource var="ds" url="jdbc:mysql://localhost/prepare" user="root" password="5591" driver="com.mysql.jdbc.Driver"/>
<sql:query var="summes" dataSource="${ds}">
    select * from tabl where year='${var_year}' and summa>${var_sum};
</sql:query>
<sql:query var="resSum" dataSource="${ds}">
    select sum(summa) from tabl where year='${var_year}' and summa>${var_sum};
</sql:query>
<table border="2">
    <p>Задан год: ${year}</p>
    <p>Задана сумма: ${sum}</p>
    <tr><td>год</td><td>сумма</td></tr>
<c:forEach items="${summes.rows}" var="suma">
    <tr>
    <td><c:out value="${suma.year}"/></td>
    <td><c:out value="${suma.summa}"/></td>
    </tr>
    <c:set var="res_sum" value="${Integer.valueOf(res_sum)+Integer.valueOf(suma.summa)}"/>
</c:forEach>
</table>
<c:if test="${res_sum > 0}">
    <h4>Результирующая сумма: ${res_sum}</h4>
</c:if>
<c:if test="${res_sum <= 0}">
    <%
        request.getSession().setAttribute("message","Сумма меньше или равна 0");
        response.sendRedirect("error");
    %>
</c:if>
</body>
</html>
