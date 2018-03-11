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
 * Created by liulin on 2017/9/21.
 */
@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    private static final String VIEW_CART="WEB-INF/jsp/cart/Cart.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    CartService cartService;
    List<Cart> cartList;
    List<Item> cartItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    DecimalFormat df = new DecimalFormat("#.00");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartItemNum=0;
        double cartItemAllPrice=0;
        cartService=new CartService();
        cartList= new ArrayList<Cart>();
        HttpSession session=request.getSession();
        //得到登录用户的信息
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        if(userInfo!=null){
            username=userInfo.getNickName();
        }else{
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }

        //得到用户购物车中所有商品的信息
        cartList=cartService.getCartListByNickName(username);
        cartItemList=cartService.getCartItem(cartList);

        //计算购物车中的总价格
        for(Item item:cartItemList){
            cartItemNum++;
            cartItemAllPrice=cartItemAllPrice+item.getPrice()*item.getItemNumber();
        }
        session.setAttribute("cartItemNum",cartItemNum);
        session.setAttribute("cartItemAllPrice",df.format(cartItemAllPrice));

        List<Item> orderItemList=new ArrayList<>();
        session.setAttribute("cartItemList",cartItemList);
        session.setAttribute("orderItemList",orderItemList);

        request.getRequestDispatcher(VIEW_CART).forward(request,response);
    }
}
