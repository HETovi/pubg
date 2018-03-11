package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Category;
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
public class AddItemsServlet extends HttpServlet {
    private static final String VIEW_ADDITEMS="WEB-INF/jsp/admin/AddItems.jsp";
    private AdminService adminService;
    private List<Category> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        adminService = new AdminService();
        list = new ArrayList<Category>();
        list = adminService.getBigCategory();
        session.setAttribute("categoryList",list);






        request.getRequestDispatcher(VIEW_ADDITEMS).forward(request,response);

    }
}
