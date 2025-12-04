1# Write your MySQL query statement below
2SELECT 
3    s.product_id,
4    s.year AS first_year,
5    s.quantity,
6    s.price
7FROM Sales s
8JOIN (
9    SELECT product_id, MIN(year) AS first_year
10    FROM Sales
11    GROUP BY product_id
12) t
13ON s.product_id = t.product_id 
14AND s.year = t.first_year;
15