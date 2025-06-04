<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>include 액션 실습</title>
</head>
<body>
<h1>include 액션 태그 실습</h1>
현재 시간을 구하는 예제입니다. 다음 줄에 삽입이 됩니다. <br>

<jsp:include page="header2.jsp" flush="true">
    <jsp:param name="nickName" value="홍"/>
</jsp:include>

</body>
</html>
