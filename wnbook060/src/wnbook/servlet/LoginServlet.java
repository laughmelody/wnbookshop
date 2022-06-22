package wnbook.servlet;

import wnbook.entity.WnBookUser;
import wnbook.service.imp.WnBookLoginServiceImp;
import wnbook.service.imp.WnBookUserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    WnBookLoginServiceImp wnBookLoginServiceImp;
    public LoginServlet(){
        wnBookLoginServiceImp = new WnBookLoginServiceImp();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.得到页面上的用户名和密码
        // 2.根据用户名和密码去数据库查找，得到结果
        // 3.根据结果，决定返回的页面或信息
        System.out.println("login-servlet");
        //处理乱码
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        String op = request.getParameter("op");
        System.out.println("LoginServlet:op=" + op);
        if ("login".equals(op)){
            login(request,response);
        }else if ("loginOut".equals(op)){
            loginOut(request,response);
        }else {
            System.out.println("-----操作符有误-----");
        }
    }
    protected void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName + password);
        //根据用户名和密码去数据库查找，得到结果
        int i = wnBookLoginServiceImp.findUserBylogin(new WnBookUser(userName,password));
        //访问相应的service，再得到结果
        PrintWriter out = response.getWriter();
        //根据结果返回信息
        if(i == 1){
            //登录成功后，把用户名保存起来
            //request和session都是域对象
            HttpSession session = request.getSession();
            session.setAttribute("loginName",userName);
            String lastTime =null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie:cookies){
                if ("JSESSIONID".equals(cookie.getName())){
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                }else if ("lastTime".equals(cookie.getName())){
                    //这个就是存上次时间的cookie
                    lastTime=cookie.getValue();
                    //得到上次登录时间后，吧它放到session里
                    session.setAttribute("lastTime",new Date(Long.parseLong(lastTime)));
                    //设置当前这一次的登陆时间,long类型
                    cookie.setValue(new Date().getTime()+"");
                    //存上次登陆时间的cookie还是设置过期时间
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                }
            }
            //如果执行到这里，lasttime还是null，说明没有执行到
            if (lastTime== null){
                Cookie cookie = new Cookie("lastTime",new Date().getTime()+"");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }

            out.write("<script>alert('恭喜,登录成功!'); location.href='main.jsp';</script>");
        }else if(i == 0){
            out.write("<script>alert('对不起，密码错误!');history.back();</script>");
        }else if (i<0){
            out.write("<script>alert('对不起，用户名错误');history.back();</script>");
        }
    }
    protected void loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginName");
        //使用响应对象，重定向-生成新的请求和响应
        response.sendRedirect("index.jsp");
    }
}
