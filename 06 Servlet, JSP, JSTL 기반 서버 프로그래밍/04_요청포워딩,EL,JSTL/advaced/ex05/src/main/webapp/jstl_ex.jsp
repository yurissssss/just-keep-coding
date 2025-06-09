<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl test</title>
</head>
<body>
<h1>JSTL 테스트</h1>

<c:if test="${role == 'ADMIN'}">관리자</c:if>
<c:if test="${role != 'ADMIN'}">일반회원</c:if>

<table>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
