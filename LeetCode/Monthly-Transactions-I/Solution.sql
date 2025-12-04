1# Write your MySQL query statement below
2SELECT class
3FROM Courses
4GROUP BY class
5HAVING COUNT(DISTINCT student) >= 5;
6