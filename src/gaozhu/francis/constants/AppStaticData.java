package gaozhu.francis.constants;


import gaozhu.francis.dao.DictionaryDao;
import gaozhu.francis.dao.RoleDao;
import gaozhu.francis.dao.impl.DictionaryDaoImpl;
import gaozhu.francis.dao.impl.RoleDaoImpl;
import gaozhu.francis.entity.Dictionary;
import gaozhu.francis.entity.Role;

import java.util.List;

public class AppStaticData
{


    public static List<Role> ROLES;

    public static List<Dictionary> DICTIONARIES;

    public static List<Dictionary> MANAGER_STATE_DICT;


    public static void reloadRoles()
    {
        RoleDao roleDao = new RoleDaoImpl();
        ROLES = roleDao.getAll();
    }

    public static void reloadDictionaries()
    {
        DictionaryDao dictionaryDao = new DictionaryDaoImpl();
        DICTIONARIES = dictionaryDao.getAll();
    }

    public static void reloadManagerStates()
    {
        DictionaryDao dictionaryDao = new DictionaryDaoImpl();
        MANAGER_STATE_DICT = dictionaryDao.getByGroup("manager_state");
    }



    public static void reloadAll()
    {
        reloadRoles();
        reloadDictionaries();
        reloadManagerStates();

    }

}
