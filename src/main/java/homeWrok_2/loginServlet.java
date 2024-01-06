package homeWrok_2;

import homeWork.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        if("admin".equals(name))
        {
            if ("123".equals(pass))
            {
                User user = new User(name,pass);
                request.getSession().setAttribute("user",user);
                response.sendRedirect("indexServlet");
            }
            else
            {
                request.setAttribute("error","密码错误");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
        else
        {
            request.setAttribute("error","用户名错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
