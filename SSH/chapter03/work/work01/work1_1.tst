PL/SQL Developer Test script 3.0
29

--计算所交税金
-- Created on 2019/3/20 by J.Z 
declare 
  -- Local variables here
  v_sal emp.sal%TYPE;
  --税率
  v_s NUMBER(7,3);
  --速算扣除数
  v_ss NUMBER(7,3);
begin
  --查出员工工资
  SELECt SAL - 1500 INTO v_sal FROM emp WHERE ENAME = 'KING';
  CASE
         WHEN v_sal <= 1500 THEN
                v_s:=0.03;
                v_ss:=0;
         WHEN v_sal <= 4500 THEN
                v_s:=0.1;
                v_ss:=105;
         WHEN v_sal <= 9000 THEN
                v_s:=0.2;
                v_ss:=555;
         WHEN v_sal <= 3500 THEN
                v_s:=0.25;
                v_ss:=1005;
         END CASE;
         DBMS_OUTPUT.PUT_LINE('所交税务金额:' || TO_CHAR(v_sal * v_s - v_ss));
end;
0
0
