package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Order;
import org.csu.pubg.domain.OrderDetail;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by liulin on 2017/9/25.
 */
public class AdminSearchOrderDetailServlet extends HttpServlet {
    private static final String VIEW_SERCHORDER="WEB-INF/jsp/admin/AdminOrderDetail.jsp";
    String username;
    UserInfo userInfo=new UserInfo();
    OrderService orderService;
    Order order;
    List<OrderDetail> orderDetailList;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        order=new Order();
        orderService=new OrderService();
        int orderId= Integer.parseInt(request.getParameter("orderId"));
        order=orderService.getOrderByOrderId(orderId);

        session.setAttribute("serchOrder",order);

        request.getRequestDispatcher(VIEW_SERCHORDER).forward(request,response);
    }
}
