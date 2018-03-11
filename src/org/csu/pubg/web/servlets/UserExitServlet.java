package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/22.
 */
@WebServlet(name = "UserExitServlet")
public class UserExitServlet extends HttpServlet {
    private static final String VIEW_MAIN="index.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("loginUser",null);

        session.setAttribute("cartItemNum",0);
        session.setAttribute("cartItemAllPrice",0);

        request.getRequestDispatcher(VIEW_MAIN).forward(request,response);
    }
}
