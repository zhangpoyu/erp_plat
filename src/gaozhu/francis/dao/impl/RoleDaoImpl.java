
package gaozhu.francis.dao.impl;

import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.dao.RoleDao;
import gaozhu.francis.entity.Role;
import gaozhu.francis.util.JDBCHelper;

import java.util.List;

public class RoleDaoImpl implements RoleDao
{
    private PrivDao privDao = new PrivDaoImpl();

    @Override
    public Role getById(String id)
    {
        Role result = JDBCHelper.executeQuery("SELECT * FROM T_ROLE WHERE ID=?", Role.class, id).get(0);
        result.setPrivs(privDao.getByRoleId(result.getId()));
        return result;
    }

    @Override
    public List<Role> getAll()
    {
        List<Role> result = JDBCHelper.executeQuery("SELECT * FROM T_ROLE", Role.class);

        for(int i = 0; i < result.size(); i ++)
        {

            Role tempRole = result.get(i);
            tempRole.setPrivs(privDao.getByRoleId(tempRole.getId()));
            result.set(i, tempRole);

        }

        return result;
    }

    @Override
    public int update(Role role)
    {
        return JDBCHelper.executeUpdate("UPDATE T_ROLE SET NAME=?, REMARK=? WHERE ID=?", role.getName(), role.getRemark(), role.getId());
    }

    @Override
    public int save(Role role)
    {
        return JDBCHelper.executeUpdate("INSERT INTO T_ROLE VALUE(?, ?, ?)", JDBCHelper.getPKL20(), role.getName(), role.getRemark());
    }


    @Override
    public int remove(String id)
    {
        return JDBCHelper.executeUpdate("DELETE FROM T_ROLE WHERE ID=?", id);
    }

    @Override
    public int removePrivsByRoleId(String rid)
    {
        return JDBCHelper.executeUpdate("DELETE FROM T_ROLE_PRIV WHERE R_ID=?", rid);
    }

    @Override
    public int savePrivsForRoleId(String rid, String[] pids)
    {
        int result = 0;

        for(String param : pids)
        {
            result += JDBCHelper.executeUpdate("INSERT INTO T_ROLE_PRIV VALUES(?, ?)", rid, param);
        }

        return result;
    }
}
