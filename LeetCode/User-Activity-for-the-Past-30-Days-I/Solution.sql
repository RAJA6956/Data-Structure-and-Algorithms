1# Write your MySQL query statement below
2SELECT 
3    activity_date AS day,
4    COUNT(DISTINCT user_id) AS active_users
5FROM Activity
6WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
7GROUP BY activity_date;
8