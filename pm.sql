/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : pm

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2018-12-21 10:32:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `startTime` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `introduction` varchar(2550) DEFAULT NULL,
  `note` varchar(2550) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_project
-- ----------------------------
INSERT INTO `tb_project` VALUES ('5', '图书管理系统', '2018-12-16', '杜小霖军辉', '管理图书的增删看', null);
INSERT INTO `tb_project` VALUES ('6', '仓库管理功能', '2018-12-17', '刘大辉', '仓库货物的crud', null);
INSERT INTO `tb_project` VALUES ('19', '电子商城系统', '2018-12-21', '不知道', '不知道', null);
INSERT INTO `tb_project` VALUES ('20', '影院管理系统', '2012-07-20', '徐小红', '此用户很懒，什么都没有留下', null);
INSERT INTO `tb_project` VALUES ('22', '哒哒哒哒哒哒', '2018-12-18', '小名2', '啦啦啦啦啦', null);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('12', '111', '123');
INSERT INTO `tb_user` VALUES ('13', '456', '456');
INSERT INTO `tb_user` VALUES ('14', '789', '789');
INSERT INTO `tb_user` VALUES ('16', '军辉', '123');
INSERT INTO `tb_user` VALUES ('20', '1231', '23');
INSERT INTO `tb_user` VALUES ('21', '徐小红', '789');
INSERT INTO `tb_user` VALUES ('22', '123', '123456');
INSERT INTO `tb_user` VALUES ('23', '杜小林', '123');
INSERT INTO `tb_user` VALUES ('25', '刘', '465');
INSERT INTO `tb_user` VALUES ('26', '321', '321');
