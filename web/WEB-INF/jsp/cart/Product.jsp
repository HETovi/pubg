<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>商品详情</h2>
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
                    <div class="product-breadcroumb">
                        <div class="product-title">
                        <a href="main">主页&nbsp;&nbsp;/</a>
                        <c:forEach var="categoryname" items="${sessionScope.nowcategoryList}">
                            <a href="shop?categoryId=${categoryname.categoryId}&nowPag=1">${categoryname.categoryName}&nbsp;&nbsp;/</a>
                        </c:forEach>
                        <a href="">${sessionScope.nowItem.itemName}</a>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <div class="product-images">
                                <div class="product-main-img">
                                    <img src=${nowItem.imgurl} alt="">
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="product-inner">
                                <h2 class="product-name">${sessionScope.nowItem.itemName}</h2>
                                <div class="product-inner-price">
                                    <ins>$${sessionScope.nowItem.price}</ins>
                                </div>

                                <form action="" class="cart" method="post" name="productform">
                                    <div class="quantity">
                                        <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                    </div>
                                    <a><button class="add_to_cart_button" type="submit" onclick="productform.action='addtocart?itemId=${sessionScope.nowItem.itemId}';productform.submit();">加入购物车</button></a>
                                    <a><button class="add_to_cart_button" type="submit" onclick="productform.action='addtowish?itemId=${sessionScope.nowItem.itemId}';productform.submit();">加入心愿单</button></a>
                                </form>

                                <div class="product-inner-category">
                                    <p>Category:
                                        <c:forEach var="categoryname" items="${sessionScope.nowcategoryList}">
                                            <a href="shop?categoryId=${categoryname.categoryId}&nowPag=1">${categoryname.categoryName}</a>
                                        </c:forEach>
                                    </p>
                                </div>

                                <div role="tabpanel">
                                    <ul class="product-tab" role="tablist">
                                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">详情</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade in active" id="home">
                                            <h2>产品描述</h2>
                                            <p>产品名：${sessionScope.nowItem.itemName}</p>
                                            <p>所属类别：
                                                <c:forEach var="categoryname" items="${sessionScope.nowcategoryList}">
                                                    <a href="shop?categoryId=${categoryname.categoryId}&nowPag=1">${categoryname.categoryName}</a>
                                                </c:forEach>
                                            </p>
                                            <p>价格：$${sessionScope.nowItem.price}</p>
                                            <p>库存：${sessionScope.nowItem.itemNumber}</p>
                                            <c:if test="${sessionScope.nowItem.descn!=null}">
                                                <p>产品描述：${sessionScope.nowItem.descn}</p>
                                            </c:if>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>


                    <div class="related-products-wrapper">
                        <h2 class="related-products-title">相关产品</h2>
                        <div class="related-products-carousel">
                            <c:forEach var="nowItemList" items="${sessionScope.nowItemList}">
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src=${nowItemList.imgurl} alt="">
                                    <div class="product-hover">
                                        <a href="addtocart?itemId=${nowItemList.itemId}&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                                        <a href="addtowish?itemId=${nowItemList.itemId}&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                                    </div>
                                </div>

                                <h2><a href="product?itemId=${nowItemList.itemId}">${nowItemList.itemName}</a></h2>

                                <div class="product-carousel-price">
                                    <ins>$${nowItemList.price}</ins>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../common/IncludeButtom.jsp"%>