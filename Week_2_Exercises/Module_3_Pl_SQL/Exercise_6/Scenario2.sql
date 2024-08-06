set serveroutput on;
DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee NUMBER := 50; 
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_accountID, v_balance;
        EXIT WHEN cur_accounts%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_accountID;
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_accountID || ', New Balance: ' || (v_balance - v_annual_fee));
    END LOOP;
    CLOSE cur_accounts;
END;
/

