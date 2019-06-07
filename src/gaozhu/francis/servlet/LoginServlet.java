package gaozhu.francis.servlet;

import gaozhu.francis.constants.AppConstants;
import gaozhu.francis.constants.AppStaticData;
import gaozhu.francis.dao.ManagerDao;
import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.dao.PrivGroupDao;
import gaozhu.francis.dao.impl.ManagerDaoImpl;
import gaozhu.francis.dao.impl.PrivDaoImpl;
import gaozhu.francis.dao.impl.PrivGroupDaoImpl;
import gaozhu.francis.entity.Manager;
import gaozhu.francis.entity.Priv;
import gaozhu.francis.entity.PrivGroup;
import gaozhu.francis.util.KeyedMD5;
import gaozhu.francis.util.String_;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet
{
    ManagerDao managerDao = new ManagerDaoImpl();
    PrivGroupDao privGroupDao = new PrivGroupDaoImpl();
    PrivDao privDao = new PrivDaoImpl();


    /**
     * 登录Servlet的处理方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


        String userName = request.getParameter("userName");
        String userPwd = KeyedMD5.getMd5Utf8(request.getParameter("userPwd"), AppConstants.MANAGER_PWD_KEY);

        if (String_.isNullOrEmpty(userName) || String_.isNullOrEmpty(userPwd))
        {
            request.setAttribute("notice", "用户名或密码为空！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


        Manager manager = managerDao.login(userName, userPwd);

        if(null != manager)
        {
            List<PrivGroup> privGroups = privGroupDao.getGroupByRoleId(manager.getRid());
            List<Priv> privs = privDao.getByRoleId(manager.getRid());
            if("1".equals(manager.getState()))
            {
                request.setAttribute("privs", privs);
                request.setAttribute("privGroups", privGroups);
                request.getSession().setAttribute(AppConstants.MANAGER_SESSION_TAG, manager);
                request.getRequestDispatcher("manager/index.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("notice", "账户状态已禁用，请联系管理员。");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
        else
        {
            request.setAttribute("notice", "用户名或密码有误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
