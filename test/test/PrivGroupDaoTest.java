package test;

import gaozhu.francis.dao.ManagerDao;
import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.dao.PrivGroupDao;
import gaozhu.francis.dao.impl.ManagerDaoImpl;
import gaozhu.francis.dao.impl.PrivDaoImpl;
import gaozhu.francis.dao.impl.PrivGroupDaoImpl;
import gaozhu.francis.entity.Manager;
import gaozhu.francis.entity.Priv;
import gaozhu.francis.entity.PrivGroup;
import org.junit.Test;

import java.util.List;

public class PrivGroupDaoTest
{
    PrivGroupDao pgDao = new PrivGroupDaoImpl();
    ManagerDao managerDao = new ManagerDaoImpl();
    PrivDao privDao = new PrivDaoImpl();

    @Test
    public void testGetAllPrivGroup()
    {
        List<PrivGroup> privGroups = pgDao.getGroupByRoleId("admin");
        List<Priv> privs = privDao.getByRoleId("admin");
        for(PrivGroup param : privGroups)
        {
            System.out.println(param.getText());
            for (Priv param2 : privs)
            {
                if(param2.getGid().equals(param.getId()))
                {
                    System.out.println("\t" + param2.getText());
                }
            }
        }
    }

}
