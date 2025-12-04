1# Write your MySQL query statement below
2SELECT 
3  score,
4  DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
5FROM Scores;
6