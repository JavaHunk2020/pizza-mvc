/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-28 14:01:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `movie_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `movie_tbl`;
CREATE TABLE `movie_tbl` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `budget` bigint(20) DEFAULT NULL,
  `teams` int(11) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of movie_tbl
-- ----------------------------
INSERT INTO `movie_tbl` VALUES ('1', 'HERO', '2010', '4', '200', '44', '2020-05-06 09:50:39');
INSERT INTO `movie_tbl` VALUES ('2', 'Danger', '2020', '6', '838383', '8', '2020-05-06 10:17:13');
INSERT INTO `movie_tbl` VALUES ('4', 'Nagendra', '2012', '4', '5', '2', '2020-05-09 10:19:49');
INSERT INTO `movie_tbl` VALUES ('5', 'Oeppe', '1221', '23', '1323', '2', '2020-05-11 09:32:28');

-- ----------------------------
-- Table structure for `signup_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `signup_tbl`;
CREATE TABLE `signup_tbl` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `salutation` varchar(5) DEFAULT NULL,
  `datecreated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `role` varchar(40) DEFAULT 'customer',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of signup_tbl
-- ----------------------------
INSERT INTO `signup_tbl` VALUES ('8', 'nagen@gmail.com', 'test', 'nagenqwe@gmail.com', 'Nagendra324', 'Mr', '2020-05-28 14:00:54', 'admin');
