1# Write your MySQL query statement below
2Select customer_number As customer_number from Orders Group By customer_number order by Count(customer_number) DESC Limit 1;