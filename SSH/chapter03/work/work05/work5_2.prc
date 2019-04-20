CREATE OR REPLACE PROCEDURE procedure_emp2
(
       cur_salary OUT SYS_REFCURSOR,
       on_FLAG    OUT NUMBER,
       on_Msg     OUT VARCHAR
) 
IS
BEGIN
  OPEN cur_salary FOR
    SELECT empno, sal FROM emp;
     on_FLAG := 2000; 
     on_Msg := 'success';
EXCEPTION
WHEN OTHERS THEN 
     on_FLAG := 2001; 
     on_Msg := 'error';
END;
/
