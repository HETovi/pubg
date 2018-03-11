package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
import org.csu.pubg.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by liulin on 2017/9/20.
 */
@WebServlet(name = "ShopServlet")
public class ShopServlet extends HttpServlet {
    private static final String VIEW_SHOP="WEB-INF/jsp/cart/Shop.jsp";
    private int categoryId;
    private int nowPag;
    private int allPag;
    ProductService productService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> itemList;
        //得到物品类别以及当前页数
        categoryId= Integer.parseInt(request.getParameter("categoryId"));
        nowPag= Integer.parseInt(request.getParameter("nowPag"));
        productService=new ProductService();
        if(categoryId==0) {
            allPag=productService.getPageNumber();
            itemList = productService.getAllItem(nowPag);
        }else{
            //分类，分页查询
            allPag=productService.getPageNumber(categoryId);
            itemList = productService.getAllItembByCategoryId(categoryId,nowPag);
        }
        HttpSession session=request.getSession();
        session.setAttribute("itemList",itemList);
        session.setAttribute("nowCategory",categoryId);
        session.setAttribute("nowPag",nowPag);
        session.setAttribute("allPag",allPag);
        request.getRequestDispatcher(VIEW_SHOP).forward(request,response);
    }
}
