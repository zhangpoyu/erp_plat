package gaozhu.francis.dao;

import gaozhu.francis.entity.PrivGroup;
import java.util.List;


/**
 * 分组dao
 */
public interface PrivGroupDao
{
    List<PrivGroup> getALL();

    /**
     * 根据角色ID获取指定角色应当拥有的权限分组
     * @param rId
     * @return
     */
    List<PrivGroup> getGroupByRoleId(String rId);

}
