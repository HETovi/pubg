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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/22.
 */
@WebServlet(name = "SerchProductServlet")
public class SerchProductServlet extends HttpServlet {
    private static final String VIEW_SERCH="WEB-INF/jsp/cart/SerchProduct.jsp";
    private String serchname=null;
    private int nowPag;
    private int allPag;
    ProductService productService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> itemList=new ArrayList<>();
        serchname=request.getParameter("serchname");
        nowPag= Integer.parseInt(request.getParameter("nowPag"));
        productService=new ProductService();

        if(!productService.isFuzzySearch(serchname)){

        }else{
            itemList=productService.fuzzySearch(nowPag,serchname);
            allPag=productService.getPageNumber(serchname);
            HttpSession session=request.getSession();
            session.setAttribute("itemList",itemList);
            session.setAttribute("serchname",serchname);
            session.setAttribute("nowPag",nowPag);
            session.setAttribute("allPag",allPag);
            request.getRequestDispatcher(VIEW_SERCH).forward(request,response);
        }


    }
}
