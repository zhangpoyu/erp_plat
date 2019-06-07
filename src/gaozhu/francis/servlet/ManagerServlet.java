package gaozhu.francis.servlet;

import gaozhu.francis.constants.AppConstants;
import gaozhu.francis.constants.AppStaticData;
import gaozhu.francis.dao.ManagerDao;
import gaozhu.francis.dao.impl.ManagerDaoImpl;
import gaozhu.francis.entity.Manager;
import gaozhu.francis.entity.Role;
import gaozhu.francis.util.JDBCHelper;
import gaozhu.francis.util.KeyedMD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ManagerServlet extends HttpServlet
{
    ManagerDao managerDao = new ManagerDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        switch(request.getParameter(AppConstants.PRIV_SIGN))
        {

            case "getAll":
            {
                List<Manager> managerList = managerDao.getAll();
                request.setAttribute("managers", managerList);
                request.setAttribute("roles", AppStaticData.ROLES);
                request.setAttribute("states", AppStaticData.MANAGER_STATE_DICT);
                request.getRequestDispatcher("manager.jsp").forward(request, response);
                break;
            }


            case "delete":
            {
                int count = managerDao.delteById(request.getParameter("mid"));
                if (0 < count)
                {
                    this.alertRedirect(response, "账号信息删除成功！", "managerMgr?_sign=getAll");
                }
                else
                {
                    this.alertRedirect(response, "账号信息删除失败！", "managerMgr?_sign=getAll");
                }
                break;
            }

            case "initAdd":
            {
                request.setAttribute("roles", AppStaticData.ROLES);
                request.setAttribute("managerStates", AppStaticData.MANAGER_STATE_DICT);
                request.getRequestDispatcher("manager-add.jsp").forward(request, response);
                break;
            }

            case "save":
            {
                Manager mgr = new Manager();
                mgr.setRid(request.getParameter("role"));
                mgr.setState(request.getParameter("state"));
                mgr.setId(request.getParameter("id"));
                String password = request.getParameter("newpwd");
                if(!password.isEmpty())
                {
                    mgr.setLoginpwd(KeyedMD5.getMd5Utf8(password, AppConstants.MANAGER_PWD_KEY));
                }
                mgr.setName(request.getParameter("name"));
                int rows = managerDao.update(mgr);
                if(0 < rows)
                {
                    this.alertRedirect(response, "账号信息【" + mgr.getName() + "】修改成功！", "managerMgr?_sign=getAll");
                }
                else
                {
                    this.alert(response, "账户信息【" + mgr.getName() + "】修改失败！");
                }

                break;
            }


            case "add":
            {
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Manager manager = new Manager();
                    manager.setId(JDBCHelper.getPKL20());
                    manager.setLoginname(request.getParameter("loginName"));
                    manager.setLoginpwd(KeyedMD5.getMd5Utf8(request.getParameter("loginPwd"), AppConstants.MANAGER_PWD_KEY));
                    manager.setName(request.getParameter("name"));
                    manager.setBirthday(sdf.parse(request.getParameter("birthday")));
                    manager.setState(request.getParameter("managerState"));
                    manager.setRid(request.getParameter("role"));
                    int rows = managerDao.add(manager);
                    if(0 < rows)
                    {
                        this.alertClose(response, "添加工号成功！");
                    }
                    else
                    {
                        this.alert(response, "添加工号失败！");
                    }
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                break;
            }


            default:
            {

            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }


    /**
     * 用于在当前项目中Servlet输出提示到页面的方法
     * @param response
     * @param message
     */
    private void alert(HttpServletResponse response, String message)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\" language=\"javascript\">alert('" + message + "');</script>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 提示信息并且页面重定向
     * @param response
     * @param url
     */
    private void alertRedirect(HttpServletResponse response, String message, String url)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\" language=\"javascript\">alert('" + message + "'); window.location.href='" + url + "';</script>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void alertClose(HttpServletResponse response, String message)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\" language=\"javascript\">alert('" + message + "'); var index = parent.layer.getFrameIndex(window.name); parent.layer.close(index);</script>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
