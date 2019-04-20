CREATE OR REPLACE PROCEDURE procedure_emp (
  v_empno NUMBER, --员工编号
  on_Flag OUT NUMBER, --状态码
  on_Msg  OUT VARCHAR2 --状态信息
)
IS
BEGIN
  --根据传入的员工编号删除员工
  DELETE FROM emp WHERE empno = v_empno;
  on_Flag := 20000;
  on_Msg  := 'success';
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    --捕获到异常
    on_Flag := 20001;
    on_Msg  := 'error';
END;
/
