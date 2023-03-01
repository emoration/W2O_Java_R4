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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`id`,`user_id`,`song_id`,`fav`) values (1,1,1,0),(2,1,2,0),(3,1,3,1),(4,2,1,0),(5,2,2,0),(6,2,3,1),(7,3,1,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=541 DEFAULT CHARSET=utf8;

/*Data for the table `song` */

insert  into `song`(`id`,`duration`,`artist`,`album`,`name`,`rid`) values (1,'3:4','蔡徐坤','1','You Can Be My GirlFriend',50191880),(2,'3:5','蔡徐坤','1','Pull Up',50191879),(3,'78:0','DJ小鱼儿','DJ小鱼儿国语串烧精选集N0;1','DJ小鱼儿国语串烧精选集N0;1',28057722),(464,'3:45','蔡徐坤','1','It’s You',50191881),(465,'0:10','陈洁丽','','1(猪猪侠主题曲)',155927434),(466,'4:11','王俊凯','','1',4809904),(467,'6:33','张帝','','1(张帝专辑十一歌问答张帝张帝)',4303849),(468,'61:0','团长','432HZ音乐','1',207142575),(469,'61:0','团长','432HZ音乐','放下手中的工作，一起冥想，放空，疗愈；(1)',207141528),(470,'5:7','佛教音乐','礼赞观音菩萨合集','1(观世音菩萨治病真言)',4395109),(471,'3:34','Oscar Scheller&Lily Allen','1%','1%',72115461),(472,'3:4','Elaine','1','I Want You',64390038),(473,'1:12','开心果果','皮特猫','1',200371364),(474,'3:51','MOB CHOIR','1','Exist',245307059),(475,'3:49','MOB CHOIR','1','1',245307057),(476,'3:38','Elaine','1','1 to 2',64389802),(477,'4:50','胡杨林','','1(你身上有她的香水味)',4569454),(478,'0:5','Kouichi Okamoto','RANDOM','1',2578935),(479,'2:5','The Beatles','1 (Remastered)','Yesterday(Remaster)',40837771),(480,'0:51','汪苏泷','','1(不分手的恋爱铃声汪)',4665675),(521,'3:49','CJ偷偷','2','红尘永相伴 (cover: 冷漠|司徒兰芳)',196338356),(522,'0:30','倩女幽魂','','2(十里平湖霜满天 粤语无对白版)',4216746),(523,'61:40','团长','432HZ音乐','2',207142636),(524,'4:24','九十九','练','2',224611608),(525,'16:10','群星','','2(百灵十三口 百灵鸟叫声)',4570020),(526,'4:26','Nik And Jay','2','En Dag Tilbage',16678507),(527,'4:51','酒酒制造','说说我当道士那些事','2',213638765),(528,'9:41','爱飘的夜','商务英语 Business English','2',85393504),(529,'4:15','Suzy&2','EP','Broken Windows',35943622),(530,'7:17','Illreme','2 (Dub Version) [feat. Saho Terao]','Blue Canary[feat. 寺尾紗穂](Dub)',156490211),(531,'3:10','Mac Demarco','2','My Kind of Woman',50313458),(532,'0:22','木理理','心灵美文','2',189206563),(533,'19:22','大兵[相声]','大兵相声辑','2(娱乐二人转)',4237700),(534,'3:33','Citizen Way&Ben Calhoun&Josh Calhoun&Seth Mosely','2','When I’m with You',27885115),(535,'3:30','B1A4','2 (通常盤)','Believe In Love',4076606),(536,'6:28','Ray Charles','Early in the Morning','What’d I Say， Parts 1 &amp; 2',41247369),(537,'1:42','英语口语','商务英语口语1000句','2',6585931),(538,'0:23','回音哥','','2(B 之歌 坑爹原创 20120224)',4341764),(539,'7:40','印象天下','战斗力系统（多人免费）','2',199878851),(540,'8:15','阿东读历史','当代江湖秘录','2',177489458);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','uaC5IVmxAAALUrzI3y+NWQ=='),(2,'admin1','s/VS4Mfg1KFt7AnaFl7PDw==');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
