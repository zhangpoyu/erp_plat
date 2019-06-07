package gaozhu.francis.filter;

import gaozhu.francis.constants.AppConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSessionFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        /*
        1.获取Session对象
        2.判断session对象中有没有登陆的用户信息
            -->有：放行访问请求
            -->没有：转发到登陆页面
         */

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(null != session.getAttribute(AppConstants.MANAGER_SESSION_TAG))
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            request.setAttribute("notice", "您还没有登录，请先登录。");
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy()
    {

    }
}
