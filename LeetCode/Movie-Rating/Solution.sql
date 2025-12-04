1# Write your MySQL query statement below
2(
3    SELECT u.name AS results
4    FROM MovieRating r
5    JOIN Users u 
6    ON r.user_id = u.user_id
7    GROUP BY r.user_id, u.name
8    ORDER BY COUNT(*) DESC, u.name
9    LIMIT 1
10)
11UNION ALL
12(
13    SELECT m.title AS results
14    FROM MovieRating r
15    JOIN Movies m 
16    ON r.movie_id = m.movie_id
17    WHERE r.created_at BETWEEN '2020-02-01' AND '2020-02-29'
18    GROUP BY r.movie_id, m.title
19    ORDER BY AVG(r.rating) DESC, m.title
20    LIMIT 1
21);
22