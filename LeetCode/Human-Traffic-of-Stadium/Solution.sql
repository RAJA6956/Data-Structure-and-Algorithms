1SELECT id, visit_date, people
2FROM Stadium
3WHERE id IN (
4    SELECT s1.id
5    FROM Stadium s1, Stadium s2, Stadium s3
6    WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100
7      AND (
8        (s1.id = s2.id - 1 AND s1.id = s3.id - 2)
9        OR (s1.id = s2.id + 1 AND s1.id = s3.id + 2)
10        OR (s1.id = s2.id - 1 AND s1.id = s3.id + 1)
11      )
12)
13ORDER BY visit_date;
14