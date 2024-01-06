package homeWork_3;

import homeWork.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");

        RegisterBean bean = new RegisterBean();
        bean.setName(name);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setPassword2(password2);

        boolean isValid = bean.isValid();
        if (!isValid){
            request.setAttribute("bean",bean);
            request.getRequestDispatcher("tiao.jsp").forward(request,response);
        }

        UserBean user = new UserBean();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        boolean insert = DBUtil.getInstance().insertUser(user);//插入数据库



        request.setAttribute("user",user);// 左边是名字 右边是值
        if (!insert){//插入失败 返回原页面
            request.setAttribute("DBError","注册失败 用户已存在");// 左边是名字 右边是值
            request.getRequestDispatcher("tiao.jsp").forward(request,response);
            return;//强制结束 不进行下面的代码
        }
        request.setAttribute("user",user);
        //成功

        request.getRequestDispatcher("success.jsp").forward(request,response);

    }
}
