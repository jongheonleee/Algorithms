-- 코드를 입력하세요
-- 주소, 경기도 Like 
-- 냉동 시설 NULL이면 N
-- ID 기준으로 오름차순 
-- 출력 대상 : WAREHOUSE_ID, NAME, ADDRESS, TLNO, FREEZER_YN
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, NVL(FREEZER_YN, 'N')
from FOOD_WAREHOUSE 
where address like '경기도%'
order by WAREHOUSE_ID
;
