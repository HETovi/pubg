<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <form method="post" action="buildorder">
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
                                <c:forEach var="orderItem" items="${sessionScope.orderItemList}">
                                    <tr class="cart_item">

                                        <td class="product-thumbnail">
                                            <a href=""><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${orderItem.imgurl}"></a>
                                        </td>

                                        <td class="product-name">
                                            <a href="">${orderItem.itemName}</a>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${orderItem.price}</span>
                                        </td>

                                        <td class="product-quantity">
                                            <div class="quantity buttons_added">
                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="${orderItem.itemNumber}" min="0" step="1" name="quantity${orderItem.itemId}" readonly>
                                            </div>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${orderItem.price*orderItem.itemNumber}</span>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:forEach var="address" items="${sessionScope.userAddressList}">
                                <tr>
                                    <td class="product-name1" colspan="5">
                                        <a>邮编号码:</a> <input type="text" name="postCode" value=${address.postCode}><br/>
                                        <a>邮编地址:</a> <input type="text" name="postPlace" value=${address.postPlace}><br/>
                                        <a>手机号码:</a> <input type="text" name="telephone" value=${address.telephone}><br/>
                                    </td>
                                </tr>
                                </c:forEach>
                                <tr>
                                    <td class="actions" colspan="5">
                                        <input type="submit" value="确定" name="update_cart" class="button"/>
                                    </td>
                                </tr>
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