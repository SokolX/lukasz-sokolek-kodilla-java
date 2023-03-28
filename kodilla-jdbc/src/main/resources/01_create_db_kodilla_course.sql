CREATE DATABASE kodilla_course;

SHOW DATABASES;

CREATE USER 'kodilla_user' IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY 'kodilla_Pass123';

GRANT ALL PRIVILEGES ON kodilla_course.* TO kodilla_user;

show tables;

set global log_bin_trust_function_creators=1;

CREATE TABLE BOOKS (
                       BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                       TITLE varchar(255) NOT NULL,
                       PUBYEAR int(4) NOT NULL,
                       PRIMARY KEY (BOOK_ID)
);

CREATE TABLE READERS (
                         READER_ID int(11) NOT NULL AUTO_INCREMENT,
                         FIRSTNAME varchar(255) NOT NULL,
                         LASTNAME varchar(255) NOT NULL,
                         PESELID varchar(11) NOT NULL,
                         PRIMARY KEY (READER_ID)
);

CREATE TABLE RENTS (
                       RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                       BOOK_ID int(11) NOT NULL,
                       READER_ID int(11) NOT NULL,
                       RENT_DATE datetime NOT NULL,
                       RETURN_DATE datetime,
                       PRIMARY KEY (RENT_ID),
                       FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                       FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
);