package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
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
public class CheckItemServlet extends HttpServlet {
    private static final String VIEW_CHECKITEM = "WEB-INF/jsp/admin/CheckItem.jsp";
    private AdminService adminService;
    private List<Item> list;
    int itemPageNumber;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        adminService = new AdminService();
        list = new ArrayList<Item>();
        int itemPage = Integer.parseInt(request.getParameter("itemPage"));
        list = adminService.getAllPage(itemPage);
        itemPageNumber = adminService.getPageNumber();
        session.setAttribute("itemPage",itemPage);
        session.setAttribute("itemList",list);
        session.setAttribute("itemPageNumber",itemPageNumber);

        request.getRequestDispatcher(VIEW_CHECKITEM).forward(request,response);
    }
}
