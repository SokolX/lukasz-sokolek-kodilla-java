DROP PROCEDURE IF EXISTS ListBooks;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT BOOK_ID, TITLE, PUBYEAR FROM BOOKS;
END $$

DELIMITER ;

CALL ListBooks();

--
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel(booksrented INT) RETURNS VARCHAR(20) DETERMINISTIC -- [1]
BEGIN									                                    -- [2]
DECLARE result VARCHAR(20) DEFAULT 'Standard customer';	                -- [3]
IF booksrented >= 10 THEN						                        -- [4]
    SET result = 'Gold customer';					                        -- [5]
ELSEIF booksrented >= 5 AND booksrented < 10 THEN			            -- [6]
    SET result = 'Silver customer';				                        -- [7]
ELSEIF booksrented >= 2 AND booksrented < 5 THEN			            -- [8]
    SET result = 'Bronze customer';		           		                -- [9]
ELSE				      					                                -- [10]
    SET result = 'Standard customer';				                        -- [11]
END IF;				    				                                -- [12]
RETURN result;
END $$

DELIMITER ;

SELECT VipLevel(12) AS LEVEL;