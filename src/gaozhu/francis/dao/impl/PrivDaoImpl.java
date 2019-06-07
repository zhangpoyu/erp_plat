package gaozhu.francis.dao.impl;

import gaozhu.francis.dao.PrivDao;
import gaozhu.francis.entity.Priv;
import gaozhu.francis.util.JDBCHelper;

import java.util.List;


public class PrivDaoImpl implements PrivDao
{
    @Override
    public List<Priv> queryByGid(String gid)
    {
        return JDBCHelper.executeQuery("SELECT * FROM T_PRIV WHERE GID=?", Priv.class, gid);
    }


    @Override
    public List<Priv> getByRoleId(String rid)
    {
        return JDBCHelper.executeQuery("SELECT TP_A.* FROM T_ROLE_PRIV TRP_A INNER JOIN T_PRIV TP_A ON TRP_A.P_ID=TP_A.ID INNER JOIN T_PRIV_GROUP TPG_A ON TP_A.GID=TPG_A.ID WHERE TRP_A.R_ID=? ORDER BY TP_A.ORDERNO ASC", Priv.class, rid);
    }


    @Override
    public List<Priv> getAll()
    {
        return JDBCHelper.executeQuery("SELECT TP_A.*, TPG_A.TEXT AS groupName FROM T_PRIV TP_A INNER JOIN T_PRIV_GROUP TPG_A ON TP_A.GID=TPG_A.ID", Priv.class);
    }
}
