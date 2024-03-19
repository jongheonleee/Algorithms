-- 코드를 입력하세요
SELECT DATETIME
from (
    select datetime
    from ANIMAL_INS
    order by datetime desc
)
where rownum <= 1;
