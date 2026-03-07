# Write your MySQL query statement below
select query_name, round(avg(ratio),2) as quality, round(( sum(per) / count(*) * 100),2) as poor_query_percentage  from (select query_name, rating/position as ratio, 
case 
when rating <3 then 1 
else 0
end 
as per
 from queries) as t group by t.query_name