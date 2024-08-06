set serveroutput on;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance * 1.01
        WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END ProcessMonthlyInterest;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

