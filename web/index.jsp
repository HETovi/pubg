<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>绝地求生交易市场</title>

  <!-- Google Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

  <!-- Bootstrap -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/owl.carousel.css">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="css/responsive.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

<div class="header-area">
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="user-menu">
          <ul>
            <c:if test="${sessionScope.loginUser != null}">
            <li><a href="myaccount"><i class="fa fa-user"></i>我的帐号</a></li>
            </c:if>
            <c:if test="${sessionScope.loginUser == null}">
            <li><a href="loginform"><i class="fa fa-user"></i> 登录</a></li>
            </c:if>
            <li><a href="myorder"><i class="fa fa-file-o"></i>我的订单</a></li>
            <li><a href="cart"><i class="fa fa-shopping-cart"></i>购物车</a></li>
            <li><a href="wish"><i class="fa fa-heart"></i> 心愿单</a></li>
            <li><a href="userexit"><i class="fa fa-user"></i> 退出</a></li>
          </ul>
        </div>
      </div>

    </div>
  </div>
</div> <!-- End header area -->

<div class="site-branding-area">
  <div class="container">
    <div class="row">
      <div class="col-sm-6">
        <div class="logo">
          <h1><a href="main"><span>PUBG市场</span></a></h1>
        </div>
      </div>

      <div class="col-sm-6">
        <div class="shopping-item">
          <c:if test="${sessionScope.cartItemNum!=null}">
          <a href="cart">购物车 - <span class="cart-amunt">$${sessionScope.cartItemAllPrice}</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">${sessionScope.cartItemNum}</span></a>
          </c:if>
          <c:if test="${sessionScope.cartItemNum==null}">
            <a href="cart">购物车 - <span class="cart-amunt">$0</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">0</span></a>
          </c:if>
        </div>
      </div>
    </div>
  </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area">
  <div class="container">
    <div class="row">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="main">主页</a></li>
          <li><a href="shop?categoryId=0&nowPag=1">商品总览</a></li>
          <li><a href="product?itemId=1">商品详情</a></li>
          <li><a href="cart">购物车</a></li>
          <li><a href="wish">心愿单</a></li>
          <li><a href="aboutus">关于我们</a></li>
        </ul>
      </div>
    </div>
  </div>
</div> <!-- End mainmenu area -->

<div class="slider-area">
  <div class="zigzag-bottom"></div>
  <div id="slide-list" class="carousel carousel-fade slide" data-ride="carousel">

    <div class="slide-bulletz">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <ol class="carousel-indicators slide-indicators">
              <li data-target="#slide-list" data-slide-to="0" class="active"></li>
              <li data-target="#slide-list" data-slide-to="1"></li>
              <li data-target="#slide-list" data-slide-to="2"></li>
            </ol>
          </div>
        </div>
      </div>
    </div>

    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <div class="single-slide">
          <div class="slide-bg slide-one"></div>
          <div class="slide-text-wrapper">
            <div class="slide-text">
              <div class="container">
                <div class="row">
                  <div class="col-md-6 col-md-offset-6">
                    <div class="slide-content">
                      <h2>声明</h2>
                      <p>《绝地求生大逃杀》为steam平台上的一款热门游戏，用户可在此网站上购买游戏中的饰品。</p>
                      <p>本网站不会以任何形式私聊用户，谨防上当受骗。了解更多游戏内容，请前往官网。</p>
                      <a href="http://www.pubger.com/" class="readmore">前往官网</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="item">
        <div class="single-slide">
          <div class="slide-bg slide-two"></div>
          <div class="slide-text-wrapper">
            <div class="slide-text">
              <div class="container">
                <div class="row">
                  <div class="col-md-6 col-md-offset-6">
                    <div class="slide-content">
                      <h2>聲明</h2>
                      <p>《絕地求生大逃殺》為steam平台上的一款熱門遊戲，用戶可在此網站上購買遊戲中的飾品</p>
                      <p>本網站不會以任何形式私聊用戶，謹防上當受騙。了解更多遊戲內容，請前往官網</p>
                      <a href="" class="readmore">前往官網</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="item">
        <div class="single-slide">
          <div class="slide-bg slide-three"></div>
          <div class="slide-text-wrapper">
            <div class="slide-text">
              <div class="container">
                <div class="row">
                  <div class="col-md-6 col-md-offset-6">
                    <div class="slide-content">
                      <h2>Statement</h2>
                      <p>Playerunknown's Battlegrounds to survive on the steam platform for a popular game, users can buy on this site in the game accessories.</p>
                      <p>This website does not chat any kind of user in any form, beware of being deceived. </p>
                      <a href="" class="readmore">official website</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</div> <!-- End slider area -->
<div class="copyrights"></div>
<div class="promo-area">
  <div class="zigzag-bottom"></div>
  <div class="container">
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="single-promo">
          <i class="fa fa-refresh"></i>
          <p>7天包退</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="single-promo">
          <i class="fa fa-truck"></i>
          <p>包邮</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="single-promo">
          <i class="fa fa-lock"></i>
          <p>支付安全</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="single-promo">
          <i class="fa fa-gift"></i>
          <p>产品新颖</p>
        </div>
      </div>
    </div>
  </div>
</div> <!-- End promo area -->

<div class="maincontent-area">
  <div class="zigzag-bottom"></div>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="latest-product">
          <h2 class="section-title">最新产品</h2>
          <div class="product-carousel">
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/pan17.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=62&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=62&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=62">Pleated Mini-skirt (Blue)</a></h2>

              <div class="product-carousel-price">
                <ins>$28</ins>
              </div>
            </div>
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/clo19.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=25&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=25&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=25">Tracksuit Top</a></h2>
              <div class="product-carousel-price">
                <ins>$16</ins>
              </div>
            </div>
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/pan6.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=51&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=51&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=51">Tracksuit Pants (Yellow)</a></h2>

              <div class="product-carousel-price">
                <ins>$15</ins>
              </div>
            </div>
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/pan20.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=65&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=65&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=65">Pleated Mini-skirt (Black)</a></h2>

              <div class="product-carousel-price">
                <ins>$28</ins>
              </div>
            </div>
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/pan1.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=46&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=46&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=46">Combat Pants (Grey Camo)</a></h2>

              <div class="product-carousel-price">
                <ins>$20</ins>
              </div>
            </div>
            <div class="single-product">
              <div class="product-f-image">
                <img src="img/oth1.png" alt="">
                <div class="product-hover">
                  <a href="addtocart?itemId=100&quantity=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                  <a href="addtowish?itemId=100&quantity=1" class="view-details-link"><i class="fa fa-heart"></i>加入心愿单</a>
                </div>
              </div>

              <h2><a href="product?itemId=100">GAMESCOM KEY</a></h2>

              <div class="product-carousel-price">
                <ins>$5</ins>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div> <!-- End main content area -->





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