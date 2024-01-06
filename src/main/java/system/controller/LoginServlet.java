package system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homeWork.User;

@WebServlet(name ="systemLoginServlet",urlPatterns = "/systemLoginServlet" )
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req,resp);
    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //模拟登陆
        //规定 用户名为：admin  密码为：123 才能登录成功,其他全部登录失败
        String name =  req.getParameter("name");
        String password = req.getParameter("password");
        String flag = " ";//临时变量 存储登录提示信息
        String page = "login.jsp";
        if("admin".equals(name) ||"zhangsan".equals(name) ) {
            if("123".equals(password)) {
                //登录成功后设置session信息，跳转到主页
                User user = new User(name,password);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("systemIndexServlet");
                return;
            }else {
                req.setAttribute("error", "用户密码错误");
            }
        }else {
            req.setAttribute("error", "用户名错误");
        }
        req.getRequestDispatcher(page).forward(req, resp);

    }
}
