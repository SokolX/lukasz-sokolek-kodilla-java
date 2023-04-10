-- INFORMACJE O ZAPYTANIU
EXPLAIN SELECT * FROM READERS
        WHERE FIRSTNAME = 'John' AND LASTNAME = 'Smith';

EXPLAIN SELECT * FROM BOOKS
        WHERE TITLE = 'The Trial';


-- UTWORZENIE INDEXOW
CREATE INDEX TITLE_BOOK_INDEX ON BOOKS (TITLE);
CREATE INDEX FIRST_AND_LASTNAME_READER_INDEX ON READERS (FIRSTNAME, LASTNAME);


-- INFORMACJE O ZAPYTANIU
EXPLAIN SELECT * FROM READERS
        WHERE FIRSTNAME = 'John' AND LASTNAME = 'Smith';

EXPLAIN SELECT * FROM BOOKS
        WHERE TITLE = 'The Trial';