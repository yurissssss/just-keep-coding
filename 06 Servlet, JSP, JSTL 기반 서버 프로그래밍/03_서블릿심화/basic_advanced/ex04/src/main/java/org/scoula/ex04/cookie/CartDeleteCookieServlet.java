package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;

@WebServlet("/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print("<html><body>");

        // 기존 쿠키 얻기
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(1);
                resp.addCookie(c);
            }
        }

        out.print("장바구니 비었음<br>");
        out.println("<h2>- cookie -</h2>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<html><body>");
    }
}
