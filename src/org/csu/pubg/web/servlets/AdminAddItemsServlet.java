package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Category;
import org.csu.pubg.domain.Classification;
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
public class AdminAddItemsServlet extends HttpServlet {
    private static final String VIEW_ADDITEMS="WEB-INF/jsp/admin/AddItems.jsp";
    private AdminService adminService;
    private Item item;
    private String msg;
    private List<Category> list;
    private Classification classification;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        String itemName = request.getParameter("itemName");
        double price = Double.parseDouble(request.getParameter("itemPrice"));
        String descn = request.getParameter("itemDescn");
        String imgUrl = request.getParameter("imgUrl");

        int categoryId = Integer.parseInt(request.getParameter("test"));
        adminService = new AdminService();
        list = new ArrayList<Category>();
        list = adminService.getBigCategory();
        session.setAttribute("categoryList", list);
        if (adminService.isExistItemId(itemId)) {
            msg = "该商品编码已存在";
            request.setAttribute("loginMsg", msg);
            request.getRequestDispatcher(VIEW_ADDITEMS).forward(request, response);
        } else {
            item = new Item();
            item.setItemId(itemId);
            item.setDescn(descn);
            item.setPrice(price);
            item.setItemName(itemName);
            item.setItemNumber(itemNumber);
            item.setImgurl(imgUrl);
            classification = new Classification();
            classification.setItemId(itemId);
            classification.setCategoryId(categoryId);

            if (adminService.addItem(item)) {
                if (adminService.addClassification(classification)) {
                    msg = "添加成功";
                    request.setAttribute("loginMsg", msg);
                    request.getRequestDispatcher(VIEW_ADDITEMS).forward(request, response);
                }
            }
            else {
                msg = "添加失败";
                request.setAttribute("loginMsg", msg);
                request.getRequestDispatcher(VIEW_ADDITEMS).forward(request, response);
            }

        }
    }
}
