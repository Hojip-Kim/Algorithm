-- 코드를 작성해주세요

select ROUND(SUM(IFNULL(LENGTH, 10)) / count(*), 2) as AVERAGE_LENGTH
from FISH_INFO
