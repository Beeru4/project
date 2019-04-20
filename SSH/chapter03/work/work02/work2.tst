PL/SQL Developer Test script 3.0
15

declare 
  v_ename VARCHAR(1);
  --异常类型
  e_error EXCEPTION;
begin
     SELECT ENAME INTO v_ename FROM emp WHERE EMPNO = 7369;
 EXCEPTION
 WHEN NO_DATA_FOUND THEN
  DBMS_OUTPUT.PUT_LINE('没有找到数据!');
 WHEN VALUE_ERROR THEN
  DBMS_OUTPUT.PUT_LINE('长度超过变量长度!');
 WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE(SQLERRM);
  end;
0
0
