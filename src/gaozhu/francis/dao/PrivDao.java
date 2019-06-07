package gaozhu.francis.dao;

import gaozhu.francis.entity.Priv;

import java.util.List;

/**
 * 针对于权限操作的的接口
 */
public interface PrivDao
{

    /**
     * 根据分组查询指定分组的权限信息
     * @param gid
     * @return
     */
    List<Priv> queryByGid(String gid);

    /**
     * 根据指定的角色，查找这个角色应当具备的功能点。
     * @param rid
     * @return
     */
    List<Priv> getByRoleId(String rid);


    List<Priv> getAll();


}
