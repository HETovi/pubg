package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Order;
import org.csu.pubg.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liulin on 2017/9/26.
 */
public class ZhifuServlet extends HttpServlet {
    private static final String VIEW_SUBMITORDER="WEB-INF/jsp/order/SerchOrder.jsp";
    private Order order;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        order = new Order();
        OrderService orderService = new OrderService();
        order=(Order) session.getAttribute("serchOrder");
        order.setStatus("已支付");
        if(orderService.modifyOrderStatus(order.getOrderId(),order)){
            request.setAttribute("loginMsg", "支付成功");
        }
        else {
            request.setAttribute("loginMsg", "支付失败");
        }
        session.setAttribute("serchOrder",order);

        request.getRequestDispatcher(VIEW_SUBMITORDER).forward(request,response);
    }
}
