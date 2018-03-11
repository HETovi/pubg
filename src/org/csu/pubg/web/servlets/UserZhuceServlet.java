package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tovi on 2017/9/22.
 */
public class UserZhuceServlet extends HttpServlet {
    private static final String VIEW_MAIN="index.jsp";
    private static final String VIEW_ZHUCE="WEB-INF/jsp/account/Zhuce.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到注册页面中的值，并解决乱码的情况
        String nickName = new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
        String pass = request.getParameter("password");
        String realName = new String(request.getParameter("realname").getBytes("ISO-8859-1"),"utf-8");
        String identity = request.getParameter("identity");
        String email = request.getParameter("email");
        UserService userService = new UserService();
        String msg = "";
        HttpSession session = request.getSession();
        if(userService.isExist(nickName)){
            msg="该昵称已存在";
            request.setAttribute("loginMsg",msg);
            request.getRequestDispatcher(VIEW_ZHUCE).forward(request,response);

        }
        else{
            UserInfo userInfo = new UserInfo();
            userInfo.setNickName(nickName);
            userInfo.setPass(pass);
            userInfo.setRealName(realName);
            userInfo.setIdentity(identity);
            userInfo.setEmail(email);
            //注册成功，则跳到主界面
            if(userService.register(userInfo)){
                session.setAttribute("loginUser",userInfo);
                request.getRequestDispatcher(VIEW_MAIN).forward(request,response);
            }
            else{
                msg="注册失败，发生未知错误";
                request.setAttribute("loginMsg",msg);
                request.getRequestDispatcher(VIEW_ZHUCE).forward(request,response);
            }
        }

    }
}
