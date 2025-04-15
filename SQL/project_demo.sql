/*
 Navicat Premium Data Transfer

 Source Server         : localhost8
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : project_demo

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 15/04/2025 21:47:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单编码',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户ID',
  `amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
  `status` tinyint(0) NOT NULL COMMENT '订单状态码',
  `create_date` datetime(0) NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders
-- ----------------------------

-- ----------------------------
-- Table structure for t_orders_1
-- ----------------------------
DROP TABLE IF EXISTS `t_orders_1`;
CREATE TABLE `t_orders_1`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单编码',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户ID',
  `amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
  `status` tinyint(0) NOT NULL COMMENT '订单状态码',
  `create_date` datetime(0) NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders_1
-- ----------------------------

-- ----------------------------
-- Table structure for t_orders_2
-- ----------------------------
DROP TABLE IF EXISTS `t_orders_2`;
CREATE TABLE `t_orders_2`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单编码',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户ID',
  `amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
  `status` tinyint(0) NOT NULL COMMENT '订单状态码',
  `create_date` datetime(0) NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders_2
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
