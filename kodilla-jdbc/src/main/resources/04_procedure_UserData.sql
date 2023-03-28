DROP PROCEDURE IF EXISTS UserData;

DELIMITER $$

CREATE PROCEDURE UserData(id_user INT)
BEGIN
IF id_user <= 0 THEN
        SELECT 'id_user cannot be lower then 1' AS ERROR_INFO;
    ELSE
        SELECT READER_ID, FIRSTNAME, LASTNAME
        FROM READERS
        WHERE READER_ID = id_user;
    END IF;

END $$

DELIMITER ;

CALL UserData(-1);
CALL UserData(0);
CALL UserData(1);