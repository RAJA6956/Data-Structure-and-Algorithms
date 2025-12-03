1SELECT e.name AS Employee
2FROM Employee e
3JOIN Employee m
4ON e.managerId = m.id
5WHERE e.salary > m.salary;
6