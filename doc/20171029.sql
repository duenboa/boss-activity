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
  `phone` bigint(20) DEFAULT NULL COMMENT '电话',
  `gift_level` int(10) DEFAULT NULL COMMENT '奖品等级 关联t_price_config.level',
  `gift` varchar(20) DEFAULT NULL COMMENT '奖品名称',
  `state` varchar(20) DEFAULT 'browse' COMMENT 'browe)浏览, visit)入店, taked)已领取奖品, other)其他状态',
  `visit_date` datetime DEFAULT NULL COMMENT '入店时间',
  `taked_date` datetime DEFAULT NULL COMMENT '领取奖品时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '删除状态 0)未删除, 1)已删除',
  PRIMARY KEY (`id`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='活动表';

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`create_at`,`update_at`,`phone`,`gift_level`,`gift`,`state`,`visit_date`,`taked_date`,`deleted`) values (1,'2017-10-28 18:54:05','2017-10-29 16:31:15',13262552522,1,'一等奖','visit',NULL,NULL,1),(2,'2017-10-28 18:55:02','2017-10-29 16:31:15',13266252235,2,'二等奖','browse',NULL,NULL,0),(3,'2017-10-28 18:55:02','2017-10-29 16:31:16',13266252232,2,'二等奖','browse',NULL,NULL,0),(4,'2017-10-28 18:55:02','2017-10-29 16:31:17',13266252111,3,'三等奖','browse',NULL,NULL,0),(5,'2017-10-28 18:55:02','2017-10-29 16:31:18',13266252222,4,'四等奖','browse',NULL,NULL,0),(6,'2017-10-28 18:55:02','2017-10-29 16:31:18',13266252235,2,'二等奖','browse',NULL,NULL,0),(7,'2017-10-28 18:55:02','2017-10-29 16:31:20',13266252236,2,'二等奖','browse',NULL,NULL,0),(8,'2017-10-28 18:55:02','2017-10-29 16:31:19',13266252237,2,'二等奖','browse',NULL,NULL,0),(9,'2017-10-28 18:55:02','2017-10-29 16:31:21',13266252238,4,'参与奖','browse',NULL,NULL,0),(10,'2017-10-28 18:55:02','2017-10-29 16:31:23',13266252231,1,'一等奖','browse',NULL,NULL,0),(11,'2017-10-28 20:15:40','2017-10-29 16:31:23',13655556666,1,'一等奖,娃哈哈一瓶','browe',NULL,NULL,0),(12,'2017-10-28 20:16:31','2017-10-29 16:31:26',13655556666,1,'一等奖,娃哈哈一瓶','browe',NULL,NULL,0),(17,'2017-10-29 18:04:54','2017-10-29 18:05:46',18650317702,NULL,'一等奖','browe',NULL,NULL,0),(18,'2017-10-29 18:05:48','2017-10-29 18:06:50',18650317703,NULL,'一等奖','browe',NULL,NULL,0),(19,'2017-10-29 18:06:52','2017-10-29 18:08:18',18650317704,NULL,'一等奖','browe',NULL,NULL,0),(20,'2017-10-29 18:08:21','2017-10-29 18:12:30',18650317706,NULL,'一等奖','browe',NULL,NULL,0),(22,'2017-10-29 18:10:54','2017-10-29 18:12:37',18650317705,NULL,'一等奖','browe',NULL,NULL,0),(23,'2017-10-29 18:12:47','2017-10-29 18:15:40',18650317708,NULL,'一等奖','browe',NULL,NULL,0),(27,'2017-10-29 19:00:47',NULL,13545699697,2,'二等奖','browe',NULL,NULL,0),(28,'2017-10-29 19:06:27',NULL,13545699698,2,'二等奖','browe',NULL,NULL,0),(29,'2017-10-29 19:07:13',NULL,13545699999,2,'二等奖','browe',NULL,NULL,0),(30,'2017-10-29 19:07:56',NULL,13545699998,3,'三等奖','browe',NULL,NULL,0),(31,'2017-10-29 19:08:47',NULL,13545965555,2,'二等奖','browe',NULL,NULL,0),(32,'2017-10-29 19:10:43',NULL,13545964123,3,'三等奖','browe',NULL,NULL,0),(33,'2017-10-29 19:16:25',NULL,13545964124,4,'四等奖','browe',NULL,NULL,0),(34,'2017-10-29 19:17:10',NULL,13545690001,2,'二等奖','browe',NULL,NULL,0),(35,'2017-10-29 19:18:13',NULL,13545698888,3,'三等奖','browe',NULL,NULL,0),(36,'2017-10-29 19:18:34',NULL,13545263333,2,'二等奖','browe',NULL,NULL,0),(37,'2017-10-29 19:19:09',NULL,13545657845,3,'三等奖','browe',NULL,NULL,0),(38,'2017-10-29 19:20:01',NULL,13545681254,4,'四等奖','browe',NULL,NULL,0),(39,'2017-10-29 19:20:20',NULL,13545872145,2,'二等奖','browe',NULL,NULL,0),(40,'2017-10-29 19:20:57',NULL,13545876589,4,'四等奖','browe',NULL,NULL,0),(41,'2017-10-29 19:21:36',NULL,13514257845,3,'三等奖','browe',NULL,NULL,0),(42,'2017-10-29 19:23:00',NULL,13565894512,3,'三等奖','browe',NULL,NULL,0),(43,'2017-10-29 19:24:23',NULL,13545698745,1,'一等奖','browe',NULL,NULL,0),(44,'2017-10-29 19:25:04',NULL,13545867894,1,'一等奖','browe',NULL,NULL,0),(45,'2017-10-29 19:25:46',NULL,13545698754,4,'四等奖','browe',NULL,NULL,0),(46,'2017-10-29 19:26:05',NULL,13545684591,3,'三等奖','browe',NULL,NULL,0),(47,'2017-10-29 19:26:28',NULL,13545684512,1,'一等奖','browe',NULL,NULL,0),(48,'2017-10-29 19:26:58',NULL,13501465784,3,'三等奖','browe',NULL,NULL,0),(49,'2017-10-29 19:31:09',NULL,13545687451,2,'二等奖','browe',NULL,NULL,0),(50,'2017-10-29 19:31:26',NULL,13545846541,3,'三等奖','browe',NULL,NULL,0),(51,'2017-10-29 19:32:52',NULL,13546854125,3,'三等奖','browe',NULL,NULL,0),(52,'2017-10-29 19:36:27',NULL,13546854121,2,'二等奖','browe',NULL,NULL,0),(53,'2017-10-29 19:36:55',NULL,13546854124,4,'四等奖','browe',NULL,NULL,0),(54,'2017-10-29 19:37:38',NULL,13546854127,2,'二等奖','browe',NULL,NULL,0),(55,'2017-10-29 19:38:09',NULL,13547854216,1,'一等奖','browe',NULL,NULL,0),(56,'2017-10-29 19:38:54',NULL,13547854212,2,'二等奖','browe',NULL,NULL,0),(57,'2017-10-29 19:40:19',NULL,13547854211,2,'二等奖','browe',NULL,NULL,0),(58,'2017-10-29 19:41:38',NULL,13547854210,2,'二等奖','browe',NULL,NULL,0),(59,'2017-10-29 19:41:48',NULL,13547854219,4,'四等奖','browe',NULL,NULL,0),(60,'2017-10-29 19:42:02',NULL,13547854218,3,'三等奖','browe',NULL,NULL,0),(61,'2017-10-29 19:42:16',NULL,13547854217,2,'二等奖','browe',NULL,NULL,0),(62,'2017-10-29 19:43:43',NULL,13569845123,2,'二等奖','browe',NULL,NULL,0),(63,'2017-10-29 19:43:49',NULL,13569845122,1,'一等奖','browe',NULL,NULL,0),(64,'2017-10-29 19:43:55',NULL,13569845121,3,'三等奖','browe',NULL,NULL,0),(65,'2017-10-29 19:44:24',NULL,13569845120,3,'三等奖','browe',NULL,NULL,0),(66,'2017-10-29 19:44:31',NULL,13569845129,4,'四等奖','browe',NULL,NULL,0),(67,'2017-10-29 19:44:36',NULL,13569845128,4,'四等奖','browe',NULL,NULL,0),(68,'2017-10-29 19:44:40',NULL,13569845127,4,'四等奖','browe',NULL,NULL,0),(69,'2017-10-29 19:44:44',NULL,13569845126,2,'二等奖','browe',NULL,NULL,0),(70,'2017-10-29 19:44:49',NULL,13569845125,4,'四等奖','browe',NULL,NULL,0),(71,'2017-10-29 19:44:53',NULL,13569845124,3,'三等奖','browe',NULL,NULL,0),(72,'2017-10-29 19:49:18','2017-10-29 19:50:07',13565478541,3,'三等奖','taked',NULL,NULL,0),(73,'2017-10-29 19:56:03',NULL,13545699656,4,'四等奖','browe',NULL,NULL,0),(74,'2017-10-29 20:43:14',NULL,13545696666,4,'四等奖','browe',NULL,NULL,0),(75,'2017-10-29 20:44:29',NULL,13545696635,1,'一等奖','browe',NULL,NULL,0);

/*Table structure for table `t_price_config` */

DROP TABLE IF EXISTS `t_price_config`;

CREATE TABLE `t_price_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `level` int(10) DEFAULT NULL COMMENT '中奖等级',
  `probability` int(10) DEFAULT NULL COMMENT '中奖概率 整数,百分比',
  `description` varchar(20) DEFAULT NULL COMMENT '中奖描述',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '删除状态 0)未删除, 1)已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='奖品概率设置表';

/*Data for the table `t_price_config` */

insert  into `t_price_config`(`id`,`create_at`,`update_at`,`level`,`probability`,`description`,`deleted`) values (1,'2017-10-29 15:56:31','2017-10-29 19:42:34',1,5,'一等奖',0),(2,'2017-10-29 15:56:42','2017-10-29 19:42:37',2,10,'二等奖',0),(3,'2017-10-29 15:56:56','2017-10-29 19:42:55',3,15,'三等奖',0),(4,'2017-10-29 15:57:52','2017-10-29 19:43:13',4,70,'四等奖',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;