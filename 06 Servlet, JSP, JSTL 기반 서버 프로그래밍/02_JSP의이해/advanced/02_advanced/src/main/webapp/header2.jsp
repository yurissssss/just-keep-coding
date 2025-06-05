<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    String nickName = request.getParameter("nickName");

    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
%>

<%-- EL: JSP엔진이 내부적으로 페이지 인코딩을 먼저 반영한 상태에서 작동
        -> UTF-8로 디코딩된 값을 안전하게 가져옴 --%>
안녕하세요. 당신의 닉네임은 ${param.nickName} 입니다. <br>
<%-- 안녕하세요. 당신의 닉네임은 <%= nickName%> 입니다. <br> --%>
현재 시간은 <%= hour%> 시 <%= minute%> 분 <%= second%> 초 입니다.
