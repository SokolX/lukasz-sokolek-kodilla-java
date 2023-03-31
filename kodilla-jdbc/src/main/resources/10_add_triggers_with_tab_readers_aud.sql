-- Tworzenie nowej tabeli na logi systemowe
CREATE TABLE READERS_AUD (
                             EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                             EVENT_DATE DATETIME NOT NULL,
                             EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                             READER_ID INT(11) NOT NULL,
                             OLD_FIRSTNAME VARCHAR(255),
                             NEW_FIRSTNAME VARCHAR(255),
                             OLD_LASTNAME VARCHAR(255),
                             NEW_LASTNAME VARCHAR(255),
                             OLD_PESELID INT(11),
                             NEW_PESELID INT(11),
                             OLD_VIP_LEVEL VARCHAR(20),
                             NEW_VIP_LEVEL VARCHAR(20),
                             PRIMARY KEY (EVENT_ID)
);

-- Dodanie wyzwalacza na dodanie rekordu do db
DELIMITER $$

CREATE TRIGGER READERS_INSERT AFTER INSERT ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
                             NEW_FIRSTNAME, NEW_LASTNAME,
                             NEW_PESELID, NEW_VIP_LEVEL)
        VALUE(CURTIME(), "INSERT", NEW.READER_ID,
              NEW.FIRSTNAME, NEW.LASTNAME,
              NEW.PESELID, NEW.VIP_LEVEL);
END $$

DELIMITER ;

-- Dodanie rekordu
INSERT INTO READERS (READER_ID, FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL)
VALUES (20, "Insert", "Insert", 1111111111, NULL);
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM READERS_AUD;


-- Dodanie wyzwalacza na usuwanie rekordu z db
DELIMITER $$

CREATE TRIGGER READERS_DELETE AFTER DELETE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE(CURTIME(), "DELETE", OLD.READER_ID);
END $$

DELIMITER ;

-- Usuniecie rekordu
DELETE FROM READERS WHERE READER_ID = 20;
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM READERS_AUD;


-- Dodanie wyzwalacza na aktualizacji rekordu z db
DELIMITER $$

CREATE TRIGGER READERS_UPDATE AFTER UPDATE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
                             OLD_FIRSTNAME, NEW_FIRSTNAME,
                             OLD_LASTNAME, NEW_LASTNAME,
                             OLD_PESELID, NEW_PESELID,
                             OLD_VIP_LEVEL, NEW_VIP_LEVEL
    )
        VALUE(CURTIME(), "UPDATE", OLD.READER_ID,
              OLD.FIRSTNAME, NEW.FIRSTNAME,
              OLD.LASTNAME, NEW.LASTNAME,
              OLD.PESELID, NEW.PESELID,
              OLD.VIP_LEVEL, NEW.VIP_LEVEL
             );

END $$

DELIMITER ;

-- Aktualizacja rekordu
INSERT INTO READERS (READER_ID, FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL)
VALUES (20, "Insert", "Insert", 1111111111, NULL);

UPDATE READERS SET FIRSTNAME = "Update", LASTNAME = "Update" WHERE READER_ID = 20;
COMMIT;

-- Weryfikacja tabeli audytowej
SELECT * FROM READERS_AUD;
