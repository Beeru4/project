PL/SQL Developer Test script 3.0
24
declare 
  v_empno emp.empno%TYPE;
  v_sal emp.sal%TYPE;
  v_deptno emp.deptno%TYPE;
  --自定义异常
  e_error EXCEPTION;
begin
 SELECT empno INTO v_empno FROM emp WHERE EMPNO = 7369;
 SELECT deptno INTO v_deptno FROM emp WHERE EMPNO = 7369;
 SELECT sal INTO v_sal FROM emp WHERE EMPNO = 7369;
 IF v_deptno = 10 AND v_sal < 1000 THEN
    UPDATE emp SET SAL = 1000 WHERE EMPNO = 7369;
     COMMIT;
 ELSE
   --抛出异常
    RAISE e_error;
 END IF;
 --捕获异常
 EXCEPTION
 WHEN e_error THEN
  DBMS_OUTPUT.PUT_LINE('工资不低于1000元,或部门代码不为10!');
  WHEN OTHERS THEN
   DBMS_OUTPUT.PUT_LINE(SQLERRM);
  end;
0
0
