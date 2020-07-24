/*
Navicat MySQL Data Transfer

Source Server         : 49.235.15.188
Source Server Version : 80017
Source Host           : 49.235.15.188:3306
Source Database       : wechatapi

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-04-21 14:58:49
*/

create database wechatapi;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechatapi_event
-- ----------------------------
DROP TABLE IF EXISTS `wechatapi_event`;
CREATE TABLE `wechatapi_event` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatapi_event
-- ----------------------------
INSERT INTO `wechatapi_event` VALUES ('17', 'oroIa49LM14cow2g279pucO9_4rY', '2020-04-22 6:00', '日程提醒');
INSERT INTO `wechatapi_event` VALUES ('20', 'oroIa49LM14cow2g279pucO9_4rY', '2020-04-22 6:00', '日程提醒');
INSERT INTO `wechatapi_event` VALUES ('30', 'oroIa49LM14cow2g279pucO9_4rY', '2020-04-22 6:00', '日程提醒');
INSERT INTO `wechatapi_event` VALUES ('31', 'oroIa49LM14cow2g279pucO9_4rY', '2020-04-24 6:00', '提醒我');
