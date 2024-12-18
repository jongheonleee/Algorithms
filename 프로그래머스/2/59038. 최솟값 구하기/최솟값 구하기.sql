-- 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회
-- 1. 시간이 가장 최솟값인 로우를 조회한다 
-- 2. 시간만 조회한다 
SELECT MIN(DATETIME) AS DATETIME
FROM ANIMAL_INS;