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
public class AdminEditServlet extends HttpServlet {
    private static final String VIEW_MYACCOUNT="WEB-INF/jsp/admin/AdminMyAccount.jsp";
    private AdminService adminService;
    private UserInfo userInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        String realName = request.getParameter("realName");
        String identity = request.getParameter("identity");
        String email = request.getParameter("email");
        String nickName = request.getParameter("nickName");
        String msg = "";
        adminService = new AdminService();
        userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfo.setIdentity(identity);
        userInfo.setRealName(realName);
        if (adminService.modifyUser(userInfo, nickName)) {
            msg = "修改成功";
            request.setAttribute("loginMsg", msg);
            userInfo = adminService.getAdminByNickName(nickName);
            session.setAttribute("loginUser", userInfo);
            request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request, response);


        } else {
            msg = "修改失败";
            request.setAttribute("loginMsg", msg);
            userInfo = adminService.getAdminByNickName(nickName);
            session.setAttribute("loginUser", userInfo);
            request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request, response);

        }
    }
}
