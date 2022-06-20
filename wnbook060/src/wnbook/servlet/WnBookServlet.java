package wnbook.servlet;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import wnbook.entity.WnBook;
import wnbook.entity.WnBookCategory;
import wnbook.mapper.WnBookMapper;
import wnbook.service.imp.WnBookCategoryServiceImp;
import wnbook.service.imp.WnBookServiceImp;
import wnbook.util.BootstrapPage;
import wnbook.util.DateUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

import java.util.Date;

import java.util.List;

@WebServlet("/book")
public class WnBookServlet extends HttpServlet {
    SqlSession sqlSession;
    WnBookMapper mapper;
    @Before
    public void before() {
        // 加载配置文件
        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private WnBookServiceImp wnBookServiceImp;
    private WnBookCategoryServiceImp wnBookCategoryServiceImp;
    public WnBookServlet(){
        wnBookServiceImp = new WnBookServiceImp();
        wnBookCategoryServiceImp = new WnBookCategoryServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面上传一个操作符，告诉servlet执行哪个文件
        String op = request.getParameter("op");
        System.out.println("WnBookServlet:op=" + op);
        if ("showAll".equals(op)){
            showAll(request,response);
        }
        else if ("readyEdit".equals(op)){
            readyEdit(request,response);
        }
        else if ("findById".equals(op)){
            findById(request,response);
        }
        else if ("del".equals(op)){
            del(request,response);
        }
        else if ("showByPage".equals(op)){
            showByPage(request,response);
        }
        else if ("doEdit".equals(op)){
            doEdit(request,response);
        }
        else if ("doAdd".equals(op)){
            doAdd(request,response);
        }
        //前台搜索功能
        else if ("doSearch".equals(op)){
            doSearch(request,response);
        }
        else if ("readyAdd".equals(op)){
            readyAdd(request,response);
        }
        else if ("checkName".equals(op)){
            checkName(request,response);
        }
        else if ("indexBook".equals(op)){
            indexBook(request,response);
        }

        else {
            System.out.println("-----操作符有误-----");
        }

    }
    //根据id找书籍
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       WnBook book = wnBookServiceImp.findBookById(id);
       request.setAttribute("book",book);
       request.getRequestDispatcher("book-detail.jsp").forward(request,response);

    }




    //一开始就要显示的数据:好书热卖，新书推荐，收藏最多
    protected void indexBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<WnBook> booksByHotSale =  wnBookServiceImp.findBooksByHotSale();
        List<WnBook> booksByNewDate = wnBookServiceImp.findBooksByNewDate();
        List<WnBook> booksByCollection= wnBookServiceImp.findBooksByCollection();
        Object[] arr = {booksByHotSale,booksByNewDate,booksByCollection};
        JSONArray jsonArray = JSONArray.fromObject(arr);
        response.getWriter().print(jsonArray);
    }

    protected void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        WnBook book = new WnBook();
        book.setBookName(bookName);
        Page<WnBook> page = wnBookServiceImp.findBookByCondition(book,0,8);
        PageInfo<WnBook> pageInfo = page.toPageInfo();
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("showSearch.jsp").forward(request,response);
    }


    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = wnBookServiceImp.removeBookById(id);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }
    protected void readyAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        WnBook book = wnBookServiceImp.findBookById(id);

        JSONObject json = JSONObject.fromObject(book);
        response.getWriter().print(json);
    }
    protected void readyEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"------------");
        WnBook book = wnBookServiceImp.findBookById(id);
        System.out.println(book+"---------");
        JSONObject json = JSONObject.fromObject(book);
        response.getWriter().print(json);
    }
    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));
        System.out.println(id+"-------------");
        String bookName = request.getParameter("bookName");
        System.out.println(id+"----->"+bookName);
        String bookImage = request.getParameter("bookImage");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPublish =request.getParameter("bookPublish");
        String time = request.getParameter("bookPublishDate");
        Date bookPublishDate = DateUtil.stringToDate(time,"yyyy-MM-dd HH:mm:ss");
        Double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int bookStoreCount = Integer.parseInt(request.getParameter("bookStoreCount"));
        WnBook book = new WnBook(id,bookName,bookImage,bookAuthor,bookPublish,bookPublishDate,
                bookPrice,new WnBookCategory(categoryId),null,bookStoreCount,
                null,null, 1,null,new Date(),true);
        System.out.println("====>"+book);
        int i = wnBookServiceImp.modifyBook(book);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }

    protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<WnBook> list = wnBookServiceImp.findAllBooks();
        for (WnBook book : list){
            System.out.println(book);
        }
        JSONArray jsonArr = JSONArray.fromObject(list);
        response.getWriter().print(jsonArr);
    }
    //新增一个用户
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
//        System.out.println(id+"----->"+bookName);
        String bookImage = request.getParameter("bookImage");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPublish =request.getParameter("bookPublish");
        String time = request.getParameter("bookPublishDate");
        Date bookPublishDate = DateUtil.stringToDate(time,"yyyy-MM-dd HH:mm:ss");
        Double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int bookStoreCount = Integer.parseInt(request.getParameter("bookStoreCount"));
        WnBook book = new WnBook(bookName,bookImage,bookAuthor,bookPublish,bookPublishDate,
                bookPrice,new WnBookCategory(categoryId),null,bookStoreCount,
                null,null, 1,null,new Date(),true);
        System.out.println("====>"+book);
        int i = wnBookServiceImp.addBook(book);
        if (i>0){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }
    }
    protected void showByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("offset"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println("offset"+offset+"------------> limit:"+limit);
        WnBook book = new WnBook();
        String bookName = request.getParameter("bookName");
        //默认为空 不为空时是输入框中得到的数据
        String temp = request.getParameter("bookPrice");
        double bookPrice = 0;
        if (temp != null && !"".equals(temp)){
            bookPrice = Double.parseDouble(temp);
        }
        int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setCate(new WnBookCategory(bookTypeId));
        Page<WnBook> page = wnBookServiceImp.findBookByCondition(book,offset,limit);
        BootstrapPage<WnBook> bootPage = new BootstrapPage<>();
        bootPage.setRows(page.getResult());
        bootPage.setTotal((int) page.getTotal());
//        Page<WnBook> page = wnBookServiceImp.findBookByPage(new Page<>(currentPage,pageSize));
//        //把我们自己的page转换成bootstrap-table 认识的格式
//        BootstrapPage<WnBook> bootPage = new BootstrapPage<>();
//        bootPage.setRows(page.getList());
//        bootPage.setTotal(page.getTotalRecord());
        JSONObject json = JSONObject.fromObject(bootPage);
        response.getWriter().print(json);

    }

    //ajax重名验证

    private void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String name = request.getParameter("username");
//    System.out.println("要检测的用户名：" + name);
//    WnBook user = wnBookServiceImp.findByName(name);
//    PrintWriter out = response.getWriter();
//    //因为使用了bootstrap-validator插件，所以这里封装成固定格式的数据，这样页面的插件才能认识我们返回的数据
//    HashMap<String,Boolean> map = new HashMap<>();
//    if (user==null){
//        map.put("valid",true);
//    }else {
//        map.put("valid",false);
//    }
//    JSONObject json = JSONObject.fromObject(map);
//    response.getWriter().print(json);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
