-- Tworzenie nowej tabeli na logi systemowe
CREATE TABLE BOOKS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           BOOK_ID INT(11) NOT NULL,
                           OLD_TITLE VARCHAR(255),
                           NEW_TITLE VARCHAR(255),
                           OLD_PUBYEAR INT,
                           NEW_PUBYEAR INT,
                           OLD_BESTSELLER BOOLEAN,
                           NEW_BESTSELLER BOOLEAN,
                           PRIMARY KEY (EVENT_ID)
);

-- Dodanie wyzwalacza na dodanie rekordu do db
DELIMITER $$

CREATE TRIGGER BOOKS_INSERT AFTER INSERT ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID,
                           NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
        VALUE(CURTIME(), "INSERT", NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR,
              NEW.BESTSELLER);
END $$

DELIMITER ;

-- Dodanie rekordu
INSERT INTO BOOKS (BOOK_ID, TITLE, PUBYEAR, BESTSELLER)
VALUES (20, "Insert", 1999, 0);
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM BOOKS_AUD;


-- Dodanie wyzwalacza na usuwanie rekordu z db
DELIMITER $$

CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE(CURTIME(), "DELETE", OLD.BOOK_ID);
END $$

DELIMITER ;

-- Usuniecie rekordu
SELECT * FROM BOOKS;
DELETE FROM BOOKS WHERE BOOK_ID = 20;
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM BOOKS_AUD;


-- Dodanie wyzwalacza na aktualizacji rekordu z db
DELIMITER $$

CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID,
                           OLD_TITLE, NEW_TITLE,
                           OLD_PUBYEAR, NEW_PUBYEAR,
                           OLD_BESTSELLER, NEW_BESTSELLER)
        VALUE(CURTIME(), "UPDATE", OLD.BOOK_ID,
              OLD.TITLE, NEW.TITLE,
              OLD.PUBYEAR, NEW.PUBYEAR,
              OLD.BESTSELLER, NEW.BESTSELLER);

END $$

DELIMITER ;

-- Aktualizacja rekordu
INSERT INTO BOOKS (BOOK_ID, TITLE, PUBYEAR, BESTSELLER)
VALUES (20, "Insert", 1999, 0);

UPDATE BOOKS SET TITLE = "Update" WHERE BOOK_ID = 20;
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM BOOKS_AUD;
