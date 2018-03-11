package org.csu.pubg.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/20.
 */
@WebServlet(name = "LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
    }
}
