-- 코드를 입력하세요
-- 대상 : 12세 이하인 여자환자
-- 출력 칼럼 : PT_NAME, PT_NO, GEND_CD, AGE, TLNO
-- 전화번호 x -> NONE, 나이 내림차순, 환자이름 오름차순
SELECT PT_NAME, PT_NO, GEND_CD, AGE, nvl(TLNO, 'NONE') as TLNO
from patient
where GEND_CD = 'W' and AGE <= 12
order by AGE desc, PT_NAME
;