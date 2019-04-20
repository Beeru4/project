DROP DATABASE IF EXISTS `SMBMS`;
CREATE  DATABASE `SMBMS`;
USE `SMBMS`;

#用户表 记录用户信息
DROP DATABASE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,	#用户ID
    `userCode` VARCHAR(15),						#用户编码 登录时使用的账号
    `userName` VARCHAR(15),						#用户姓名
    `userPassword` VARCHAR(15),					#用户密码	
    `gender` INT(10),							#性别 0 代表男 1代表女
    `birthday` DATE,							#出生日期
    `phone` VARCHAR(15),						#手机
    `address` VARCHAR(30),						#地址
    `userRole` INT(10),							#用户角色(取自角色表-角色id)
    `createBy` BIGINT(20),						#创建者(userId)
    `creationDate` DATETIME,					#创建时间
    `modifyBy` BIGINT,							#更新者 (userId)
    `modifyDate` DATETIME						#更新时间
)ENGINE = INNODB  AUTO_INCREMENT = 1101 DEFAULT CHARSET = UTF8;

#地址表
DROP DATABASE IF EXISTS `smbms_address`;
CREATE TABLE `smbms_address`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT, #主键ID
    `contact` VARCHAR(15),						#联系人姓名
    `addressDesc` VARCHAR(50),					#收货地址明细
    `postCode` VARCHAR(15),						#邮编
    `tel` VARCHAR(20),							#联系人电话
    `createBy` BIGINT(20),						#创建者
    `creationDate` DATETIME,					#创建时间
    `modifyBy` BIGINT,							#修改者
    `modifyDate` DATETIME,						#修改时间
    `userId` BIGINT(20)							#用户ID
)ENGINE = INNODB  AUTO_INCREMENT = 2201 DEFAULT CHARSET = UTF8;

##订单表
DROP DATABASE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,	#主键ID
    `billCode` VARCHAR(20),						#账单编码			
    `productName` VARCHAR(20),					#商品名称	
    `productDesc` VARCHAR(50),					#商品描述	
    `productUnit` VARCHAR(10),					#商品单位	
    `productCount` DECIMAL(20,2),				#商品数量		
    `totalPrice` DECIMAL(20,2),					#商品总额		
    `isPayment` INT(10),						#是否支付（1：未支付 2：已支付）
	`createBy` BIGINT(20),						#创建者(userId)
    `creationDate` DATETIME,					#创建时间	
    `modifyBy` BIGINT,							#更新者(userId)
    `modifyDate` DATETIME,						#更新时间
    `providerId` BIGINT(20)						#供应商ID
)ENGINE = INNODB  AUTO_INCREMENT = 3301 DEFAULT CHARSET = UTF8;

##角色表
DROP DATABASE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,	#主键ID
    `roleCode` VARCHAR(20),						#角色编码
    `roleName` VARCHAR(20),						#角色名称
    `createBy` BIGINT(20),						#创建者
    `creationDate` DATETIME,					#创建时间
    `modifyBy` BIGINT,							#修改者
    `modifyDate` DATETIME						#修改时间
);


##供应商表
DROP DATABASE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,	#主键ID
    `proCode` VARCHAR(20),						#供应商编码
    `proName` VARCHAR(20),						#供应商名称
    `proDesc` VARCHAR(20),						#供应商详细地址
    `proContact` VARCHAR(20),					#供应商联系人
    `proPhone` VARCHAR(20),						#联系电话
    `proAddress` VARCHAR(20),					#地址	
    `proFax` VARCHAR(20),						#传真
    `createBy` BIGINT(20),						#创建者(userID)
    `creationDate` DATETIME,					#创建数据
    `modifyBy` BIGINT,							#修改者
    `modifyDate` DATETIME						#修改时间
)ENGINE = INNODB  AUTO_INCREMENT = 4401 DEFAULT CHARSET = UTF8;


#角色表
INSERT INTO`smbms_role` VALUES 
(DEFAULT,'SMBMS_ADMIN','系统管理员',1101,NOW(),NULL,NULL),
(DEFAULT,'SMBMS_MANAGER','经理',1101,NOW(),NULL,NULL),
(DEFAULT,'SMBMS_EMPLOYEE','普通员工',1101,NOW(),NULL,NULL);

#地址表
INSERT INTO`smbms_address` VALUES 
(DEFAULT,'成亮','深圳福田区福田路33号','518000','13678789999',1101,NOW(),NULL,NULL,1102),
(DEFAULT,'王晨','深圳市南山区南三路12号','518000','18567672312',1101,NOW(),NULL,NULL,1103),
(DEFAULT,'刘志毅','深圳市福田区深南中路20号','518000','13387906742',1101,NOW(),NULL,NULL,1104),
(DEFAULT,'王文志一','深圳市罗湖区罗湖街道306号','518000','13568902323',1101,NOW(),NULL,NULL,1105),
(DEFAULT,'刘奕呈','深圳市龙岗区龙城广场20号','518000','18032356666',1101,NOW(),NULL,NULL,1106),
(DEFAULT,'陈震','深圳市龙岗区布吉街道32号','518000','13787882222',1101,NOW(),NULL,NULL,1107);

#供应商
INSERT INTO `smbms_provider` VALUES
(DEFAULT,'BJ_GYS001','北京三木堂商贸有限公司','长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等','张国强','13566667777','北京市丰台区育芳园北路','010-58858787',1101,'2018-03-21 16:52:07',NULL,NULL),
(DEFAULT,'HB_GYS001','石家庄帅益食品贸易有限公司','长期合作伙伴，主营产品:饮料、水饮料、植物蛋白饮料、休闲食品、果汁饮料、功能饮料等','王军','13309094212','河北省石家庄新华区','0311-67738876',1101,'2018-04-13 04:20:40',NULL,NULL),
(DEFAULT,'GZ_GYS001','深圳市泰香米业有限公司','初次合作伙伴，主营产品：良记金轮米,龙轮香米等','郑程瀚','13402013312','广东省深圳市福田区深南大道6006华丰大厦','0755-67776212',1101,'2014-03-21 16:56:07',NULL,NULL),
(DEFAULT,'GZ_GYS002','深圳市喜来客商贸有限公司','长期合作伙伴，主营产品：坚果炒货.果脯蜜饯.天然花茶.营养豆豆.特色美食.进口食品.海味零食.肉脯肉','林妮','18599897645','广东省深圳市福龙工业区B2栋3楼西','0755-67772341',1101,'2018-03-22 16:52:07',NULL,NULL),
(DEFAULT,'JS_GYS001','兴化佳美调味品厂','长期合作伙伴，主营产品：天然香辛料、鸡精、复合调味料','徐国洋','13754444221','江苏省兴化市林湖工业区','0523-21299098',1101,'2018-11-22 16:52:07',NULL,NULL),
(DEFAULT,'BJ_GYS002','北京纳福尔食用油有限公司','长期合作伙伴，主营产品：山茶油、大豆油、花生油、橄榄油等','马莺','13422235678','北京市朝阳区珠江帝景1号楼','010-588634233',1101,'2018-03-21 17:52:07',NULL,NULL),
(DEFAULT,'BJ_GYS003','北京国粮食用油有限公司','初次合作伙伴，主营产品：花生油、大豆油、小磨油等','王驰','13344441135','北京大兴青云店开发区','010-588134111',1101,'2018-04-13 00:00:00',NULL,NULL),
(DEFAULT,'ZJ_GYS001','慈溪市广和绿色食品厂','长期合作伙伴，主营产品：豆瓣酱、黄豆酱、甜面酱，辣椒，大蒜等农产品','薛圣丹','18099953223','浙江省宁波市慈溪周巷小安村','0574-34449090',1101,'2018-11-21 06:02:07',NULL,NULL),
(DEFAULT,'GX_GYS001','优百商贸有限公司','长期合作伙伴，主营产品：日化产品','李立国','13323566543','广西南宁市秀厢大道42-1号','0771-98861134',1101,'2018-03-21 19:52:07',NULL,NULL),
(DEFAULT,'JS_GYS002','南京火头军信息技术有限公司','长期合作伙伴，主营产品：不锈钢厨具等','陈女士','13098992113','江苏省南京市浦口区浦口大道1号新城总部大厦A座903室','025-86223345',1101,'2018-03-25 16:52:07',NULL,NULL),
(DEFAULT,'GZ_GYS003','广州市白云区美星五金制品厂','长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等','梁天','13562276775','广州市白云区钟落潭镇福龙路20号','020-85542231',1101,'2018-12-21 06:12:17',NULL,NULL),
(DEFAULT,'BJ_GYS004','北京隆盛日化科技','长期合作伙伴，主营产品：日化环保清洗剂，家居洗涤专卖、洗涤用品网、墙体除霉剂、墙面霉菌清除剂等','孙欣','13689865678','北京市大兴区旧宫','010-35576786',1101,'2018-11-21 12:51:11',NULL,NULL),
(DEFAULT,'SD_GYS001','山东豪克华光联合发展有限公司','长期合作伙伴，主营产品：洗衣皂、洗衣粉、洗衣液、洗洁精、消杀类、香皂等','吴洪转','13245468787','山东济阳济北工业区仁和街21号','0531-53362445',1101,'2018-01-28 10:52:07',NULL,NULL),
(DEFAULT,'JS_GYS003','无锡喜源坤商行','长期合作伙伴，主营产品：日化品批销','周一清','18567674532','江苏无锡盛岸西路','0510-32274422',1101,'2018-04-23 11:11:11',NULL,NULL),
(DEFAULT,'ZJ_GYS002','乐摆日用品厂','长期合作伙伴，主营产品：各种中、高档塑料杯，塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯','王世杰','13212331567','浙江省金华市义乌市义东路','0579-34452321',1101,'2018-08-22 10:01:30',NULL,NULL);

##订单
INSERT INTO `smbms_bill` VALUES
(DEFAULT,'BILL2016_001','洗发水、护发素','日用品-洗发、护发','瓶','500.00','25000.00',2,1101,'2018-12-14 13:02:03',NULL,NULL,4403),
(DEFAULT,'BILL2016_002','香皂、肥皂、药皂','日用品-皂类','块','1000.00','10000.00',2,1101,'2018-03-23 04:20:40',NULL,NULL,4413),
(DEFAULT,'BILL2016_003','大豆油','食品-食用油','斤','300.00','5890.00',2,1101,'2018-12-14 13:02:03',NULL,NULL,4406),
(DEFAULT,'BILL2016_004','橄榄油','食品-进口食用油','斤','200.00','9800.00',2,1101,'2018-10-10 03:12:13',NULL,NULL,4407),
(DEFAULT,'BILL2016_005','洗洁精','日用品-厨房清洁','瓶','500.00','7000.00',2,1101,'2018-12-14 13:02:03',NULL,NULL,4409),
(DEFAULT,'BILL2016_006','美国大杏仁','食品-坚果','袋','300.00','5000.00',2,1101,'2018-04-14 06:08:09',NULL,NULL,4404),
(DEFAULT,'BILL2016_007','沐浴液、精油','日用品-沐浴类','瓶','500.00','23000.00',1,1101,'2018-07-22 10:10:22',NULL,NULL,4414),
(DEFAULT,'BILL2016_008','不锈钢盘碗','日用品-厨房用具','个','600.00','6000.00',2,1101,'2018-04-14 05:12:13',NULL,NULL,4414),
(DEFAULT,'BILL2016_009','塑料杯','日用品-杯子','个','350.00','1750.00',2,1101,'2018-02-04 11:40:20',NULL,NULL,4414),
(DEFAULT,'BILL2016_010','豆瓣酱','食品-调料','瓶','200.00','2000.00',2,1101,'2018-10-29 05:07:03',NULL,NULL,4408),
(DEFAULT,'BILL2016_011','海之蓝','饮料-国酒','瓶','50.00','10000.00',1,1101,'2018-04-14 16:16:00',NULL,NULL,4401),
(DEFAULT,'BILL2016_012','芝华士','饮料-洋酒','瓶','20.00','6000.00',1,1101,'2018-09-09 17:00:00',NULL,NULL,4401),
(DEFAULT,'BILL2016_013','长城红葡萄酒','饮料-红酒','瓶','60.00','800.00',2,1101,'2018-11-14 15:23:00',NULL,NULL,4401),
(DEFAULT,'BILL2016_014','泰国香米','食品-大米','斤','400.00','5000.00',2,1101,'2018-10-09 15:20:00',NULL,NULL,4403),
(DEFAULT,'BILL2016_015','东北大米','食品-大米','斤','600.00','4000.00',2,1101,'2018-11-14 14:00:00',NULL,NULL,4403),
(DEFAULT,'BILL2016_016','可口可smbms_user乐','饮料','瓶','2000.00','6000.00',2,1101,'2018-03-27 13:03:01',NULL,NULL,4402),
(DEFAULT,'BILL2016_017','脉动','饮料','瓶','1500.00','4500.00',2,1101,'2018-05-10 12:00:00',NULL,NULL,4402),
(DEFAULT,'BILL2016_018','哇哈哈','饮料','瓶','2000.00','4000.00',2,1101,'2018-11-24 15:12:03',NULL,NULL,4402);

##用户
INSERT INTO `smbms_user` VALUES
(DEFAULT,'admin','系统管理员','123',0,'1983-10-10','13688889999','深圳市福田区成府路207号',1,1101,NOW(),NULL,NULL),
(DEFAULT,'liming','李明','123',1,'1983-12-10','13688884457','深圳市罗湖区前门东大街9号',2,1101,NOW(),NULL,NULL),
(DEFAULT,'hanlubiao','韩路彪','123',1,'1984-06-05','18567542321','深圳市福田区北辰中心12号',2,1101,NOW(),NULL,NULL),
(DEFAULT,'zhanghua','张华','123',0,'1983-06-15','13544561111','深圳市盐田区学院路61号',3,1101,NOW(),NULL,NULL),
(DEFAULT,'wangyang','王洋','123',1,'1982-12-31','13444561124','深圳市龙岗区西二旗辉煌国际16层',3,1101,NOW(),NULL,NULL),
(DEFAULT,'zhaoyan','赵燕','123',0,'1986-03-07','18098764545','深圳市龙岗区回龙观小区10号楼',3,1101,NOW(),NULL,NULL),
(DEFAULT,'sunlei','孙磊','123',1,'1981-01-04','13387676765','深圳市坪山区管庄新月小区12楼',3,1101,NOW(),NULL,NULL),
(DEFAULT,'sunxing','孙兴','123',1,'1978-03-12','13367890900','深圳市大鹏新区建国门南大街10号',3,1101,NOW(),NULL,NULL),
(DEFAULT,'zhangchen','张晨','123',0,'1986-03-28','18098765434','深圳市南山区管庄路口北柏林爱乐三期13号楼',3,1101,NOW(),NULL,NULL),
(DEFAULT,'dengchao','邓超','123',1,'1981-11-04','13689674534','深圳市福田区北航家属院10号楼',3,1101,NOW(),NULL,NULL),
(DEFAULT,'yangguo','杨过','123',1,'1980-01-01','13388886623','深圳市南山区北苑家园茉莉园20号楼',3,1101,NOW(),NULL,NULL),
(DEFAULT,'zhaomin','赵敏','123',0,'1987-12-04','18099897657','深圳市龙岗区天通苑3区12号楼',2,1101,NOW(),NULL,NULL);
