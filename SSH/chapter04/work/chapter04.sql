DROP  DATABASE IF EXISTS  `Renting`;
CREATE DATABASE `Renting`;
USE `Renting`;
##USERS TABLES
DROP  TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS`(
	`ID` INT(4) PRIMARY KEY AUTO_INCREMENT,
	NAME NVARCHAR(50) NOT NULL,
	PASSWORD  NVARCHAR(50),
	`TELEPHONE`  NVARCHAR(15),
	`USERNAME`  NVARCHAR(50),
	`ISADMIN` NVARCHAR(5)
)ENGINE=INNODB AUTO_INCREMENT=1101 DEFAULT CHARSET=utf8;
## TYPE TABLE
DROP  TABLE IF EXISTS TYPE;
CREATE TABLE TYPE(
	`ID` INT(4) PRIMARY KEY AUTO_INCREMENT,
	`NAME` NVARCHAR(50) NOT NULL
)ENGINE=INNODB AUTO_INCREMENT=2201 DEFAULT CHARSET=utf8;

## DISTRICT TABLE
DROP  TABLE IF EXISTS `DISTRICT`;
CREATE TABLE `DISTRICT`(
	`ID` INT(4) PRIMARY KEY AUTO_INCREMENT,
	`NAME` NVARCHAR(50) NOT   NULL
)ENGINE=INNODB AUTO_INCREMENT=3301 DEFAULT CHARSET=utf8;

## STREET TABLE
DROP  TABLE IF EXISTS `STREET`;
CREATE TABLE `STREET`(
	`ID` INT(4) PRIMARY KEY AUTO_INCREMENT,
	`NAME` NVARCHAR(50) NOT NULL,
	`DISTRICT_ID`  INT(4)
)ENGINE=INNODB AUTO_INCREMENT=4401 DEFAULT CHARSET=utf8;

## HOUSE TABLE
DROP  TABLE IF EXISTS `HOUSE`;
CREATE TABLE `HOUSE`(
	`ID` INT(6) PRIMARY KEY AUTO_INCREMENT,
	`TITLE` NVARCHAR(50),
	`DESCRIPTION` NVARCHAR(2000),
	`PRICE` INT(6),
	`PUBDATE` DATE,
	`FLOORAGE` INT(4),
	`CONTACT` NVARCHAR(100),
	`USER_ID` INT(4),
	`TYPE_ID` INT(4),
	`STREET_ID` INT(4)
)ENGINE=INNODB AUTO_INCREMENT=5501 DEFAULT CHARSET=utf8;
ALTER TABLE `STREET` ADD CONSTRAINT FK_DISTRICT_ID FOREIGN KEY(`DISTRICT_ID`) REFERENCES `DISTRICT`(`ID`);
ALTER TABLE `HOUSE` ADD CONSTRAINT FK_USER_ID FOREIGN KEY(`USER_ID`) REFERENCES `USERS`(`ID`);
ALTER TABLE `HOUSE` ADD CONSTRAINT FK_TYPE_ID FOREIGN KEY(`TYPE_ID`) REFERENCES `TYPE`(`ID`);
ALTER TABLE `HOUSE` ADD CONSTRAINT FK_STREET_ID FOREIGN KEY(`STREET_ID`) REFERENCES `STREET`(`ID`);
##用户表
INSERT INTO `USERS` VALUES(DEFAULT,'张三','jbit','18679829381','jbit','1'); 
INSERT INTO `USERS` VALUES(DEFAULT,'李四','bdqn','18679829382','bdqn','1'); 
INSERT INTO `USERS` VALUES(DEFAULT,'王五','admin','18679829383','admin','2'); 
INSERT INTO `USERS` VALUES(DEFAULT,'李兰花','bdqn1','18679829384','bdqn1','1'); 
INSERT INTO `USERS` VALUES(DEFAULT,'刘震云','tiger','18679829385','scott','1'); 
INSERT INTO `USERS` VALUES(DEFAULT,'王辰辰','sys','18679829386','sys','2'); 

##类型表
INSERT INTO `TYPE` VALUES(DEFAULT,'1房1厅1卫');
INSERT INTO `TYPE` VALUES(DEFAULT,'1房0厅1卫');
INSERT INTO `TYPE` VALUES(DEFAULT,'2房0厅1卫');
INSERT INTO `TYPE` VALUES(DEFAULT,'2房1厅1卫');
INSERT INTO `TYPE` VALUES(DEFAULT,'3房1厅1卫');


##区县表
INSERT INTO `DISTRICT` VALUES(DEFAULT,'福田区');
INSERT INTO `DISTRICT` VALUES(DEFAULT,'罗湖区');
INSERT INTO `DISTRICT` VALUES(DEFAULT,'宝安区');
INSERT INTO `DISTRICT` VALUES(DEFAULT,'南山区');
INSERT INTO `DISTRICT` VALUES(DEFAULT,'盐田区');

##街道表
INSERT INTO `STREET` VALUES(DEFAULT,'华强北街道',3301);
INSERT INTO `STREET` VALUES(DEFAULT,'深南中路',3301);
INSERT INTO `STREET` VALUES(DEFAULT,'福田街道',3301);
INSERT INTO `STREET` VALUES(DEFAULT,'沿河南路',3302);
INSERT INTO `STREET` VALUES(DEFAULT,'爱国路',3302);
INSERT INTO `STREET` VALUES(DEFAULT,'粤宝路',3302);
INSERT INTO `STREET` VALUES(DEFAULT,'南环路',3303);
INSERT INTO `STREET` VALUES(DEFAULT,'新玉路',3303);
INSERT INTO `STREET` VALUES(DEFAULT,'海滨路',3303);
INSERT INTO `STREET` VALUES(DEFAULT,'茶光路',3304);
INSERT INTO `STREET` VALUES(DEFAULT,'翻身路',3304);
INSERT INTO `STREET` VALUES(DEFAULT,'新安',3304);
INSERT INTO `STREET` VALUES(DEFAULT,'永安北一街',3305);
INSERT INTO `STREET` VALUES(DEFAULT,'深盐路',3305);
INSERT INTO `STREET` VALUES(DEFAULT,'临海路',3305);

##房屋信息表
INSERT INTO `HOUSE` VALUES(DEFAULT,'双地铁口 梅林的繁华地段 闹中取静','小区门口就是地铁4号线，9号线,贯穿深圳的东南西北，出行便捷。自驾可走北环高速，皇岗路，都很方便。',23000,'2019-01-01',200,'张先生',1101,2205,4401);
INSERT INTO `HOUSE` VALUES(DEFAULT,'新潮装修，看花园林园小区，方正舒适，带车位','此房是正规房，新潮装修，方正大体，南向采光好，带有固定停车位',23000,'2019-01-08',210,'王先生',1103,2202,4402);
INSERT INTO `HOUSE` VALUES(DEFAULT,'星河国际精装1房 南北通透 随时可看 拎包入住','星河国际花园空中花园，小区自带游泳池、会所等等，星河物业，车位充足！',1800,'2019-02-02',50,'王先生',1103,2201,4401);
INSERT INTO `HOUSE` VALUES(DEFAULT,'朝向视野好，无遮挡，通风采光好，干净整洁，欢迎入住','房子是复式一房一厅，客厅和卫生间，落地窗阳台，，实际使用面积比较大，空间很宽敞。楼上楼梯间可做小客厅或者放一张上床下桌',6000,'2019-03-02',61,'李小姐',1101,2203,4403);
INSERT INTO `HOUSE` VALUES(DEFAULT,'福田中 心会展中 心旁花园小区105平大两房','房子是正规的三房改的两房，房间面积很大。一厨两卫的，南向朝花园，安静',12000,'2019-01-26',32,'刘先生',1105,2204,4403);
INSERT INTO `HOUSE` VALUES(DEFAULT,'（客厅大阳台，精装）享得繁华都市生活就此红树西岸','红树西岸 精装修 两房 高楼层 视野开阔 安静海景 红树林景高尔夫景',30000,'2019-01-26',30,'张先生',1101,2205,4410);
INSERT INTO `HOUSE` VALUES(DEFAULT,'伍兹公寓，通透敞亮大四房 高层看大海','采光好，户型方正，交通便利，小区舒适，适宜居住，密度低，南北通透，楼层好',16000,'2019-01-26',56,'王先生',1103,2202,4411);
INSERT INTO `HOUSE` VALUES(DEFAULT,'英伦名苑凤凰楼层，南北通透，品质生活的选择','本房是澳城居家的户型，三房两卫，客厅出一个大阳台，东北看阳光海滨花园，采光视野还很好。客厅餐厅，卧室都南北通透',1800,'2019-02-26',70,'王先生',1106,2203,4412);
INSERT INTO `HOUSE` VALUES(DEFAULT,'湾厦地铁澳城花园一期居家经典大三房，南北通透大阳台','御景东方正规3房，东南向，大阳台，少有放租 .户型方正、，东南朝向，客厅出圆弧观景大阳台',6000,'2019-01-6',140,'李小姐',1101,2201,4410);
INSERT INTO `HOUSE` VALUES(DEFAULT,'海景花园精装3房 家私齐拎包入住 近沃尔玛华侨城站','装修比较新颖，保养好家私家具齐全，安静整洁拎包入住。房子为大户型，适合一家人一起住',3000,'2019-03-20',200,'刘先生',1105,2204,4411);
INSERT INTO `HOUSE` VALUES(DEFAULT,'窝趣轻社区 窝趣大望轻社区 年租减免 开间','此房为东北向的四居室，主卧，一个次卧和客厅朝东南，另外两个卧室朝西南，不错的朝向，打开大门能形成良好的自然通风，主卧带独立卫生间，另外一个卫生间为其他房间公用',7500,'2019-01-08',40,'张先生',1101,2205,4404);
INSERT INTO `HOUSE` VALUES(DEFAULT,'长丰苑正规大两房 客厅出阳台 面积大 采光好','下约50米处有地铁黄贝岭站2号5号线D出口，黄贝岭公交站等交通便利，2016年底9号线的起点站文锦站就在（500米）处',8500,'2019-01-21',134,'王先生',1103,2202,4405);
INSERT INTO `HOUSE` VALUES(DEFAULT,'环岛丽园 居家户型 温馨舒适 诚心出租','房子是小三房改的两房，是南北通的户型，有个卧室很大，业主诚心出租的，找住家或者白领客户，挂盘时间长，急租',6000,'2019-02-20',250,'王先生',1103,2201,4406);
INSERT INTO `HOUSE` VALUES(DEFAULT,'窝趣轻社区 窝趣大望轻社区 金榜题名','HI~我是窝趣，铂涛集团旗下“”青年长租公寓品牌，开创了集舒适居住与轻松社交于一体的新品类——轻社区',2200,'2019-03-09',20,'李小姐',1101,2203,4404);
INSERT INTO `HOUSE` VALUES(DEFAULT,'温馨居家，大空房，居家的好选择，满足您的一切需求','小区离湖贝A出口大约500米左右路程，离国贸地铁口1000米左右，多路公交线（春风万家公交站），还有地铁9向西站B出口',10000,'2019-02-26',39,'刘先生',1105,2204,4405);
INSERT INTO `HOUSE` VALUES(DEFAULT,'城家公寓 留仙洞店 一居室C 开间','从小区出发到11号线碧海湾站只需要70米的距离（亲测），到地铁1号线西乡站需要500米的距离（亲测）',2700,'2019-02-23',80,'张先生',1101,2205,4410);
INSERT INTO `HOUSE` VALUES(DEFAULT,'宝中 壹方城商圈精装三房，一号五号双地铁口物业','距离地铁1号线西乡站1.6公里，11号线碧海湾站1公里,公交：305路上行(笋岗百安居-强荣东工业区)',8600,'2019-03-16',58,'王先生',1103,2202,4411);
INSERT INTO `HOUSE` VALUES(DEFAULT,'城家公寓 留仙洞店 一居室B 开间','看房方便 ，家私电齐全，可以拎包入住 ， 阳台宽大采光好 ，房子保养不错',1800,'2019-03-12',75,'王先生',1106,2203,4412);
INSERT INTO `HOUSE` VALUES(DEFAULT,'尚都花园小区 三地铁口物业 近壹方城','5号线：宝安中-心站；15号线:宝安中-心、宝体站 11号线宝安站，交通枢纽：宝安汽车站 ，宝安大道，107国道，沿江高速，',11000,'2019-03-01',140,'李小姐',1101,2201,4410);
INSERT INTO `HOUSE` VALUES(DEFAULT,'碧家国际社区 塘尾十一区店 黄金时代大床房 开间','小区是属于双地铁口物业，距离小区563米（来源于高德地图）就是1号线和5号线交汇处，可通往南山科技园，罗湖国贸，宝安机场，小区可直接上宝安大道',1300,'2019-03-20',190,'刘先生',1105,2204,4411);
INSERT INTO `HOUSE` VALUES(DEFAULT,'户型方正 使用率高 关口物业 交通便利','居家装修，24小时安保，小区环境好有停车场。关口物业。房子得房率高，使用性好。采光充足。位置好，交通方便。',4000,'2019-01-21',25,'张先生',1101,2205,4413);
INSERT INTO `HOUSE` VALUES(DEFAULT,'蓝山雅园 精装修带家私家电 高楼层采光好','房源位于高层，采光充足，并且阳台很长，其他小区的风景也能尽收眼底。',5000,'2019-01-29',47,'王先生',1106,2202,4413);
INSERT INTO `HOUSE` VALUES(DEFAULT,'优质房源 精致装修 环境安静优美 适合居住','倚山花园三期 优质房源 价格合适 精致装修 环境安静优美 适合居住',1800,'2019-03-25',60,'王先生',1106,2203,4414);
INSERT INTO `HOUSE` VALUES(DEFAULT,'优质房源 精致装修 环境安静优美 适合居住','客厅较大，宽敞明亮，四个卧室，一个大阳台，晾晒衣服方便，采光较好，精致实用',6000,'2019-01-23',66,'李小姐',1101,2201,4414);
INSERT INTO `HOUSE` VALUES(DEFAULT,'家私电齐全 海景房 看房方便 车位充足 拎包入住','小区环境好，安静，适宜居住。配套小区有菜市场可以满足生活需求，离万科壹海城广富百货等',13000,'2019-01-20',151,'刘先生',1105,2205,4415);
INSERT INTO `HOUSE` VALUES(DEFAULT,'精装复式 背靠翠竹宜居宜家 近喜荟城近地铁 复式','房位于深圳市罗湖太宁路，有百仕达花园公交站台1路，320路，376路，有地铁5号线和7号线太安站300米左右，田贝站3号线和7号约500米左右。',23000,'2019-01-20',183,'王先生',1103,2201,4401);
INSERT INTO `HOUSE` VALUES(DEFAULT,'整租 · 电梯房，地铁房，南北通透，精装修，交通便利。','此房三房两厅南北通透，客厅带大阳台，采光亮堂通透，户型方正。',8500,'2019-01-21',73,'王先生',1103,2202,4412);
INSERT INTO `HOUSE` VALUES(DEFAULT,'海境界 户型方正 家私齐全，居家装修','家私齐全，装修用心，细节到位，保养的好，高层视野，通风效果也挺好，可看点远海',7000,'2019-01-22',94,'王先生',1103,2203,4413);
INSERT INTO `HOUSE` VALUES(DEFAULT,'精装修 一线看海 拎包入住 南北通透','本房源真实有效，业主诚心出租，房产为：156平米的大三房两厅两卫双阳台，主卧带洗手间，客厅出阳台看海景，景观超级漂亮，',7400,'2019-01-23',90,'王先生',1103,2204,4410);
INSERT INTO `HOUSE` VALUES(DEFAULT,'房子面积大，采光好，离地铁站近','小区楼下就是11号线地铁碧海湾F出口，3个站到南山7个站福田，1个站到机场，距西乡地铁站400米，小区门口就是公交站，走宝安大道，西乡大道，107以及沿江高速出行很方便。',6900,'2019-01-24',82,'王先生',1103,2205,4401);


ALTER TABLE `HOUSE` ADD COLUMN `house_image` VARCHAR(20) NULL;


SELECT * FROM `HOUSE`;