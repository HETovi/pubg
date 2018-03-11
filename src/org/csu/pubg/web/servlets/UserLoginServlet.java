package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.CartService;
import org.csu.pubg.service.UserService;

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
 * Created by liulin on 2017/9/13.
 */
@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final String VIEW_MAIN="index.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    private static final String VIEW_ADMINLOGIN="WEB-INF/jsp/admin/AdminIndex.jsp";
    private UserService service;
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
        String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        service=new UserService();

        //判断用户名密码是否正确
        if(service.islogin(username,password)) {

            //得到登录用户的信息，并写入loginUser中
            UserInfo userInfo = service.getUser(username);
            session.setAttribute("loginUser", userInfo);

            //判断登录用户的身份，跳转到不同的页面。
            //1.超级管理员  2.管理员  3.普通用户
            if (userInfo.getRoleId() == 1) {
                request.getRequestDispatcher(VIEW_ADMINLOGIN).forward(request, response);
            } else if (userInfo.getRoleId() == 2) {
                request.getRequestDispatcher(VIEW_ADMINLOGIN).forward(request, response);
            } else {
                cartService = new CartService();
                cartList = new ArrayList<Cart>();
                userInfo = (UserInfo) session.getAttribute("loginUser");
                if (userInfo != null) {
                    username = userInfo.getNickName();
                } else {
                    request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
                }

                //获取数据库中该用户的购物车中的信息
                cartList = cartService.getCartListByNickName(username);
                cartItemList = cartService.getCartItem(cartList);
                session.setAttribute("cartItemList", cartItemList);

                //计算购物车中的价格
                for (Item item : cartItemList) {
                    cartItemNum++;
                    cartItemAllPrice = cartItemAllPrice + item.getPrice() * item.getItemNumber();
                }

                //cartItemNum：购物车的数量   cartItemAllPrice：购物车的总价
                session.setAttribute("cartItemNum", cartItemNum);
                session.setAttribute("cartItemAllPrice", df.format(cartItemAllPrice));

                //跳到普通用户主界面
                request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
            }
        }
        else{
            //用户名或密码错误则返回提示
            request.setAttribute("loginMsg","用户名或者密码错误");
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }

    }
}
