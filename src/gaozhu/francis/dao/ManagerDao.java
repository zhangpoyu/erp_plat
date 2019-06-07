package gaozhu.francis.dao;

import gaozhu.francis.entity.Manager;

import java.util.List;

public interface ManagerDao
{
    /**
     * 执行登陆的方法
     * @param loginname 用户名
     * @param loginpwd 密码
     * @return 登录用户实体
     */
    Manager login(String loginname, String loginpwd);

    /**
     * 获取所有的管理员信息
     * @return
     */
    List<Manager> getAll();

    /**
     * 根据指定的ID删除指定的管理员记录
     * @param id
     * @return
     */
    int delteById(String id);

    /**
     * 添加一个工号信息记录
     * @param mgr
     * @return
     */
    int add(Manager mgr);

    /**
     * 根据ID修改用户的角色，状态，密码
     * @param mgr
     * @return
     */
    int update(Manager mgr);

}
