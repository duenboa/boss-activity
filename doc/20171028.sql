/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 10.1.14-MariaDB : Database - hz_act
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hz_act` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hz_act`;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间,即用户点击参与活动时间',
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `phone` bigint(20) NOT NULL COMMENT '电话',
  `gift` varchar(20) NOT NULL COMMENT '奖品名称',
  `state` varchar(20) NOT NULL DEFAULT 'browse' COMMENT 'browe)浏览, visit)入店, taked)已领取奖品, other)其他状态',
  `visit_date` datetime DEFAULT NULL COMMENT '入店时间',
  `taked_date` datetime DEFAULT NULL COMMENT '领取奖品时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '删除状态 0)未删除, 1)已删除',
  PRIMARY KEY (`id`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='活动表';

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`create_at`,`update_at`,`phone`,`gift`,`state`,`visit_date`,`taked_date`,`deleted`) values (1,'2017-10-28 18:54:05','2017-10-28 18:54:34',13262552522,'一等奖','browse',NULL,NULL,0),(2,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252235,'二等奖','browse',NULL,NULL,0),(3,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252232,'二等奖','browse',NULL,NULL,0),(4,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252111,'三等奖','browse',NULL,NULL,0),(5,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252222,'四等奖','browse',NULL,NULL,0),(6,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252235,'二等奖','browse',NULL,NULL,0),(7,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252236,'二等奖','browse',NULL,NULL,0),(8,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252237,'二等奖','browse',NULL,NULL,0),(9,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252238,'参与奖','browse',NULL,NULL,0),(10,'2017-10-28 18:55:02','2017-10-28 18:54:36',13266252231,'一等奖','browse',NULL,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
