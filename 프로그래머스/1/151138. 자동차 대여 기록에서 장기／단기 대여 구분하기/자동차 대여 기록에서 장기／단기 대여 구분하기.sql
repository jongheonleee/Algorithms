select HISTORY_ID, CAR_ID, to_char(start_date, 'YYYY-MM-DD') START_DATE, to_char(end_date, 'YYYY-MM-DD') END_DATE,
(case when (end_date - start_date)+1 >= 30 then '장기 대여' else '단기 대여' end) RENT_TYPE
from car_rental_company_rental_history
where extract(year from start_date) = '2022'
and extract(month from start_date) = '09'
order by HISTORY_ID desc
;