PL/SQL Developer Test script 3.0
13
-- 简答02.5测试程序
declare
  v_COMM      emp.comm%TYPE; -- 模拟所得税金额
  v_updateMsg VARCHAR(50); -- 修改状态
  v_level     NUMBER(5); -- 薪水级别
  on_FLAG     NUMBER(5);
  on_MSG      VARCHAR(200);
begin
  PROCEDURE_orders(7788, v_COMM, v_updateMsg, v_level, on_FLAG, on_MSG);
  DBMS_OUTPUT.PUT_LINE('税务:' || TO_CHAR(v_COMM) || '修改信息:' || v_updateMsg ||
                       '级别:' || TO_CHAR(v_level) || '状态码:' ||
                       TO_CHAR(on_FLAG) || '消息:' || on_MSG);
end;
0
0
