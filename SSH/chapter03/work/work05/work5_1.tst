PL/SQL Developer Test script 3.0
8
--Ö´ÐÐ
declare
  on_Flag NUMBER(5);
  on_Msg  VARCHAR2(200);
begin
  procedure_emp(7369, on_Flag, on_Msg);
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(on_Flag) || on_Msg);
end;
0
0
