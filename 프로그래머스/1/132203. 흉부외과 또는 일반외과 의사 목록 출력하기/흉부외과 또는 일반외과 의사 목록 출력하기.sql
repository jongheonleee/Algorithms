-- 코드를 입력하세요
-- 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회
-- 고용일자를 기준으로 내림차순 정렬, 이름기준으로 오름차순 정렬
SELECT dr_name as DR_NAME, dr_id as DR_ID, mcdp_cd as MCDP_CD, to_char(hire_ymd, 'YYYY-MM-DD') as HIRE_YMD
from doctor
where mcdp_cd in ('CS', 'GS')
order by hire_ymd desc, dr_name