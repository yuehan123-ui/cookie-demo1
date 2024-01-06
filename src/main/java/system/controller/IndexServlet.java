package system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homeWork.User;

import homeWrok_2.CityDB;

/**
 *  使用session技术
 * 目标：访问主页servlet，如果登陆过，显示登录信息，如果没有登录跳转到登录页面
 *  1、indexServlet判断session 有无用户信息  user
 *      a.有 现在登录用户信息 b. 没有，跳转到登录界面
 *  2、loginServlet 获取登录用户信息，
 *      1、登录成功，保存用户信息到session中
 *      2、登录失败，给出提示信息，重新登录
 * @author wan
 *
 */
@WebServlet(name ="systemIndexServlet",urlPatterns = "/systemIndexServlet" )
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //session 取用户信息
        HttpSession session =  req.getSession();
        User user =  (User) session.getAttribute("user");
        if(null == user) {
            //跳转到登录界面
            resp.sendRedirect("login2.jsp");
        }else {
            //通过cookie 设置session 过期；复写  JSESSIONID 值
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(120);
            resp.addCookie(cookie);
            String page = "/WEB-INF/system/main.jsp";//管理端页面
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }

}