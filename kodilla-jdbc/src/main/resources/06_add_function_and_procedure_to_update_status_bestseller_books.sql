-- DODANIE KOLUMNY BESTSELLER
ALTER TABLE BOOKS ADD BESTSELLER BOOLEAN NOT NULL DEFAULT 0;

SELECT * FROM BOOKS;
SELECT * FROM RENTS;

-- DODANIE FUNKCJI SPRAWDZAJACEJ CZY KSIAZKA TO BESTSELLER
DROP FUNCTION IF EXISTS CheckBestseller;

DELIMITER $$

CREATE FUNCTION CheckBestseller(numberOfRents INT) RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE result BOOLEAN DEFAULT 0;

        IF numberOfRents > 2 THEN
            SET result = 1;
        ELSE
            SET result = 0;
        END IF;

    RETURN result;
END $$

DELIMITER ;

SELECT CheckBestseller(1) AS bestSeller;

-- PROCEDURA AKTUALIZUJACA STATUS BESTSELLERA KSIAZEK
DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE NUMBER_OF_RENTS, B_ID INT;
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;

    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO B_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*)
                FROM RENTS
                WHERE BOOK_ID = B_ID
                INTO NUMBER_OF_RENTS;

                UPDATE BOOKS
                SET BOOKS.BESTSELLER = CheckBestseller(NUMBER_OF_RENTS)
                WHERE BOOK_ID = B_ID;
                COMMIT;
            END IF;
        END WHILE;

    CLOSE ALL_BOOKS;
END $$

DELIMITER ;

CALL UpdateBestsellers();

SELECT * FROM BOOKS;
