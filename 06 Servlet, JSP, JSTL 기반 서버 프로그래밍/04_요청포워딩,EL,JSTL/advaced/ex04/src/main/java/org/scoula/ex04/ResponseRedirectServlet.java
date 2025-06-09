package org.scoula.ex04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getAttribute("username");
        String useraddress = (String) req.getAttribute("useraddress");

        // 속성 설정
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress", "서울");

        // forward
        RequestDispatcher dis = req.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(req, resp);
    }
}
