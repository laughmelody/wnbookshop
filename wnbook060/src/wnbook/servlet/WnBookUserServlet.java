package wnbook.servlet;

import com.github.pagehelper.Page;
import net.sf.json.JSONObject;

import wnbook.entity.WnBookUser;
import wnbook.service.imp.WnBookUserServiceImp;
import wnbook.util.BootstrapPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class WnBookUserServlet extends HttpServlet {
    private WnBookUserServiceImp wnBookUserServiceImp;
    public WnBookUserServlet(){
        wnBookUserServiceImp = new WnBookUserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookUserServlet:op=" + op);
        if ("doAdd".equals(op)){
            doAdd(request,response);}
        else if ("del".equals(op)){
            del(request,response);
        }
        else if ("doEdit".equals(op)){
            doEdit(request,response);
        }
        else if ("readyEdit".equals(op)){
            readyEdit(request,response);
        }
        else if ("showAll".equals(op)){
            showAll(request,response);
        }
        else if ("doEditImg".equals(op)){
            doEditImg(request,response);
        }
        else if ("readyCenterEdit".equals(op)){
            readyCenterEdit(request,response);
        }
        else if ("doLogin".equals(op)){
            doLogin(request,response);
        }
        else if ("centerEdit".equals(op)){
            centerEdit(request,response);
        }
        else {
            System.out.println("-----操作符有误-----");
        }

    }
    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username =request.getParameter("username");
       String password = request.getParameter("password");
       WnBookUser user = wnBookUserServiceImp.findUserByName(username);
       PrintWriter out = response.getWriter();
       if (user!=null){
           if (user.getPassword().equals(password)){
               request.getSession().setAttribute("loginUser",user);
               out.write("<script>alert('恭喜，登录成功');location.href='"+request.getContextPath()+"/index.jsp'</script>");
           }else {
               out.write("<script>alert('对不起，密码错误');history.back();</script>");
           }
       }else {
           out.write("<script>alert('对不起，用户名错误');history.back();</script>");
       }

    }
    protected void centerEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = (request.getParameter("username"));
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        System.out.println(id+"---------"+password+"----------"+tel);
        int i = wnBookUserServiceImp.modifyCenter(new WnBookUser(id,username,password,tel));
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("failed");
        }

    }
    protected void readyCenterEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"------------");
        WnBookUser user = wnBookUserServiceImp.findWnBookUserById(id);
//        WnBookUser user = wnBookUserServiceImp.findUserByName(username);
        JSONObject json = JSONObject.fromObject(user);
        response.getWriter().print(json);

    }




    protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("offset"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println("pageSize"+limit);
        Page<WnBookUser> page = wnBookUserServiceImp.findAllUser(offset,limit);
        //把我们自己的page转换成bootstrap-table 认识的格式
        BootstrapPage<WnBookUser> bootPage = new BootstrapPage<>();
        bootPage.setRows(page.getResult());
        bootPage.setTotal((int) page.getTotal());
        JSONObject json = JSONObject.fromObject(bootPage);
        response.getWriter().print(json);

    }

    //头像选择
    protected void doEditImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String imgPath = request.getParameter("address");
        System.out.println(id+"--->"+imgPath);
        //把得到的参数封装成对象
        WnBookUser user = new WnBookUser();
        user.setAvatar(imgPath);
        user.setId(id);
        int i = wnBookUserServiceImp.modifyWnBookUserImg(user);
        PrintWriter out = response.getWriter();
        if (i>0){
            //修改了投降后，session里存的loginuser要换成新的
            WnBookUser u = wnBookUserServiceImp.findWnBookUserById(id);
            request.getSession().setAttribute("loginUser",user);
            out.write("<script>alert('修改成功！');location.href='center.jsp'</script>");
        }else {
            out.write("<script>alert('对不起！修改失败');history.back()</script>");
        }
    }

    //增

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        WnBookUser user = new WnBookUser(username,password);
        System.out.println("=======>"+user);
        int i = wnBookUserServiceImp.addUser(user);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }
    //删

    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = wnBookUserServiceImp.removeWnBookUserById(id);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("failed");
        }

    }


    //ajax显示所有用户
    protected void readyEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"------------");
        WnBookUser user = wnBookUserServiceImp.findWnBookUserById(id);
        System.out.println(user+"---------");
        JSONObject json = JSONObject.fromObject(user);
        response.getWriter().print(json);

    }






    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt((request.getParameter("id")));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int i = wnBookUserServiceImp.modifyUser(new WnBookUser(id,username,password));
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("failed");
        }

    }













    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
