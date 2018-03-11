package org.csu.pubg.web.servlets;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/24.
 */
@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    private static final String VIEW_MYORDER="WEB-INF/jsp/order/MyOrder.jsp";
    private static final String VIEW_LOGIN="WEB-INF/jsp/account/LoginForm.jsp";
    String username;
    UserInfo userInfo=new UserInfo();
    OrderService orderService;
    List<Order> orderList;
    List<OrderDetail> orderDetailList;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        orderService=new OrderService();
        orderList=new ArrayList<>();
        userInfo=(UserInfo)session.getAttribute("loginUser") ;
        if(userInfo!=null){
            username=userInfo.getNickName();
        }else{
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }
        //根据用户名得到用户的所有订单
        orderList=orderService.getAllOrder(username);

        //计算每个订单的总价
        for(Order order:orderList){
            double allprice=0;
           orderDetailList=order.getOrderDetails();
           for(OrderDetail orderDetail:orderDetailList){
               allprice=allprice+orderDetail.getItemNumber()*orderDetail.getItemPrice();
           }
           order.setAllPrice(allprice);
        }

        session.setAttribute("orderList",orderList);

        request.getRequestDispatcher(VIEW_MYORDER).forward(request,response);
    }
}
