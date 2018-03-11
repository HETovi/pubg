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
                            <li><a href="adminmyaccount"><i class="fa fa-user"></i>我的帐号</a></li>
                        </c:if>
                        <c:if test="${sessionScope.loginUser == null}">
                            <li><a href="loginform"><i class="fa fa-user"></i> 登录</a></li>
                        </c:if>
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
                    <h1><a href="adminmain"><span>PUBG市场</span></a></h1>
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
                    <li class="active"><a href="adminmain">主页</a></li>
                    <li><a href="checkuser?nowPage=1">查看用户</a></li>
                    <li><a href="checkitem?itemPage=1">查看物品</a></li>
                    <li><a href="additems">添加物品</a></li>
                    <li><a href="adminsearchorders">查看订单</a></li>
                </ul>
            </div>
        </div>
    </div>
</div> <!-- End mainmenu area -->


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <form method="post" action="updatecart">
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
                                <c:forEach var="orderDetails" items="${sessionScope.serchOrder.orderDetails}">
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
                                        <a>订单编号：${sessionScope.serchOrder.orderId}</a><br>
                                        <a>订单用户：${sessionScope.serchOrder.nickName}</a><br>
                                        <a>订单状态:${sessionScope.serchOrder.status}</a><br>
                                        <a>电话号码:${sessionScope.serchOrder.telephone}</a><br>
                                        <a>邮政编码：${sessionScope.serchOrder.postCode}</a><br>
                                        <a>地    址:${sessionScope.serchOrder.postPlace}</a><br>
                                        <a>订单时间:${sessionScope.serchOrder.time}</a><br>

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
