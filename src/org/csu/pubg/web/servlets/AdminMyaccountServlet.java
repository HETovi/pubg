package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by liulin on 2017/9/24.
 */
public class AdminMyaccountServlet extends HttpServlet {
    private static final String VIEW_ADMINACCOUNT="WEB-INF/jsp/admin/AdminMyAccount.jsp";
    private static final String VIEW_LOGIN = "WEB-INF/jsp/account/LoginForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("loginUser");
        if(userInfo==null){
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }
        else{
            AdminService adminService = new AdminService();
            session.setAttribute("loginUser",userInfo);
            request.getRequestDispatcher(VIEW_ADMINACCOUNT).forward(request,response);
        }

    }
}
