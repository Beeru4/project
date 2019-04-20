/*
SQLyog Community v12.3.3 (64 bit)
MySQL - 5.5.54 : Database - renting_room
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`renting_room` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `renting_room`;

/*Table structure for table `district` */

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

/*Data for the table `district` */

insert  into `district`(`id`,`name`) values 
(1000,'丰台'),
(1001,'东城'),
(1002,'西城'),
(1003,'石景山'),
(1004,'海淀'),
(1006,'朝阳'),
(1007,'福田区');

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `id` int(6) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `pubdate` date DEFAULT NULL,
  `floorage` int(4) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `user_id` int(4) DEFAULT NULL,
  `type_id` int(4) DEFAULT NULL,
  `street_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `house` */

insert  into `house`(`id`,`title`,`description`,`price`,`pubdate`,`floorage`,`contact`,`user_id`,`type_id`,`street_id`) values 
(1001,'皇冠澳门赌场','000000000000000',1000000,'2019-03-26',1200,'房东',77,1000,1001),
(6612,'双地铁口 梅林的繁华地段 闹中取静','小区门口就是地铁4号线，9号线,贯穿深圳的东南西北，出行便捷。自驾可走北环高速，皇岗路，都很方便。',23000,'2019-01-01',200,'张先生',1000,1166,1002),
(6613,'新潮装修，看花园林园小区，方正舒适，带车位','此房是正规房，新潮装修，方正大体，南向采光好，带有固定停车位',23000,'2019-01-08',210,'王先生',60,1133,1003),
(6614,'星河国际精装1房 南北通透 随时可看 拎包入住','星河国际花园空中花园，小区自带游泳池、会所等等，星河物业，车位充足！',1800,'2019-02-02',50,'王先生',1001,1122,1004),
(6615,'朝向视野好，无遮挡，通风采光好，干净整洁，欢迎入住','房子是复式一房一厅，客厅和卫生间，落地窗阳台，，实际使用面积比较大，空间很宽敞。楼上楼梯间可做小客厅或者放一张上床下桌',6000,'2019-03-02',61,'李小姐',1001,1144,1005),
(6616,'福田中 心会展中 心旁花园小区105平大两房','房子是正规的三房改的两房，房间面积很大。一厨两卫的，南向朝花园，安静',12000,'2019-01-26',32,'刘先生',1002,1155,1006),
(6617,'（客厅大阳台，精装）享得繁华都市生活就此红树西岸','红树西岸 精装修 两房 高楼层 视野开阔 安静海景 红树林景高尔夫景',30000,'2019-01-26',30,'张先生',1002,1166,1007),
(6618,'伍兹公寓，通透敞亮大四房 高层看大海','采光好，户型方正，交通便利，小区舒适，适宜居住，密度低，南北通透，楼层好',16000,'2019-01-26',56,'王先生',60,1133,1001),
(6619,'英伦名苑凤凰楼层，南北通透，品质生活的选择','本房是澳城居家的户型，三房两卫，客厅出一个大阳台，东北看阳光海滨花园，采光视野还很好。客厅餐厅，卧室都南北通透',1800,'2019-02-26',70,'王先生',77,1144,1002),
(6620,'湾厦地铁澳城花园一期居家经典大三房，南北通透大阳台','御景东方正规3房，东南向，大阳台，少有放租 .户型方正、，东南朝向，客厅出圆弧观景大阳台',6000,'2019-01-06',140,'李小姐',1001,1122,1003),
(6621,'海景花园精装3房 家私齐拎包入住 近沃尔玛华侨城站','装修比较新颖，保养好家私家具齐全，安静整洁拎包入住。房子为大户型，适合一家人一起住',3000,'2019-03-20',200,'刘先生',1002,1155,1004),
(6622,'窝趣轻社区 窝趣大望轻社区 年租减免 开间','此房为东北向的四居室，主卧，一个次卧和客厅朝东南，另外两个卧室朝西南，不错的朝向，打开大门能形成良好的自然通风，主卧带独立卫生间，另外一个卫生间为其他房间公用',7500,'2019-01-08',40,'张先生',1001,1166,1005),
(6623,'长丰苑正规大两房 客厅出阳台 面积大 采光好','下约50米处有地铁黄贝岭站2号5号线D出口，黄贝岭公交站等交通便利，2016年底9号线的起点站文锦站就在（500米）处',8500,'2019-01-21',134,'王先生',60,1133,1006);

/*Table structure for table `street` */

DROP TABLE IF EXISTS `street`;

CREATE TABLE `street` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `district_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

/*Data for the table `street` */

insert  into `street`(`id`,`name`,`district_id`) values 
(1001,'中关村大街',1004),
(1002,'学院路',1004),
(1003,'朝阳路',1006),
(1004,'华南街道',1006),
(1005,'华强北街道',1007),
(1006,'华强南街道',1006),
(1007,'中山街道',1007);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`name`) values 
(1000,'一室一厅'),
(1001,'一室两厅'),
(1002,'两室一厅'),
(1003,'两室两厅'),
(1004,'三室一厅'),
(1005,'三室两厅'),
(1006,'四室一厅'),
(1007,'四室两厅'),
(1008,'四十三厅');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `isadmin` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`password`,`telephone`,`username`,`isadmin`) values 
(60,'ACCP6','123',NULL,NULL,NULL),
(77,'accp5','123',NULL,NULL,NULL),
(1000,'admin','123',NULL,NULL,NULL),
(1001,'accp','123',NULL,NULL,NULL),
(1002,'jbit','123',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
