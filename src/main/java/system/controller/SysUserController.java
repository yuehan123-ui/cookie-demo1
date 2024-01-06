package system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import system.dao.impl.SysUserDaoImpl;
import system.model.SysUser;


/**
 * 用户控制层
 *
 *
 */
@WebServlet(name ="SysUserController",urlPatterns = "/SysUserController" )
public class SysUserController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //展示用户的列表信息
        SysUserDaoImpl dao = new SysUserDaoImpl();
        List<SysUser> list = dao.getAll();
        System.out.println(list);
        req.setAttribute("userList", list);
        String page = "/WEB-INF/system/sysUserList.jsp";//管理端页面
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
