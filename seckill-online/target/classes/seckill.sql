/*
Navicat MySQL Data Transfer

Source Server         : 192.168.88.150
Source Server Version : 50633
Source Host           : 192.168.88.150:3306
Source Database       : seckill

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-12-29 15:37:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depot
-- ----------------------------
DROP TABLE IF EXISTS `depot`;
CREATE TABLE `depot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(80) NOT NULL COMMENT '仓库名称',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库表';

-- ----------------------------
-- Records of depot
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(150) NOT NULL COMMENT '订单号',
  `product_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `goods_price` decimal(10,2) NOT NULL COMMENT '订单价格',
  `g_num` int(11) NOT NULL COMMENT '数量',
  `create_on` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(80) NOT NULL COMMENT '会员名称',
  PRIMARY KEY (`id`),
  KEY `member_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `p_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `p_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`),
  KEY `product_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `depot_id` int(11) NOT NULL COMMENT '仓库id',
  `s_price` decimal(10,2) NOT NULL COMMENT '商品总价',
  `s_num` int(11) NOT NULL COMMENT '总数量',
  PRIMARY KEY (`id`),
  KEY `d_s_id` (`product_id`,`depot_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

-- ----------------------------
-- Records of stock
-- ----------------------------
