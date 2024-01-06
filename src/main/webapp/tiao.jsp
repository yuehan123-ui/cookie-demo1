<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/11/11
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <style type="text/css">
        h3 {
            margin-left: 100px;
        }
        #outer {
            width: 750px;
        }
        span {
            color: #ff0000
        }
        div {
            height:20px;
            margin-bottom: 10px;
        }
        .ch {
            width: 80px;
            text-align: right;
            float: left;
        }
        .ip {
            width: 500px;
            float: left
        }
        .ip>input {
            margin-right: 20px
        }
        #bt {
            margin-left: 50px;
        }
        #bt>input {
            margin-right: 30px;
        }
    </style>
</head>
<body>
<form action="RegisterServlet" method="post">
    <h3>用户注册</h3>
    <div id="outer">
        <div>
            <div class="ch">姓名:</div>
            <div class="ip">
                <input type="text" name="name"  value="${user.name}"/>
                <span>${bean.errors.name}</span>
            </div>
        </div>
        <div>
            <div class="ch">密码:</div>
            <div class="ip">
                <input type="text" name="password" value="${user.password}">
                <span>${bean.errors.password}</span>
            </div>
        </div>
        <div>
            <div class="ch">确认密码:</div>
            <div class="ip">
                <input type="text" name="password2" value="${user.password2}">
                <span>${bean.errors.password2}</span>
            </div>
        </div>
        <div>
            <div class="ch">邮箱:</div>
            <div class="ip">
                <input type="text" name="email" value="${user.email}" > <%--  value : 值--%>
                <span>${bean.errors.email}</span>
            </div>
        </div>
        <div id="bt">
            <input type="reset" value="重置 " />
            <input type="submit" value="注册" />
        </div>
    </div>
</form>
</body>
</html>
