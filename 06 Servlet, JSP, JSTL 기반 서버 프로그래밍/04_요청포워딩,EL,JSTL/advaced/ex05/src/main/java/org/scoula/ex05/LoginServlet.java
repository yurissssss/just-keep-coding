package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")  // url 매핑: /login
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("LoginServlet");

        // userid, passwd 파라미터를 추출하여 request 스코프에 저장
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        // System.out.println(userid);
        // System.out.println(passwd);

        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        // login.jsp로 포워딩
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
