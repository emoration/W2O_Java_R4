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

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `department_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`department_name`) values (1,'myDepartment');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(30) CHARACTER SET latin1 NOT NULL,
  `email` varchar(60) CHARACTER SET latin1 NOT NULL,
  `gender` int(11) NOT NULL,
  `department` int(11) NOT NULL,
  `birth` varchar(30) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`last_name`,`email`,`gender`,`department`,`birth`) values (1,'hhh','1@qq.com',1,1,'2002-02-02');

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  `fav` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_song_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`id`,`user_id`,`song_id`,`fav`) values (1,1,1,0),(2,1,2,0),(3,1,3,1),(4,2,1,0),(5,2,2,0),(6,2,3,1),(8,3,1,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;

/*Data for the table `song` */

insert  into `song`(`id`,`duration`,`artist`,`album`,`name`,`rid`) values (1,'2:42','幻想与现实','b','In The Shadow Of The Sun (remi',219045814),(2,'14:3','陈安之','','b(潜意识的确认录音带)',4366863),(3,'2:32','BamBam (뱀뱀)','B','Slow Mo',206833220),(4,'2:8','TRVP&B&Denny Well&Enemy Style','L.A. VIBES','De Lunes a Jueves',93163920),(5,'3:9','B&E','Chords To Live By','Poverty',35522331),(6,'4:34','Supercar','B','PINK ROCK',1272546),(7,'3:6','Jaden Smith','SYRE','B',35482769),(8,'3:29','R&b','天国的嫁衣 电视剧原声带','多一天爱一点',51497825),(9,'7:12','B&Og','John Digweed Re:Structured','Ava',55799691),(10,'3:9','B','','黑毒',20274732),(11,'6:33','B.','Struggling (Limited Edition)','Hurricane',32102024),(12,'3:51','B.','Struggling (Limited Edition)','Part-E',32102023),(13,'4:22','Santana&The Product G&B','Party Hits: Summer Edition (Ex','Maria Maria',9866343),(14,'3:8','R&b','The Heart of Clay','Tonight',38656164),(15,'5:46','B&B Yoga&MUSIC&Bill Webb','Music for Power Yoga','Solar Power',33485058),(16,'68:0','黄子华','','b(儿童不宜)',4369592),(18,'66:0','DJ舞曲','','B(口水坚江门大上海俱乐部 年超牛 现场)',4782186),(19,'5:20','DJ & B','Resistance','Resistance',86623915),(20,'3:57','Santana&The Product G&B','30 Stars: Chill','Maria Maria(Radio Edit)',29247646),(41,'2:58','A','Hi-Fi Serious (Explicit)','Something’s Going On',417690),(42,'3:16','A','Hi-Fi Serious (Explicit)','Starbucks',417689),(43,'2:21','M&A&Бэтси','Симпл димпл поп ит сквиш','Симпл димпл поп ит сквиш',181797534),(44,'4:59','胎教音乐宝典','','A(卓人右脑 脑波音乐)',4713265),(45,'3:37','A','Hi-Fi Serious (Explicit)','The Distance',417695),(46,'4:0','Blutch','Equilibrium','A.',7975429),(47,'5:28','瑜伽','','A(Spa 静心瑜珈音乐 奔向你期待的森林)',4254144),(48,'3:27','A','Hi-Fi Serious (Explicit)','W.D.Y.C.A.I.',417685),(49,'3:1','GOT7','GOT♡','A(Korean ver.)',4800757),(50,'1:44','三冬三夏','PEP三年级上册英语','A(P16)',244397879),(51,'0:42','三冬三夏','PEP三年级上册英语','A (P15)',244397427),(52,'3:43','A','Hi-Fi Serious (Explicit)','Shut Yer Face',417694),(53,'5:16','锅巴男孩','后室音乐合集','A',241750273),(54,'4:2','A-','','So Cold (The Good Wife Trailer) (cover: Ben Cocks)',140707022),(55,'3:12','苦珀kuper','A','皎',173490999),(56,'4:1','电子琴','','A(人间第一情)',4260248),(58,'4:2','A','','Ouvertura',10785340),(59,'3:27','A','','烟花三月下扬州',20422895),(101,'3:22','孟美岐&周震南','C','C',98319953),(103,'10:55','@c','Music for Empty Spaces','76.6',26753517),(104,'3:11','ZZX','C','C49',74375298),(105,'1:19','沈波','C (纯音乐)','C(琵琶版)',169396618),(106,'1:19','沈波','C (纯音乐)','C(二胡版)',169396594),(107,'1:19','沈波','C (纯音乐)','C(古筝版)',169396646),(108,'1:53','沈波','C','C(钢琴版)',140541782),(109,'3:6','沈波','C','与梦同行(钢琴版)',153155570),(110,'1:19','沈波','C (纯音乐)','C(扬琴版)',169406070),(111,'3:54','ZZX','C','C149',74375212),(112,'3:6','沈波','C','与梦同行(扬琴版)',153155567),(113,'4:45','C&K','アサトヒカリ','アサトヒカリ',143369722),(114,'1:8','C','一样','我们的理想(其他)',213611274),(116,'3:6','沈波','C','与梦同行(琵琶版)',153155568),(118,'2:58','Yoga','C','冲鸭',187546957),(119,'4:54','C&K','Y','GOOD LUCK',26139004),(120,'3:12','C & M a Gospel Singers','C & M a Gospel Singers','Jesus Remembered You',7945784),(121,'3:4','蔡徐坤','1','You Can Be My GirlFriend',50191880),(122,'3:5','蔡徐坤','1','Pull Up',50191879),(123,'0:10','陈洁丽','','1(猪猪侠主题曲)',155927434),(124,'3:45','蔡徐坤','1','It’s You',50191881),(125,'78:0','DJ小鱼儿','DJ小鱼儿国语串烧精选集N0;1','DJ小鱼儿国语串烧精选集N0;1',28057722),(126,'4:11','王俊凯','','1',4809904),(127,'6:33','张帝','','1(张帝专辑十一歌问答张帝张帝)',4303849),(128,'3:51','MOB CHOIR','1','Exist',245307059),(130,'61:0','团长','432HZ音乐','放下手中的工作，一起冥想，放空，疗愈；(1)',207141528),(131,'3:34','Oscar Scheller&Lily Allen','1%','1%',72115461),(132,'5:7','佛教音乐','礼赞观音菩萨合集','1(观世音菩萨治病真言)',4395109),(133,'3:4','Elaine','1','I Want You',64390038),(134,'0:51','汪苏泷','','1(不分手的恋爱铃声汪)',4665675),(135,'4:50','胡杨林','','1(你身上有她的香水味)',4569454),(138,'2:5','The Beatles','1 (Remastered)','Yesterday(Remaster)',40837771),(139,'4:25','刘德华','','1(爱是没有尽头)',4213115),(140,'4:53','周传雄','','1(小刚 吉普塞的情人)',4298490),(181,'2:4','5limebam','Life Slime You (Explicit)','B.C.(Explicit)',169902706),(182,'1:8','Shoeless','The Lost Year (Explicit)','B.C.',168589008),(183,'3:29','Chris122','B&C (Explicit)','B&C(Explicit)',160586472),(184,'2:45','BC','Circle of Life Volume 2 (Explicit)','Game Play(Explicit)',149180921),(185,'3:6','Antoni Frankowski','L6','BC',7971937),(186,'3:3','BC','','青鸟指弹（节目） (cover: 李森茂sam)',142109380),(187,'3:57','Santigold&B.C','99 Cents','Can’t Get Enough Of Myself',6855255),(188,'1:28','B&C','下雨了 我好想你','I lose my soul',146225406),(189,'2:47','B$C','','哭泣的女人',144484723),(190,'1:31','B&C','下雨了 我好想你','miss u',146225408),(191,'2:19','BC','','黑人抬棺 (cover: 寐加岛)',142137469),(192,'4:20','宇多田ヒカル','First Love','B&C(Album Version)',45808487),(193,'4:37','宇多田ヒカル','Movin’ on without you','B&C',994231),(195,'2:32','P4TTY&BC','STREET VIEW (Explicit)','Baby (feat. BC)',263103622),(196,'2:40','B.C.','Running Out of Time (Explicit)','Running Out of Time(Explicit)',262206080),(197,'2:40','B.C','Rule 1 (Explicit)','Rule 1(Explicit)',261424653),(198,'3:47','B.C.','U Can Smell It on Me (Explicit)','U Can Smell It on Me(Explicit)',261284816),(199,'2:51','Junker Team&DoppiaDfaidischi','BC (Explicit)','SCHIAVITU’(Explicit)',259480832),(200,'2:26','Junker Team&Madd&Rico F','BC (Explicit)','LENTO(Explicit)',259480815),(241,'2:0','姚贝娜','大丈夫 电视剧原声带','至少还有你',4049098),(242,'3:47','姚贝娜','冰雪奇缘 中文版电影原声带','随它吧(中文版)',6210425),(243,'4:11','姚贝娜&肖山','记得我们有约','我记得你眼里的依恋',5014883),(244,'2:46','姚贝娜','甄嬛传 电视剧原声带','红颜劫',11023347),(245,'3:53','姚贝娜','时间都去哪儿了','时间都去哪儿了',23543034),(246,'3:25','姚贝娜','姚贝娜影视音乐精选辑','惊鸿舞',3554868),(248,'5:26','姚贝娜','画皮Ⅱ 电影原声带','画情',1427647),(249,'4:34','姚贝娜','2014央视春晚','天耀中华(Live)',3997383),(250,'3:47','姚贝娜','Let It Go The Complete Set (From “Frozen”)','随它吧(Mandarin End Credit Version)',4109232),(251,'4:18','姚贝娜','','矜持',5234289),(252,'5:11','姚贝娜','御龙在天 游戏原声带','御龙吟',10378687),(253,'2:33','姚贝娜','姚贝娜影视音乐精选辑','采莲',51463923),(254,'5:4','姚贝娜','空','鱼(Live)',14365460),(255,'1:2','夜未洺','自娱自乐','12',190223900),(256,'1:30','姚贝娜','','我要你幸福(单曲)',77117619),(257,'3:47','姚贝娜','天生骄傲','随它吧',39752103),(259,'3:4','姚贝娜','2014湖北卫视新年环球狂欢夜','也许明天',3950759),(260,'3:50','等一下就回家','月球的背面，我去过哪里','1/2',188858114),(261,'1:39','J-I-E','Xin Đừng Nhấc Máy','123(降调版)',223044948),(262,'4:27','Gu’Brian','Check This Out EP','1 2 3(Original Mix)',39431778),(263,'3:48','张震岳&Fusion乐团','男生女生配','123',372670),(264,'3:3','幼稚不hiphop','123','苦咖啡·唯一 (cover: 那奇沃夫|KKECHO)',263677206),(265,'3:23','十豆彡吖','123','从实招来 (cover: 邹念慈)',178133645),(266,'3:31','甄咏珊','花嫁','花嫁',55420700),(267,'3:34','Gloria Estefan','Greatest Hits','1，2，3(Remix)',168974038),(268,'4:59','アフターザレイン&そらる&まふまふ','１・２・３','１・２・３',84778754),(269,'3:32','AB6IX','COMPLETE WITH YOU','1， 2， 3',206489431),(272,'3:33','Gloria Estefan&Miami Sound Machine','Let It Loose','1-2-3',2163142),(273,'4:49','鏡音リン&&カラスヤサボウ','','1、2、3(リン&レンVer.)',10338118),(275,'3:25','nicoten','Nicoten','1.2.3',8055710),(277,'1:38','儿童歌曲','童歌精选(7)','1.2.3.',7182942),(278,'3:38','LOVE PSYCHEDELICO','LOVE YOUR LOVE','1 2 3(Demo Acoustic Version)',26394317),(279,'3:3','X布丁','小布丁广场舞舞曲专辑一','123(00121)P4包青天）',201542116),(280,'3:33','YK丶安安','123','不是因为寂寞才想你 (cover: 王小帅)',182494742);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (13,'admin','uaC5IVmxAAALUrzI3y+NWQ==');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
