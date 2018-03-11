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
@WebServlet(name = "AddItemToWishServlet")
public class AddItemToWishServlet extends HttpServlet {
    private static final String VIEW_WISH="WEB-INF/jsp/wish/MyWishForm.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    WishService wishService;
    List<Wish> wishList;
    List<Item> wishItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    DecimalFormat df = new DecimalFormat("#.00");
    int itemId;
    int quantity=0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        wishService=new WishService();
        wishList= new ArrayList<Wish>();
        HttpSession session=request.getSession();
        //得到登录用户的信息
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        if(userInfo!=null){
            username=userInfo.getNickName();
            itemId= Integer.parseInt(request.getParameter("itemId"));
            quantity= Integer.parseInt(request.getParameter("quantity"));

            //将商品添加到对应用户的心愿单中
            if(wishService.addWish(username,itemId,quantity)){
                wishList=wishService.getWishListByNickName(username);
                wishItemList=wishService.getWishItem(wishList);
                session.setAttribute("wishItemList",wishItemList);

                request.getRequestDispatcher(VIEW_WISH).forward(request,response);
            }
        }else{
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }

    }
}
