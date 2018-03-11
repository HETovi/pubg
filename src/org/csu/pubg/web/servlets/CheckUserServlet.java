package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/24.
 */
public class CheckUserServlet extends HttpServlet {
    private static final String VIEW_CHECK = "WEB-INF/jsp/admin/CheckUser.jsp";
    private AdminService adminService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        adminService = new AdminService();
        int pageSize = 5;
        List<UserInfo> list = new ArrayList<UserInfo>();
        String nowPage = request.getParameter("nowPage");
        list = adminService.getAllPage(Integer.parseInt(nowPage),pageSize);
        int pageNumber = adminService.getAllPageNumber(pageSize);
        session.setAttribute("pageNumber",pageNumber);
        session.setAttribute("adminList",list);
        session.setAttribute("nowPage",nowPage);
        request.getRequestDispatcher(VIEW_CHECK).forward(request,response);


    }
}
