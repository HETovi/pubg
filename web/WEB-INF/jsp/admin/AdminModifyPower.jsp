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

<div class="logincontainer">
    <section id="logincontent">
        <form action="adminmodifypower" method="post">
            <h1>修改基本权限</h1>
            <div>
                昵&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp称:&nbsp&nbsp<input type="text" name="nickName" id="username" value=${sessionScope.ModifyUserInfo.nickName} readonly><br/>
            </div>
            <div>
                真实姓名:&nbsp&nbsp<input type="text" name="realName" id="username" value=${sessionScope.ModifyUserInfo.realName} readonly><br/>
            </div>
            <div>
                身份证号:&nbsp&nbsp<input type="text" name="identity" id="username"  value=${sessionScope.ModifyUserInfo.identity} readonly><br/>
            </div>
            <div>
                电子邮箱:&nbsp&nbsp<input type="text" name="email"id="username"  value=${sessionScope.ModifyUserInfo.email} readonly><br/>
            </div>
            <div> 职&nbsp&nbsp&nbsp&nbsp称：
                <select name="test">
                    <c:forEach var="role" items="${sessionScope.roleList}">

                        <option  <c:if test="${sessionScope.ModifyUserInfo.roleId==role.id}"> selected </c:if>  value=${role.id}>${role.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <input type="submit" value="修改并保存">
            </div>
            <div>
                <c:if test="${requestScope.loginMsg!=null}">
                    <font color="red">${requestScope.loginMsg}</font>
                </c:if>
            </div>
        </form><!-- form -->
    </section><!-- content -->
</div><!-- container -->

<!--
<div id="header1"><h1>修改基本权限</h1></div>
<form action="adminmodifypower">

            昵&nbsp&nbsp&nbsp&nbsp称: <input type="text" name="nickName" value=${sessionScope.ModifyUserInfo.nickName} readonly><br/>
            真实姓名: <input type="text" name="realName" value=${sessionScope.ModifyUserInfo.realName} readonly><br/>
            身份证号: <input type="text" name="identity" value=${sessionScope.ModifyUserInfo.identity} readonly><br/>
            电子邮箱：<input type="text" name="email" value=${sessionScope.ModifyUserInfo.email} readonly><br/>
            职&nbsp&nbsp&nbsp&nbsp称：
            <select name="test">
                <c:forEach var="role" items="${sessionScope.roleList}">

                    <option  <c:if test="${sessionScope.ModifyUserInfo.role.id==role.id}"> selected </c:if>  value=${role.id}>${role.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <input type="submit" value="修改并保存">

    <div>
        <c:if test="${requestScope.loginMsg!=null}">
            <font color="red">${requestScope.loginMsg}</font>
        </c:if>
    </div>
</form>
-->


<%@ include file="../common/IncludeButtom.jsp"%>


