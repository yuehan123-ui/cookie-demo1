package com.example.cookie_demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cookiedemo1", value = "/cookiedemo1")
public class cookiedemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie  = new Cookie("username","zhangsan");
        cookie.setMaxAge(60*60);//      设置cookie存活时间 （秒）
        response.addCookie(cookie);

        /**
         * cookie 不能直接存储中文 需要先进行url解码 再解码
         *  String value = “张三”;
         *  value = URLEncoder.encode(value,"UTF-8");
         *  Cookie cookie  = new Cookie("username",value);
         *
         *  解码： value = URLDecoder.decode(value,"UTF-8");
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
