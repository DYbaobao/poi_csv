/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-15 17:16:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '包', '2');
INSERT INTO `user` VALUES ('2', '你', '4');
INSERT INTO `user` VALUES ('3', '满', '57');
INSERT INTO `user` VALUES ('4', '意', '54');
INSERT INTO `user` VALUES ('5', 'x下', '54');
INSERT INTO `user` VALUES ('6', '你好', '45');
INSERT INTO `user` VALUES ('7', '手机', '44');
INSERT INTO `user` VALUES ('8', '那你', '56');
INSERT INTO `user` VALUES ('9', '深V深V', '44');
INSERT INTO `user` VALUES ('10', '', null);
