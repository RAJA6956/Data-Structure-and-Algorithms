1# Write your MySQL query statement below
2SELECT 
3    ROUND(SUM(tiv_2016), 2) AS tiv_2016
4FROM Insurance
5WHERE tiv_2015 IN (
6    SELECT tiv_2015
7    FROM Insurance
8    GROUP BY tiv_2015
9    HAVING COUNT(*) > 1
10)
11AND (lat, lon) IN (
12    SELECT lat, lon
13    FROM Insurance
14    GROUP BY lat, lon
15    HAVING COUNT(*) = 1
16);
17