package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.AdminService;
import org.csu.pubg.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/24.
 */
public class AdminModifyPowerServlet extends HttpServlet {
    private static final  String VIEW_ADMINMODIFYPOWER="WEB-INF/jsp/admin/AdminModifyPower.jsp";
    private UserInfo userInfo;
    private RoleService roleService;
    private AdminService adminService;
    private String msg;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        userInfo = new UserInfo();
        roleService = new RoleService();
        adminService = new AdminService();
        userInfo = (UserInfo)session.getAttribute("ModifyUserInfo");
        int roleId = Integer.parseInt(request.getParameter("test"));
        userInfo.setRole(roleService.getRoleById(roleId));
        if(adminService.modifyUserPower(userInfo.getNickName(),roleId)){
            msg="修改成功";
        }
        else {
            msg="修改失败";
        }
        session.setAttribute("ModifyUserInfo",userInfo);
        request.setAttribute("loginMsg",msg);
        request.getRequestDispatcher(VIEW_ADMINMODIFYPOWER).forward(request,response);

    }
}
