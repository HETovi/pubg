<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>购物车</h2>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End Page title area -->


<div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="single-sidebar">
                            <h2 class="sidebar-title">搜索商品</h2>
                            <form action="serchproduct?nowPag=1" method="post">
                                <input type="text" placeholder="搜索商品..." name="serchname">
                                <input type="submit" value="搜索">
                            </form>
                        </div>

                        <div class="single-sidebar">
                            <h2 class="sidebar-title">热门产品</h2>
                            <div class="thubmnail-recent">
                                <img src="img/clo3.png" class="recent-thumb" alt="">
                                <h2><a href="product?itemId=9">Tracksuit Top(Yellow)</a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$34.00</ins> <del>$54.5</del>
                                </div>
                            </div>
                            <div class="thubmnail-recent">
                                <img src="img/clo19.png" class="recent-thumb" alt="">
                                <h2><a href="product?itemId=25">Tracksuit Top</a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$16.00</ins> <del>$18.00</del>
                                </div>
                            </div>
                            <div class="thubmnail-recent">
                                <img src="img/hat3.png" class="recent-thumb" alt="">
                                <h2><a href="product?itemId=3">Camo Cap</a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$30.25</ins> <del>$50.00</del>
                                </div>
                            </div>
                            <div class="thubmnail-recent">
                                <img src="img/pan17.png" class="recent-thumb" alt="">
                                <h2><a href="product?itemId=62">Pleated Mini-skirt (Blue) </a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$28.00</ins> <del>$39.50</del>
                                </div>
                            </div>
                        </div>
                    </div>

            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <form method="post" action="" name="cartForm">
                            <table cellspacing="0" class="shop_table cart">
                                <thead>
                                <tr>
                                    <th class="product-remove">&nbsp;</th>
                                    <th class="product-thumbnail">&nbsp;</th>
                                    <th class="product-price">商品</th>
                                    <th class="product-price">价格</th>
                                    <th class="product-quantity">数量</th>
                                    <th class="product-subtotal">总价</th>
                                    <th class="product-subtotal">&nbsp;</th>
                                    <th class="product-price">购买</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${sessionScope.cartItemList}">
                                <tr class="cart_item">
                                    <td class="product-name">
                                        <a title="Remove this item" class="remove" href="deletecart?deleteCartItem=${cartItem.itemId}">x</a>
                                    </td>

                                    <td class="product-thumbnail">
                                        <a href="product?itemId=${cartItem.itemId}"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${cartItem.imgurl}"></a>
                                    </td>

                                    <td class="product-name">
                                        <a href="product?itemId=${cartItem.itemId}">${cartItem.itemName}</a>
                                    </td>

                                    <td class="product-name">
                                        <span class="amount">${cartItem.price}</span>
                                    </td>

                                    <td class="product-quantity">
                                        <div class="quantity buttons_added">
                                            <input type="number" size="4" class="input-text qty text" title="Qty" value="${cartItem.itemNumber}" min="0" step="1" name="quantity${cartItem.itemId}">
                                        </div>
                                    </td>

                                    <td class="product-name">
                                        <span class="amount">${cartItem.price*cartItem.itemNumber}</span>
                                    </td>

                                    <td class="product-name">
                                        <a href="addtowish?itemId=${cartItem.itemId}&quantity=1"><i class="fa fa-heart"></i></a>
                                    </td>

                                    <td class="product-price">
                                        <input type="checkbox" value="${cartItem.itemId}" name="buytoorder" />
                                    </td>
                                </tr>
                                </c:forEach>
                                <tr>
                                    <td class="actions" colspan="8">
                                        <input type="submit" value="刷新" name="update_cart" class="button" onclick="cartForm.action='updatecart';cartForm.submit();" />
                                        <input type="submit" value="生成订单" name="proceed" class="checkout-button button alt wc-forward" onclick="cartForm.action='addorder';cartForm.submit();" />
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>

                        <div class="cart-collaterals">


                            <div class="cross-sells">
                                <h2>猜你喜欢</h2>
                                <ul class="products">
                                    <li class="product">
                                        <a href="product?itemId=65">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="img/pan20.png">
                                            <h3>Pleated Mini-skirt</h3>
                                            <span class="price"><span class="amount">£28.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="addtocart?itemId=65&quantity=1">加入购物车</a>
                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="addtowish?itemId=65&quantity=1">加入心愿单</a>
                                    </li>

                                    <li class="product">
                                        <a href="product?itemId=25">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="img/clo19.png">
                                            <h3>Tracksuit Top</h3>
                                            <span class="price"><span class="amount">£16.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="addtocart?itemId=25&quantity=1">加入购物车</a>
                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="addtowish?itemId=25&quantity=1">加入心愿单</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../common/IncludeButtom.jsp"%>