package homeWrok_2;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String returnURL = request.getParameter("returnURL");
        String rootname = request.getParameter("rootname");
        request.setAttribute("returnURL",returnURL);
        request.setAttribute("rootname",rootname);
        request.setAttribute("cityname",CityDB.getByName(rootname));
        request.getRequestDispatcher("/WEB-INF/Lg/getCity.jsp").forward(request,response);


    }
}

