set serveroutput on;
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_account_id NUMBER, p_amount NUMBER) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    
    RETURN v_balance >= p_amount;
END HasSufficientBalance;
/

DECLARE
    v_sufficient BOOLEAN;
BEGIN
    v_sufficient := HasSufficientBalance(1, 1500);
    IF v_sufficient THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/



