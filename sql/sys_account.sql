/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : springboot-api-demo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-05 15:57:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `account_id` varchar(40) NOT NULL,
  `account_no` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES ('1', 'admin', '123456', '1');
INSERT INTO `sys_account` VALUES ('2', 'root', '123456', '1');
INSERT INTO `sys_account` VALUES ('3', 'guest', 'guest', '2');
INSERT INTO `sys_account` VALUES ('5', 'test', '123456', '2');
INSERT INTO `sys_account` VALUES ('8', 'roott', '123456', null);
