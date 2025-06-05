<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>include 액션 실습</title>
</head>
<body>
<h1>include 액션 태그 실습</h1>
현재 시간을 구하는 예제입니다. 다음 줄에 삽입이 됩니다. <br>


<%--
<form action="header2.jsp" method="post">
    <input type="hidden" name="nickName" value="홍길동">
    <input type="submit" value="POST 방식으로 전달">
</form>
--%>


<%-- jsp:include, jsp:param 은 기본적으로 GET  방식 --%>
    <jsp:include page="header2.jsp" flush="true">
        <jsp:param name="nickName" value="홍길동"/>
    </jsp:include>

</body>
</html>
