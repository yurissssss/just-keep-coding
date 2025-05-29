<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%-- Tomcat으로 run하면 jsp가 반영됨 --%>
<h1><%= "Hello Servlet!" %></h1>
<br/>
<%-- /hello-servlet 요청이 오면 --%>
<%-- "홈으로" 링크 설정 -> 클릭 시 홈으로 이동 --%>
<a href="hello-servlet">Home</a>
</body>
</html>