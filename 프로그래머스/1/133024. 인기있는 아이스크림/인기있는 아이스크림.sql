-- 코드를 입력하세요
-- 출력 칼럼 : FLAVOR
-- 총주문량 내림차순, 출하번호 오름차순
SELECT flavor
from first_half
order by total_order desc, shipment_id
;