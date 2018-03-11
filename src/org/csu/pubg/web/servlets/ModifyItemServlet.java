package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
import org.csu.pubg.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/24.
 */
public class ModifyItemServlet extends HttpServlet {
    private AdminService adminService;
    private Item item;
    private static final  String VIEW_ADMINMODIFYITEM="WEB-INF/jsp/admin/AdminModifyItem.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session = request.getSession();
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        adminService = new AdminService();
        item = adminService.getItemById(itemId);
        session.setAttribute("ModifyItem",item);
        request.getRequestDispatcher(VIEW_ADMINMODIFYITEM).forward(request,response);

    }
}
