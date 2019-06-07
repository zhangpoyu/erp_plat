package gaozhu.francis.test;

import gaozhu.francis.dao.RoleDao;
import gaozhu.francis.dao.impl.RoleDaoImpl;
import gaozhu.francis.entity.Role;
import org.junit.Test;

import java.util.List;

import static com.sun.deploy.config.JREInfo.getAll;

public class TestRoleDao
{
    RoleDao roleDao = new RoleDaoImpl();

    @Test
    public void testGetAll()
    {
        List<Role> lst = roleDao.getAll();
    }


}
