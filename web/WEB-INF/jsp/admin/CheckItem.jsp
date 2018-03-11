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
    <link href="http://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">

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
                        <table cellspacing="0" class="shop_table cart">
                            <thead>
                            <tr>
                                <th class="product-remove">编号</th>
                                <th class="product-thumbnail">商品名字</th>
                                <th class="product-price">商品价格</th>
                                <th class="product-price">商品描述</th>
                                <th class="product-quantity">库存</th>
                                <th class="product-subtotal">图片</th>
                                <th class="product-subtotal">修改操作</th>
                                <th class="product-subtotal">删除操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach  var="itemInfo" items="${sessionScope.itemList}">
                                <tr class="cart_item">

                                    <td class="product-name">
                                        <a>${itemInfo.itemId}</a>
                                    </td>
                                    <td class="product-name">
                                        <a>${itemInfo.itemName}</a>
                                    </td>
                                    <td class="product-name">
                                        <a>${itemInfo.price}</a>
                                    </td>
                                    <td class="product-name">
                                        <a>${itemInfo.descn}</a>
                                    </td>
                                    <td class="product-name">
                                        <a>${itemInfo.itemNumber}</a>
                                    </td>
                                    <td class="product-thumbnail">
                                        <a href="#"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${itemInfo.imgurl}"></a>
                                    </td>
                                    <td class="product-name"><a href="modifyitem?itemId=${itemInfo.itemId}">修改物品</a></td>
                                    <td class="product-name"><a href="admindeleteitem?itemId=${itemInfo.itemId}&itemPage=${sessionScope.itemPage}">删除物品</a></td>

                                </tr>
                            </c:forEach>
                            <tr><td class="product-name" colspan="8">
                                <a href="checkitem?itemPage=1">首页</a>

                                <c:if test="${sessionScope.itemPage!=1}">
                                    <a href="checkitem?itemPage=${sessionScope.itemPage-1}">上一页</a>
                                </c:if>

                                <a>现在${sessionScope.itemPage}页/共${sessionScope.itemPageNumber}页</a>

                                <c:if test="${sessionScope.itemPage!=sessionScope.itemPageNumber}">
                                    <a href="checkitem?itemPage=${sessionScope.itemPage+1}">下一页</a>
                                </c:if>


                                <a href="checkitem?itemPage=${sessionScope.itemPageNumber}">尾页</a>
                            </td>
                            </tr>
                            <c:if test="${requestScope.loginMsg!=null}">
                            <tr>
                                <td colspan="8">
                                    <font color="red">${requestScope.loginMsg}&nbsp</font>
                                </td>
                            </tr>
                            </c:if>
                            </tbody>
                        </table>


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<%@ include file="../common/IncludeButtom.jsp"%>

