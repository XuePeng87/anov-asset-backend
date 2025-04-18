-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: localhost    Database: anov-assets
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asset_category`
--

DROP TABLE IF EXISTS `asset_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `sequence` int NOT NULL DEFAULT '100' COMMENT '排序',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_category`
--

LOCK TABLES `asset_category` WRITE;
/*!40000 ALTER TABLE `asset_category` DISABLE KEYS */;
INSERT INTO `asset_category` VALUES (1,'cf7e6b78408d4003b4294136d89b569f','笔记本电脑',1,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:10:23','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:33:07'),(2,'8ece26c710f74526881d7c7bbdb4c5b6','显示器',2,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:21','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:21'),(3,'d9d3c02372914be799bf083741d57997','鼠标',3,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:34','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:40'),(4,'fc848d3804c74a7b843dbb003e115456','配件',4,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:48','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:50:48'),(5,'933e7feab1cc478a9339e361262a9906','麦克风',5,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:08','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:26'),(6,'0c4f8eff06184cd3abd00bb3f4991ff8','音响',6,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:22','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:44'),(7,'9b7c25eb96d44f60bbadf46c7915b524','摄像头',7,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:52','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:52:05'),(8,'a8a03a81403d4b62bf359f067c91e282','一体机',8,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:51:58','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:52:10'),(9,'812ff095ff314e0f9da3ff2e7b045afe','键盘',9,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:52:29','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:52:29'),(10,'44e9cdb2356f4c68a420c5e8eaf3ffba','激光雷达',10,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:54:40','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:54:40'),(11,'435a36c8cd124aecb7573e672463e0e2','3D打印机',11,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:54:51','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:54:51'),(12,'ba8d8c2897d34aae98bae9dd3220317b','移动硬盘',12,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:01','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:01'),(13,'2a1b9d75743c4a9abbc16ba3dcbc4e9c','平板电脑',13,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:12','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:12'),(14,'4ba99d135d0a4580911de14816cf1ea1','耳机',14,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:19','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:19'),(15,'c2d7ef2f2cfd436abd34232d3610b0fb','显卡拓展坞',15,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:54','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:55:54'),(16,'95cfb6331e3042ae998300e03497ff81','扩展坞',16,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:01','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:01'),(17,'eae934476c4a484a943742b81ac44418','数据线',17,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:10','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:10'),(18,'92f41a0967bf48918005d6bb3186fc06','显卡',18,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:27','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:27'),(19,'2449c1621e09455588cfc5b47bbe972a','相机',19,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:40','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:40'),(20,'c83dd2db6f4141c6bcf97dc2a33b8b77','穿戴设备',20,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:49','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:56:49'),(21,'b9574245e1954b70a197efd32f4c0ae9','投影仪',21,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:57:53','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:57:53'),(22,'c5febf96ec3640d18a28024d937d8bfb','耗材',22,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:02','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:02'),(23,'83e92d071d894144a2ed0a5e8d133522','工作站',23,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:36','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:36'),(24,'76bc0e71c7164dad9ce6e70554914990','台式机',24,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:46','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:46'),(25,'2fe3afac8d904aa1b1cf431fc1772d0b','内存',25,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:52','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:58:52'),(26,'b2bf0df586cd4eeaa9802d7accca749e','服务器',26,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:00','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:00'),(27,'9fbc5b2acff545448711aa28e137112a','文件服务器',27,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:09','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:09'),(28,'5e34573d58334538bbe9fc125d21bdd1','固态硬盘',28,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:17','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:17'),(29,'d131f90be8ac4ca6a2cc34c178e2af12','机械硬盘',29,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:25','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:25'),(30,'c4e1b265e3944b9f9c0837b62c2491d9','无人机',30,0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:37','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 07:59:37');
/*!40000 ALTER TABLE `asset_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_info`
--

DROP TABLE IF EXISTS `asset_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资产分类',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `brand` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌',
  `model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '型号',
  `specification` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0=在库；1=使用；2=维修；3=报废',
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '存放位置',
  `purchase_year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '采购年份',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '设备金额',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_info`
--

LOCK TABLES `asset_info` WRITE;
/*!40000 ALTER TABLE `asset_info` DISABLE KEYS */;
INSERT INTO `asset_info` VALUES (1,'cf7e6b78408d4003b4294136d89b569f','e7f570e3f2d5427b9516f0f25ac1ff2f','苹果笔记本','Apple','M1 Pro','MacBook Pro | 16英寸 | M1 Pro | 16G | 512G',1,'4楼柜子','2021',18999.00,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-16 02:23:02','2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:14:01');
/*!40000 ALTER TABLE `asset_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_loan`
--

DROP TABLE IF EXISTS `asset_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_loan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `asset_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资产编号',
  `user_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '领用人编号',
  `loan_date` date NOT NULL COMMENT '领用日期',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0=领用；1=归还',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产领用表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_loan`
--

LOCK TABLES `asset_loan` WRITE;
/*!40000 ALTER TABLE `asset_loan` DISABLE KEYS */;
INSERT INTO `asset_loan` VALUES (1,'bd2e8595f6c045a9aa5df0d41b7e6c47','e7f570e3f2d5427b9516f0f25ac1ff2f','2bd631f674af40f19c73c0d8962a4d28','2025-04-17',0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 06:54:18','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 06:54:18'),(2,'e40890e215304dcd83b4f36e9f4f3e0c','e7f570e3f2d5427b9516f0f25ac1ff2f','2bd631f674af40f19c73c0d8962a4d28','2025-04-17',0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:44:05','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:44:18'),(3,'7d59a5eb723441d2ac97dff3dc95fe35','e7f570e3f2d5427b9516f0f25ac1ff2f','2bd631f674af40f19c73c0d8962a4d28','2025-04-17',0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:52:01','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:52:01'),(4,'1d83a5c988b74082a86e84d96fb72d41','e7f570e3f2d5427b9516f0f25ac1ff2f','2bd631f674af40f19c73c0d8962a4d28','2025-04-17',0,0,'','','2025-04-17 08:52:08','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:52:08'),(5,'0a02167613994f24bb3de6794809f194','e7f570e3f2d5427b9516f0f25ac1ff2f','bd385b2b16e64aba89e46a668901fbe8','2025-04-18',0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:14:01','2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:14:01');
/*!40000 ALTER TABLE `asset_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_repair`
--

DROP TABLE IF EXISTS `asset_repair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_repair` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `asset_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备编号',
  `start_date` date NOT NULL COMMENT '报修时间',
  `company` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '维修公司',
  `cost` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '维修费用',
  `fault_cause` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '问题描述',
  `status` tinyint NOT NULL COMMENT '状态：0=待维修；1=维修中；2=已完成',
  `result` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '维修结果',
  `end_date` date DEFAULT NULL COMMENT '完成时间',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产维修表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_repair`
--

LOCK TABLES `asset_repair` WRITE;
/*!40000 ALTER TABLE `asset_repair` DISABLE KEYS */;
/*!40000 ALTER TABLE `asset_repair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_scrap`
--

DROP TABLE IF EXISTS `asset_scrap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_scrap` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `asset_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备编号',
  `reason` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '报废原因',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=通过；1=驳回',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产报废表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_scrap`
--

LOCK TABLES `asset_scrap` WRITE;
/*!40000 ALTER TABLE `asset_scrap` DISABLE KEYS */;
/*!40000 ALTER TABLE `asset_scrap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_status_log`
--

DROP TABLE IF EXISTS `asset_status_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_status_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `asset_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资产编号',
  `status_from` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0=在库；1=使用；2=维修；3=报废',
  `status_to` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0=在库；1=使用；2=维修；3=报废',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资产状态变更记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_status_log`
--

LOCK TABLES `asset_status_log` WRITE;
/*!40000 ALTER TABLE `asset_status_log` DISABLE KEYS */;
INSERT INTO `asset_status_log` VALUES (6,'e7f570e3f2d5427b9516f0f25ac1ff2f',0,1,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 06:54:18'),(7,'e7f570e3f2d5427b9516f0f25ac1ff2f',1,0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:44:05'),(8,'e7f570e3f2d5427b9516f0f25ac1ff2f',0,1,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:52:01'),(9,'e7f570e3f2d5427b9516f0f25ac1ff2f',1,0,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-17 08:52:08'),(10,'e7f570e3f2d5427b9516f0f25ac1ff2f',0,1,0,'','2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:14:01');
/*!40000 ALTER TABLE `asset_status_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_auth_log`
--

DROP TABLE IF EXISTS `sys_auth_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_auth_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint NOT NULL COMMENT '日志类型：1=登录；2=登出；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `login_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录IP地址',
  `browser` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器',
  `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器版本',
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '平台',
  `os` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
  `os_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统版本',
  `engine` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎',
  `engine_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎版本',
  `exe_time` bigint NOT NULL DEFAULT '0' COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统认证日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_auth_log`
--

LOCK TABLES `sys_auth_log` WRITE;
/*!40000 ALTER TABLE `sys_auth_log` DISABLE KEYS */;
INSERT INTO `sys_auth_log` VALUES (1,1,'2025-04-07 03:10:25','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',188),(2,1,'2025-04-08 08:57:24','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',194),(3,2,'2025-04-08 08:58:04','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(4,1,'2025-04-08 08:58:50','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',192),(5,2,'2025-04-08 08:59:05','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',13),(6,1,'2025-04-08 09:04:30','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',183),(7,2,'2025-04-08 09:07:17','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(8,1,'2025-04-08 09:11:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',41),(9,2,'2025-04-15 10:08:27','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',32),(10,1,'2025-04-15 10:08:29','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',39),(11,2,'2025-04-15 10:11:36','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',3),(12,1,'2025-04-15 10:11:40','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',21),(13,1,'2025-04-16 10:21:27','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',216),(14,1,'2025-04-16 11:47:59','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',173),(15,1,'2025-04-18 01:13:39','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',57),(16,2,'2025-04-18 01:39:36','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(17,1,'2025-04-18 01:39:38','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',22);
/*!40000 ALTER TABLE `sys_auth_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dept_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'0','6220837f5a994d11a4f5cb4833fc216a','德玛西亚',1,0,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-28 07:18:51','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:56:51'),(2,'6220837f5a994d11a4f5cb4833fc216a','4baaf0e7b8384147ab1309f5f12d8294','研发部',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:22:02','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:22:02'),(3,'6220837f5a994d11a4f5cb4833fc216a','66ec739c41644db9a1ef6c2f085c8370','产品部',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:57:20','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:57:20'),(4,'6220837f5a994d11a4f5cb4833fc216a','47e92a5f57114126b95fd62a46f391df','test',1,1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:04:01','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:04:04'),(5,'4baaf0e7b8384147ab1309f5f12d8294','20b16b73651541739f1a298f2b9933f3','研发一部',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:22','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:22'),(6,'4baaf0e7b8384147ab1309f5f12d8294','c31ab656ddcd4446aef40ba8eaabdea1','研发二部',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:30','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:30');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'3606a726056c4f72903493a43a62b193','性别','GENDER',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-28 06:22:59','2bd631f674af40f19c73c0d8962a4d28','2024-10-22 08:59:03'),(2,'a812a48ce14a48f38c8ddc9f5ab984af','方向','DIRECTION',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 06:39:27','bd385b2b16e64aba89e46a668901fbe8','2025-01-07 08:21:27'),(3,'bc14496899be4d61a4314ff0025c672e','测试1','TEST1',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:11:41','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(4,'223e8c29d02e43b78be25a93f99f593e','测试2','TEST2',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:54:14','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(5,'77b64a60db80486f8238d1e492e02daf','测试3','TEST3',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:55:50','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(6,'5bd0023525cd4b03b7ba6290be3d4a36','测试4','TEST4',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:55:59','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(7,'2f1a03b292b9402287454c9a12c18d09','测试5','TEST5',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:56:04','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(8,'ec500a22f9ce46d3a18b9e87a782fdfe','测试6','TEST6',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:05:49','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(9,'c9d2372540464bd9999d1603da6008ae','测试7','TEST7',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:05:55','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(10,'06a80c6ba3614cb6803a7f7837272aa1','测试8','TEST8',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:01','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(11,'6bc10de58ba148c9af40f9e972b8fba3','测试9','TEST9',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:06','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(12,'17419b93799a42d8b23e3183eb270d2f','测试10','TEST10',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:13','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属字典',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容名称',
  `value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '100' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统字典项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

LOCK TABLES `sys_dict_item` WRITE;
/*!40000 ALTER TABLE `sys_dict_item` DISABLE KEYS */;
INSERT INTO `sys_dict_item` VALUES (2,'GENDER','50d32e1e15cf498e87dfccdefe7d9bc9','男','MALE',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 03:58:13','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:48:26'),(3,'GENDER','8c583631b761435bb6ff4c03022f4367','女','FEMALE',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:39:54','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:20'),(5,'DIRECTION','fc60415f377b4ef183675f7a964aed34','东','EAST',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36'),(6,'DIRECTION','c9ce6f8cf7e34e32a9022e24e0d402da','西','WEST',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:50:44','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:22'),(7,'DIRECTION','229eb399e9ec43b4a25b4206a94018bb','南','SOUTH',1,3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18'),(8,'DIRECTION','16505e5563fe4965846662f78e2cc6e1','北','NORTH',1,4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51');
/*!40000 ALTER TABLE `sys_dict_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_func`
--

DROP TABLE IF EXISTS `sys_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_func` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型：0=目录，1=功能；2=按钮；3=外链',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路由地址',
  `redirect` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '重定向地址',
  `linkable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否外链',
  `cacheable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否缓存',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `always_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '始终显示根菜单',
  `permission` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限',
  `component` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '组件',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_func_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_func`
--

LOCK TABLES `sys_func` WRITE;
/*!40000 ALTER TABLE `sys_func` DISABLE KEYS */;
INSERT INTO `sys_func` VALUES (1,'0','0e5580ae61f54380bbc9f473655060bc','系统管理',0,'system','/system','',0,0,1,1,'ray:system','Layout',99,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 02:40:45','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:08:41'),(2,'0e5580ae61f54380bbc9f473655060bc','6bfb7cc5de7a4d9c9b70d8563c7377ec','用户管理',1,'user','user','',0,0,1,0,'ray:system:users','system/user/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 09:22:11','2bd631f674af40f19c73c0d8962a4d28','2024-05-24 13:13:48'),(3,'0e5580ae61f54380bbc9f473655060bc','7982cdc53a124340ab7da5e3f130b419','角色管理',1,'role','role','',0,0,1,0,'ray:system:roles','system/role/index',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17'),(4,'0e5580ae61f54380bbc9f473655060bc','86132348f09a4a8299d949d12f1237b4','菜单管理',1,'menu','menu','',0,0,1,0,'ray:system:funcs','system/menu/index',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:46:02','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:56'),(5,'0e5580ae61f54380bbc9f473655060bc','9c476acf5ed34dd19a4f8037a065a669','部门管理',1,'tree','dept','',0,0,1,0,'ray:system:depts','system/dept/index',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:50','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:51:55'),(6,'0e5580ae61f54380bbc9f473655060bc','5b9a474efbc14b6e865e51cbbd16f311','字典管理',1,'dict','dict','',0,0,1,0,'ray:system:dicts','system/dict/index',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:48:49','2bd631f674af40f19c73c0d8962a4d28','2024-10-08 06:18:09'),(7,'0e5580ae61f54380bbc9f473655060bc','76ed9e00ddcc4e58a60a8b86ebc5bbc6','日志管理',1,'document','log','',0,1,1,0,'ray:system:logs','system/log/index',7,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-30 03:29:58','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 10:41:49'),(8,'5b9a474efbc14b6e865e51cbbd16f311','cf7068d9d6d84afcb4a59b803e1e1a2f','创建字典',2,'','','',0,0,0,0,'ray:system:dicts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:18','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:07'),(9,'5b9a474efbc14b6e865e51cbbd16f311','97d0150bf2ec45fbbf14cc3c6e0f5d14','搜索字典',2,'','','',0,0,0,0,'ray:system:dicts:search','',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:57','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:53'),(10,'5b9a474efbc14b6e865e51cbbd16f311','0bd07cc721d94942bc1001ccd1fe9e14','编辑字典',2,'','','',0,0,0,0,'ray:system:dicts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:23','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:10'),(11,'5b9a474efbc14b6e865e51cbbd16f311','fb05ae0889da4e089c09a987e2e1673c','删除字典',2,'','','',0,0,0,0,'ray:system:dicts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:52','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:13'),(12,'5b9a474efbc14b6e865e51cbbd16f311','c37f6402651a4dc09cd250dda79ed7fc','字典项管理',2,'','','',0,0,0,0,'ray:system:dicts:items','',5,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:26:29','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:56'),(13,'5b9a474efbc14b6e865e51cbbd16f311','6b7666bd1dab4e20974422295de536e2','创建字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:create','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:29:21','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:16'),(14,'5b9a474efbc14b6e865e51cbbd16f311','cb5684b760cf4fa29f1816e141b3ee10','搜索字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:search','',6,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:31:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:00'),(15,'5b9a474efbc14b6e865e51cbbd16f311','89bdd7e788e1476fb56035a8b4760e44','编辑字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:edit','',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:28','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:20'),(16,'5b9a474efbc14b6e865e51cbbd16f311','62e4f7d81aa2417db99845a4f663d419','删除字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:delete','',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:43','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:24'),(17,'6bfb7cc5de7a4d9c9b70d8563c7377ec','a69358b0070f447db2ad7c3c42297270','创建用户',2,'','','',0,0,0,0,'ray:system:users:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:50','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:18'),(18,'6bfb7cc5de7a4d9c9b70d8563c7377ec','85471b98e6e0478f916c431b93e65dad','编辑用户',2,'','','',0,0,0,0,'ray:system:users:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:22:53','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:21'),(19,'6bfb7cc5de7a4d9c9b70d8563c7377ec','4fe517c3a47a4b3e820ae812327f48cd','删除用户',2,'','','',0,0,0,0,'ray:system:users:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:07','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:26'),(20,'6bfb7cc5de7a4d9c9b70d8563c7377ec','b60ca056b2404078ac905f59caa992d2','重置密码',2,'','','',0,0,0,0,'ray:system:users:reset','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:25','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:29'),(21,'9c476acf5ed34dd19a4f8037a065a669','743f88e0ec7a4047b74d9487a8826e93','创建部门',2,'','','',0,0,0,0,'ray:system:depts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44'),(22,'9c476acf5ed34dd19a4f8037a065a669','6371d5a4b47c41fe984d8e4d960c9460','编辑部门',2,'','','',0,0,0,0,'ray:system:depts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59'),(23,'9c476acf5ed34dd19a4f8037a065a669','9b3793acfb7d485dbeee68e11524cc1d','删除部门',2,'','','',0,0,0,0,'ray:system:depts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11'),(24,'0e5580ae61f54380bbc9f473655060bc','51e96aa3fa43456eb5ff9be56ae26914','字典项管理',1,'dict','dictItem','',0,0,0,0,'ray:system:dict-items','system/dict/item',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-01 08:44:32','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 01:55:29'),(25,'0','b06c17577fda441b84e8f2299534897e','资产管理',0,'homepage','/asset','',0,0,1,0,'ray:asset','Layout',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:09:31','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:09:41'),(26,'b06c17577fda441b84e8f2299534897e','edd9fb65be7f469da3a9ad8afaa07e40','分类管理',1,'tree','/asset/category','',0,0,1,0,'ray:asset:category','asset/category/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:10:45','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:10:45'),(27,'b06c17577fda441b84e8f2299534897e','006ee3f81b9742ce84dc113854d99ada','资产维护',1,'document','/asset/info','',0,0,1,0,'ray:asset:info','asset/info/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:11:24','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 10:11:24'),(28,'b06c17577fda441b84e8f2299534897e','8fbbcd4ef86047eca4cda803b845596b','资产维修',1,'publish','repair','',0,0,0,0,'ray:asset:repair','asset/repair/index',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:36:54','2bd631f674af40f19c73c0d8962a4d28','2025-04-18 01:37:08');
/*!40000 ALTER TABLE `sys_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operate_log`
--

DROP TABLE IF EXISTS `sys_operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operate_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint NOT NULL COMMENT '日志类型：1=操作；2=错误；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `module` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称',
  `func` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能名称',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能描述',
  `action` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '动作描述',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求IP',
  `url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Url',
  `uri` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Uri',
  `method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Method',
  `class_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求类名',
  `method_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求方法名',
  `browser` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器',
  `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器版本',
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '平台',
  `os` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
  `os_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统版本',
  `engine` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎',
  `engine_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎版本',
  `exe_time` bigint NOT NULL DEFAULT '0' COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log`
--

LOCK TABLES `sys_operate_log` WRITE;
/*!40000 ALTER TABLE `sys_operate_log` DISABLE KEYS */;
INSERT INTO `sys_operate_log` VALUES (3,1,'2025-04-07 03:12:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','用户管理','修改用户','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysUserController','','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',21),(4,1,'2025-04-08 09:04:36','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','用户管理','修改用户','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysUserController','','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',46),(5,1,'2025-04-15 07:10:23','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',133),(6,1,'2025-04-15 07:27:44','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','删除类别','DELETE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','DELETE','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(7,1,'2025-04-15 07:33:07','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/cf7e6b78408d4003b4294136d89b569f','/console/v1/asset-categories/v1/cf7e6b78408d4003b4294136d89b569f','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',32),(8,1,'2025-04-15 07:50:02','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/cf7e6b78408d4003b4294136d89b569f','/console/v1/asset-categories/v1/cf7e6b78408d4003b4294136d89b569f','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',16),(9,1,'2025-04-15 07:50:21','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',16),(10,1,'2025-04-15 07:50:35','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',14),(11,1,'2025-04-15 07:50:40','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/d9d3c02372914be799bf083741d57997','/console/v1/asset-categories/v1/d9d3c02372914be799bf083741d57997','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(12,1,'2025-04-15 07:50:49','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(13,1,'2025-04-15 07:51:09','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',15),(14,1,'2025-04-15 07:51:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',14),(15,1,'2025-04-15 07:51:26','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/933e7feab1cc478a9339e361262a9906','/console/v1/asset-categories/v1/933e7feab1cc478a9339e361262a9906','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',15),(16,1,'2025-04-15 07:51:44','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/0c4f8eff06184cd3abd00bb3f4991ff8','/console/v1/asset-categories/v1/0c4f8eff06184cd3abd00bb3f4991ff8','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(17,1,'2025-04-15 07:51:52','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(18,1,'2025-04-15 07:51:59','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(19,1,'2025-04-15 07:52:05','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/9b7c25eb96d44f60bbadf46c7915b524','/console/v1/asset-categories/v1/9b7c25eb96d44f60bbadf46c7915b524','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',13),(20,1,'2025-04-15 07:52:11','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','修改类别','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1/a8a03a81403d4b62bf359f067c91e282','/console/v1/asset-categories/v1/a8a03a81403d4b62bf359f067c91e282','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',15),(21,1,'2025-04-15 07:52:30','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(22,1,'2025-04-15 07:54:41','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(23,1,'2025-04-15 07:54:51','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(24,1,'2025-04-15 07:55:02','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(25,1,'2025-04-15 07:55:12','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(26,1,'2025-04-15 07:55:19','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(27,1,'2025-04-15 07:55:54','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(28,1,'2025-04-15 07:56:01','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(29,1,'2025-04-15 07:56:10','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(30,1,'2025-04-15 07:56:27','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(31,1,'2025-04-15 07:56:41','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',7),(32,1,'2025-04-15 07:56:50','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(33,1,'2025-04-15 07:57:53','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(34,1,'2025-04-15 07:58:03','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',14),(35,1,'2025-04-15 07:58:36','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',7),(36,1,'2025-04-15 07:58:47','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(37,1,'2025-04-15 07:58:53','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(38,1,'2025-04-15 07:59:00','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(39,1,'2025-04-15 07:59:10','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(40,1,'2025-04-15 07:59:18','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(41,1,'2025-04-15 07:59:25','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(42,1,'2025-04-15 07:59:37','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产类别','创建类别','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-categories/v1','/console/v1/asset-categories/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetCategoryController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(43,1,'2025-04-15 10:08:41','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc','/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',18),(44,1,'2025-04-15 10:09:31','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(45,1,'2025-04-15 10:09:42','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/b06c17577fda441b84e8f2299534897e','/console/v1/funcs/v1/b06c17577fda441b84e8f2299534897e','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(46,1,'2025-04-15 10:10:46','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',5),(47,1,'2025-04-15 10:11:24','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',3),(48,1,'2025-04-15 10:11:33','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','角色管理','保存授权功能','GRANT','127.0.0.1','http://127.0.0.1:28080/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysRoleController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',34),(49,1,'2025-04-16 02:23:03','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产信息','创建资产','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/assets/v1','/console/v1/assets/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetInfoController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',130),(50,1,'2025-04-16 02:29:57','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产信息','修改资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetInfoController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',21),(51,1,'2025-04-17 01:15:45','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产信息','修改资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetInfoController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(52,1,'2025-04-17 01:21:42','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产信息','修改资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','/console/v1/assets/v1/e7f570e3f2d5427b9516f0f25ac1ff2f','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetInfoController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',18),(53,1,'2025-04-17 06:46:15','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',71),(54,1,'2025-04-17 06:47:07','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',214),(55,1,'2025-04-17 06:52:40','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',208),(56,1,'2025-04-17 06:52:55','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',34),(57,1,'2025-04-17 06:53:30','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',19317),(58,1,'2025-04-17 06:54:09','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1','/console/v1/asset-loans/v1','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',8928),(59,1,'2025-04-17 08:06:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(60,1,'2025-04-17 08:15:51','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',6),(61,1,'2025-04-17 08:17:49','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',154),(62,1,'2025-04-17 08:35:21','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','/console/v1/asset-loans/v1/e7f570e3f2d5427b9516f0f25ac1ff2f/return','PUT','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',11),(63,1,'2025-04-17 08:44:05','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/return','/console/v1/asset-loans/v1/return','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',31),(64,1,'2025-04-17 08:52:01','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/loan','/console/v1/asset-loans/v1/loan','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',26),(65,1,'2025-04-17 08:52:08','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','归还资产','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/return','/console/v1/asset-loans/v1/return','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',25),(66,1,'2025-04-18 01:14:01','2bd631f674af40f19c73c0d8962a4d28','17600891908','资产管理','资产借用','创建借用','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/asset-loans/v1/loan','/console/v1/asset-loans/v1/loan','POST','cc.xuepeng.ray.framework.module.asset.api.controller.AssetLoanController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',25),(67,1,'2025-04-18 01:36:54','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',18),(68,1,'2025-04-18 01:37:08','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/8fbbcd4ef86047eca4cda803b845596b','/console/v1/funcs/v1/8fbbcd4ef86047eca4cda803b845596b','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',30),(69,1,'2025-04-18 01:39:32','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','角色管理','保存授权功能','GRANT','127.0.0.1','http://127.0.0.1:28080/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysRoleController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',36);
/*!40000 ALTER TABLE `sys_operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operate_log_detail`
--

DROP TABLE IF EXISTS `sys_operate_log_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operate_log_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_id` bigint DEFAULT NULL COMMENT '系统日志主键',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求路径参数',
  `args` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求方法参数',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '返回值',
  `error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '错误信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log_detail`
--

LOCK TABLES `sys_operate_log_detail` WRITE;
/*!40000 ALTER TABLE `sys_operate_log_detail` DISABLE KEYS */;
INSERT INTO `sys_operate_log_detail` VALUES (1,3,NULL,'[arg0:2bd631f674af40f19c73c0d8962a4d28][arg1:SysUserRequest(deptCode=6220837f5a994d11a4f5cb4833fc216a, roleCodes=[2c2650abd2814511a7eee37e422ac97a], phoneNumber=17600891908, name=盖伦, email=17600891908@qq.com, status=BizStatus.ENABLE(code=1, desc=启用), remark=)]','Result(code=20000, desc=成功, msg=修改系统用户成功, data=true)',NULL),(2,4,NULL,'[arg0:2bd631f674af40f19c73c0d8962a4d28][arg1:SysUserRequest(deptCode=6220837f5a994d11a4f5cb4833fc216a, roleCodes=[2c2650abd2814511a7eee37e422ac97a], phoneNumber=17600891908, name=盖伦, email=17600891908@qq.com, status=BizStatus.ENABLE(code=1, desc=启用), remark=)]','Result(code=20000, desc=成功, msg=修改系统用户成功, data=true)',NULL),(3,5,NULL,'[arg0:AssetCategoryRequest(name=笔记本电脑, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(4,6,NULL,'[arg0:[cf7e6b78408d4003b4294136d89b569f]]','Result(code=20000, desc=成功, msg=删除资产类别成功, data=true)',NULL),(5,7,NULL,'[arg0:cf7e6b78408d4003b4294136d89b569f][arg1:AssetCategoryRequest(name=笔记本电脑, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(6,8,NULL,'[arg0:cf7e6b78408d4003b4294136d89b569f][arg1:AssetCategoryRequest(name=笔记本电脑, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(7,9,NULL,'[arg0:AssetCategoryRequest(name=显示器, sequence=2, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(8,10,NULL,'[arg0:AssetCategoryRequest(name=鼠标, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(9,11,NULL,'[arg0:d9d3c02372914be799bf083741d57997][arg1:AssetCategoryRequest(name=鼠标, sequence=3, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(10,12,NULL,'[arg0:AssetCategoryRequest(name=配件, sequence=4, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(11,13,NULL,'[arg0:AssetCategoryRequest(name=麦克风, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(12,14,NULL,'[arg0:AssetCategoryRequest(name=摄像头, sequence=6, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(13,15,NULL,'[arg0:933e7feab1cc478a9339e361262a9906][arg1:AssetCategoryRequest(name=麦克风, sequence=5, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(14,16,NULL,'[arg0:0c4f8eff06184cd3abd00bb3f4991ff8][arg1:AssetCategoryRequest(name=音响, sequence=6, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(15,17,NULL,'[arg0:AssetCategoryRequest(name=摄像头, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(16,18,NULL,'[arg0:AssetCategoryRequest(name=一体机, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(17,19,NULL,'[arg0:9b7c25eb96d44f60bbadf46c7915b524][arg1:AssetCategoryRequest(name=摄像头, sequence=7, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(18,20,NULL,'[arg0:a8a03a81403d4b62bf359f067c91e282][arg1:AssetCategoryRequest(name=一体机, sequence=8, remark=null)]','Result(code=20000, desc=成功, msg=修改资产类别成功, data=true)',NULL),(19,21,NULL,'[arg0:AssetCategoryRequest(name=键盘, sequence=9, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(20,22,NULL,'[arg0:AssetCategoryRequest(name=激光雷达, sequence=10, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(21,23,NULL,'[arg0:AssetCategoryRequest(name=3D打印机, sequence=11, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(22,24,NULL,'[arg0:AssetCategoryRequest(name=移动硬盘, sequence=12, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(23,25,NULL,'[arg0:AssetCategoryRequest(name=平板电脑, sequence=13, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(24,26,NULL,'[arg0:AssetCategoryRequest(name=耳机, sequence=14, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(25,27,NULL,'[arg0:AssetCategoryRequest(name=显卡拓展坞, sequence=15, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(26,28,NULL,'[arg0:AssetCategoryRequest(name=扩展坞, sequence=16, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(27,29,NULL,'[arg0:AssetCategoryRequest(name=数据线, sequence=17, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(28,30,NULL,'[arg0:AssetCategoryRequest(name=显卡, sequence=18, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(29,31,NULL,'[arg0:AssetCategoryRequest(name=相机, sequence=19, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(30,32,NULL,'[arg0:AssetCategoryRequest(name=穿戴设备, sequence=20, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(31,33,NULL,'[arg0:AssetCategoryRequest(name=投影仪, sequence=21, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(32,34,NULL,'[arg0:AssetCategoryRequest(name=耗材, sequence=22, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(33,35,NULL,'[arg0:AssetCategoryRequest(name=工作站, sequence=23, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(34,36,NULL,'[arg0:AssetCategoryRequest(name=台式机, sequence=24, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(35,37,NULL,'[arg0:AssetCategoryRequest(name=内存, sequence=25, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(36,38,NULL,'[arg0:AssetCategoryRequest(name=服务器, sequence=26, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(37,39,NULL,'[arg0:AssetCategoryRequest(name=文件服务器, sequence=27, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(38,40,NULL,'[arg0:AssetCategoryRequest(name=固态硬盘, sequence=28, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(39,41,NULL,'[arg0:AssetCategoryRequest(name=机械硬盘, sequence=29, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(40,42,NULL,'[arg0:AssetCategoryRequest(name=无人机, sequence=30, remark=null)]','Result(code=20000, desc=成功, msg=创建资产类别成功, data=true)',NULL),(41,43,NULL,'[arg0:0e5580ae61f54380bbc9f473655060bc][arg1:SysFuncRequest(parentCode=0, name=系统管理, type=SysFuncType.DICT(code=0, desc=目录), icon=system, path=/system, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=true, permission=ray:system, component=Layout, sequence=99, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(42,44,NULL,'[arg0:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.MENU(code=1, desc=功能), icon=homepage, path=/asset, redirect=null, linkable=false, cacheable=false, visible=true, alwaysShow=false, permission=ray:asset, component=Layout, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(43,45,NULL,'[arg0:b06c17577fda441b84e8f2299534897e][arg1:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.DICT(code=0, desc=目录), icon=homepage, path=/asset, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=false, permission=ray:asset, component=Layout, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(44,46,NULL,'[arg0:SysFuncRequest(parentCode=b06c17577fda441b84e8f2299534897e, name=分类管理, type=SysFuncType.MENU(code=1, desc=功能), icon=tree, path=/asset/category, redirect=null, linkable=false, cacheable=false, visible=true, alwaysShow=false, permission=ray:asset:category, component=asset/category/index, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(45,47,NULL,'[arg0:SysFuncRequest(parentCode=b06c17577fda441b84e8f2299534897e, name=资产维护, type=SysFuncType.MENU(code=1, desc=功能), icon=document, path=/asset/info, redirect=null, linkable=false, cacheable=false, visible=true, alwaysShow=false, permission=ray:asset:info, component=asset/info/index, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(46,48,NULL,'[arg0:2c2650abd2814511a7eee37e422ac97a][arg1:[b06c17577fda441b84e8f2299534897e, edd9fb65be7f469da3a9ad8afaa07e40, 006ee3f81b9742ce84dc113854d99ada, 0e5580ae61f54380bbc9f473655060bc, 6bfb7cc5de7a4d9c9b70d8563c7377ec, a69358b0070f447db2ad7c3c42297270, 85471b98e6e0478f916c431b93e65dad, 4fe517c3a47a4b3e820ae812327f48cd, b60ca056b2404078ac905f59caa992d2, 7982cdc53a124340ab7da5e3f130b419, 86132348f09a4a8299d949d12f1237b4, 9c476acf5ed34dd19a4f8037a065a669, 743f88e0ec7a4047b74d9487a8826e93, 6371d5a4b47c41fe984d8e4d960c9460, 9b3793acfb7d485dbeee68e11524cc1d, 5b9a474efbc14b6e865e51cbbd16f311, cf7068d9d6d84afcb4a59b803e1e1a2f, 0bd07cc721d94942bc1001ccd1fe9e14, fb05ae0889da4e089c09a987e2e1673c, 6b7666bd1dab4e20974422295de536e2, 89bdd7e788e1476fb56035a8b4760e44, 62e4f7d81aa2417db99845a4f663d419, 51e96aa3fa43456eb5ff9be56ae26914, 76ed9e00ddcc4e58a60a8b86ebc5bbc6]]','Result(code=20000, desc=成功, msg=授权功能成功, data=true)',NULL),(47,49,NULL,'[arg0:AssetInfoRequest(categoryCode=cf7e6b78408d4003b4294136d89b569f, name=苹果笔记本, brand=Apple, model=M1 Pro, specification=MacBook Pro | 16英寸 | M1 Pro | 16G | 512G, status=null, location=null, purchaseYear=2021, price=18999, remark=null)]','Result(code=20000, desc=成功, msg=创建资产信息成功, data=true)',NULL),(48,50,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:AssetInfoRequest(categoryCode=cf7e6b78408d4003b4294136d89b569f, name=苹果笔记本, brand=Apple, model=M1 Pro, specification=MacBook Pro | 16英寸 | M1 Pro | 16G | 512G, status=AssetStatus.IN_STOCK(code=0, desc=在库), location=4楼柜子, purchaseYear=2021, price=18999, remark=)]','Result(code=20000, desc=成功, msg=修改资产信息成功, data=true)',NULL),(49,51,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:AssetInfoRequest(categoryCode=cf7e6b78408d4003b4294136d89b569f, name=苹果笔记本, brand=Apple, model=M1 Pro, specification=MacBook Pro | 16英寸 | M1 Pro | 16G | 512G, status=AssetStatus.IN_STOCK(code=0, desc=在库), location=4楼柜子, purchaseYear=2021, price=18999, remark=)]','Result(code=20000, desc=成功, msg=修改资产信息成功, data=true)',NULL),(50,52,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:AssetInfoRequest(categoryCode=cf7e6b78408d4003b4294136d89b569f, name=苹果笔记本, brand=Apple, model=M1 Pro, specification=MacBook Pro | 16英寸 | M1 Pro | 16G | 512G, status=AssetStatus.IN_STOCK(code=0, desc=在库), location=4楼柜子, purchaseYear=2021, price=18999, remark=)]','Result(code=20000, desc=成功, msg=修改资产信息成功, data=true)',NULL),(51,53,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]',NULL,'\n### Error updating database.  Cause: java.sql.SQLException: Field \'code\' doesn\'t have a default value\n### The error may exist in cc/xuepeng/ray/framework/module/asset/repository/repository/AssetLoanRepository.java (best guess)\n### The error may involve cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository.insert-Inline\n### The error occurred while setting parameters\n### SQL: INSERT INTO asset_loan  ( asset_code,  status, remark,  create_user,  modify_user )  VALUES (  ?,  ?, ?,  ?,  ?  )\n### Cause: java.sql.SQLException: Field \'code\' doesn\'t have a default value\n; Field \'code\' doesn\'t have a default value'),(52,54,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]',NULL,'\n### Error updating database.  Cause: java.sql.SQLException: Field \'loan_date\' doesn\'t have a default value\n### The error may exist in cc/xuepeng/ray/framework/module/asset/repository/repository/AssetLoanRepository.java (best guess)\n### The error may involve cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository.insert-Inline\n### The error occurred while setting parameters\n### SQL: INSERT INTO asset_loan  ( code,  asset_code,  status, remark,  create_user,  modify_user )  VALUES (  ?,  ?,  ?, ?,  ?,  ?  )\n### Cause: java.sql.SQLException: Field \'loan_date\' doesn\'t have a default value\n; Field \'loan_date\' doesn\'t have a default value'),(53,55,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]',NULL,'\n### Error updating database.  Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n### The error may exist in cc/xuepeng/ray/framework/module/asset/repository/repository/AssetLoanRepository.java (best guess)\n### The error may involve cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository.insert-Inline\n### The error occurred while setting parameters\n### SQL: INSERT INTO asset_loan  ( code, loan_date, asset_code,  status, remark,  create_user,  modify_user )  VALUES (  ?, ?, ?,  ?, ?,  ?,  ?  )\n### Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n; Field \'user_code\' doesn\'t have a default value'),(54,56,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]',NULL,'\n### Error updating database.  Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n### The error may exist in cc/xuepeng/ray/framework/module/asset/repository/repository/AssetLoanRepository.java (best guess)\n### The error may involve cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository.insert-Inline\n### The error occurred while setting parameters\n### SQL: INSERT INTO asset_loan  ( code, loan_date, asset_code,  status, remark,  create_user,  modify_user )  VALUES (  ?, ?, ?,  ?, ?,  ?,  ?  )\n### Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n; Field \'user_code\' doesn\'t have a default value'),(55,57,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]',NULL,'\n### Error updating database.  Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n### The error may exist in cc/xuepeng/ray/framework/module/asset/repository/repository/AssetLoanRepository.java (best guess)\n### The error may involve cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository.insert-Inline\n### The error occurred while setting parameters\n### SQL: INSERT INTO asset_loan  ( code, loan_date, asset_code,  status, remark,  create_user,  modify_user )  VALUES (  ?, ?, ?,  ?, ?,  ?,  ?  )\n### Cause: java.sql.SQLException: Field \'user_code\' doesn\'t have a default value\n; Field \'user_code\' doesn\'t have a default value'),(56,58,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公使用, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]','Result(code=20000, desc=成功, msg=创建资产借用记录成功, data=true)',NULL),(57,59,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:null]',NULL,'无法根据编号[e7f570e3f2d5427b9516f0f25ac1ff2f]查询到借用记录'),(58,60,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:null]',NULL,'无法根据编号[e7f570e3f2d5427b9516f0f25ac1ff2f]查询到借用记录'),(59,61,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:null]','Result(code=50000, desc=业务异常, msg=归还资产失败, data=false)',NULL),(60,62,NULL,'[arg0:e7f570e3f2d5427b9516f0f25ac1ff2f][arg1:null]','Result(code=50000, desc=业务异常, msg=归还资产失败, data=false)',NULL),(61,63,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=归还, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]','Result(code=20000, desc=成功, msg=归还资产成功, data=true)',NULL),(62,64,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=开发, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]','Result(code=20000, desc=成功, msg=创建资产借用记录成功, data=true)',NULL),(63,65,NULL,'[arg0:AssetLoanRequest(userCode=2bd631f674af40f19c73c0d8962a4d28, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=不用了, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]','Result(code=20000, desc=成功, msg=归还资产成功, data=true)',NULL),(64,66,NULL,'[arg0:AssetLoanRequest(userCode=bd385b2b16e64aba89e46a668901fbe8, assetCode=e7f570e3f2d5427b9516f0f25ac1ff2f, reason=办公, status=AssetLoanStatus.LOANED(code=0, desc=借用), remark=)]','Result(code=20000, desc=成功, msg=创建资产借用记录成功, data=true)',NULL),(65,67,NULL,'[arg0:SysFuncRequest(parentCode=b06c17577fda441b84e8f2299534897e, name=资产维修, type=SysFuncType.MENU(code=1, desc=功能), icon=Van, path=repair, redirect=null, linkable=false, cacheable=false, visible=false, alwaysShow=false, permission=ray:asset:repair, component=asset/repair/index, sequence=3, remark=)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(66,68,NULL,'[arg0:8fbbcd4ef86047eca4cda803b845596b][arg1:SysFuncRequest(parentCode=b06c17577fda441b84e8f2299534897e, name=资产维修, type=SysFuncType.MENU(code=1, desc=功能), icon=publish, path=repair, redirect=, linkable=false, cacheable=false, visible=false, alwaysShow=false, permission=ray:asset:repair, component=asset/repair/index, sequence=3, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(67,69,NULL,'[arg0:2c2650abd2814511a7eee37e422ac97a][arg1:[b06c17577fda441b84e8f2299534897e, edd9fb65be7f469da3a9ad8afaa07e40, 006ee3f81b9742ce84dc113854d99ada, 8fbbcd4ef86047eca4cda803b845596b, 0e5580ae61f54380bbc9f473655060bc, 6bfb7cc5de7a4d9c9b70d8563c7377ec, a69358b0070f447db2ad7c3c42297270, 85471b98e6e0478f916c431b93e65dad, 4fe517c3a47a4b3e820ae812327f48cd, b60ca056b2404078ac905f59caa992d2, 7982cdc53a124340ab7da5e3f130b419, 86132348f09a4a8299d949d12f1237b4, 9c476acf5ed34dd19a4f8037a065a669, 743f88e0ec7a4047b74d9487a8826e93, 6371d5a4b47c41fe984d8e4d960c9460, 9b3793acfb7d485dbeee68e11524cc1d, 5b9a474efbc14b6e865e51cbbd16f311, cf7068d9d6d84afcb4a59b803e1e1a2f, 0bd07cc721d94942bc1001ccd1fe9e14, fb05ae0889da4e089c09a987e2e1673c, 6b7666bd1dab4e20974422295de536e2, 89bdd7e788e1476fb56035a8b4760e44, 62e4f7d81aa2417db99845a4f663d419, 51e96aa3fa43456eb5ff9be56ae26914, 76ed9e00ddcc4e58a60a8b86ebc5bbc6]]','Result(code=20000, desc=成功, msg=授权功能成功, data=true)',NULL);
/*!40000 ALTER TABLE `sys_operate_log_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'2c2650abd2814511a7eee37e422ac97a','ROLE_SUPER_ADMIN',1,1,'超级管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-28 07:19:30','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05'),(2,'c1b1d17824a14a2286a0150c048987d8','ROLE_SYSTEM_ADMIN',1,2,'系统管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:18:04','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_func_relation`
--

DROP TABLE IF EXISTS `sys_role_func_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_func_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `func_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '功能编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与功能的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_func_relation`
--

LOCK TABLES `sys_role_func_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_func_relation` DISABLE KEYS */;
INSERT INTO `sys_role_func_relation` VALUES (200,'c1b1d17824a14a2286a0150c048987d8','0e5580ae61f54380bbc9f473655060bc'),(201,'c1b1d17824a14a2286a0150c048987d8','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(202,'c1b1d17824a14a2286a0150c048987d8','a69358b0070f447db2ad7c3c42297270'),(203,'c1b1d17824a14a2286a0150c048987d8','85471b98e6e0478f916c431b93e65dad'),(204,'c1b1d17824a14a2286a0150c048987d8','4fe517c3a47a4b3e820ae812327f48cd'),(205,'c1b1d17824a14a2286a0150c048987d8','b60ca056b2404078ac905f59caa992d2'),(206,'c1b1d17824a14a2286a0150c048987d8','9c476acf5ed34dd19a4f8037a065a669'),(207,'c1b1d17824a14a2286a0150c048987d8','743f88e0ec7a4047b74d9487a8826e93'),(208,'c1b1d17824a14a2286a0150c048987d8','6371d5a4b47c41fe984d8e4d960c9460'),(209,'c1b1d17824a14a2286a0150c048987d8','9b3793acfb7d485dbeee68e11524cc1d'),(255,'2c2650abd2814511a7eee37e422ac97a','b06c17577fda441b84e8f2299534897e'),(256,'2c2650abd2814511a7eee37e422ac97a','edd9fb65be7f469da3a9ad8afaa07e40'),(257,'2c2650abd2814511a7eee37e422ac97a','006ee3f81b9742ce84dc113854d99ada'),(258,'2c2650abd2814511a7eee37e422ac97a','8fbbcd4ef86047eca4cda803b845596b'),(259,'2c2650abd2814511a7eee37e422ac97a','0e5580ae61f54380bbc9f473655060bc'),(260,'2c2650abd2814511a7eee37e422ac97a','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(261,'2c2650abd2814511a7eee37e422ac97a','a69358b0070f447db2ad7c3c42297270'),(262,'2c2650abd2814511a7eee37e422ac97a','85471b98e6e0478f916c431b93e65dad'),(263,'2c2650abd2814511a7eee37e422ac97a','4fe517c3a47a4b3e820ae812327f48cd'),(264,'2c2650abd2814511a7eee37e422ac97a','b60ca056b2404078ac905f59caa992d2'),(265,'2c2650abd2814511a7eee37e422ac97a','7982cdc53a124340ab7da5e3f130b419'),(266,'2c2650abd2814511a7eee37e422ac97a','86132348f09a4a8299d949d12f1237b4'),(267,'2c2650abd2814511a7eee37e422ac97a','9c476acf5ed34dd19a4f8037a065a669'),(268,'2c2650abd2814511a7eee37e422ac97a','743f88e0ec7a4047b74d9487a8826e93'),(269,'2c2650abd2814511a7eee37e422ac97a','6371d5a4b47c41fe984d8e4d960c9460'),(270,'2c2650abd2814511a7eee37e422ac97a','9b3793acfb7d485dbeee68e11524cc1d'),(271,'2c2650abd2814511a7eee37e422ac97a','5b9a474efbc14b6e865e51cbbd16f311'),(272,'2c2650abd2814511a7eee37e422ac97a','cf7068d9d6d84afcb4a59b803e1e1a2f'),(273,'2c2650abd2814511a7eee37e422ac97a','0bd07cc721d94942bc1001ccd1fe9e14'),(274,'2c2650abd2814511a7eee37e422ac97a','fb05ae0889da4e089c09a987e2e1673c'),(275,'2c2650abd2814511a7eee37e422ac97a','6b7666bd1dab4e20974422295de536e2'),(276,'2c2650abd2814511a7eee37e422ac97a','89bdd7e788e1476fb56035a8b4760e44'),(277,'2c2650abd2814511a7eee37e422ac97a','62e4f7d81aa2417db99845a4f663d419'),(278,'2c2650abd2814511a7eee37e422ac97a','51e96aa3fa43456eb5ff9be56ae26914'),(279,'2c2650abd2814511a7eee37e422ac97a','76ed9e00ddcc4e58a60a8b86ebc5bbc6');
/*!40000 ALTER TABLE `sys_role_func_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user_relation`
--

DROP TABLE IF EXISTS `sys_role_user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_user_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `user_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与用户的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_relation`
--

LOCK TABLES `sys_role_user_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_user_relation` DISABLE KEYS */;
INSERT INTO `sys_role_user_relation` VALUES (10,'c1b1d17824a14a2286a0150c048987d8','bd385b2b16e64aba89e46a668901fbe8'),(11,'c1b1d17824a14a2286a0150c048987d8','67348a262c4048a9b12ddbdbfb2b437c'),(15,'2c2650abd2814511a7eee37e422ac97a','2bd631f674af40f19c73c0d8962a4d28');
/*!40000 ALTER TABLE `sys_role_user_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'6220837f5a994d11a4f5cb4833fc216a','2bd631f674af40f19c73c0d8962a4d28','17600891908','盖伦','670b14728ad9902aecba32e22fa4f6bd','17600891908@qq.com','http://5b0988e595225.cdn.sohucs.com/images/20190513/8e9becdd22bc47ba95ec7c79cebdbcb2.jpeg',1,'',0,'6220837f5a994d11a4f5cb4833fc216a','2024-04-25 08:18:08','2bd631f674af40f19c73c0d8962a4d28','2025-04-08 09:11:15'),(2,'6220837f5a994d11a4f5cb4833fc216a','67348a262c4048a9b12ddbdbfb2b437c','15810051066','卡特琳娜','670b14728ad9902aecba32e22fa4f6bd','15810051066@qq.com','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-22 02:03:21','2bd631f674af40f19c73c0d8962a4d28','2025-01-02 05:58:00'),(3,'66ec739c41644db9a1ef6c2f085c8370','bd385b2b16e64aba89e46a668901fbe8','13840586729','伊泽瑞尔','670b14728ad9902aecba32e22fa4f6bd','13840586729@qq.com','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-02 05:57:52','2bd631f674af40f19c73c0d8962a4d28','2025-01-07 08:20:42');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'anov-assets'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-18 17:52:18
