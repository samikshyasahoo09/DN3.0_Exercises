set SERVEROUTPUT on;
DECLARE
    CURSOR c_customers IS
        SELECT l.CustomerID, c.DOB, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
    
    v_customer_id Loans.CustomerID%TYPE;
    v_dob Customers.DOB%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_age NUMBER;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_dob, v_interest_rate;
        EXIT WHEN c_customers%NOTFOUND;
        
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = v_interest_rate - 1
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    CLOSE c_customers;
    
    COMMIT;
END;
/

