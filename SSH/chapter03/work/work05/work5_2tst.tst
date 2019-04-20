PL/SQL Developer Test script 3.0
28
--读取游标
declare
  cur_salary SYS_reFCURSOR;
  on_FLAG    NUMBER(4);
  on_Msg     VARCHAR(200);
  sal        emp.sal%TYPE;
  empno        emp.empno%TYPE;
begin
  /**
  - --接收返回的游标
   procedure_emp2(cur_salary,on_FLAG,on_Msg);
   --循环游标
   FOR c_object IN cur_salary LOOP
       --读取游标
       DBMS_OUTPUT.PUT_LINE(c_object.sal);
   END LOOP;
  -
  */
  --因为已打开游标 使用FOR循环读读取会自动打开 所以引起冲突
  --使用LOOP循环则没事
 procedure_emp2(cur_salary,on_FLAG,on_Msg);
  LOOP
       FETCH cur_salary INTO empno,sal;
       EXIT WHEN cur_salary%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(sal);
   END LOOP;
   CLOSE cur_salary;
  end;
0
0
