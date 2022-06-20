package wnbook.servlet;

import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSessionFactory;
import wnbook.entity.WnBookAddress;
import wnbook.entity.WnBookUser;
import wnbook.service.imp.WnBookAddressServiceImp;
import wnbook.service.imp.WnBookServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/address")
public class WnBookAddressServlet extends HttpServlet {
    private WnBookAddressServiceImp wnBookAddressServiceImp;
    public WnBookAddressServlet(){
        wnBookAddressServiceImp = new WnBookAddressServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        System.out.println("WnBookAddressServlet---->op="+op);
        if ("add".equals(op)){
            add(request,response);
        }else if ("searchByUserId".equals(op)){
            searchByUserId(request,response);
        }else if ("del".equals(op)){
            del(request,response);
        }else {
            System.out.println("----操作符有误----");
        }
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String receiver = request.getParameter("addreceiver");
        Long tel = Long.valueOf(request.getParameter("addtel"));
        String detailAddress = request.getParameter("address");
        WnBookUser user = (WnBookUser)request.getSession().getAttribute("loginUser");
        int userId = user.getId();
        WnBookAddress add = new WnBookAddress(detailAddress,receiver,tel,userId,0,0,new Date(),new Date(),0);

        System.out.println("lognUser--->"+user.getId());

        System.out.println(add+"------------");
        int i = wnBookAddressServiceImp.addAddress(add);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }



    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }



    protected void searchByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        System.out.println("查询地址的userid:"+userid);

        List<WnBookAddress> list = wnBookAddressServiceImp.findAddressByUserId(userid);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
