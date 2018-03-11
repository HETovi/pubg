<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <form method="post" action="submitorder">
                            <table cellspacing="0" class="shop_table cart">
                                <thead>
                                <tr>
                                    <th class="product-thumbnail">&nbsp;</th>
                                    <th class="product-price">商品</th>
                                    <th class="product-price">价格</th>
                                    <th class="product-quantity">数量</th>
                                    <th class="product-subtotal">总价</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="orderDetails" items="${sessionScope.buildOrder.orderDetails}">
                                    <tr class="cart_item">

                                        <td class="product-thumbnail">
                                            <a><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${orderDetails.item.imgurl}"></a>
                                        </td>

                                        <td class="product-name">
                                            <a>${orderDetails.item.itemName}</a>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${orderDetails.itemPrice}</span>
                                        </td>

                                        <td class="product-name">
                                            <a>${orderDetails.itemNumber}</a>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${orderDetails.itemPrice*orderDetails.itemNumber}</span>
                                        </td>

                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td class="product-name" colspan="5">
                                        <a>订单编号：${sessionScope.buildOrder.orderId}</a><br>
                                        <a>订单用户：${sessionScope.buildOrder.nickName}</a><br>
                                        <a>订单状态:${sessionScope.buildOrder.status}</a><br>
                                        <a>电话号码:${sessionScope.buildOrder.telephone}</a><br>
                                        <a>邮政编码：${sessionScope.buildOrder.postCode}</a><br>
                                        <a>地    址:${sessionScope.buildOrder.postPlace}</a><br>
                                        <a>订单时间:${sessionScope.buildOrder.time}</a><br>
                                    </td>
                                </tr>
                                <c:if test="${sessionScope.buildOrder.status=='未支付'}">
                                <tr>
                                    <td class="actions" colspan="5">
                                        <input type="submit" value="支付" name="update_cart" class="button" />
                                    </td>
                                </tr>
                                </c:if>
                                <c:if test="${requestScope.loginMsg!=null}">
                                    <tr>
                                        <td class="actions" colspan="5">
                                            <font color="red">${requestScope.loginMsg}</font>
                                        </td>
                                    </tr>
                                </c:if>

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