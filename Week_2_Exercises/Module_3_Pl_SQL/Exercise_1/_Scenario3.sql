set serveroutput on;
DECLARE
    CURSOR c_loans IS
        SELECT CustomerID, LoanID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    
    v_customer_id Loans.CustomerID%TYPE;
    v_loan_id Loans.LoanID%TYPE;
    v_end_date Loans.EndDate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_customer_id, v_loan_id, v_end_date;
        EXIT WHEN c_loans%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || v_loan_id || ' for Customer ' || v_customer_id || ' is due on ' || v_end_date);
    END LOOP;
    CLOSE c_loans;
END;
/
