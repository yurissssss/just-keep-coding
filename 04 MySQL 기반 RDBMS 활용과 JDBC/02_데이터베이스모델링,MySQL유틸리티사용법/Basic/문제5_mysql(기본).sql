-- productTBL의 데이터를 출력하세요.
-- SELECT * FROM productTBL;
select * from productTBL;

-- memberTBL의 데이터를 출력하세요.
-- 단, memberName과 memberAddress만 출력.
select memberName, memberAddress from memberTBL;

-- memberTBL의 데이터 중 이름이 '지운이'인 데이터만 출력하세요.
select * from memberTBL where memberName = '지운이';