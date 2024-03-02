-- 코드를 입력하세요
-- 출력 대상 : Flavor 

-- first_half, icecream_info 조인
-- flavor 칼럼으로 조인
-- 이때, total_order가 3000이상이고 ingredient_type이 fruit_based기반인거 출력
-- 마지막으로 총 주문량 내림차순
SELECT t1.flavor
from first_half t1, icecream_info t2
where t1.flavor = t2.flavor
and t2.ingredient_type = 'fruit_based'
and t1.total_order >= 3000
order by t1.total_order desc
;