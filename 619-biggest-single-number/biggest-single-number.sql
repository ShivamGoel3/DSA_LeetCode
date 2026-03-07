# Write your MySQL query statement below
select max(num) as num from ( select * from MyNumbers group by num having count(*) = 1 order by num desc  limit 1 ) as t