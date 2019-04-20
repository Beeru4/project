--01
CREATE TABLESPACE tp_orders
       DATAFILE 'C:\tp_orders.dbf'
       SIZE 10M
       AUTOEXTEND ON;
CREATE USER A_oe
       IDENTIFIED BY bdqn
       DEFAULT TABLESPACE tp_orders;
GRANT CONNECT,RESOURCE TO A_oe;
CREATE USER A_hr IDENTIFIED BY orcl;
GRANT DBA TO A_hr;
CREATE TABLE employee(
       ID NUMBER(11) NOT NULL
);
GRANT ALL ON A_hr.employee TO A_oe;
--02
CREATE SEQUENCE dept_seq
       START WITH 60
       INCREMENT BY 10
       MAXVALUE 10000
       MINVALUE 60;
INSERT INTO dept(DEPTNO,DNAME,LOC) VALUES(dept_seq.NEXTVAL,'ACCOUNTING1','NEW YORK1');
INSERT INTO dept(DEPTNO,DNAME,LOC) VALUES(dept_seq.NEXTVAL,'ACCOUNTING2','NEW YORK2');
SELECT * FROM dept;
DROP SEQUENCE dept_seq;
CREATE TABLE deptBAK as SELECT * FROM dept WHERE 1=2;
INSERT INTO deptBAK(DEPTNO,DNAME,LOC) VALUES(dept_seq.NEXTVAL,'ACCOUNTING1','NEW YORK1');
INSERT INTO deptBAK(DEPTNO,DNAME,LOC) VALUES(dept_seq.NEXTVAL,'ACCOUNTING2','NEW YORK2');
SELECT * FROM deptBAK;
--03
--授予访问scott.emp表的权限
GRANT ALL ON scott.dept TO A_hr;
SELECT * FROM scott.dept;
--克隆表
CREATE TABLE A_hr.dept AS  SELECT * FROM scott.dept;
--创建公共同义词
CREATE PUBLIC SYNONYM p_sy_dept FOR A_hr.dept;
--查询
SELECT * FROM p_sy_dept;
--04
--为客户编号创建反向键索引
CREATE INDEX index_customer_id ON scott.customers(customer_id) REVERSE;
--姓名组合索引
CREATE INDEX index_customer_name ON scott.customers(cust_first_name,cust_last_name);
--地域位图索引
CREATE BITMAP INDEX index_customer_TERRITORY ON scott.customers(nls_territory);
--授予A_oe用户访问oraders表权限
--04
SELECT * FROM scott.orders;
GRANT ALL ON scott.orders TO A_oe;
CREATE TABLE order2 (
       order_id NUMBER(12) PRIMARY KEY,
       order_date DATE NOT NULL 
)
PARTITION BY RANGE(order_date)
(
          PARTITION part1 VALUES LESS THAN (TO_DATE('2005/01/01','yyyy/mm/dd')),
          PARTITION part2 VALUES LESS THAN (TO_DATE('2006/01/01','yyyy/mm/dd')),
          PARTITION part3 VALUES LESS THAN (TO_DATE('2007/01/01','yyyy/mm/dd')),
          PARTITION part4 VALUES LESS THAN (TO_DATE('2008/01/01','yyyy/mm/dd')),
          PARTITION part5 VALUES LESS THAN (TO_DATE('2009/01/01','yyyy/mm/dd'))
);

SELECT * FROM order2 PARTITION(part1);
SELECT * FROM order2 PARTITION(part2);
SELECT * FROM order2 PARTITION(part3);
SELECT * FROM order2 PARTITION(part4);
SELECT * FROM order2 PARTITION(part5);

INSERT INTO order2(order_id,order_date) VALUES(1,TO_DATE('2004/03/12','yyyy-mm-dd'));
INSERT INTO order2(order_id,order_date) VALUES(2,TO_DATE('2005/12/12','yyyy-mm-dd'));
INSERT INTO order2(order_id,order_date) VALUES(3,TO_DATE('2007/03/06','yyyy-mm-dd'));
INSERT INTO order2(order_id,order_date) VALUES(4,TO_DATE('2003/12/11','yyyy-mm-dd'));
INSERT INTO order2(order_id,order_date) VALUES(5,TO_DATE('2013/01/01','yyyy-mm-dd'));
--解决2013-01-01数据不能插入的问题
CREATE TABLE order3 
PARTITION BY RANGE(order_date)
(
          PARTITION part1 VALUES LESS THAN (TO_DATE('2005/01/01','yyyy/mm/dd')),
          PARTITION part2 VALUES LESS THAN (TO_DATE('2006/01/01','yyyy/mm/dd')),
          PARTITION part3 VALUES LESS THAN (TO_DATE('2007/01/01','yyyy/mm/dd')),
          PARTITION part4 VALUES LESS THAN (TO_DATE('2008/01/01','yyyy/mm/dd')),
          PARTITION part5 VALUES LESS THAN (TO_DATE('2009/01/01','yyyy/mm/dd')),
          PARTITION part6 VALUES LESS THAN (maxvalue)
)
AS SELECT * FROM order2;
--删除第三个分区的数据
DELETE FROM order2 PARTITION(part3);
--06 创建间隔分区
CREATE TABLE intervalOrders
PARTITION BY RANGE(order_date)
          INTERVAL(NUMTOYMINTERVAL(1,'year'))
          (
             PARTITION part1 VALUES LESS THAN(TO_DATE('2005/01/01','yyyy/mm/dd'))
             
          )
AS SELECT * FROM order2;
--查询分区
SELECT table_name,partition_name FROM user_tab_partitions WHERE table_name = UPPER('intervalOrders');
SELECT * FROM intervalOrders PARTITION(part1);
SELECT * FROM intervalOrders PARTITION(SYS_P21);
SELECT * FROM intervalOrders PARTITION(SYS_P22);
--简答
--创建 p_Stock_Received表
CREATE TABLE p_Stock_Received(
       Stock_ID NUMBER,
       Stock_Date DATE,
       Cost VARCHAR2(10)
);
--2.1 创建myseq序列
CREATE SEQUENCE myseq
       START WITH 1000
       INCREMENT BY 10
       MAXVALUE 1100
       CYCLE;
--2.2 创建共有同义词
CREATE PUBLIC SYNONYM Stock_Received FOR A_hr.p_Stock_Received;
--通过A_oe访问
SELECT * FROM Stock_Received;
--2.3 分区
CREATE TABLE Stock_Received2
PARTITION BY RANGE(Stock_Date)(
          PARTITION VALUES LESS THAN (TO_DATE('2012-01-01','yyyy-mm-dd')),
          PARTITION VALUES LESS THAN (TO_DATE('2013-01-01','yyyy-mm-dd')),
          PARTITION VALUES LESS THAN (TO_DATE('2014-01-01','yyyy-mm-dd'))
)AS SELECT * FROM Stock_Received;
--查询分区
SELECT table_name,partition_name FROM user_tab_partitions WHERE table_name = UPPER('Stock_Received2');
--2.4 创建一个唯一索引
CREATE UNIQUE INDEX index_STOCK_ID ON p_Stock_Received(Stock_ID);
       
