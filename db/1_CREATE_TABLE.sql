drop table if exists T_DICTIONARY;

drop table if exists T_MANAGER;

drop table if exists T_PRIV;

drop table if exists T_PRIV_GROUP;

drop table if exists T_ROLE;

drop table if exists T_ROLE_PRIV;

/*==============================================================*/
/* Table: T_DICTIONARY                                          */
/*==============================================================*/
create table T_DICTIONARY
(
   id                   varchar(35) not null comment '字典ID',
   value                varchar(50) not null comment '保存数据字典某个美剧的值',
   text                 text not null comment '当前字典的文字体现',
   dgroup               varchar(50) not null comment '字典意义所在的分组',
   remark               text comment '针对于当前字典值内容和用途场景的描述',
   primary key (id)
);

alter table T_DICTIONARY comment '保存一系列枚举信息';

/*==============================================================*/
/* Table: T_MANAGER                                             */
/*==============================================================*/
create table T_MANAGER
(
   id                   varchar(20) not null comment '主键，唯一标志。',
   rid                  varchar(20) not null comment '对应角色信息表中id字段',
   name                 varchar(20) comment '工号用户的名字',
   birthday             date comment '出出生日期',
   loginname            varchar(20) not null comment '登陆名称',
   loginpwd             varchar(32) not null comment '登陆密码',
   state                varchar(20) not null comment '标识当前工号的状态',
   primary key (id)
);

alter table T_MANAGER comment '保存工号信息表';

/*==============================================================*/
/* Table: T_PRIV                                                */
/*==============================================================*/
create table T_PRIV
(
   id                   varchar(35) not null comment '主键',
   gid                  varchar(20) not null comment '外键，关联权限分组信息表id',
   text                 varchar(20) not null comment '保存功能文字信息',
   url                  varchar(500) comment '保存跳转到的功能访问地址',
   orderno              int not null comment '排序依据',
   primary key (id)
);

alter table T_PRIV comment '保存系统中功能权限的相关信息';

/*==============================================================*/
/* Table: T_PRIV_GROUP                                          */
/*==============================================================*/
create table T_PRIV_GROUP
(
   id                   varchar(20) not null comment '主键',
   text                 varchar(50) not null comment '功能组文字',
   orderno              int not null comment '排序使用',
   primary key (id)
);

alter table T_PRIV_GROUP comment '保存权限分组信息';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   id                   varchar(20) not null comment '主键，唯一标志。',
   name                 varchar(20) not null comment '角色名称',
   remark               varchar(200) comment '角色描述信息',
   primary key (id)
);

alter table T_ROLE comment '工号对应角色信息字段';

/*==============================================================*/
/* Table: T_ROLE_PRIV                                           */
/*==============================================================*/
create table T_ROLE_PRIV
(
   R_ID                 varchar(20) not null,
   P_ID                 varchar(20)
);

alter table T_ROLE_PRIV comment '分别关联角色id，权限id';
