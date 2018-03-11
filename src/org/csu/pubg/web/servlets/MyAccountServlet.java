package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/22.
 */
public class MyAccountServlet extends HttpServlet {
    private static final String VIEW_MYACCOUNT="WEB-INF/jsp/account/MyAccount.jsp";
    private static final String VIEW_LOGIN = "WEB-INF/jsp/account/LoginForm.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int isAddressnull=0;
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("loginUser");
        //判断用户是否登录，如果未登录则跳转到登录界面
        if(userInfo==null){
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }
        else{
            //得到用户的地址信息
            UserService userService = new UserService();
            List<UserAddress> list = new ArrayList<UserAddress>();
            String name = userInfo.getNickName();
            list = userService.getUserAddressByName(name);
            for(UserAddress userAddress:list){
                isAddressnull++;
            }

            //设置用户的地址信息
            session.setAttribute("addressList",list);
            session.setAttribute("isAddressnull",isAddressnull);
            request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request,response);
        }


    }
}
