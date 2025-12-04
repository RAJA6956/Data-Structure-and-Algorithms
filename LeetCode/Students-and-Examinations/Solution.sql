1# Write your MySQL query statement below
2SELECT 
3    s.student_id,
4    s.student_name,
5    sub.subject_name,
6    COUNT(e.subject_name) AS attended_exams
7FROM Students s
8CROSS JOIN Subjects sub
9LEFT JOIN Examinations e
10ON s.student_id = e.student_id
11AND sub.subject_name = e.subject_name
12GROUP BY 
13    s.student_id, 
14    s.student_name, 
15    sub.subject_name
16ORDER BY 
17    s.student_id, 
18    sub.subject_name;
19