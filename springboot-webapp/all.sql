/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.19 : Database - springboot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `springboot`;

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  `fav` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_song_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` varchar(100) NOT NULL,
  `artist` varchar(100) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `song_id_uindex` (`id`),
  UNIQUE KEY `song_rid_uindex` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=601 DEFAULT CHARSET=utf8;

/*Data for the table `song` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','uaC5IVmxAAALUrzI3y+NWQ==');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
