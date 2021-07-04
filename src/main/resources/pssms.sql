/*
 Navicat Premium Data Transfer

 Source Server         : MySQLone
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : pssms

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/07/2021 23:49:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quantity` int(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '华为手机', 47, '北京', 9888.00);
INSERT INTO `product` VALUES (2, '华为路由器', 50, '上海', 6998.00);
INSERT INTO `product` VALUES (3, '华为电脑', 21, '武汉', 5999.00);
INSERT INTO `product` VALUES (8, '小米手机', 32, '长沙', 2999.00);

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `count` int(0) NULL DEFAULT NULL,
  `totalPrice` decimal(10, 2) NULL DEFAULT NULL,
  `saleDate` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` int(0) NULL DEFAULT NULL,
  `productId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES (1, 33, 326304.00, '2021-01-23', 1, 1);
INSERT INTO `sale` VALUES (2, 21, 146958.00, '2021-01-23', 2, 2);
INSERT INTO `sale` VALUES (3, 21, 125979.00, '2021-03-01', 3, 3);
INSERT INTO `sale` VALUES (12, 5, 14995.00, '2021-07-12', 12, 8);
INSERT INTO `sale` VALUES (13, 9, 88992.00, '2021-07-15', 2, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '曹明康');
INSERT INTO `user` VALUES (2, 'admin321', '123456', '王大妈');
INSERT INTO `user` VALUES (3, 'adminds', '3123412', '李明');
INSERT INTO `user` VALUES (11, 'admin122', '123123', '张三');
INSERT INTO `user` VALUES (12, 'admin21', '123456', '王二麻子');

SET FOREIGN_KEY_CHECKS = 1;
