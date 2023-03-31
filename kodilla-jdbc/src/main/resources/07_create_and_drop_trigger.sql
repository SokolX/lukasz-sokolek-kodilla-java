SET @RENTSQTY = 0;

DELIMITER $$

CREATE TRIGGER RENTSCOUNTER BEFORE INSERT ON RENTS
    FOR EACH ROW
BEGIN
    SET @RENTSQTY = @RENTSQTY + 1;
END $$

DELIMITER ;

SELECT @RENTSQTY;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(1, 3, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 3, DATE_SUB(CURDATE(), INTERVAL 2 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(3, 1, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 4, DATE_SUB(CURDATE(), INTERVAL 3 DAY), NULL);

COMMIT;

DROP TRIGGER RENTSCOUNTER;