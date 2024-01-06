package homeWrok_2;

import homeWork.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User User = (User) session.getAttribute("user");
        if (User == null){
            response.getWriter().println("你还没有登录，请先<a href='index.jsp'>登录</a>");
        }else {
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            response.addCookie(cookie);
            cookie.setMaxAge(60);
            String returnURL = request.getRequestURI();
            String rootname = CityDB.init();
            request.setAttribute("returnURL",returnURL);
            request.setAttribute("rootname",rootname);
            request.setAttribute("cityname",CityDB.getByName(rootname));
            request.getRequestDispatcher("/WEB-INF/Lg/main.jsp").forward(request,response);
        }
    }
}
