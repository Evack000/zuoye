/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : xmgl

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-05-20 23:48:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `courseName` varchar(30) DEFAULT NULL,
  `courseDetail` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`courseId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('0001', 'DataStructure', 'Data structure is a way for computers to store and organize data. Data structure refers to the collection of data elements that have one or more specific relationships with each other. In general, carefully selected data structure can bring higher operation or storage efficiency. Data structure is often related to efficient retrieval algorithm and index technology.');
INSERT INTO `course` VALUES ('0002', 'DiscreteMathematics', 'Discrete mathematics is a branch of modern mathematics, which studies the structure of discrete quantity and its relationship with each other. It mainly studies the structure of discrete quantity and its relationship with each other. Its object is generally limited or countable elements.');

-- ----------------------------
-- Table structure for `courseregistration`
-- ----------------------------
DROP TABLE IF EXISTS `courseregistration`;
CREATE TABLE `courseregistration` (
  `userId` int(4) unsigned zerofill DEFAULT NULL,
  `courseId` int(4) unsigned zerofill DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of courseregistration
-- ----------------------------
INSERT INTO `courseregistration` VALUES ('0001', '0001');
INSERT INTO `courseregistration` VALUES ('0002', '0001');
INSERT INTO `courseregistration` VALUES ('0005', '0001');
INSERT INTO `courseregistration` VALUES ('0001', '0002');
INSERT INTO `courseregistration` VALUES ('0005', '0002');
INSERT INTO `courseregistration` VALUES ('0003', '0002');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '普通用户的url', '允许普通用户和管理员访问', '/hello/helloUser', null);
INSERT INTO `permission` VALUES ('2', '管理员的url', '允许管理员访问', '/hello/helloAdmin', null);
INSERT INTO `permission` VALUES ('3', '普通用户的url', '允许普通用户和管理员访问', '/index', null);
INSERT INTO `permission` VALUES ('4', '普通用户的url', '允许普通用户和管理员访问', '/', null);
INSERT INTO `permission` VALUES ('5', '普通用户的url', '允许普通用户和管理员访问', '/api/users', null);

-- ----------------------------
-- Table structure for `relation_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `relation_role_permission`;
CREATE TABLE `relation_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation_role_permission
-- ----------------------------
INSERT INTO `relation_role_permission` VALUES ('1', '1', '2');
INSERT INTO `relation_role_permission` VALUES ('2', '2', '1');
INSERT INTO `relation_role_permission` VALUES ('3', '2', '3');
INSERT INTO `relation_role_permission` VALUES ('4', '2', '4');
INSERT INTO `relation_role_permission` VALUES ('5', '1', '3');
INSERT INTO `relation_role_permission` VALUES ('6', '1', '1');
INSERT INTO `relation_role_permission` VALUES ('7', '1', '4');
INSERT INTO `relation_role_permission` VALUES ('8', '1', '5');
INSERT INTO `relation_role_permission` VALUES ('9', '2', '5');

-- ----------------------------
-- Table structure for `relation_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `relation_user_role`;
CREATE TABLE `relation_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_rid` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation_user_role
-- ----------------------------
INSERT INTO `relation_user_role` VALUES ('1', '1', '1');
INSERT INTO `relation_user_role` VALUES ('2', '2', '1');
INSERT INTO `relation_user_role` VALUES ('3', '5', '1');
INSERT INTO `relation_user_role` VALUES ('4', '3', '2');
INSERT INTO `relation_user_role` VALUES ('5', '4', '2');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'p1', '管理员');
INSERT INTO `role` VALUES ('2', 'p2', '普通用户');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPwd` varchar(255) DEFAULT NULL,
  `profileName` varchar(30) DEFAULT NULL,
  `userPromission` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0001', 'rx78', '0079', 'AmuroRay', 'p1');
INSERT INTO `user` VALUES ('0002', 'msz006z', '0088', 'KamilleBidan', 'p1');
INSERT INTO `user` VALUES ('0003', 'rx78gp01', '0083', 'KouUraki', 'p2');
INSERT INTO `user` VALUES ('0004', 'msn100', '0087', 'QuattroBajeena', 'p2');
INSERT INTO `user` VALUES ('0005', 'msn04', '0093', 'CharAznable', 'p1');
DROP TRIGGER IF EXISTS `insertPermission`;
DELIMITER ;;
CREATE TRIGGER `insertPermission` AFTER INSERT ON `role` FOR EACH ROW insert into relation_role_permission(role_id,permission_id) values(new.id,1)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deletePermission`;
DELIMITER ;;
CREATE TRIGGER `deletePermission` AFTER DELETE ON `role` FOR EACH ROW DELETE FROM  relation_role_permission where role_id = old.id
;;
DELIMITER ;
