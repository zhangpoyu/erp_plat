package gaozhu.francis.servlet;

import gaozhu.francis.constants.AppConstants;
import gaozhu.francis.constants.AppStaticData;
import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.dao.RoleDao;
import gaozhu.francis.dao.impl.PrivDaoImpl;
import gaozhu.francis.dao.impl.RoleDaoImpl;
import gaozhu.francis.entity.Priv;
import gaozhu.francis.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RoleServlet extends HttpServlet
{

    private RoleDao roleDao = new RoleDaoImpl();
    private PrivDao privDao = new PrivDaoImpl();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String sign = request.getParameter(AppConstants.PRIV_SIGN);
        switch (sign)
        {
            case "getAll":
            {
                List<Role> listRole = roleDao.getAll();
                request.setAttribute("roles", listRole);
                request.getRequestDispatcher( "role-mgr.jsp").forward(request, response);
                break;
            }


            case "update":
            {
                Role role = new Role();
                role.setId(request.getParameter("id"));
                role.setRemark(request.getParameter("remark"));
                role.setName(request.getParameter("name"));
                int count = roleDao.update(role);
                if(0 < count)
                {
                    AppStaticData.reloadRoles();
                    this.alertRedirect(response, "信息修改成功！", "roleMgr?_sign=getAll");
                }
                else
                {
                    this.alert(response, "信息修改失败！");
                }
                break;
            }

            case "delete":
            {
                int total = roleDao.remove(request.getParameter("id"));
                if(0 < total)
                {
                    AppStaticData.reloadRoles();
                    this.alertRedirect(response, "信息删除成功！", "roleMgr?_sign=getAll");
                }
                else
                {
                    this.alert(response, "删除失败！");
                }
                break;
            }

            case "save":
            {
                Role role = new Role();
                role.setName(request.getParameter("name"));
                role.setRemark(request.getParameter("remark"));
                int total = roleDao.save(role);
                if(0 < total)
                {
                    AppStaticData.reloadRoles();
                    this.alertClose(response, "保存成功！");
                }
                else
                {
                    this.alert(response, "保存失败！");
                }
                break;
            }

            case "privInit":
            {
                String rid = request.getParameter("id");
                Role role = roleDao.getById(rid);
                List<Priv> privs = privDao.getAll();
                request.setAttribute("privs", privs);
                request.setAttribute("role", role);
                request.getRequestDispatcher("role-priv-mgr.jsp").forward(request, response);
                break;
            }

            case "privSave":
            {
                String rid = request.getParameter("rid");
                String[] selPrivs = request.getParameterValues("selPrivs");
                if(null == selPrivs)
                {
                    selPrivs = new String[0];
                }

                roleDao.removePrivsByRoleId(rid);
                int total = roleDao.savePrivsForRoleId(rid, selPrivs);
                if(selPrivs.length == total)
                {
                    this.alertClose(response, "保存成功");
                }
                else
                {
                    this.alertClose(response, "执行操作失败。");
                }


                break;
            }

            default:
            {
                break;
            }

        }

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
