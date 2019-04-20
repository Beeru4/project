

DROP DATABASE IF EXISTS `manager`;
CREATE DATABASE `manager`;
USE `manager`;
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`(
	`info_id`  INT(4) PRIMARY KEY,
    `type` VARCHAR(20) NOT NULL,
    `out_price` INT(7),
    `out_date` DATE
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `info` VALUES(1,'CDMA-1',650,'2008-10-25');
INSERT INTO `info` VALUES(2,'CDMA-2',650,'2009-10-25');
INSERT INTO `info` VALUES(3,'CDMA-3',650,'2010-10-25');
SELECT * FROM `info`;