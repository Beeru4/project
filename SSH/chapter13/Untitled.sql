DROP DATABASE IF EXISTS `manager`;
CREATE DATABASE `manager`;
USE `manager`;
##顾客信息表
DROP TABLE IF EXISTS `CUS_CUSTOMER`;
CREATE TABLE `CUS_CUSTOMER`(
	`CUS_ID` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `CUS_NAME` VARCHAR(100),
    `CUS_ADDR` VARCHAR(500)
)ENGINE INNODB AUTO_INCREMENT=1001 DEFAULT CHARSET=UTF8;

##产品信息表
DROP TABLE IF EXISTS `SALE_PRODUCT`;
CREATE TABLE `SALE_PRODUCT`(
	`PROD_ID` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `PROD_NAME` VARCHAR(100),
    `PROD_PRICE` INT(11)
)ENGINE INNODB AUTO_INCREMENT=2201 DEFAULT CHARSET=UTF8;

##订单信息
DROP TABLE IF EXISTS `SALE_ORDER`;
CREATE TABLE `SALE_ORDER`(
	`ODR_ID` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `ODR_CUSTOMER_ID` INT(10),
    `ODR_CUSTOMER_NAME` VARCHAR(100),
    `ODR_DELIVER_ADDR` VARCHAR(500),
    `ODR_ORDER_DATE` DATE,
    `ODR_DELIVER_DATE` DATE,
    `ODR_STATUS` VARCHAR(5)
)ENGINE INNODB AUTO_INCREMENT=3301 DEFAULT CHARSET=UTF8;

##订单明细
DROP TABLE IF EXISTS `SALE_ORDER_LINE`;
CREATE TABLE `SALE_ORDER_LINE`(
	`ODL_ID` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `ODL_ORDER_ID` INT(10),
	`ODL_PRODUCT_NAME` VARCHAR(100),
	`ODL_PRODUCT_PRICE` INT(11),
	`ODL_PRODUCT_COUNT` INT(10)
)ENGINE INNODB AUTO_INCREMENT=4401 DEFAULT CHARSET=UTF8;

## 外键
ALTER TABLE `SALE_ORDER_LINE` ADD CONSTRAINT FK_ODL_ODR FOREIGN KEY(`ODL_ORDER_ID`) REFERENCES `SALE_ORDER`(`ODR_ID`);

INSERT INTO`CUS_CUSTOMER`(`CUS_ID`,`CUS_NAME`,`CUS_ADDR`) VALUES(DEFAULT,'张三','福田区深南中路20号');
INSERT INTO`CUS_CUSTOMER`(`CUS_ID`,`CUS_NAME`,`CUS_ADDR`) VALUES(DEFAULT,'李四','盐田区盐田路路66号');
INSERT INTO`CUS_CUSTOMER`(`CUS_ID`,`CUS_NAME`,`CUS_ADDR`) VALUES(DEFAULT,'王五','南山区南山路10号');
INSERT INTO`CUS_CUSTOMER`(`CUS_ID`,`CUS_NAME`,`CUS_ADDR`) VALUES(DEFAULT,'赵六','龙华区龙华路1号');
INSERT INTO`CUS_CUSTOMER`(`CUS_ID`,`CUS_NAME`,`CUS_ADDR`) VALUES(DEFAULT,'陈七','罗湖区罗湖路31号');

INSERT INTO`SALE_PRODUCT`(`PROD_ID`,`PROD_NAME`,`PROD_PRICE`) VALUES(DEFAULT,'13 英寸 MacBook Air触控 ID-9253.0',9253);
INSERT INTO`SALE_PRODUCT`(`PROD_ID`,`PROD_NAME`,`PROD_PRICE`) VALUES(DEFAULT,'MacBook Pro (13inch)-13988.0',13988);
INSERT INTO`SALE_PRODUCT`(`PROD_ID`,`PROD_NAME`,`PROD_PRICE`) VALUES(DEFAULT,'21.5 英寸 iMac2.3GHz-8390.0',8390);
INSERT INTO`SALE_PRODUCT`(`PROD_ID`,`PROD_NAME`,`PROD_PRICE`) VALUES(DEFAULT,'iMac Pro.2GHz 八核 Intel-38138.0',38138);
INSERT INTO`SALE_PRODUCT`(`PROD_ID`,`PROD_NAME`,`PROD_PRICE`) VALUES(DEFAULT,'15 英寸 MacBook Pro触控栏和触控ID-18205.0',18205);

INSERT INTO`SALE_ORDER`(`ODR_ID`,`ODR_CUSTOMER_ID`,`ODR_CUSTOMER_NAME`,`ODR_DELIVER_ADDR`,`ODR_ORDER_DATE`,`ODR_DELIVER_DATE`,`ODR_STATUS`)VALUES(DEFAULT,1001,'张三','福田区深南中路20号','2019-04-10',NULL,'未发货');
INSERT INTO`SALE_ORDER`(`ODR_ID`,`ODR_CUSTOMER_ID`,`ODR_CUSTOMER_NAME`,`ODR_DELIVER_ADDR`,`ODR_ORDER_DATE`,`ODR_DELIVER_DATE`,`ODR_STATUS`)VALUES(DEFAULT,1002,'李四','盐田区盐田路路66号','2019-04-09','2019-04-10','已发货');
INSERT INTO`SALE_ORDER`(`ODR_ID`,`ODR_CUSTOMER_ID`,`ODR_CUSTOMER_NAME`,`ODR_DELIVER_ADDR`,`ODR_ORDER_DATE`,`ODR_DELIVER_DATE`,`ODR_STATUS`)VALUES(DEFAULT,1003,'王五','南山区南山路10号','2019-04-08','2019-04-09','已发货');
INSERT INTO`SALE_ORDER`(`ODR_ID`,`ODR_CUSTOMER_ID`,`ODR_CUSTOMER_NAME`,`ODR_DELIVER_ADDR`,`ODR_ORDER_DATE`,`ODR_DELIVER_DATE`,`ODR_STATUS`)VALUES(DEFAULT,1004,'赵六','龙华区龙华路1号','2019-04-10',NULL,'未发货');
INSERT INTO`SALE_ORDER`(`ODR_ID`,`ODR_CUSTOMER_ID`,`ODR_CUSTOMER_NAME`,`ODR_DELIVER_ADDR`,`ODR_ORDER_DATE`,`ODR_DELIVER_DATE`,`ODR_STATUS`)VALUES(DEFAULT,1005,'陈七','罗湖区罗湖路31号','2019-04-05','2019-04-05','已发货');

INSERT INTO`SALE_ORDER_LINE`(`ODL_ID`,`ODL_ORDER_ID`,`ODL_PRODUCT_NAME`,`ODL_PRODUCT_PRICE`,`ODL_PRODUCT_COUNT`) VALUES(DEFAULT,3301,'13 英寸 MacBook Air触控 ID-9253.0',9253,1);
INSERT INTO`SALE_ORDER_LINE`(`ODL_ID`,`ODL_ORDER_ID`,`ODL_PRODUCT_NAME`,`ODL_PRODUCT_PRICE`,`ODL_PRODUCT_COUNT`) VALUES(DEFAULT,3302,'MacBook Pro (13-inch)-13988.0',13988,2);
INSERT INTO`SALE_ORDER_LINE`(`ODL_ID`,`ODL_ORDER_ID`,`ODL_PRODUCT_NAME`,`ODL_PRODUCT_PRICE`,`ODL_PRODUCT_COUNT`) VALUES(DEFAULT,3303,'21.5 英寸 iMac2.3GHz-8390.0',8390,3);
INSERT INTO`SALE_ORDER_LINE`(`ODL_ID`,`ODL_ORDER_ID`,`ODL_PRODUCT_NAME`,`ODL_PRODUCT_PRICE`,`ODL_PRODUCT_COUNT`) VALUES(DEFAULT,3304,'iMac Pro.2GHz 八核 Intel-38138.0',38138,2);
INSERT INTO`SALE_ORDER_LINE`(`ODL_ID`,`ODL_ORDER_ID`,`ODL_PRODUCT_NAME`,`ODL_PRODUCT_PRICE`,`ODL_PRODUCT_COUNT`) VALUES(DEFAULT,3305,'15 英寸 MacBook Pro触控栏和触控ID-18205.0',18205,1);

SELECT * FROM `CUS_CUSTOMER`;
SELECT * FROM `SALE_PRODUCT`;
SELECT * FROM `SALE_ORDER`;
SELECT * FROM `SALE_ORDER_LINE`;
