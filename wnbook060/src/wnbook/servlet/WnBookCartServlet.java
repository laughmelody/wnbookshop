package wnbook.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wnbook.entity.CartQueryVo;
import wnbook.entity.WnBookCart;
import wnbook.entity.WnBookUser;
import wnbook.service.imp.WnBookCartServiceImp;
import wnbook.util.IDTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/cart")
public class WnBookCartServlet extends HttpServlet {
    private WnBookCartServiceImp wnBookCartServiceImp;
    public WnBookCartServlet(){
        wnBookCartServiceImp = new WnBookCartServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookCartServlet:op=" + op);
        if ("addToCart".equals(op)){
            addToCart(request,response);}
        else if ("findByUid".equals(op)){
            findByUid(request,response);
        }
        else if ("findByIds".equals(op)){
            findByIds(request,response);
        }
        else if ("findCartCount".equals(op)){
            findCartCount(request,response);
        }
        else if ("delByIds".equals(op)){
            delByIds(request,response);
        }
        else {
            System.out.println("-----操作符有误-----");
        }

    }

    protected void delByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
         wnBookCartServiceImp.removeCartById(id);

        request.getRequestDispatcher("order.jsp").forward(request,response);
    }


    //根据ids查询购物车数据
    protected void findByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("id");
        List<CartQueryVo> list = wnBookCartServiceImp.findCartsByIds(ids);
        request.setAttribute("list",list);
        request.setAttribute("ids",ids);
        request.getRequestDispatcher("./order?op=addOrder").forward(request,response);
    }




    //购物车
    protected void findCartCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WnBookUser loginUser = (WnBookUser) request.getSession().getAttribute("loginUser");
        int uid = loginUser.getId();
        int i = wnBookCartServiceImp.findCartCount(uid);
        System.out.println("--------->"+i);

        response.getWriter().print(i);
    }


    //新增数据到购物车
    protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WnBookUser loginUser = (WnBookUser) request.getSession().getAttribute("loginUser");
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int buyCount = Integer.parseInt(request.getParameter("buyCount"));

        int i = wnBookCartServiceImp.addBookCart(new WnBookCart(loginUser.getId(),bookId,buyCount));
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("failed");
        }
    }
    //查找当前用户的购物车数据
    protected void findByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WnBookUser loginUser = (WnBookUser) request.getSession().getAttribute("loginUser");
        Integer uid = loginUser.getId();
        List<CartQueryVo> list = wnBookCartServiceImp.findCartQueryVoByUid(uid);
        request.setAttribute("list",list);
        request.getRequestDispatcher("cart.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
