set serveroutput on;
DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loanID Loans.LoanID%TYPE;
    v_interestRate Loans.InterestRate%TYPE;
    v_new_interest_rate NUMBER := 6; 
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loanID, v_interestRate;
        EXIT WHEN cur_loans%NOTFOUND;

        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loanID;
        
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loanID || ', Old Interest Rate: ' || v_interestRate || ', New Interest Rate: ' || v_new_interest_rate);
    END LOOP;
    CLOSE cur_loans;
END;
/

