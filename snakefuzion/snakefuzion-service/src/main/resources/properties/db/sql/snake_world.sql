/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : snake_world

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-06-29 11:19:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sf_user
-- ----------------------------
DROP TABLE IF EXISTS `sf_user`;
CREATE TABLE `sf_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(50) NOT NULL,
  `userPwd` varchar(255) NOT NULL,
  `userNickName` varchar(100) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
