# Write your MySQL query statement below
select p.student_id,p.student_name,p.subject_name, count(e.student_id) as attended_exams 
-- select * , count(e.student_id)
from (select * from students join subjects) as p
 left join examinations e on e.student_id  = p.student_id and e.subject_name = p.subject_name
--  where p.student_id = 2
--  where (e.subject_name = p.subject_name or e.subject_name  is null ) 
 group by p.student_id,p.subject_name 
order by p.student_id, p.subject_name

