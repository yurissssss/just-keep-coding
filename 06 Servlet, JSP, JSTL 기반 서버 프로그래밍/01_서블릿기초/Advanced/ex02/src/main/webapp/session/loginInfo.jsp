<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userid");
    if (id == null) {
        response.sendRedirect("loginForm.html");
    } else {
        String pw = (String) session.getAttribute("password");
        out.print("사용자 아이디값: " + id + "<br>");
        out.print("사용자 비밀번호값: " + pw + "<br>");
        out.print("<a href='logout.jsp'>로그 아웃</a>");
    }
%>
</body>
