1select p.firstName,p.lastname,a.city,a.state
2from Person p
3left join Address a
4on p.personId=a.personId;