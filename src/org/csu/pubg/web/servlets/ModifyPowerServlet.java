package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.RoleInfo;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.AdminService;
import org.csu.pubg.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/24.
 */
public class ModifyPowerServlet extends HttpServlet {
    private static final  String VIEW_ADMINMODIFYPOWER="WEB-INF/jsp/admin/AdminModifyPower.jsp";
    private AdminService adminService;
    private UserInfo userInfo;
    private RoleService roleService;
    private List<RoleInfo> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nickName = request.getParameter("nickName");
        adminService = new AdminService();
        userInfo = adminService.getAdminByNickName(nickName);
        session.setAttribute("ModifyUserInfo",userInfo);
        roleService = new RoleService();
        list = new ArrayList<RoleInfo>();
        list = roleService.getAll();
        session.setAttribute("roleList",list);
        request.getRequestDispatcher(VIEW_ADMINMODIFYPOWER).forward(request,response);

    }
}
