1# Write your MySQL query statement below
2SELECT P.firstName, P.lastName,AD.city,AD.state FROM Person P
3LEFT JOIN
4Address Ad
5ON P.personID=AD.personID;