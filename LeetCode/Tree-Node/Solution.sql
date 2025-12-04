1# Write your MySQL query statement below
2SELECT 
3    id,
4    CASE
5        WHEN p_id IS NULL THEN 'Root'
6        WHEN id IN (SELECT DISTINCT p_id FROM Tree) THEN 'Inner'
7        ELSE 'Leaf'
8    END AS type
9FROM Tree;
10