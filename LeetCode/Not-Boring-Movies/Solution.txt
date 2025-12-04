1# Write your MySQL query statement below
2select id,movie,description,rating from Cinema where id%2=1 and  description not like '%boring%'  order by rating desc;