CREATE OR REPLACE PROCEDURE PROCEDURE_orders
(
       v_empno NUMBER,                        --员工编号
       v_COMM OUT emp.comm%TYPE,              -- 模拟所得税金额
       v_updateMsg OUT VARCHAR,               -- 修改状态
       v_level OUT NUMBER,                    -- 薪水级别
       on_FLAG OUT NUMBER,
       on_MSG OUT VARCHAR
)
IS
BEGIN
       -- 税务
       SELECT COMM INTO v_COMM FROM emp WHERE empno = v_empno;
       --修改奖金列表
       UPDATE emp SET COMM = 1000 WHERE empno = v_empno;
       COMMIT;
       --返回薪水级别
       SELECT SAL INTO v_level FROM emp WHERE empno = v_empno;
       IF v_level > 3000 THEN
          v_level := 1;
       END IF;
        on_FLAG:=2001;
        on_MSG:='success';
        v_updateMsg:='update success!';
EXCEPTION
       WHEN OTHERS THEN
            v_updateMsg:='update error!';
            on_FLAG:=2000;
            on_MSG:=SQLERRM;
END;
/
