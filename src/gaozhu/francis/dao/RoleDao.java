package gaozhu.francis.dao;

import gaozhu.francis.entity.Role;

import java.util.List;

public interface RoleDao
{

    Role getById(String id);

    List<Role> getAll();

    /**
     * 根据ID更改某个角色的名称和描述信息
     * @param role
     * @return
     */
    int update(Role role);


    /**
     * 保存方法
     * @param role
     * @return
     */
    int save(Role role);

    /**
     * 删除指定的角色信息
     * @param id
     * @return
     */
    int remove(String id);

    /**
     * 清空某个角色下指定的权限信息
     * @param rid
     * @return
     */
    int removePrivsByRoleId(String rid);

    /**
     * 将某些权限附加给某个角色
     * @return
     */
    int savePrivsForRoleId(String rid, String[] pids);

}
