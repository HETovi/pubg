package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Wish;
import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.WishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/23.
 */
@WebServlet(name = "WishServlet")
public class WishServlet extends HttpServlet {
    private static final String VIEW_WISH="WEB-INF/jsp/wish/MyWishForm.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
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
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        if(userInfo!=null){
            username=userInfo.getNickName();
        }else{
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }
        wishList=wishService.getWishListByNickName(username);
        wishItemList=wishService.getWishItem(wishList);

        session.setAttribute("wishItemList",wishItemList);

        request.getRequestDispatcher(VIEW_WISH).forward(request,response);
    }
}
