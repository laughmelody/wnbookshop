package wnbook.servlet;

import org.apache.log4j.Logger;
import wnbook.entity.WnBookAdmin;
import wnbook.service.imp.WnBookAdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class WnBookAdminServlet extends HttpServlet {
    Logger logger;
    private WnBookAdminServiceImp wnBookAdminServiceImp;
    public WnBookAdminServlet(){
        wnBookAdminServiceImp = new WnBookAdminServiceImp();
        logger = Logger.getLogger("wnbook");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookAdminServlet---------->op=" + op);
        if ("showAll".equals(op)){
            showAllByPage(request,response);}
        else if ("doEdit".equals(op)){
            doEdit(request,response);
        }
        else if ("add".equals(op)){
            add(request,response);
        }
        else if ("login".equals(op)){
            login(request,response);
        }
        else if ("checkName".equals(op)){
            checkName(request,response);
        }
        else {
            System.out.println("-----操作符有误-----");
        }

    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("后台登陆用户名和密码:" +username+"------->"+password);
        WnBookAdmin admin = wnBookAdminServiceImp.findAdminByName(username);
        PrintWriter out = response.getWriter();
        if (admin == null){
            out.write("<script>alert('对不起，用户名有误');history.back();</script>");
        }else {
            if (password.equals(admin.getPassword())){
                logger.info(username+",登陆成功");
                //登陆成功
                HttpSession session = request.getSession();
                session.setAttribute("loginAdmin",admin);
                out.write("<script>alert('恭喜，登录成功');location.href='manager?op=toMain'</script>");
            }else {
                out.write("<script>alert('对不起，密码有误');history.back();</script>");
            }
        }
    }



    //ajax重名验证
    private void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String name = request.getParameter("name");
//    System.out.println("要检测的用户名：" + name);
//    WnBookAdmin admin = wnBookAdminServiceImp.findAdminByName(name);
//    PrintWriter out = response.getWriter();
//    if (admin==null){
//        out.print("可以使用");
//    }else {
//        out.print("重名");
//    }
    }


    protected void showAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
//        Page<WnBookAdmin> page = wnBookAdminServiceImp.findadminByPage(new Page<>(currentPage,pageSize));
//        request.setAttribute("page",page);
//        //数据存在request里，要用服务器内部跳转到另一个页面
//        request.getRequestDispatcher("showAllAdmin.jsp").forward(request,response);
    }




   protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt((request.getParameter("id")).trim());
//        int currentPage = Integer.parseInt((request.getParameter("currentPage")).trim());
//        String adminName = request.getParameter("adminName");
//        String password = request.getParameter("password");
//        int i = wnBookAdminServiceImp.modifyAdminById(new WnBookAdmin(id,adminName,password));
//        PrintWriter out = response.getWriter();
//        if(i == 1){
//            out.write("<script>alert('恭喜,修改成功!'); location.href='admin?op=showAll&currentPage="+currentPage+"&pageSize=5';</script>");
//        }else{
//            out.write("<script>alert('对不起，修改失败!');history.back();</script>");
//        }
    }

    //新增一个用户
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String adminname = request.getParameter("adminname");
//        String password = request.getParameter("password");
//
//        int i = wnBookAdminServiceImp.addAdmin(new WnBookAdmin(adminname,password));
//        PrintWriter out = response.getWriter();
//        if(i == 1){
//            out.write("<script>alert('恭喜,新增成功!');location.href='login.jsp';</script>");
//        }else{
//            out.write("<script>alert('对不起，新增失败!');history.back();</script>");
//        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
