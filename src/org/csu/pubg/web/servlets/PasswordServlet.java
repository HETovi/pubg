package org.csu.pubg.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tovi on 2017/9/22.
 */
public class PasswordServlet extends HttpServlet {
    private static final String VIEW_PASSWORD="WEB-INF/jsp/account/ModifyPassword.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(VIEW_PASSWORD).forward(request,response);

    }
}
