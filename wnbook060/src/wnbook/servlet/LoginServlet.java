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
        // 1.�õ�ҳ���ϵ��û���������
        // 2.�����û���������ȥ���ݿ���ң��õ����
        // 3.���ݽ�����������ص�ҳ�����Ϣ
        System.out.println("login-servlet");
        //��������
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
            System.out.println("-----����������-----");
        }
    }
    protected void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName + password);
        //�����û���������ȥ���ݿ���ң��õ����
        int i = wnBookLoginServiceImp.findUserBylogin(new WnBookUser(userName,password));
        //������Ӧ��service���ٵõ����
        PrintWriter out = response.getWriter();
        //���ݽ��������Ϣ
        if(i == 1){
            //��¼�ɹ��󣬰��û�����������
            //request��session���������
            HttpSession session = request.getSession();
            session.setAttribute("loginName",userName);
            String lastTime =null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie:cookies){
                if ("JSESSIONID".equals(cookie.getName())){
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                }else if ("lastTime".equals(cookie.getName())){
                    //������Ǵ��ϴ�ʱ���cookie
                    lastTime=cookie.getValue();
                    //�õ��ϴε�¼ʱ��󣬰����ŵ�session��
                    session.setAttribute("lastTime",new Date(Long.parseLong(lastTime)));
                    //���õ�ǰ��һ�εĵ�½ʱ��,long����
                    cookie.setValue(new Date().getTime()+"");
                    //���ϴε�½ʱ���cookie�������ù���ʱ��
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                }
            }
            //���ִ�е����lasttime����null��˵��û��ִ�е�
            if (lastTime== null){
                Cookie cookie = new Cookie("lastTime",new Date().getTime()+"");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }

            out.write("<script>alert('��ϲ,��¼�ɹ�!'); location.href='main.jsp';</script>");
        }else if(i == 0){
            out.write("<script>alert('�Բ����������!');history.back();</script>");
        }else if (i<0){
            out.write("<script>alert('�Բ����û�������');history.back();</script>");
        }
    }
    protected void loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginName");
        //ʹ����Ӧ�����ض���-�����µ��������Ӧ
        response.sendRedirect("index.jsp");
    }
}
