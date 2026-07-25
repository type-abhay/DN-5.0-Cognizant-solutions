-- Start logging output to text file
SPOOL output3.txt
SET SERVEROUTPUT ON;

PROMPT =======================================================;
PROMPT EXERCISE 3 - SCENARIO 1: ProcessMonthlyInterest
PROMPT =======================================================;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE UPPER(AccountType) = 'SAVINGS';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% processed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- Test Procedure Execution
BEGIN
    ProcessMonthlyInterest;
END;
/

PROMPT ;
PROMPT =======================================================;
PROMPT EXERCISE 3 - SCENARIO 2: UpdateEmployeeBonus
PROMPT =======================================================;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_DepartmentID IN NUMBER,
    p_BonusPercentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_BonusPercentage / 100))
    WHERE DepartmentID = p_DepartmentID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully applied ' || p_BonusPercentage || '% bonus to Dept ID ' || p_DepartmentID);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- Test Procedure Execution
BEGIN
    UpdateEmployeeBonus(10, 5);
END;
/

PROMPT ;
PROMPT =======================================================;
PROMPT EXERCISE 3 - SCENARIO 3: TransferFunds
PROMPT =======================================================;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) IS
    v_FromBalance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in Account ' || p_FromAccountID);
    ELSE
        UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
        UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer complete: $' || p_Amount || ' transferred from Account ' || p_FromAccountID || ' to ' || p_ToAccountID);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TransferFunds;
/

-- Test Procedure Execution
BEGIN
    TransferFunds(201, 202, 500);
END;
/

-- Stop logging and close file
SPOOL OFF;