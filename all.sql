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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`id`,`user_id`,`song_id`,`fav`) values (2,1,2,1),(5,1,2,0);

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
  UNIQUE KEY `song_name_uindex` (`name`),
  UNIQUE KEY `song_rid_uindex` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;

/*Data for the table `song` */

insert  into `song`(`id`,`duration`,`artist`,`album`,`name`,`rid`) values (1,'2:42','幻想与现实','b','In The Shadow Of The Sun (remi',219045814),(2,'14:3','陈安之','','b(潜意识的确认录音带)',4366863),(3,'2:32','BamBam (뱀뱀)','B','Slow Mo',206833220),(4,'2:8','TRVP&B&Denny Well&Enemy Style','L.A. VIBES','De Lunes a Jueves',93163920),(5,'3:9','B&E','Chords To Live By','Poverty',35522331),(6,'4:34','Supercar','B','PINK ROCK',1272546),(7,'3:6','Jaden Smith','SYRE','B',35482769),(8,'3:29','R&b','天国的嫁衣 电视剧原声带','多一天爱一点',51497825),(9,'7:12','B&Og','John Digweed Re:Structured','Ava',55799691),(10,'3:9','B','','黑毒',20274732),(11,'6:33','B.','Struggling (Limited Edition)','Hurricane',32102024),(12,'3:51','B.','Struggling (Limited Edition)','Part-E',32102023),(13,'4:22','Santana&The Product G&B','Party Hits: Summer Edition (Ex','Maria Maria',9866343),(14,'3:8','R&b','The Heart of Clay','Tonight',38656164),(15,'5:46','B&B Yoga&MUSIC&Bill Webb','Music for Power Yoga','Solar Power',33485058),(16,'68:0','黄子华','','b(儿童不宜)',4369592),(18,'66:0','DJ舞曲','','B(口水坚江门大上海俱乐部 年超牛 现场)',4782186),(19,'5:20','DJ & B','Resistance','Resistance',86623915),(20,'3:57','Santana&The Product G&B','30 Stars: Chill','Maria Maria(Radio Edit)',29247646),(41,'2:58','A','Hi-Fi Serious (Explicit)','Something’s Going On',417690),(42,'3:16','A','Hi-Fi Serious (Explicit)','Starbucks',417689),(43,'2:21','M&A&Бэтси','Симпл димпл поп ит сквиш','Симпл димпл поп ит сквиш',181797534),(44,'4:59','胎教音乐宝典','','A(卓人右脑 脑波音乐)',4713265),(45,'3:37','A','Hi-Fi Serious (Explicit)','The Distance',417695),(46,'4:0','Blutch','Equilibrium','A.',7975429),(47,'5:28','瑜伽','','A(Spa 静心瑜珈音乐 奔向你期待的森林)',4254144),(48,'3:27','A','Hi-Fi Serious (Explicit)','W.D.Y.C.A.I.',417685),(49,'3:1','GOT7','GOT♡','A(Korean ver.)',4800757),(50,'1:44','三冬三夏','PEP三年级上册英语','A(P16)',244397879),(51,'0:42','三冬三夏','PEP三年级上册英语','A (P15)',244397427),(52,'3:43','A','Hi-Fi Serious (Explicit)','Shut Yer Face',417694),(53,'5:16','锅巴男孩','后室音乐合集','A',241750273),(54,'4:2','A-','','So Cold (The Good Wife Trailer) (cover: Ben Cocks)',140707022),(55,'3:12','苦珀kuper','A','皎',173490999),(56,'4:1','电子琴','','A(人间第一情)',4260248),(58,'4:2','A','','Ouvertura',10785340),(59,'3:27','A','','烟花三月下扬州',20422895),(101,'3:22','孟美岐&周震南','C','C',98319953),(103,'10:55','@c','Music for Empty Spaces','76.6',26753517),(104,'3:11','ZZX','C','C49',74375298),(105,'1:19','沈波','C (纯音乐)','C(琵琶版)',169396618),(106,'1:19','沈波','C (纯音乐)','C(二胡版)',169396594),(107,'1:19','沈波','C (纯音乐)','C(古筝版)',169396646),(108,'1:53','沈波','C','C(钢琴版)',140541782),(109,'3:6','沈波','C','与梦同行(钢琴版)',153155570),(110,'1:19','沈波','C (纯音乐)','C(扬琴版)',169406070),(111,'3:54','ZZX','C','C149',74375212),(112,'3:6','沈波','C','与梦同行(扬琴版)',153155567),(113,'4:45','C&K','アサトヒカリ','アサトヒカリ',143369722),(114,'1:8','C','一样','我们的理想(其他)',213611274),(116,'3:6','沈波','C','与梦同行(琵琶版)',153155568),(118,'2:58','Yoga','C','冲鸭',187546957),(119,'4:54','C&K','Y','GOOD LUCK',26139004),(120,'3:12','C & M a Gospel Singers','C & M a Gospel Singers','Jesus Remembered You',7945784),(121,'3:4','蔡徐坤','1','You Can Be My GirlFriend',50191880),(122,'3:5','蔡徐坤','1','Pull Up',50191879),(123,'0:10','陈洁丽','','1(猪猪侠主题曲)',155927434),(124,'3:45','蔡徐坤','1','It’s You',50191881),(125,'78:0','DJ小鱼儿','DJ小鱼儿国语串烧精选集N0;1','DJ小鱼儿国语串烧精选集N0;1',28057722),(126,'4:11','王俊凯','','1',4809904),(127,'6:33','张帝','','1(张帝专辑十一歌问答张帝张帝)',4303849),(128,'3:51','MOB CHOIR','1','Exist',245307059),(130,'61:0','团长','432HZ音乐','放下手中的工作，一起冥想，放空，疗愈；(1)',207141528),(131,'3:34','Oscar Scheller&Lily Allen','1%','1%',72115461),(132,'5:7','佛教音乐','礼赞观音菩萨合集','1(观世音菩萨治病真言)',4395109),(133,'3:4','Elaine','1','I Want You',64390038),(134,'0:51','汪苏泷','','1(不分手的恋爱铃声汪)',4665675),(135,'4:50','胡杨林','','1(你身上有她的香水味)',4569454),(138,'2:5','The Beatles','1 (Remastered)','Yesterday(Remaster)',40837771),(139,'4:25','刘德华','','1(爱是没有尽头)',4213115),(140,'4:53','周传雄','','1(小刚 吉普塞的情人)',4298490);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','12345678'),(5,'admin1','1234567'),(6,'admin2','1234567'),(7,'admin3','secret1234567'),(8,'admin4','secret1234567'),(9,'admin5','secret1234567'),(10,'admin7','secret123456'),(11,'admin8','secret123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
