package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/22.
 */
public class EditServlet extends HttpServlet {
    private static final String VIEW_MYACCOUNT="WEB-INF/jsp/account/MyAccount.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String realName =request.getParameter("realName");
        String identity =request.getParameter("identity") ;
        String email = request.getParameter("email");
        String postCode =request.getParameter("postCode") ;
        String postPlace =request.getParameter("postPlace");
        String telephone = request.getParameter("telephone");
        String nickName =request.getParameter("nickName");
        String addressId=request.getParameter("addressId");
        int addressId1=0;
        if(!addressId.equals("")){
            addressId1 = Integer.parseInt(addressId);
        }

        String msg = "";
        if(realName.equals("")||identity.equals("")||email.equals("")||postCode.equals("")||postPlace.equals("")||telephone.equals("")){
            msg = "上述表单都需填值";
            request.setAttribute("loginMsg",msg);
            request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request,response);
        }
        else{
            UserService userService = new UserService();
            UserAddress userAddress = new UserAddress();
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(email);
            userInfo.setIdentity(identity);
            userInfo.setRealName(realName);
            List<UserAddress>list = new ArrayList<UserAddress>();
            list = userService.getUserAddressByName(nickName);
            if(list.isEmpty()){

                userAddress.setPostCode(Integer.parseInt(postCode));
                userAddress.setPostPlace(postPlace);
                userAddress.setTelephone(telephone);
                userAddress.setNickName(nickName);
                if(userService.addUserAddress(userAddress)){
                    if(userService.modifyUser(userInfo,nickName)){
                        msg="修改成功";
                        request.setAttribute("loginMsg",msg);

                        int isAddressnull=1;
                        userInfo = userService.getUser(nickName);
                        list = userService.getUserAddressByName(nickName);
                        session.setAttribute("loginUser",userInfo);
                        session.setAttribute("addressList",list);
                        session.setAttribute("isAddressnull",isAddressnull);
                        request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request,response);
                    }
                }

            }
            else{
                if(userService.modifyUser(userInfo,nickName)){
                    userAddress.setPostCode(Integer.parseInt(postCode));
                    userAddress.setPostPlace(postPlace);
                    userAddress.setTelephone(telephone);
                    userAddress.setNickName(nickName);
                    if(userService.modifyAddress(addressId1,userAddress)){
                        msg="修改成功";
                        request.setAttribute("loginMsg",msg);

                        userInfo = userService.getUser(nickName);
                        list = userService.getUserAddressByName(nickName);
                        session.setAttribute("loginUser",userInfo);
                        session.setAttribute("addressList",list);
                        request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request,response);
                    }

                }
            }


            }
        }

    }

