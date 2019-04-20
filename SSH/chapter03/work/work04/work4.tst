PL/SQL Developer Test script 3.0
71
declare
  v_sal emp.sal%TYPE;
  --税率
  v_s NUMBER(7, 3);
  --速算扣除数
  v_ss NUMBER(7, 3);
  --总税率
  v_toaltax NUMBER(11, 4) := 0;
  --所在级别
  v_level NUMBER(1);
  --创建游标查询数据
  CURSOR currsor_emp
  --查出员工工资
  IS
    SELECT SAL,
           TO_CHAR(HIREDATE, 'yyyy') as year_date,
           empno,
           ename,
           dname,
           TO_CHAR(SYSDATE, 'yyyy') as year_curr
      FROM emp, dept
     WHERE emp.deptno = dept.deptno;
begin
  --循环读取
  FOR v_object IN currsor_emp LOOP
    v_sal := (v_object.sal - 1500);
    --判断税务
    IF v_sal <= 1500 THEN
      v_s  := 0.03;
      v_ss := 0;
    ELSIF v_sal <= 4500 THEN
      v_s  := 0.1;
      v_ss := 105;
    ELSIF v_sal <= 9000 THEN
      v_s  := 0.2;
      v_ss := 555;
    ELSE
      v_s  := 0.25;
      v_ss := 1005;
    END IF;
    --累加金额
    v_toaltax := v_toaltax + (v_sal * v_s - v_ss);
    --判断级别
    IF v_sal > 700 AND v_sal <= 3200 THEN
      v_level := 1;
    ELSIF v_sal >= 3201 AND v_sal <= 4400 THEN
      v_level := 2;
    ELSIF v_sal >= 4401 AND v_sal <= 5000 THEN
      v_level := 3;
    ELSIF v_sal >= 5001 AND v_sal <= 7000 THEN
      v_level := 4;
    ELSE
      v_level := 5;
    END IF;
    --更改金额
     IF v_object.year_curr - v_object.year_date < 6 THEN
      --修改奖金1000
      UPDATE emp SET COMM = COMM + 1000 WHERE  EMPNO = v_object.empno;
  ELSE
      --修改金额为2000
      UPDATE emp SET COMM = COMM + 2000 WHERE  EMPNO = v_object.empno;
  END IF;
  COMMIT;
    --输出信息
    DBMS_OUTPUT.PUT_LINE('员工姓名:' || v_object.ename || '部门名称:' ||
                         v_object.dname || '薪水:' ||
                         TO_CHAR(v_object.SAL + 1500) || '所在级别:' ||
                         TO_CHAR(v_level));
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('总税务:' || TO_CHAR(v_toaltax));
end;
0
0
