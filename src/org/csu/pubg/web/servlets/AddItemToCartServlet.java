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
@WebServlet(name = "AddItemToCartServlet")
public class AddItemToCartServlet extends HttpServlet {

    private static final String VIEW_CART="WEB-INF/jsp/cart/Cart.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    CartService cartService;
    List<Cart> cartList;
    List<Item> cartItemList;
    String username;
    UserInfo userInfo=new UserInfo();
    DecimalFormat df = new DecimalFormat("#.00");
    int itemId;
    int quantity=0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartItemNum=0;
        double cartItemAllPrice=0;
        cartService=new CartService();
        cartList= new ArrayList<Cart>();
        HttpSession session=request.getSession();
        //得到登录的用户信息
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        if(userInfo!=null){
            username=userInfo.getNickName();
            itemId= Integer.parseInt(request.getParameter("itemId"));
            quantity= Integer.parseInt(request.getParameter("quantity"));

            //将商品添加到对应用户的cart表中
            if(cartService.addCart(username,itemId,quantity)){
                cartList=cartService.getCartListByNickName(username);
                cartItemList=cartService.getCartItem(cartList);
                //读取cart表中的数据，并存入cartItemList
                session.setAttribute("cartItemList",cartItemList);

                //计算购物车中商品的总价格
                for(Item item:cartItemList){
                    cartItemNum++;
                    cartItemAllPrice=cartItemAllPrice+item.getPrice()*item.getItemNumber();
                }
                session.setAttribute("cartItemNum",cartItemNum);
                session.setAttribute("cartItemAllPrice",df.format(cartItemAllPrice));

                request.getRequestDispatcher(VIEW_CART).forward(request,response);
            }
        }else{
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }

    }
}
