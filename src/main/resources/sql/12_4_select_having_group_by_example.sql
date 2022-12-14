SELECT USER_ID, COUNT(*) AS POSTS_NUMBER
FROM POSTS
GROUP BY USER_ID;

SELECT USER_ID, COUNT(*) AS POSTS_NUMBER
FROM POSTS
GROUP BY USER_ID
HAVING COUNT(*) > 1;

SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER
FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID
GROUP BY P.USER_ID
HAVING COUNT(*) > 1;

SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER
FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID
GROUP BY P.USER_ID
HAVING COUNT(*) > 1
ORDER BY U.LASTNAME, U.FIRSTNAME;