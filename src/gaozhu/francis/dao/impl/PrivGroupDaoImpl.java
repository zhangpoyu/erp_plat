package gaozhu.francis.dao.impl;

import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.dao.PrivGroupDao;
import gaozhu.francis.entity.PrivGroup;
import gaozhu.francis.util.JDBCHelper;

import java.util.List;

public class PrivGroupDaoImpl implements PrivGroupDao
{
    private PrivDao privDao = new PrivDaoImpl();


    @Override
    public List<PrivGroup> getALL()
    {
        List<PrivGroup> result = JDBCHelper.executeQuery("SELECT * FROM T_PRIV_GROUP", PrivGroup.class);
        for(PrivGroup param:result)
        {
            param.setPrivs(privDao.queryByGid(param.getId()));
        }
        return result;
    }


    @Override
    public List<PrivGroup> getGroupByRoleId(String rId)
    {
        String sql = "SELECT TPG_A.* FROM T_ROLE_PRIV TRP_A INNER JOIN T_PRIV TP_A ON TRP_A.P_ID=TP_A.ID INNER JOIN T_PRIV_GROUP TPG_A ON TP_A.GID=TPG_A.ID WHERE TRP_A.R_ID=? GROUP BY TPG_A.ID  ORDER BY TPG_A.ORDERNO ASC";
        return JDBCHelper.executeQuery(sql, PrivGroup.class, rId);
    }
}
