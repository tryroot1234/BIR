/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-08 20:59:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('9999', 'admin', 'admin');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `category` set('S','E','W','L','O') NOT NULL DEFAULT 'O',
  `author` varchar(20) NOT NULL,
  `discount` decimal(2,1) NOT NULL,
  `price` double(10,2) NOT NULL,
  `amount` int(11) NOT NULL,
  `profile` varchar(200) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='S(科学);E(教育);W(文学);L(生活);O(其它)';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '面向对象的核心逻辑', 'S,E,W', '刘晟', '0.9', '65.80', '1200', '开发Java应用程序核心逻辑');
INSERT INTO `book` VALUES ('2', 'JavaSE高级应用程序', 'S,E', '冉子乔', '0.9', '86.70', '900', '开发JavaSE应用程序');
