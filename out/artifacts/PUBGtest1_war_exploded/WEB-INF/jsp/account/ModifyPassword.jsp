<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="logincontainer">
    <section id="logincontent">
        <form action="userpassword" method="post">
            <h1>修改密码</h1>
            <div>
                <input type="password" placeholder="请输入原密码" required="" id="password" name="oldpassword" />
            </div>
            <div>
                <input type="password" placeholder="请输入新密码" required="" id="password" name="newpassword1"/>
            </div>
            <div>
                <input type="password" placeholder="再次输入新密码" required="" id="password" name="newpassword2"/>
            </div>
            <div>
                <input type="submit"  style="line-height: 15px"  value="修改并保存" />
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
