package wnbook.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/manager")
public class    Manager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String op = request.getParameter("op");
        System.out.println("WnBookAdminServlet--------->op="+op);
        if ("toMain".equals(op)){
            toMain(request,response);
        }
        else if ("toWelcome".equals(op)){
            toWelcome(request,response);
        }
        else if ("showCart".equals(op)){
            showCart(request,response);
        }
        else if ("addPage".equals(op)){
            addPage(request,response);
        }
        else if ("showAllCategory".equals(op)){
            showAllCategory(request,response);
        }
        else if ("showUser".equals(op)){
            showUser(request,response);
        }
        else if ("showAllBook".equals(op)){
            showAllBook(request,response);
        }
        else if ("showBookByPage".equals(op)){
            showBookByPage(request,response);
        }
        else{
            request.getRequestDispatcher("WEB-INF/back-login.jsp").forward(request,response);
        }
        //后台管理页面，在web-inf目录下，这个目录只能通过转发访问
//        request.getRequestDispatcher("WEB-INF/back-login.jsp").forward(request,response);
    }
    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/showCart.jsp").forward(request,response);
    }
    protected void showAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/showAllCategory.jsp").forward(request,response);
    }

    protected void addPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/addUser.jsp").forward(request,response);
    }

    protected void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/showBook.jsp").forward(request,response);
    }
    protected void showBookByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/showBookByPage.jsp").forward(request,response);
    }
    protected void toMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/main.jsp").forward(request,response);
    }
    protected void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/showAllUser.jsp").forward(request,response);
    }
    protected void toWelcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }
}
