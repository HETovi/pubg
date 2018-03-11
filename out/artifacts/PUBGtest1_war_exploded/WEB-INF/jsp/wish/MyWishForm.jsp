<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>我的心愿单</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="single-sidebar">
                    <h3 class="sidebar-title">搜索其他用户心愿单</h3>
                    <form action="serchwish" method="post">
                        <input type="text" placeholder="搜索用户名..." name="serchname">
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
                        <form method="post" action="updatewish">
                            <table cellspacing="0" class="shop_table wish">
                                <thead>
                                <tr>
                                    <th class="product-remove">&nbsp;</th>
                                    <th class="product-thumbnail">&nbsp;</th>
                                    <th class="product-price">商品</th>
                                    <th class="product-price">价格</th>
                                    <th class="product-quantity">数量</th>
                                    <th class="product-subtotal">总价</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="wishItem" items="${sessionScope.wishItemList}">
                                    <tr class="wish_item">
                                        <td class="product-remove">
                                            <a title="Remove this item" class="remove" href="deletewish?deleteWishItem=${wishItem.itemId}">×</a>
                                        </td>

                                        <td class="product-thumbnail">
                                            <a href="single-product.html"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${wishItem.imgurl}"></a>
                                        </td>

                                        <td class="product-name">
                                            <a href="single-product.html">${wishItem.itemName}</a>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${wishItem.price}</span>
                                        </td>

                                        <td class="product-quantity">
                                            <div class="quantity buttons_added">
                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="${wishItem.itemNumber}" min="0" step="1" name="quantity${wishItem.itemId}">
                                            </div>
                                        </td>

                                        <td class="product-name">
                                            <span class="amount">${wishItem.price*wishItem.itemNumber}</span>
                                        </td>

                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td class="actions" colspan="7">
                                        <input type="submit" value="刷新" name="update_cart" class="button">
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