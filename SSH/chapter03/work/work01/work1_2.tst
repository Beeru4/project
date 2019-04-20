PL/SQL Developer Test script 3.0
21
--修改奖金
-- Created on 2019/3/20 by J.Z 
declare 
  -- Local variables here
  --入职时间
  v_HIREDATE NUMBER;
  --当前时间
  v_currDATE NUMBER;
begin
  -- Test statements here
  SELECT TO_CHAR(HIREDATE,'yyyy') INTO v_HIREDATE FROM emp WHERE  ENAME = UPPER('Scott');
  SELECT  TO_CHAR(Sysdate,'yyyy') INTO v_currDATE FROM dual;
  IF v_currDATE - v_HIREDATE < 6 THEN
      --修改奖金1000
      UPDATE emp SET COMM = COMM + 1000 WHERE  ENAME = UPPER('Scott');
  ELSE
      --修改金额为2000
      UPDATE emp SET COMM = COMM + 2000 WHERE  ENAME = UPPER('Scott');
  END IF;
  COMMIT;
end;
0
0
