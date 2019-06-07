package gaozhu.francis.dao.impl;

import gaozhu.francis.dao.DictionaryDao;
import gaozhu.francis.entity.Dictionary;
import gaozhu.francis.util.JDBCHelper;

import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao
{
    @Override
    public List<Dictionary> getAll()
    {
        return JDBCHelper.executeQuery("SELECT * FROM T_DICTIONARY", Dictionary.class);
    }

    @Override
    public List<Dictionary> getByGroup(String group)
    {
        return JDBCHelper.executeQuery("SELECT * FROM T_DICTIONARY WHERE DGROUP=?", Dictionary.class, group);
    }
}
