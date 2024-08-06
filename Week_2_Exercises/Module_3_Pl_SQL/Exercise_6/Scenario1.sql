set serveroutput on;
DECLARE
    CURSOR cur_transactions IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, c.CustomerID, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);

    v_transactionID Transactions.TransactionID%TYPE;
    v_accountID Accounts.AccountID%TYPE;
    v_transactionDate Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transactionType Transactions.TransactionType%TYPE;
    v_customerID Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
BEGIN
    OPEN cur_transactions;
    LOOP
        FETCH cur_transactions INTO v_transactionID, v_accountID, v_transactionDate, v_amount, v_transactionType, v_customerID, v_name;
        EXIT WHEN cur_transactions%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customerID || ', Name: ' || v_name || 
                             ', Transaction ID: ' || v_transactionID || ', Date: ' || v_transactionDate || 
                             ', Amount: ' || v_amount || ', Type: ' || v_transactionType);
    END LOOP;
    CLOSE cur_transactions;
END;
/
