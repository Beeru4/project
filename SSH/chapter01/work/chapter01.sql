DROP TABLE employee;
DROP TABLE depts;
CREATE TABLE employee AS SELECT * FROM emp;
CREATE TABLE depts AS SELECT * FROM dept;
ALTER TABLE employee ADD PRIMARY KEY(empno);
ALTER TABLE depts ADD PRIMARY KEY(deptno);
ALTER TABLE employee ADD CONSTRAINT FK_deptnos FOREIGN KEY(deptno) REFERENCES depts(deptno);
ALTER TABLE employee ADD (empTel_no VARCHAR2(12),empAddress VARCHAR2(20));
ALTER TABLE employee DROP (empTel_no,empAddress);
SELECT * FROM employee ORDER BY SAL DESC;
SELECT * FROM (
  SELECT em.*,ROWNUM row_ FROM (
         SELECT * FROM employee ORDER BY SAL DESC
  ) em
) WHERE row_ BETWEEN 5 AND 9; 
SELECT * FROM(
       SELECT employee.*,RANK() OVER (PARTITION BY JOB ORDER BY SAL) row_ FROM employee
) WHERE row_ = 2;
SELECT ENAME "姓名",CONCAT(TO_CHAR(ROUND(HIREDATE,'YEAR'),'yyyy'),' 年度') "入职年度" FROM employee;
SELECT * FROM employee;
SELECT JOB,COUNT(1) FROM employee GROUP BY JOB HAVING COUNT(JOB) > 1;
SELECT ENAME,JOB FROM employee WHERE JOB = 'CLERK';
SELECT * FROM(
       SELECT JOB,MIN(SAL) as sal FROM employee GROUP BY JOB
) WHERE sal > 1500;

SELECT * FROM employee WHERE HIREDATE IN(
       SELECT LAST_DAY(HIREDATE) FROM employee
);

--简答
--01建表
DROP TABLE ORDERS;
CREATE TABLE ORDERS(
       ORDER_ID NUMBER(12) PRIMARY KEY NOT NULL,
       ORDER_DATE DATE NOT NULL,
       ORDER_MODE VARCHAR2(8),
       CUSTOMER_ID NUMBER(6) NOT NULL,
       ORDER_STATUS NUMBER(2),
       ORDER_TOTAL NUMBER(8,2),
       SALES_REP_ID NUMBER(6),
       PROMOTION_ID NUMBER(6)
);
DROP TABLE CUSTOMERS;
CREATE TABLE CUSTOMERS(
       CUSTOMER_ID NUMBER(6) NOT NULL,
       CUST_FIRST_NAME VARCHAR2(20) NOT NULL,
       CUST_LAST_NAME VARCHAR2(20) NOT NULL,
       NLS_LANGUAGE VARCHAR2(4),
       NLS_TERRITORY VARCHAR2(30),
       CREDIT_LIMIE NUMBER(9,2),
       CUST_EMAIL VARCHAR2(30),
       ACCOUNT_MGR_ID NUMBER(30),
       MARITAL_STATUS VARCHAR2(30),
       GENDER CHAR(2)
);
INSERT INTO ORDERS VALUES(1,TO_DATE('2012-12-12','yyyy-mm-dd'),'线下',1,11,123456.12,121212,131313);
INSERT INTO ORDERS VALUES(2,TO_DATE('2012-12-12','yyyy-mm-dd'),'线下',2,11,123456.12,121212,131313);
INSERT INTO ORDERS VALUES(3,TO_DATE('2012-12-12','yyyy-mm-dd'),'线下',3,11,123456.12,121212,131313);
INSERT INTO ORDERS VALUES(4,TO_DATE('2012-12-12','yyyy-mm-dd'),'线下',4,11,123456.12,121212,131313);
INSERT INTO CUSTOMERS VALUES(1,'三','张','中文','中国',12.12,'124564@qq.com',1,'未婚','男');
INSERT INTO CUSTOMERS VALUES(2,'四','张','中文','中国',12.12,'124564@qq.com',1,'未婚','男');
INSERT INTO CUSTOMERS VALUES(3,'七','张','中文','中国',12.12,'124564@qq.com',1,'未婚','男');
INSERT INTO CUSTOMERS VALUES(4,'八','张','中文','中国',12.12,'124564@qq.com',1,'未婚','男');
SELECT * FROM ORDERS;
SELECT * FROM CUSTOMERS;
--01.02
SELECT NLS_TERRITORY FROM CUSTOMERS GROUP BY NLS_TERRITORY HAVING COUNT(1) = 1 ;
--01.03
SELECT ORDERS.CUSTOMER_ID,CUST_LAST_NAME,ACCOUNT_MGR_ID 
FROM ORDERS,CUSTOMERS WHERE ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;
--01.04
SELECT * FROM CUSTOMERS WHERE CUST_LAST_NAME = 'AMERICA';
--01.05
SELECT CUSTOMER_ID,NLS_LANGUAGE  WHERE NLS_TERRITORY = 'AMERICA' OR NLS_TERRITORY = 'ITALY' OR NLS_TERRITORY = 'INDIA' OR NLS_TERRITORY = 'CHINA';
--01.06
SELECT CONCAT(CUST_LAST_NAME,CUST_FIRST_NAME),CUST_EMAIL FROM CUSTOMERS WHERE CUST_LAST_NAME LIKE 'F%';
--01.07
SELECT CONCAT(CUST_LAST_NAME,CUST_FIRST_NAME),ORDER_ID FROM ORDERS,CUSTOMERS WHERE ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;
--02
SELECT deptno,MAX(SAL),MIN(SAL) FROM employee GROUP BY deptno HAVING 5000 < MIN(SAL) OR 15000 > MAX(SAL);
--03
SELECT MAX(SAL) as 最高工资,JOB as 工作类别 FROM (
       SELECT RANK() OVER (PARTITION BY deptno ORDER BY SAL DESC),SAL,JOB FROM employee 
) GROUP BY JOB;
