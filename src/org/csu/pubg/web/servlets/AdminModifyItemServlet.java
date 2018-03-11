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
public class AdminModifyItemServlet extends HttpServlet {
    private static final String VIEW_CHECKITEM = "WEB-INF/jsp/admin/AdminModifyItem.jsp";
    private Item item;
    private AdminService adminService;
    String msg;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        item = new Item();
        adminService = new AdminService();
        item = (Item) session.getAttribute("ModifyItem");
        String itemName = request.getParameter("itemName");
        String itemDescn = request.getParameter("itemDescn");
        int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
        double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        item.setItemNumber(itemNumber);
        item.setItemName(itemName);
        item.setPrice(itemPrice);
        item.setDescn(itemDescn);
        item.setItemId(itemId);
        if(adminService.modifyItem(item,itemId)){
            msg="修改成功";
        }
        else {
            msg="修改失败";
        }
        session.setAttribute("ModifyItem",item);
        request.setAttribute("loginMsg",msg);
        request.getRequestDispatcher(VIEW_CHECKITEM).forward(request,response);
    }
}
