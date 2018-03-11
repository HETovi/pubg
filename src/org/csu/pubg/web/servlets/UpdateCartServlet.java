package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.CartService;

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
 * Created by liulin on 2017/9/22.
 */
@WebServlet(name = " UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
    private static final String VIEW_CART="WEB-INF/jsp/cart/Cart.jsp";
    CartService cartService;
    List<Cart> cartList;
    List<Item> cartItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    DecimalFormat df = new DecimalFormat("#.00");
    int itemId;
    int quantity=0;
    String quantityname;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartItemNum=0;
        double cartItemAllPrice=0;
        cartService=new CartService();
        cartList= new ArrayList<Cart>();
        cartItemList=new ArrayList<Item>();

        HttpSession session=request.getSession();
        cartItemList=(List<Item>)session.getAttribute("cartItemList");
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        username=userInfo.getNickName();
        for(Item item:cartItemList){
            itemId=item.getItemId();
            quantityname="quantity"+itemId;
            quantity= Integer.parseInt(request.getParameter(quantityname));
            cartService.updateCart(username,itemId,quantity);
        }
        cartList=cartService.getCartListByNickName(username);
        cartItemList=cartService.getCartItem(cartList);

        for(Item item:cartItemList){
            cartItemNum++;
            cartItemAllPrice=cartItemAllPrice+item.getPrice()*item.getItemNumber();
        }
        session.setAttribute("cartItemNum",cartItemNum);
        session.setAttribute("cartItemAllPrice",df.format(cartItemAllPrice));


        session.setAttribute("cartItemList",cartItemList);
        request.getRequestDispatcher(VIEW_CART).forward(request,response);

    }
}
