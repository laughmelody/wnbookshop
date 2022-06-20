package wnbook.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        //项目中有些资源不用登录就可以访问，需要直接放行
        //首页 静态资源 主目录
        String uri = request.getRequestURI();
        System.out.println("访问的资源路径是:" +uri);
        if (uri.contains("login") ||uri.contains("css")||uri.contains("javascript")||uri.contains("img")
                ||uri.contains("bootstrap")||uri.equals(request.getContextPath()+"/")){
            chain.doFilter(request,response);
        }else {
            String loginName=(String)session.getAttribute("loginName");

            if (loginName==null){
                //未登录的拦截，提示登录才可以访问
                PrintWriter out = response.getWriter();

                //location.href改成绝对路径
                out.write("<script>alert('对不起,请先登录!');location.href='"+request.getContextPath()+"/back-login.jsp'</script>");
            }else {
                //已经登录的放行
                chain.doFilter(request,response);
            }
        }
        System.out.println("登录过滤结束");

    }

    @Override
    public void destroy() {

    }


}
