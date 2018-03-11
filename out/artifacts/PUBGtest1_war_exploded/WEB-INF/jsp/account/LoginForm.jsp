<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="logincontainer">
    <section id="logincontent">
        <form action="userlogin" method="post">
            <h1>登录</h1>
            <div>
                <input type="text" placeholder="Username" required="" id="username" name="username" />
            </div>
            <div>
                <input type="password" placeholder="Password" required="" id="password" name="password"/>
            </div>
            <div>
                <input type="submit"  style="line-height: 15px"  value="登录" />
                <a href="zhuce"><input type="button" value="注册" /></a>
            </div>
            <div>
                <c:if test="${requestScope.loginMsg!=null}">
                <font color="red">${requestScope.loginMsg}</font>
                </c:if>
            </div>
        </form><!-- form -->
    </section><!-- content -->
</div><!-- container -->


<%@ include file="../common/IncludeButtom.jsp"%>