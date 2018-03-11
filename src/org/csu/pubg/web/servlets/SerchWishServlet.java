package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.domain.Wish;
import org.csu.pubg.service.WishService;

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
 * Created by liulin on 2017/9/23.
 */
@WebServlet(name = "SerchWishServlet")
public class SerchWishServlet extends HttpServlet {
    private static final String VIEW_SERCHWISH="WEB-INF/jsp/wish/SerchWishForm.jsp";
    private String serchname=null;
    WishService wishService;
    List<Wish> wishList;
    List<Item> wishItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        wishService=new WishService();
        wishList= new ArrayList<Wish>();
        HttpSession session=request.getSession();
        username= new String(request.getParameter("serchname").getBytes("ISO-8859-1"),"utf-8");
        //根据用户名搜索其他用户的心愿单详细信息
        wishList=wishService.getWishListByNickName(username);
        wishItemList=wishService.getWishItem(wishList);

        session.setAttribute("wishName",username);
        session.setAttribute("wishItemList",wishItemList);

        request.getRequestDispatcher(VIEW_SERCHWISH).forward(request,response);
    }
}
