package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.OrderService;
import org.csu.pubg.service.ProductService;

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
 * Created by liulin on 2017/9/25.
 */
@WebServlet(name = "AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    private static final String VIEW_ADDORDER="WEB-INF/jsp/order/AddOrder.jsp";
    List<Item> orderItemList=new ArrayList<>();
    Item item;
    int itemId;
    ProductService productService=new ProductService();
    List<Item> cartItemList;
    OrderService orderService=new OrderService();
    List<UserAddress> userAddressList=new ArrayList<>();
    String username;
    UserInfo userInfo=new UserInfo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String arr[]=request.getParameterValues("buytoorder");
        orderItemList=(List<Item>)session.getAttribute("orderItemList");
        if(!orderItemList.isEmpty()){
            orderItemList.clear();
        }

        //得到购物车中选择的物品的数量和单价
        cartItemList=(List<Item>)session.getAttribute("cartItemList");
            for(int i=0;i<arr.length;i++){
               itemId=Integer.parseInt(arr[i]);
               item=new Item();
               item=productService.getItemByItemId(itemId);
               orderItemList.add(item);
               for(Item cartItem:cartItemList){
                   if(cartItem.getItemId()==itemId){
                       item.setItemNumber(cartItem.getItemNumber());
                       item.setPrice(cartItem.getPrice());
                       break;
                   }
               }
            }
            //得到用户备份地址
            userInfo=(UserInfo)session.getAttribute("loginUser") ;
            username=userInfo.getNickName();
            userAddressList=orderService.getUserAddressByNickName(username);

            //设置订单中商品的信息以及用户的地址信息
            session.setAttribute("orderItemList",orderItemList);
            session.setAttribute("userAddressList",userAddressList);

            request.getRequestDispatcher(VIEW_ADDORDER).forward(request,response);
        }
    }
