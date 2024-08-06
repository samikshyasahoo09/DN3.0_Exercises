set SERVEROUTPUT on;
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_balance Customers.Balance%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_balance;
        EXIT WHEN c_customers%NOTFOUND;
        
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 1  
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    CLOSE c_customers;
    
    COMMIT;
END;
/

