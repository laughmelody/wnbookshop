package wnbook.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("设置的编码格式是"+encoding);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==========字符过滤开始");
        //设置编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        //放行
        chain.doFilter(request,response);
        System.out.println("======字符过滤结束");
    }

    @Override
    public void destroy() {

    }
}
