# Write your MySQL query statement below
select t.customer_number from (select customer_number, count(*) as counts from Orders group by customer_number ) as t order by t.counts desc limit 1