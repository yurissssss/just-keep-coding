<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>방문자수 조회하기 화면</title>
</head>
<body>
<h1>방문자수 조회하기 화면</h1>

<%--
    count.jsp에서
    application.setAttribute("countValue", count);
--%>

<%--
    꼭 count.jsp 먼저 방문한 다음 방문하기!
    안 그러면 error (count가 null이므로)
--%>
<%
    int count = (Integer) application.getAttribute("countValue");
%>
현재까지 총 방문자수: <%=count%>
</body>
</html>
