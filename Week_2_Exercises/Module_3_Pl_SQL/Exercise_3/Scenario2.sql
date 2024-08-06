set serveroutput on;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    DBMS_OUTPUT.PUT_LINE('Employee bonuses updated for department: ' || p_department);
END;
/

BEGIN
    UpdateEmployeeBonus('HR', 5);
END;
/
