-- 创建数据库
CREATE DATABASE `td_peanut_cms_0103`;
CREATE USER 'td_peanut_0103'@'localhost' IDENTIFIED BY 'dasd2131';
GRANT ALL ON `td_peanut_cms_0103`.* TO 'td_peanut_0103'@'localhost';
FLUSH PRIVILEGES;
USE `td_peanut_cms_0103`;

-- 权限表
DROP TABLE IF EXISTS `user_rule`;
CREATE TABLE `user_rule`
(
  `id`          int(11) UNSIGNED          NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `pid`         int(11) UNSIGNED                   DEFAULT NULL COMMENT '所归属的父级权限的id值，如果为null，表示当前权限为顶级',
  `rule_name`   varchar(255)              NOT NULL COMMENT '权限名称',
  `rule_url`    varchar(255)              NOT NULL COMMENT '权限访问路径',
  `rule_method` enum ('GET','POST')       NOT NULL DEFAULT 'GET' COMMENT '访问的方法',
  `rule_type`   enum ('API','NAV','PAGE') NOT NULL DEFAULT 'API' COMMENT '权限的分类',
  `rule_icon`   varchar(255)              NOT NULL DEFAULT '' COMMENT '权限的图标',
  `rule_des`    varchar(255)              NOT NULL DEFAULT '' COMMENT '权限的描述信息',
  `add_time`    datetime(0)               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED          NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_user_rule_pid` FOREIGN KEY (`pid`) REFERENCES `user_rule` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  UNIQUE INDEX `uk_user_rule_name` (`pid`, `rule_name`, `del_time`) USING BTREE,
  INDEX `user_rule_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '系统权限表';

-- 管理员角色表
DROP TABLE IF EXISTS `user_router`;
CREATE TABLE `user_router`
(
  `id`          int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `router_name` varchar(255)     NOT NULL COMMENT '角色名称',
  `router_des`  varchar(255)     NOT NULL DEFAULT '' COMMENT '角色的描述信息',
  `add_time`    datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_router_name` (`router_name`, `del_time`) USING BTREE,
  INDEX `user_router_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '管理员角色表';

-- 角色权限表
DROP TABLE IF EXISTS `user_router_rule`;
CREATE TABLE `user_router_rule`
(
  `id`          int(11) UNSIGNED          NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `router_id`   int(11) UNSIGNED          NOT NULL COMMENT '所归属角色',
  `rule_id`     int(11) UNSIGNED          NOT NULL COMMENT '角色所拥有的权限',
  `rule_state`  enum ('GRANTED','DENIED') NOT NULL DEFAULT 'GRANTED' COMMENT '权限状态',
  `add_time`    datetime(0)               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED          NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_router_rule_router` FOREIGN KEY (`router_id`) REFERENCES `user_router` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_router_rule_rule` FOREIGN KEY (`rule_id`) REFERENCES `user_rule` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  UNIQUE INDEX `uk_router_rule` (`router_id`, `rule_id`, `del_time`) USING BTREE,
  INDEX `user_router_rule_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '角色权限表';

-- 管理员信息表
DROP TABLE IF EXISTS `user_master`;
CREATE TABLE `user_master`
(
  `id`              int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `router_id`       int(11) UNSIGNED NOT NULL COMMENT '管理员所属角色',
  `master_name`     varchar(255)     NOT NULL COMMENT '管理员姓名',
  `master_thumb`    varchar(255)     NOT NULL COMMENT '管理员头像',
  `master_username` varchar(255)     NOT NULL COMMENT '管理员登录账号',
  `master_password` char(32)         NOT NULL DEFAULT '' COMMENT '管理员登录密码->加密后',
  `master_phone`    varchar(255)     NOT NULL DEFAULT '' COMMENT '管理员联系电话',
  `master_mail`     varchar(255)     NOT NULL DEFAULT '' COMMENT '管理员联系邮箱',
  `add_time`        datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`     timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`        int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_master_router` FOREIGN KEY (`router_id`) REFERENCES `user_router` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  UNIQUE INDEX `uk_master_username` (`master_username`, `del_time`) USING BTREE,
  INDEX `user_master_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '管理员信息表';

-- 管理员权限表
DROP TABLE IF EXISTS `user_master_rule`;
CREATE TABLE `user_master_rule`
(
  `id`          int(11) UNSIGNED          NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `master_id`   int(11) UNSIGNED          NOT NULL COMMENT '所属管理员',
  `rule_id`     int(11) UNSIGNED          NOT NULL COMMENT '管理员所拥有的权限',
  `rule_state`  enum ('GRANTED','DENIED') NOT NULL DEFAULT 'GRANTED' COMMENT '权限状态',
  `add_time`    datetime(0)               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED          NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_master_rule_master` FOREIGN KEY (`master_id`) REFERENCES `user_master` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_master_rule_rule` FOREIGN KEY (`rule_id`) REFERENCES `user_rule` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  UNIQUE INDEX `uk_master_rule` (`master_id`, `rule_id`, `del_time`) USING BTREE,
  INDEX `user_master_rule_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '管理员权限表';

-- changed AT 2021-10-29
  ALTER TABLE `user_rule`ADD COLUMN `rule_level` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '权限的层级'AFTER `pid`;
  ALTER TABLE `user_rule`ADD COLUMN `rule_sort` int(4) UNSIGNED NOT NULL DEFAULT 100 COMMENT '权限的排序字段'AFTER `rule_level`;
  ALTER TABLE `user_rule`ADD INDEX(`rule_sort`);

-- 初始化数据
  UPDATE `user_rule`SET `rule_level`=1 WHERE `pid`IS NULL;
  UPDATE `user_rule`SET `rule_level`=2 WHERE `pid`IN(
    SELECT temp.id FROM(SELECT id FROM `user_rule`WHERE `rule_level`=1)temp
    );
  UPDATE `user_rule`SET `rule_level`=3 WHERE `pid`IN(
    SELECT temp.id FROM(SELECT id FROM `user_rule`WHERE `rule_level`=2)temp
    );
  UPDATE `user_rule`SET `rule_level`=4 WHERE `pid`IN(
    SELECT temp.id FROM(SELECT id FROM `user_rule`WHERE `rule_level`=3)temp
    );
  UPDATE `user_rule`SET `rule_level`=5 WHERE `pid`IN(
    SELECT temp.id FROM(SELECT id FROM `user_rule`WHERE `rule_level`=4)temp
    );

-- 创建视图
DROP VIEW IF EXISTS `view_router_rule`;
CREATE VIEW `view_router_rule` AS
SELECT `router_rule`.`id`,
       `router_rule`.`router_id`,
       `router_rule`.`rule_id`,
       `router_rule`.`rule_state`,
       `router`.`router_name`,
       `rule`.`rule_name`,
       `rule`.`rule_type`,
       `rule`.`rule_method`,
       `rule`.`rule_url`,
       `router_rule`.`add_time`,
       `router_rule`.`update_time`,
       `router_rule`.`del_time`
FROM `user_router_rule` `router_rule`
       JOIN `user_router` `router` on `router_rule`.`router_id` = `router`.`id`
       JOIN `user_rule` `rule` on `router_rule`.`rule_id` = `rule`.`id`
WHERE `rule`.`del_time` = 0;

-- changed AT 2021-10-28 维护内容管理表
   -- 1:系统配置
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`
(
  `id`           int(11) UNSIGNED            NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `config_name`  varchar(50)                 NOT NULL COMMENT '配置信息的名称',
  `config_key`   varchar(50)                 NOT NULL COMMENT '读取配置信息的主键，key-value',
  `config_type`  enum ('int','string','url') NOT NULL COMMENT '配置信息的数据类型,url:记录的是文件访问的URL地址',
  `config_value` varchar(255)                NOT NULL COMMENT '配置信息的结果值',
  `config_des`   varchar(500)                         DEFAULT NULL COMMENT '配置信息的描述内容',
  `add_time`     datetime(0)                 NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`  timestamp(0)                NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`     int(10) UNSIGNED            NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_system_config_key` (`config_key`, `del_time`) USING BTREE,
  INDEX `system_config_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '系统配置';
-- 2:模板设置
DROP TABLE IF EXISTS `system_template`;
CREATE TABLE `system_template`
(
  `id`               int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `template_name`    varchar(50)      NOT NULL COMMENT '模板名称',
  `template_file`    varchar(255)     NOT NULL COMMENT '模板存放的物理路径',
  `template_thumb`   varchar(255)     NOT NULL COMMENT '模板预览图片',
  `template_des`     varchar(500)     NOT NULL COMMENT '模板的介绍信息',
  `template_content` longtext         NOT NULL COMMENT '模板的详细内容',
  `add_time`         datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`      timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`         int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_system_template_name` (`template_name`, `del_time`) USING BTREE,
  INDEX `system_template_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '模板设置';
--  文章管理
--   分类文章
-- 3：   分类管理
DROP TABLE IF EXISTS `content_type`;
CREATE TABLE `content_type`
(
  `id`               int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `pid`              int(11) UNSIGNED          DEFAULT NULL COMMENT '父级分类的ID，为空表示顶级分类',
  `level`            int(2) UNSIGNED  NOT NULL COMMENT '当前分类所在的层级',
  `type_template`    int(11) UNSIGNED NOT NULL COMMENT '文章分类所使用的模板',
  `content_template` int(11) UNSIGNED NOT NULL COMMENT '文章详情页面推荐使用的模板',
  `type_folder`      varchar(255)     NOT NULL COMMENT '生成静态文件后，静态文件存放的目录名称',
  `type_name`        varchar(255)     NOT NULL COMMENT '分类名称',
  `type_sort`        int(4) UNSIGNED  NOT NULL COMMENT '分类排序字段：ASC',
  `type_click`       int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前分类和其子文章被点击的次数',
  `type_title`       varchar(255)              DEFAULT NULL COMMENT '分类页面的SEO标题',
  `type_keywords`    varchar(255)              DEFAULT NULL COMMENT '分类页面的SEO关键字',
  `type_description` varchar(255)              DEFAULT NULL COMMENT '分类页面的SEO描述信息',
  `type_content`     longtext                  DEFAULT NULL COMMENT '分类的详细内容',
  `add_time`         datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`      timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`         int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_content_type_name` (`type_name`, `del_time`) USING BTREE,
  CONSTRAINT `fk_content_type_pid` FOREIGN KEY (`pid`) REFERENCES `content_type` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_content_type_template` FOREIGN KEY (`type_template`) REFERENCES `system_template` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_content_content_template` FOREIGN KEY (`content_template`) REFERENCES `system_template` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  INDEX `content_type_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '分类管理';
-- 4：   子文章管理
DROP TABLE IF EXISTS `content_article`;
CREATE TABLE `content_article`
(
  `id`                  int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `type_id`             int(11) UNSIGNED NOT NULL COMMENT '子类文章所属的文章分类',
  `content_template`    int(11) UNSIGNED          DEFAULT NULL COMMENT '子类文章使用的模板',
  `article_name`        varchar(255)     NOT NULL COMMENT '文章的标题',
  `article_thumb`       varchar(255)     NOT NULL COMMENT '文章的展示缩略图',
  `article_content`     longtext         NOT NULL COMMENT '文章的详细内容',
  `article_author`      varchar(255)     NOT NULL COMMENT '文章的作者',
  `article_time`        datetime(0)      NOT NULL COMMENT '文章的发布时间，可以由作者自由指定',
  `article_click`       int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前文章被访问次数',
  `article_title`       varchar(255)     NOT NULL COMMENT '文章的SEO标题',
  `article_keywords`    varchar(255)     NOT NULL COMMENT '文章的SEO关键字',
  `article_description` varchar(255)     NOT NULL COMMENT '文章的SEO详细内容',
  `article_flag`        varchar(255)     NOT NULL COMMENT '文章的标签，多个标签之间使用逗号分割',
  `add_time`            datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`         timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`            int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_content_article_type` FOREIGN KEY (`type_id`) REFERENCES `content_type` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_content_article_template` FOREIGN KEY (`content_template`) REFERENCES `system_template` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  INDEX `content_article_add_time` (`add_time`) USING BTREE,
  INDEX `content_article_article_time` (`article_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '子文章管理';
-- 5;  无分类文章
DROP TABLE IF EXISTS `content_page`;
CREATE TABLE `content_page`
(
  `id`               int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `content_template` int(11) UNSIGNED          DEFAULT NULL COMMENT '文章使用的模板',
  `page_name`        varchar(255)     NOT NULL COMMENT '文章的标题',
  `page_thumb`       varchar(255)     NOT NULL COMMENT '文章的展示缩略图',
  `page_content`     longtext         NOT NULL COMMENT '文章的详细内容',
  `page_author`      varchar(255)     NOT NULL COMMENT '文章的作者',
  `page_time`        datetime(0)      NOT NULL COMMENT '文章的发布时间，可以由作者自由指定',
  `page_click`       int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前文章被访问次数',
  `page_title`       varchar(255)     NOT NULL COMMENT '文章的SEO标题',
  `page_keywords`    varchar(255)     NOT NULL COMMENT '文章的SEO关键字',
  `page_description` varchar(255)     NOT NULL COMMENT '文章的SEO详细内容',
  `page_flag`        varchar(255)     NOT NULL COMMENT '文章的标签，多个标签之间使用逗号分割',
  `add_time`         datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`      timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`         int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_page_name` (`page_name`, `del_time`) USING BTREE,
  CONSTRAINT `fk_content_page_template` FOREIGN KEY (`content_template`) REFERENCES `system_template` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  INDEX `content_page_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '无分类文章';
-- 6:导航配置
DROP TABLE IF EXISTS `content_nav`;
CREATE TABLE `content_nav`
(
  `id`          int(11) UNSIGNED                         NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `pid`         int(11) UNSIGNED                                  DEFAULT NULL COMMENT '上级导航',
  `level`       int(2) UNSIGNED                          NOT NULL COMMENT '导航的层级',
  `nav_name`    varchar(255)                             NOT NULL COMMENT '导航的名称',
  `nav_url`     varchar(255)                             NOT NULL COMMENT '导航的跳转链接',
  `nav_type`    enum ('_blank','_self','_parent','_top') NOT NULL DEFAULT '_self' COMMENT '点击导航后的跳转方式',
  `add_time`    datetime(0)                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)                             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED                         NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `fk_content_nav_pid` FOREIGN KEY (`pid`) REFERENCES `content_nav` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  INDEX `content_nav_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '导航配置';
-- 其余资源管理
-- 7：轮播图
DROP TABLE IF EXISTS `content_banner`;
CREATE TABLE `content_banner`
(
  `id`              int(11) UNSIGNED                         NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `banner_name`     varchar(255)                             NOT NULL COMMENT '名称',
  `banner_sort`     int(4)                                   NOT NULL COMMENT '排序:ASC',
  `banner_url`      varchar(255)                             NOT NULL COMMENT '跳转链接',
  `banner_thumb`    varchar(255)                             NOT NULL COMMENT '轮播图图片',
  `banner_position` varchar(255)                             NOT NULL COMMENT '轮播图摆放的位置',
  `open_type`       enum ('_blank','_self','_parent','_top') NOT NULL DEFAULT '_self' COMMENT '点击导航后的跳转方式',
  `add_time`        datetime(0)                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time`     timestamp(0)                             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`        int(10) UNSIGNED                         NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `content_banner_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '轮播图';
-- 8：友情链接
DROP TABLE IF EXISTS `system_link`;
CREATE TABLE `system_link`
(
  `id`          int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `link_name`   varchar(255)     NOT NULL COMMENT '友情链接名称',
  `link_url`    varchar(255)     NOT NULL COMMENT '友情链接地址',
  `add_time`    datetime(0)      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录数据的添加时间',
  `update_time` timestamp(0)     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录数据的更新时间',
  `del_time`    int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数据删除标记，0表示数据未删除，>0表示数据被删除，记录的是数据删除的时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `system_link_add_time` (`add_time`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '友情链接';

-- changed AT 2021-10-29
-- 修改模板引擎数据表
ALTER TABLE `system_template` ADD COLUMN `template_type` varchar(255)  NOT NULL DEFAULT 'default' COMMENT '模板分类名称' AFTER `id`;
ALTER TABLE `system_template` ADD COLUMN `template_dir` varchar(255)  NOT NULL DEFAULT 'default' COMMENT '模板文件存储的上级目录' AFTER `template_name`;
ALTER TABLE `system_template` CHANGE `template_file` `template_file`  varchar(255) NOT NULL COMMENT '模板存放的物理名称';
ALTER TABLE `content_page` CHANGE `page_content` `page_content`  longtext DEFAULT NULL COMMENT '详情内容';
-- changed AT 2021-11-2
ALTER TABLE `content_page`CHANGE `page_click` `page_click`int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章的点击次数';
ALTER TABLE `content_type`CHANGE `type_click` `type_click`int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章分类的点击次数';