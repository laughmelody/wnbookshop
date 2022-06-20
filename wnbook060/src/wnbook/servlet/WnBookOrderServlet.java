package wnbook.servlet;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import wnbook.entity.*;
import wnbook.mapper.WnBookMapper;
import wnbook.mapper.WnBookOrderMapper;
import wnbook.service.imp.WnBookAddressServiceImp;
import wnbook.service.imp.WnBookCategoryServiceImp;
import wnbook.service.imp.WnBookOrderServiceImp;
import wnbook.service.imp.WnBookServiceImp;
import wnbook.util.BootstrapPage;
import wnbook.util.DateUtil;
import wnbook.util.IDTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@WebServlet("/order")
public class WnBookOrderServlet extends HttpServlet {
    private WnBookOrderServiceImp wnBookOrderServiceImp;
    private WnBookAddressServiceImp wnBookAddressServiceImp;

    public WnBookOrderServlet(){
        wnBookOrderServiceImp = new WnBookOrderServiceImp();
        wnBookAddressServiceImp = new WnBookAddressServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookOrderServlet:op=" + op);
        if ("addOrder".equals(op)){
            addOrder(request,response);
        }
        else if ("editAddress".equals(op)){
            editAddress(request,response);
        }
        else if ("pay".equals(op)){
            pay(request,response);
        }
        else if ("noPay".equals(op)){
            noPay(request,response);
        }
        else {
            System.out.println("-----操作符有误-----");
        }

    }
    //添加订单
    protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderNum = IDTools.getId();
        WnBookUser loginUser = (WnBookUser) request.getSession().getAttribute("loginUser");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        int addressId = wnBookAddressServiceImp.findDefaultByUid(loginUser.getId());
        //得到订单对象
        WnBookOrder order =new WnBookOrder(orderNum, loginUser.getId(), addressId,totalPrice);
        //先得到多个购物车提交过来的记录id，因为可能有多个id，所以使用request.getParameterValues
        String[] ids = request.getParameterValues("id");
        int i = wnBookOrderServiceImp.addOrder(order,ids);
        System.out.println("订单增加后的结果:"+i);
        if (i>0){
            System.out.println("成功");
            //成功后，根据刚下好单的id，把订单信息显示在订单页面
            OrderQueryVo orderQueryVo = wnBookOrderServiceImp.findOrderById(order.getId());
            request.setAttribute("order",orderQueryVo);
            //还有收货地址，可以再次选择
            List<WnBookAddress> list = wnBookAddressServiceImp.findAddressByUserId(loginUser.getId());
            request.setAttribute("order",orderQueryVo);
            request.setAttribute("list",list);
            request.getRequestDispatcher("order.jsp").forward(request,response);
        }else {
            System.out.println("失败");
        }
    }
    protected void noPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        WnBookUser loginUser = (WnBookUser) request.getSession().getAttribute("loginUser");
//        WnBookOrder userId = wnBookOrderServiceImp.findOrderByUserId(loginUser.getId());
//        String orderNum = request.getParameter("orderNum");
//        int status = request.getParameter("status");
//        WnBookOrder order =new WnBookOrder(orderNum,userId,status)；
    }

    //修改收货地址
    protected void editAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }





    //支付
    protected void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
