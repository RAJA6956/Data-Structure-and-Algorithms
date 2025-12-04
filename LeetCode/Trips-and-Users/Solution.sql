1# Write your MySQL query statement below
2SELECT 
3    t.request_at AS Day,
4    ROUND(
5        SUM(CASE 
6            WHEN t.status != 'completed' THEN 1 ELSE 0 
7        END) / COUNT(*),
8    2) AS "Cancellation Rate"
9FROM Trips t
10JOIN Users u1 
11ON t.client_id = u1.users_id AND u1.banned = 'No'
12JOIN Users u2 
13ON t.driver_id = u2.users_id AND u2.banned = 'No'
14WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
15GROUP BY t.request_at;
16