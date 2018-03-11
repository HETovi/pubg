<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <form method="post" action="">
                            <table cellspacing="0" class="shop_table cart">
                                <thead>
                                <tr>
                                    <th class="product-remove">&nbsp;</th>
                                    <th class="product-price">订单编号</th>
                                    <th class="product-price">订单用户</th>
                                    <th class="product-price">订单状态</th>
                                    <th class="product-price">电话号码</th>
                                    <th class="product-price">订单总价</th>
                                    <th class="product-price">订单时间</th>
                                    <th class="product-price">&nbsp;</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="order" items="${sessionScope.orderList}">
                                    <tr class="cart_item">
                                        <td class="product-remove">
                                            <a title="Remove this item" class="remove" href="deleteorder?orderId=${order.orderId}">x</a>
                                        </td>
                                        <td class="product-name">
                                            <a>${order.orderId}</a>
                                        </td>
                                        <td class="product-name">
                                            <a>${order.nickName}</a>
                                        </td>
                                        <td class="product-name">
                                            <a>${order.status}</a>
                                        </td>
                                        <td class="product-name">
                                            <a>${order.telephone}</a>
                                        </td>
                                        <td class="product-name">
                                            <span class="amount">${order.allPrice}</span>
                                        </td>
                                        <td class="product-name">
                                            <a>${order.time}</a>
                                        </td>
                                        <td class="product-name">
                                            <a href="serchorder?orderId=${order.orderId}">查看详情</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                  </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../common/IncludeButtom.jsp"%>