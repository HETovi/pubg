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
    <link rel="stylesheet" type="text/css" href="stylesheet.css"/>

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


<div id="header1"><h1>用户个人基本信息</h1></div>
<form action="edit">
<div id="wrapper1">
    <div id="inputs1">
            昵&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp称:<input type="text" name="nickName" value="${sessionScope.loginUser.nickName}" readonly><br>
            真实姓名:<input type="text" name="realName" value="${sessionScope.loginUser.realName}"><br>
            身份证号:<input type="text" name="identity" value="${sessionScope.loginUser.identity}"><br>
            电子邮箱:<input type="text" name="email" value="${sessionScope.loginUser.email}"><br>
    </div>
</div>
<div id="header2"><h1>用户收货地址信息</h1></div>
<div id="wrapper2">
    <div id="inputs2">
        <c:if test="${sessionScope.isAddressnull==0}">
            用户存储地址码：<input type="hidden" name="addressId" value=""> <br/>
            邮编号码: <input type="text" name="postCode" placeholder="输入邮编号码"><br/>
            邮编地址: <input type="text" name="postPlace" placeholder="输入邮编地址"><br/>
            手机号码: <input type="text" name="telephone" placeholder="输入手机号码"><br/>
        </c:if>
        <c:forEach var="address" items="${sessionScope.addressList}">
            用户存储地址码：<input type="hidden" name="addressId" value=${address.userAddressId} ><br/>
            邮编号码: <input type="text" name="postCode" value=${address.postCode}><br/>
            邮编地址: <input type="text" name="postPlace" value=${address.postPlace}><br/>
            手机号码: <input type="text" name="telephone" value=${address.telephone}><br/>
        </c:forEach>
        <input type="submit" value="修改并保存">
        <a href="password"><input type="button" value="修改密码" /></a>
    </div>
</div>
    <div>
        <c:if test="${requestScope.loginMsg!=null}">
            <font color="red">${requestScope.loginMsg}</font>
        </c:if>
    </div>
</form>



<%@ include file="../common/IncludeButtom.jsp"%>