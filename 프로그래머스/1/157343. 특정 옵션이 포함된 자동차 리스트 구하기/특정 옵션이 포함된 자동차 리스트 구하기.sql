-- 코드를 입력하세요
-- 네비게이션 있는 차 가져오기 -> 와일드 카드, id 기준 내림차순
-- 출력 대상 : car_id, car_type, daily_fee, options
SELECT car_id CAR_ID, car_type CAR_TYPE, daily_fee DAILY_FEE, options OPTIONS
from CAR_RENTAL_COMPANY_CAR
where options like '%네비게이션%'
order by CAR_ID desc
;