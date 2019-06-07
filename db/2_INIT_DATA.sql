INSERT INTO `erp_plat`.`t_role` (`id`, `name`, `remark`) VALUES ('admin', '超级管理员', '拥有一切权限');
INSERT INTO `erp_plat`.`t_manager` (`id`, `rid`, `name`, `birthday`, `loginname`, `loginpwd`, `state`) VALUES ('001', 'admin', 'FrancisGaozhu', '1992-04-27', '18846457728', '8566a379a820e6586b9ce5fbbad8694a', '1');

INSERT INTO `erp_plat`.`t_priv_group` (`id`, `text`, `orderno`) VALUES ('system', '系统管理', '0');
INSERT INTO `erp_plat`.`t_priv` (`id`, `gid`, `text`, `url`, `orderno`) VALUES ('managerMgr', 'system', '人员管理', 'managerMgr?_sign=getAll','0');
INSERT INTO `erp_plat`.`t_priv` (`id`, `gid`, `text`, `orderno`) VALUES ('roleMgr', 'system', '角色信息管理', '1');


INSERT INTO T_ROLE_PRIV VALUES('admin', 'managerMgr');
INSERT INTO T_ROLE_PRIV VALUES('admin', 'roleMgr');

--数据字典表初始化内容
INSERT INTO `erp_plat`.`t_dictionary` (`id`, `value`, `text`, `dgroup`) VALUES ('manager_state_nomal', '1', '正常', 'manager_state');
INSERT INTO `erp_plat`.`t_dictionary` (`id`, `value`, `text`, `dgroup`) VALUES ('manager_state_invalid', '2', '无效账户', 'manager_state');