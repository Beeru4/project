PL/SQL Developer Test script 3.0
17
--每次增加100元
-- Created on 2019/3/20 by J.Z 
declare 
  -- Local variables here
  var_sal emp.sal%TYPE;
  var_moeny emp.sal%TYPE:=0;
begin
  -- Test statements here
  SELECT SAL INTO var_sal FROM emp WHERE ename = 'SCOTT';
  WHILE var_moeny < 10000 LOOP
        --工资每次增加100
        var_moeny:=(var_moeny + 100);
  END LOOP;
  --修改数据
  UPDATE emp SET SAL = var_sal + var_moeny WHERE ename = 'SCOTT';
  COMMIT;
end;
0
0
