1select e1.name as Employee from
2Employee e1
3join Employee e2
4on e1.managerId=e2.id
5where e1.salary>e2.salary;