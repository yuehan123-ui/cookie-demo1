package com.example.cookie_demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cookiedemo2", value = "/cookiedemo2")
public class cookiedemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Cookie [] cookies = request.getCookies();
        String lastTime  = "";
        if (null!=cookies){
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())){
                    lastTime = cookie.getValue();
                }
            }
        }
        String text = "欢迎登陆";
        if (!"".equals(lastTime)){
            lastTime = URLDecoder.decode(lastTime,"UTF-8");
            text = "欢迎登录 您上一次访问时间为："+lastTime;
        }
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastTimes = format.format(date);
        lastTimes = URLEncoder.encode(lastTimes,"UTF-8");
        Cookie cookie = new Cookie("lastTime",lastTimes);

        response.addCookie(cookie);
        response.getWriter().print(text);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
