package wnbook.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import wnbook.entity.WnBook;
import wnbook.entity.WnBookCategory;

import wnbook.service.imp.WnBookCategoryServiceImp;
import wnbook.util.BootstrapPage;
import com.github.pagehelper.Page;
import wnbook.util.DateUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet("/cate")
public class WnBookCategoryServlet extends HttpServlet {

    private WnBookCategoryServiceImp wnBookCategoryServiceImp;
    public WnBookCategoryServlet(){
        wnBookCategoryServiceImp = new WnBookCategoryServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookcategoryServlet:op=" + op);
        if ("showAl".equals(op)) {
            showAl(request, response);
        }else if ("showAll".equals(op)){
            showAll(request,response);
        }
        else if ("doAdd".equals(op)){
            doAdd(request,response);
        }else if ("del".equals(op)){
            del(request,response);
        }else if ("doEdit".equals(op)){
            doEdit(request,response);
        } else if ("readyEdit".equals(op)){
            readyEdit(request,response);
        }   else {
            System.out.println("-----操作符有误-----");
        }

    }

    protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<WnBookCategory> list = wnBookCategoryServiceImp.selectAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }



    protected void readyEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"------------");
        WnBookCategory category = wnBookCategoryServiceImp.findCategoryById(id);
        System.out.println(category+"---------");
        JSONObject json = JSONObject.fromObject(category);
        response.getWriter().print(json);
    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            int id = Integer.parseInt(request.getParameter("id"));
//            System.out.println(id+"-------------");
            String typeName = request.getParameter("typeName");
//            System.out.println(id+"----->"+typeName);
            WnBookCategory category = new WnBookCategory(typeName);
            System.out.println("====>"+category);
            int i = wnBookCategoryServiceImp.addCategory(category);
            if (i>0){
                response.getWriter().print("ok");
            }else {
                response.getWriter().print("no");
            }
    }
    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"-------------");
        String typeName = request.getParameter("typeName");
        System.out.println(id+"----->"+typeName);
        WnBookCategory category = new WnBookCategory(id,typeName);
        System.out.println("====>"+category);
        int i = wnBookCategoryServiceImp.modifyCategory(category);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = wnBookCategoryServiceImp.removeWnBookCategoryById(id);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }



    //得到所有的目录
    protected void showAl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("offset"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println("pageSize"+limit);
        Page<WnBookCategory> page = wnBookCategoryServiceImp.findAllCategory(offset,limit);
        //把我们自己的page转换成bootstrap-table 认识的格式
        BootstrapPage<WnBookCategory> bootPage = new BootstrapPage<>();
        bootPage.setRows(page.getResult());
        bootPage.setTotal((int) page.getTotal());
        JSONObject json = JSONObject.fromObject(bootPage);
        response.getWriter().print(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
