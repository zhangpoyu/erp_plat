package gaozhu.francis.dao.impl;

import gaozhu.francis.dao.ManagerDao;
import gaozhu.francis.dao.RoleDao;
import gaozhu.francis.entity.Manager;
import gaozhu.francis.util.JDBCHelper;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao
{
    private RoleDao roleDao = new RoleDaoImpl();


    @Override
    public Manager login(String loginname, String loginpwd)
    {
        String sql = "SELECT * FROM T_MANAGER WHERE loginname=? AND loginpwd=?";
        List<Manager> list = JDBCHelper.executeQuery(sql, Manager.class, loginname, loginpwd);
        if(null != list && 0 < list.size())
        {
            Manager mgr = list.get(0);
            mgr.setRole(roleDao.getById(mgr.getRid()));
            return mgr;
        }
        else
            return null;
    }

    @Override
    public List<Manager> getAll()
    {
        return JDBCHelper.executeQuery("SELECT * FROM T_MANAGER", Manager.class);
    }

    @Override
    public int delteById(String id)
    {
        return JDBCHelper.executeUpdate("DELETE FROM T_MANAGER WHERE ID=?", id);
    }

    @Override
    public int add(Manager mgr)
    {
        return JDBCHelper.executeUpdate("INSERT INTO T_MANAGER VALUES(?, ?, ?, ?, ?, ?, ?)", mgr.getId(), mgr.getRid(), mgr.getName(), mgr.getBirthday(), mgr.getLoginname(), mgr.getLoginpwd(), mgr.getState());
    }

    @Override
    public int update(Manager mgr)
    {
        if(null != mgr.getLoginpwd() && !mgr.getLoginpwd().isEmpty())
        {
            return JDBCHelper.executeUpdate("UPDATE T_MANAGER SET RID=?, STATE=?, LOGINPWD=? WHERE ID=?", mgr.getRid(), mgr.getState(), mgr.getLoginpwd(), mgr.getId());
        }
        else
        {
            return JDBCHelper.executeUpdate("UPDATE T_MANAGER SET RID=?, STATE=? WHERE ID=?", mgr.getRid(), mgr.getState(), mgr.getId());
        }
    }
}
