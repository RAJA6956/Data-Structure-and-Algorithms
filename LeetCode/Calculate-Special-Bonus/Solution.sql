1# Write your MySQL query statement below
2select employee_id,if(employee_id % 2 = 1 and name not like 'M%',salary,0) as bonus from Employees order by employee_id;