-- 코드를 입력하세요
SELECT t1.title TITLE, t1.board_id BOARD_ID, t2.reply_id REPLY_ID, t2.writer_id WRITER_ID, t2.contents CONTENTS, to_char(t2.created_date, 'YYYY-MM-DD') CREATED_DATE
from USED_GOODS_BOARD t1, USED_GOODS_REPLY t2
where t1.board_id = t2.board_id
and to_char(t1.created_date, 'YYYY-MM') = '2022-10'
order by t2.created_date, t1.title