package homeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if ("admin".equals(name)) {
            if ("123".equals(password)){

                    User user = new User(name,password);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    session.setMaxInactiveInterval(10);
                    resp.sendRedirect("LoginServlet");
                    return;
            }
            else {
                req.setAttribute("error","密码错误");
            }
        }
        else {
            req.setAttribute("error","用户名错误");
        }
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }





}