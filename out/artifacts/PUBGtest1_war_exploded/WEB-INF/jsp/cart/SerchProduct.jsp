<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <c:forEach var="iteminfo" items="${sessionScope.itemList}">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src=${iteminfo.imgurl} alt="">
                        </div>
                        <h2><a href="product?itemId=${iteminfo.itemId}">${iteminfo.itemName}</a></h2>
                        <div class="product-carousel-price">
                            <ins>$${iteminfo.price}</ins>
                        </div>

                        <div class="product-option-shop">
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="addtocart?itemId=${iteminfo.itemId}&quantity=1">加入购物车</a>
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="">加入心愿单</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="product-pagination text-center">
                    <nav>
                        <ul class="pagination">
                            <li>
                                <a  aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="serchproduct?serchname=${sessionScope.serchname}&nowPag=1">首页</a></li>
                            <c:if test="${sessionScope.nowPag!=1}">
                                <li><a href="serchproduct?serchname=${sessionScope.serchname}&nowPag=${sessionScope.nowPag-1}">上一页</a></li>
                            </c:if>
                            <li><a>当前页：${sessionScope.nowPag}/${sessionScope.allPag}</a></li>
                            <c:if test="${sessionScope.nowPag!=sessionScope.allPag}">
                                <li><a href="serchproduct?serchname=${sessionScope.serchname}&nowPag=${sessionScope.nowPag+1}">下一页</a></li>
                            </c:if>
                            <li><a href="serchproduct?serchname=${sessionScope.serchname}&nowPag=${sessionScope.allPag}">尾页</a></li>
                            <li>
                                <a  aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../common/IncludeButtom.jsp"%>
