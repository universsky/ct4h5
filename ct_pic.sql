/*
Navicat MySQL Data Transfer

Source Server         : etaotest
Source Server Version : 50616
Source Host           : 10.125.1.58:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-05-27 18:11:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ct_pic`
-- ----------------------------
DROP TABLE IF EXISTS `ct_pic`;
CREATE TABLE `ct_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `run_stamp` varchar(15) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `img_name` varchar(1000) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `img_timestamp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9018 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of ct_pic
-- ----------------------------
INSERT INTO ct_pic VALUES ('9010', '20140527055026', '0123456789ABCDEF', '20140527055026$0123456789ABCDEF$20140527055046$httpdaily.m.admin.search.taobao.comh5q=E69CBAE7A5A8_20140527055046.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9C%BA%E7%A5%A8', '20140527055046');
INSERT INTO ct_pic VALUES ('9011', '20140527055026', '4d0069c2b2e0901d', '20140527055026$4d0069c2b2e0901d$20140527055059$httpdaily.m.admin.search.taobao.comh5q=E69CBAE7A5A8_20140527055059.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9C%BA%E7%A5%A8', '20140527055059');
INSERT INTO ct_pic VALUES ('9012', '20140527055026', '4d004077b4369049', '20140527055026$4d004077b4369049$20140527055059$httpdaily.m.admin.search.taobao.comh5q=E69CBAE7A5A8_20140527055059.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9C%BA%E7%A5%A8', '20140527055059');
INSERT INTO ct_pic VALUES ('9013', '20140527055026', '351BBHJN6LVP', '20140527055026$351BBHJN6LVP$20140527055100$httpdaily.m.admin.search.taobao.comh5q=E69CBAE7A5A8_20140527055100.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9C%BA%E7%A5%A8', '20140527055100');
INSERT INTO ct_pic VALUES ('9014', '20140527055026', '0123456789ABCDEF', '20140527055026$0123456789ABCDEF$20140527055106$httpdaily.m.admin.search.taobao.comh5q=E69D8EE5AE81_20140527055106.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9D%8E%E5%AE%81', '20140527055106');
INSERT INTO ct_pic VALUES ('9015', '20140527055026', '4d0069c2b2e0901d', '20140527055026$4d0069c2b2e0901d$20140527055119$httpdaily.m.admin.search.taobao.comh5q=E69D8EE5AE81_20140527055119.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9D%8E%E5%AE%81', '20140527055119');
INSERT INTO ct_pic VALUES ('9016', '20140527055026', '4d004077b4369049', '20140527055026$4d004077b4369049$20140527055120$httpdaily.m.admin.search.taobao.comh5q=E69D8EE5AE81_20140527055120.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9D%8E%E5%AE%81', '20140527055120');
INSERT INTO ct_pic VALUES ('9017', '20140527055026', '351BBHJN6LVP', '20140527055026$351BBHJN6LVP$20140527055129$httpdaily.m.admin.search.taobao.comh5q=E69D8EE5AE81_20140527055129.jpeg', 'http://daily.m.admin.search.taobao.com/h5?q=%E6%9D%8E%E5%AE%81', '20140527055129');
