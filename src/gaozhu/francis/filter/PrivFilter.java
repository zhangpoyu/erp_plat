package gaozhu.francis.filter;

import gaozhu.francis.constants.AppConstants;
import gaozhu.francis.entity.Manager;
import gaozhu.francis.entity.Priv;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PrivFilter implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String reqUri = request.getRequestURI();
        Manager currMgr = (Manager) session.getAttribute(AppConstants.MANAGER_SESSION_TAG);
        reqUri = (-1 < reqUri.indexOf("?")) ? reqUri.split("\\?")[0] : reqUri;
        if(
                reqUri.endsWith(".jsp") ||
                reqUri.endsWith(".html") ||
                reqUri.endsWith(".htm")
          )
        {
            chain.doFilter(request, response);
            return;
        }

        for(Priv param : currMgr.getRole().getPrivs())
        {
            String tempUrl = (-1 < param.getUrl().indexOf("?")) ? param.getUrl().split("\\?")[0] : param.getUrl();
            if(reqUri.endsWith(tempUrl))
            {
                chain.doFilter(request, response);
                return;
            }
        }

        response.sendRedirect(request.getContextPath() + "/PrivError.html");
    }

    public void init(FilterConfig config) throws ServletException
    {

    }

}
