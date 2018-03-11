<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer-top-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="footer-about-us">
                    <h2><span>绝地求生交易市场</span></h2>
                    <p>《绝地求生大逃杀》为steam平台上的一款热门游戏，用户可在此网站上购买游戏中的饰品。本网站不会以任何形式私聊用户，谨防上当受骗。</p>
                    <p>如果您觉得此网站有用，请向其他用户推荐。</p>
                    <div class="footer-social">
                        <a target="_blank"><i class="fa fa-qq"></i></a>
                        <a target="_blank"><i class="fa fa-wechat"></i></a>
                        <a target="_blank"><i class="fa fa-weibo"></i></a>
                        <a target="_blank"><i class="fa fa-linkedin"></i></a>
                        <a target="_blank"><i class="fa fa-youtube"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">用户导航 </h2>
                    <ul>
                        <c:if test="${sessionScope.loginUser != null}">
                            <li><a href="myaccount">我的帐号</a></li>
                        </c:if>
                        <c:if test="${sessionScope.loginUser == null}">
                            <li><a href="loginform">登录</a></li>
                        </c:if>
                        <li><a href="cart">购物车</a></li>
                        <li><a href="myorder">我的订单</a></li>
                        <li><a href="wish">心愿单</a></li>
                        <li><a href="#">回到顶部</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">分类</h2>
                    <ul>
                        <li><a href="shop?categoryId=1&nowPag=1">帽子</a></li>
                        <li><a href="shop?categoryId=2&nowPag=1">衣服</a></li>
                        <li><a href="shop?categoryId=4&nowPag=1">裤子</a></li>
                        <li><a href="shop?categoryId=5&nowPag=1">鞋子</a></li>
                        <li><a href="shop?categoryId=11&nowPag=1">其他</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-newsletter">
                    <h2 class="footer-wid-title">联系我们</h2>
                    <p>若有任何疑问，可发送邮件到以下地址，获取解答</p>
                    <div class="newsletter-form">
                        <a>735122171@qq.com</a><br>
                        <a>578734284@qq.com</a><br>
                        <a>595724384@qq.com</a><br>
                        <a>1125333801@qq.com</a><br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->



<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>
</body>
</html>