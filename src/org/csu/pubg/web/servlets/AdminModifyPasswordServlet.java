package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/26.
 */
public class AdminModifyPasswordServlet extends HttpServlet {

    private static final String VIEW_PASSWORD = "WEB-INF/jsp/admin/AdminModifyPassword.jsp";
    private AdminService adminService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String oldPassword = request.getParameter("oldpassword");
        String newPassword1 = request.getParameter("newpassword1");
        String newPassword2 = request.getParameter("newpassword2");
        String msg = "";
        if (oldPassword.equals("") || newPassword1.equals("") || newPassword2.equals("")) {
            msg = "上述都不能为空";
            request.setAttribute("loginMsg", msg);
            request.getRequestDispatcher(VIEW_PASSWORD).forward(request, response);
        } else {
            UserInfo userInfo = new UserInfo();
            adminService = new AdminService();
            userInfo = (UserInfo) session.getAttribute("loginUser");
            String password = userInfo.getPass();
            if (password.equals(oldPassword)) {
                if (newPassword1.equals(newPassword2)) {
                    String nickName = userInfo.getNickName();
                    if (adminService.modifyPassword(userInfo.getNickName(), newPassword1)) {
                        msg = "修改密码成功";
                        request.setAttribute("loginMsg", msg);
                        userInfo.setPass(newPassword1);
                        session.setAttribute("loginUser", userInfo);
                        request.getRequestDispatcher(VIEW_PASSWORD).forward(request, response);
                    }
                } else {
                    msg = "两次密码输入不匹配";
                    request.setAttribute("loginMsg", msg);
                    request.getRequestDispatcher(VIEW_PASSWORD).forward(request, response);
                }
            } else {
                msg = "原密码输入错误";
                request.setAttribute("loginMsg", msg);
                request.getRequestDispatcher(VIEW_PASSWORD).forward(request, response);
            }
        }
    }
}
