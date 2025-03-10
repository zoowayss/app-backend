/*
 Navicat Premium Dump SQL

 Source Server         : aliyun-self
 Source Server Type    : MySQL
 Source Server Version : 80021 (8.0.21)
 Source Host           : aliyun.zoowayss.top:3306
 Source Schema         : temp

 Target Server Type    : MySQL
 Target Server Version : 80021 (8.0.21)
 File Encoding         : 65001

 Date: 06/01/2025 14:27:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `id`                 bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户UID，自增',
                          `nickname`           varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '用户昵称',
                          `account`            varchar(150) COLLATE utf8mb4_unicode_ci                       NOT NULL DEFAULT '' COMMENT '用户账号',
                          `email`              varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户邮箱',
                          `password`           varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户密码',
                          `last_login_time`    bigint unsigned NOT NULL DEFAULT '0' COMMENT '最近登录时间',
                          `last_login_ip`      varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '最近登录IP',
                          `avatar`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户头像地址',
                          `google_user_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '谷歌用户的唯一uid',
                          `google_connected`   tinyint(1) NOT NULL DEFAULT '0' COMMENT '谷歌是否绑定了，0 没有，1 绑定了',
                          `device`             varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '用户注册时的设备，android/ios',
                          `did`                varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备唯一编号',
                          `facebook_user_id`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT 'Facebook user id',
                          `facebook_connected` tinyint                                                       NOT NULL DEFAULT '0' COMMENT 'Facebook 是否绑定，0 没有 1 绑定了',
                          `level`              int                                                           NOT NULL DEFAULT '0' COMMENT '会员等级',
                          `sub_start_time`     bigint                                                        NOT NULL DEFAULT '0' COMMENT '连续订阅的开始时间',
                          `sub_expire_time`    bigint                                                        NOT NULL DEFAULT '0' COMMENT '用户订阅过期时间',
                          `deleted`            tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：未删除，1：已删除',
                          `create_time`        bigint unsigned NOT NULL DEFAULT '0' COMMENT '用户创建时间，毫秒',
                          `update_time`        bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新时间，毫秒',
                          PRIMARY KEY (`id`) USING BTREE,
                          KEY                  `idx_google_user_id` (`google_user_id`) USING BTREE,
                          KEY                  `idx_facebook_user_id` (`facebook_user_id`) USING BTREE,
                          KEY                  `idx_email` (`facebook_user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表'

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`id`, `nickname`, `email`, `password`, `last_login_time`, `last_login_ip`, `avatar`, `google_user_id`, `google_connected`, `device`, `did`, `facebook_user_id`, `facebook_connected`, `level`, `sub_start_time`, `sub_expire_time`, `deleted`, `create_time`, `update_time`) VALUES (1, '', 'zoowayss@c.cccc', '59cfa92740c7276581023b76d7709cc6', 1736136943472, '0:0:0:0:0:0:0:1', '', '', 0, 'ios', 'xxdid', '', 0, 0, 0, 0, 0, 1736136943475, 1736136943475);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
