<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="logincontainer">
    <section id="logincontent">
        <form action="userzhuce" method="post">
            <h1>注册</h1>
            <div>
                <input type="text" placeholder="Username" required="" id="username" name="username" />
            </div>
            <div>
                <input type="password" placeholder="Password" required="" id="password" name="password"/>
            </div>
            <div>
                <input type="text" placeholder="Realname" required="" id="username" name="realname">
            </div>
            <div>
                <input type="text" placeholder="Identity" required="" id="username" name="identity">
            </div>
            <div>
                <input type="text" placeholder="Email" required="" id="username" name="email">
            </div>
            <div>
                <input type="submit"  style="line-height: 15px"  value="注册并返回" />
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
