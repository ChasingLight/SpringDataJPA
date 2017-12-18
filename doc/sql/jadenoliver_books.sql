/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : jadenoliver_books

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-12-18 10:03:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='????ͼ???;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'C语言', '邢华阳', '12', '这个学习的第一本书', null, '2017-12-15 15:50:53');
INSERT INTO `books` VALUES ('2', '数据库结构333', 'jaden', '20', '测试更新记录333', '2017-03-15 00:00:00', '2017-03-21 15:28:52');
INSERT INTO `books` VALUES ('3', '穆斯林的葬礼', '王振', '30', '非常棒的一本书', '2017-03-16 00:00:00', null);
INSERT INTO `books` VALUES ('5', '鬼吹灯', 'jaden', '501', '非常刺激的一本书1', null, '2017-12-15 17:40:13');
INSERT INTO `books` VALUES ('6', '发丘秘术', 'jaden', '50', '非常玄幻的一本书', '2017-03-21 15:28:08', null);
INSERT INTO `books` VALUES ('7', '聊斋志异', '蒲松龄', '20', '玄幻奇妙的书籍', '2017-03-22 11:16:10', null);
INSERT INTO `books` VALUES ('8', '代码优化之道', 'jaden', '20', '提高代码的品质', '2017-03-22 11:26:01', null);
INSERT INTO `books` VALUES ('9', '111', '111', '23', '1111', '2017-03-22 11:28:21', null);
INSERT INTO `books` VALUES ('10', '靳浩东传记', '靳浩东', '23', '靳浩东的描述信息', '2017-03-22 11:28:44', null);
INSERT INTO `books` VALUES ('11', '天才疯子', '心理学家', '29', '靳浩东很喜欢', '2017-12-15 10:24:11', null);
INSERT INTO `books` VALUES ('12', '道德经', '老子', '29', '道家传统经典名著，有很多经典名句：“上善若水”“大器晚成”等。', '2017-12-15 10:36:24', null);
INSERT INTO `books` VALUES ('13', '心经', '释迦摩尼', '29', '大智慧', '2017-12-15 10:53:34', null);
INSERT INTO `books` VALUES ('14', '法华经', '释迦摩尼', '29', '成佛的法华经', '2017-12-15 10:57:37', null);
INSERT INTO `books` VALUES ('15', '平凡世界', 'jaden', '22', '每个人都有自己的生活', '2017-12-15 11:04:24', null);
INSERT INTO `books` VALUES ('16', '梦想', '来自', '20', '你我', '2017-12-15 11:16:50', null);
INSERT INTO `books` VALUES ('17', '天津', '打', '12', '辣豆腐', '2017-12-15 11:31:01', null);
INSERT INTO `books` VALUES ('18', '如何饲养猪', 'jaden', '11', '教授如何养殖猪', '2017-12-15 11:32:19', null);
INSERT INTO `books` VALUES ('19', '天才疯子2', '心理学家', '29', '第二版', '2017-12-15 11:45:51', null);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `C_ID` varchar(20) NOT NULL,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_REMARK` varchar(50) DEFAULT NULL,
  `C_GRADE` decimal(10,0) DEFAULT NULL,
  `C_TIME` datetime DEFAULT NULL,
  `U_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1701', '商务礼仪', '介绍商务相关的礼仪规则', '100', '2017-07-05 18:24:49', '2017-07-05 18:24:51');
INSERT INTO `course` VALUES ('1702', '太极养生', '介绍中国传统的知识，太极', '80', '2017-07-05 18:25:25', '2017-07-05 18:25:27');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `STU_ID` int(20) NOT NULL AUTO_INCREMENT,
  `STU_NAME` varchar(30) DEFAULT NULL,
  `GENDER` int(11) DEFAULT NULL,
  `T_ID` varchar(20) DEFAULT NULL COMMENT '班主任教师工号',
  `CLASS_NAME` varchar(20) DEFAULT NULL,
  `C_TIME` datetime DEFAULT NULL,
  `U_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`STU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('104', '靳浩东', '1', '666', '计科1201', '2017-07-05 18:23:56', '2017-07-05 18:23:58');
INSERT INTO `student` VALUES ('105', '陈龙基', '1', '666', '计科1201', '2017-07-05 18:28:25', '2017-07-05 18:28:28');
INSERT INTO `student` VALUES ('117', '鸣人', '1', '674', '卡卡西班级', '2017-07-12 16:06:09', null);
INSERT INTO `student` VALUES ('118', '小樱', '0', '674', '卡卡西班级', '2017-07-12 16:06:09', null);

-- ----------------------------
-- Table structure for student_extra_info
-- ----------------------------
DROP TABLE IF EXISTS `student_extra_info`;
CREATE TABLE `student_extra_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `STU_ID` int(20) DEFAULT NULL,
  `EXTRA_INFO` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_extra_info
-- ----------------------------
INSERT INTO `student_extra_info` VALUES ('3', '117', '鸣人额外信息：鸣人坚韧不拔，拥有火之意志');

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STU_ID` varchar(20) DEFAULT NULL,
  `C_ID` varchar(20) DEFAULT NULL,
  `GRADE` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES ('1', '104', '1701', '99');
INSERT INTO `stu_course` VALUES ('2', '104', '1702', '79');
INSERT INTO `stu_course` VALUES ('3', '105', '1701', '98');
INSERT INTO `stu_course` VALUES ('4', '105', '1702', '78');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `T_ID` int(20) NOT NULL AUTO_INCREMENT,
  `T_NAME` varchar(20) DEFAULT NULL,
  `T_GENDER` int(11) DEFAULT NULL,
  `T_AGE` int(11) DEFAULT NULL,
  `T_SUBJECT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=675 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('666', '李创军', '1', '34', '语文,政治');
INSERT INTO `teacher` VALUES ('674', '卡卡西老师', '1', '23', '忍术、生活道理');
