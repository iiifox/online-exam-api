-- ------------ 系统设置表 ------------ --
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`
(
    `id`          VARCHAR(32) NOT NULL COMMENT 'ID',
    `site_name`   VARCHAR(255) DEFAULT NULL COMMENT '系统名称',
    `front_logo`  VARCHAR(255) DEFAULT NULL COMMENT '前端LOGO',
    `back_logo`   VARCHAR(255) DEFAULT NULL COMMENT '后台LOGO',
    `copy_right`  VARCHAR(255) DEFAULT NULL COMMENT '版权信息',
    # 表示列值为当前时间戳但不会自动更新
    `create_time` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    # 表示列值为当前时间戳并且自动更新（每次更新记录时自动更新该列值为当前时间戳）
    `update_time` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by`   VARCHAR(255) DEFAULT '' COMMENT '创建人',
    `update_by`   VARCHAR(255) DEFAULT '' COMMENT '修改人',
    `data_flag`   INT          DEFAULT '0' COMMENT '数据标识',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统设置';

INSERT INTO `sys_config` (`id`, `site_name`, `data_flag`)
VALUES ('1', '在线考试系统', 1);


-- ------------ 部门表 ------------ --
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart`
(
    `id`        varchar(32)  NOT NULL COMMENT 'ID',
    `dept_type` int          NOT NULL DEFAULT '1' COMMENT '1公司 2部门',
    `parent_id` varchar(32)  NOT NULL COMMENT '上级部门ID',
    `dept_name` varchar(255) NOT NULL DEFAULT '' COMMENT '部门名称',
    `dept_code` varchar(255) NOT NULL DEFAULT '' COMMENT '部门编码',
    `sort`      int          NOT NULL DEFAULT '0' COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='部门表';

INSERT INTO `sys_depart` (`id`, `dept_type`, `parent_id`, `dept_name`, `dept_code`, `sort`)
VALUES ('1', 1, '0', '湖南工商大学', 'A01', 1);


-- ------------ 用户表 ------------ --
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          varchar(32)  NOT NULL COMMENT 'ID',
    `user_name`   varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
    `real_name`   varchar(255) NOT NULL DEFAULT '' COMMENT '真实姓名',
    `password`    varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
    `depart_id`   varchar(32)  NOT NULL DEFAULT '' COMMENT '部门ID',
    `create_time` TIMESTAMP             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `state`       int          NOT NULL DEFAULT '0' COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';

INSERT INTO `sys_user` (`id`, `user_name`, `real_name`, `password`, `depart_id`, `state`)
VALUES ('10001', 'admin', '超管A', '$2a$10$pJEDCXFSJA9aU42WW023dezAlKGYphwjFjHchXa6nCGaTZoDbPk1q', '1', 0);


-- ------------ 角色表(K-V型) ------------ --
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`        varchar(32)  NOT NULL COMMENT '角色ID',
    `role_name` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色';

BEGIN;
INSERT INTO `sys_role` (`id`, `role_name`)
VALUES ('sa', '超级管理员');
INSERT INTO `sys_role` (`id`, `role_name`)
VALUES ('student', '学员');
COMMIT;


-- ------------ 用户角色表(用于关联用户与角色，多对多关系) ------------ --
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`      varchar(32) NOT NULL COMMENT 'ID',
    `user_id` varchar(32) NOT NULL COMMENT '用户ID',
    `role_id` varchar(32) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户角色';

INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`)
VALUES ('1', '10001', 'sa');