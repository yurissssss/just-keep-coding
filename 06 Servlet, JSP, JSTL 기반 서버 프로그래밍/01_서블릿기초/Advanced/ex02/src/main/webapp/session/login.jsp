
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("userid");
    if (id == null) {
        response.sendRedirect("loginForm.html");
    } else {
        String pw = request.getParameter("password");
        session.setAttribute("userid", id);
        session.setAttribute("password", pw);
        out.print("안녕하세요 " + id + "<br>");
        out.print("<a href='loginInfo.jsp'>정보보기</a>");

    }
%>
</body>
</html>
