package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.Order;
import org.csu.pubg.domain.OrderDetail;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/25.
 */
@WebServlet(name = "BuildOrderServlet")
public class BuildOrderServlet extends HttpServlet {
    private static final String VIEW_BUILDORDER="WEB-INF/jsp/order/BuildOrder.jsp";
    Order order=new Order();
    Order buildOrder=new Order();
    String username;
    UserInfo userInfo=new UserInfo();
    OrderDetail orderDetail;
    List<Item> orderItemList=new ArrayList<>();
    List<OrderDetail> orderDetailList=new ArrayList<>();
    OrderService orderService=new OrderService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        username=userInfo.getNickName();
        String status="未支付";
        String telephone=request.getParameter("telephone");
        int postCode= Integer.parseInt(request.getParameter("postCode"));
        String postPlace=new String(request.getParameter("postPlace").getBytes("ISO-8859-1"),"utf-8");
        Timestamp orderTime = new Timestamp(System.currentTimeMillis());
        order.setNickName(username);
        order.setStatus(status);
        order.setTelephone(telephone);
        order.setPostCode(postCode);
        order.setPostPlace(postPlace);
        order.setTime(orderTime);
        int orderId=orderService.addOrder(order);
        order=orderService.getOrderByOrderId(orderId);

        orderItemList=(List<Item>)session.getAttribute("orderItemList");
        for(Item item:orderItemList){
            orderDetail=new OrderDetail();
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setItemId(item.getItemId());
            orderDetail.setItemNumber(item.getItemNumber());
            orderDetail.setItemPrice(item.getPrice());
            orderService.addOrderDetail(orderDetail);
            orderDetailList.add(orderDetail);
        }


        order.setOrderDetails(orderDetailList);

        buildOrder=orderService.getOrderByOrderId(order.getOrderId());

        session.setAttribute("buildOrder",buildOrder);
        request.getRequestDispatcher(VIEW_BUILDORDER).forward(request,response);
    }
}
