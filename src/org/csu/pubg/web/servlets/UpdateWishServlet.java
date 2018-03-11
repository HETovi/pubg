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
@WebServlet(name = "UpdateWishServlet")
public class UpdateWishServlet extends HttpServlet {
    private static final String VIEW_WISH="WEB-INF/jsp/wish/MyWishForm.jsp";
    WishService wishService;
    List<Wish> wishList;
    List<Item> wishItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    int itemId;
    int quantity=0;
    String quantityname;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        wishService=new WishService();
        wishList= new ArrayList<Wish>();
        wishItemList=new ArrayList<Item>();

        HttpSession session=request.getSession();
        wishItemList=(List<Item>)session.getAttribute("wishItemList");
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        username=userInfo.getNickName();
        for(Item item:wishItemList){
            itemId=item.getItemId();
            quantityname="quantity"+itemId;
            quantity= Integer.parseInt(request.getParameter(quantityname));
            wishService.updateWish(username,itemId,quantity);
        }
        wishList=wishService.getWishListByNickName(username);
        wishItemList=wishService.getWishItem(wishList);


        session.setAttribute("wishItemList",wishItemList);
        request.getRequestDispatcher(VIEW_WISH).forward(request,response);

    }
}
