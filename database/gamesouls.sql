/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : gamesouls

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2020-04-19 13:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `text` longtext,
  `cover` varchar(255) DEFAULT NULL,
  `heart` int(11) DEFAULT '0',
  `collect` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `username` (`username`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid1` int(11) NOT NULL,
  `userid2` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `text` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid4` (`userid1`),
  CONSTRAINT `userid4` FOREIGN KEY (`userid1`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for check
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `workid` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `text` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `workid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid1` (`userid`),
  CONSTRAINT `userid1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `text` varchar(500) DEFAULT NULL,
  `workid` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid2` (`userid`),
  CONSTRAINT `userid2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `collect` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid3` (`userid`),
  KEY `username1` (`username`),
  CONSTRAINT `userid3` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  `image` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid5` (`userid`),
  KEY `username2` (`username`),
  CONSTRAINT `userid5` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `useravatar` varchar(255) DEFAULT NULL,
  `usertext` varchar(100) DEFAULT NULL,
  `followid` int(11) NOT NULL,
  `followavatar` varchar(255) DEFAULT NULL,
  `followtext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for index
-- ----------------------------
DROP TABLE IF EXISTS `index`;
CREATE TABLE `index` (
  `id` int(11) NOT NULL,
  `text` varchar(100) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `image` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid1` int(11) NOT NULL,
  `userid2` int(11) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `workid` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `read` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `text` longtext,
  `cover` varchar(0) DEFAULT NULL,
  `heart` int(11) DEFAULT '0',
  `collect` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid10` (`userid`),
  KEY `username6` (`username`),
  CONSTRAINT `userid10` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username6` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `avatar` varchar(500) DEFAULT NULL,
  `workid` int(11) NOT NULL,
  `text` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid13` (`userid`),
  KEY `username7` (`username`),
  CONSTRAINT `userid13` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username7` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reportid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `type` varchar(4) NOT NULL COMMENT '资讯，文章，评测，攻略，论坛，用户',
  PRIMARY KEY (`id`),
  KEY `userid6` (`userid`),
  KEY `username3` (`username`),
  CONSTRAINT `userid6` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username3` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `game` varchar(50) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `cover` varchar(0) DEFAULT NULL,
  `heart` int(11) DEFAULT '0',
  `collect` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid7` (`userid`),
  KEY `username4` (`username`),
  CONSTRAINT `userid7` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username4` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for search
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `search` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid8` (`userid`),
  CONSTRAINT `userid8` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avatar` varchar(1000) DEFAULT NULL,
  `background` varchar(1000) DEFAULT NULL,
  `power` int(11) NOT NULL DEFAULT '3',
  `heart` int(11) DEFAULT '0',
  `exp` int(11) DEFAULT '0',
  `gametype` varchar(255) DEFAULT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  `follow` int(11) DEFAULT '0',
  `follower` int(11) DEFAULT '0',
  `publish` int(11) DEFAULT '0',
  PRIMARY KEY (`id`,`username`),
  KEY `id` (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for walkthrough
-- ----------------------------
DROP TABLE IF EXISTS `walkthrough`;
CREATE TABLE `walkthrough` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `text` longtext,
  `cover` varchar(1000) DEFAULT NULL,
  `heart` int(11) DEFAULT '0',
  `collect` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid9` (`userid`),
  KEY `username5` (`username`),
  CONSTRAINT `userid9` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username5` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
