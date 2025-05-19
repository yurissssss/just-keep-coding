-- (문제 1) sqldb 데이터베이스에서 다음 조건을 처리하세요.
USE sqldb;

-- (문제 1-1) sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- 사용자별로 구매 이력을 출력함  --> userID 이용
-- 모든 컬럼을 출력함  --> SELECT *
-- 구매 이력이 없는 정보는 출력하지 않음 --> INNER JOIN
SELECT * FROM buytbl b 
INNER JOIN usertbl u
	ON b.userID = u.userID;

-- (문제 1-2) 앞의 결과에서 userID가 'JYP'인 데이터만 출력하세요.
SELECT * FROM buytbl b 
INNER JOIN usertbl u 
	ON b.userID = u.userID 
WHERE b.userID = 'JYP';

-- ----------------------------------------------------

-- (문제 2) sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- 각 사용자별로 구매 이력을 출력하세요.  --> userID
-- 연결 컬럼은 userID로 함  --> ON u.userID = b.userID
-- 결과를 userID를 기준으로 오름차순으로 정렬함  --> ORDER BY u.userID
-- 구매이력이 없는 사용자도 출력하세요.  --> LEFT OUTER JOIN
-- userID, name, prodName, addr, 연락처를 다음과 같이 출력함

-- Use sqldb;
SELECT u.userID, u.name, b.prodName, u.addr, 
	CONCAT(u.mobile1, u.mobile2) 연락처 
FROM usertbl u 
LEFT OUTER JOIN buytbl b 
	ON u.userID = b.userID 
ORDER BY u.userID; 

-- ----------------------------------------------------

-- (문제 3) 

-- (문제 3-1) sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요.
SELECT name, CONCAT(mobile1, mobile2) 
FROM usertbl
WHERE name NOT IN (
	SELECT name FROM usertbl 
		WHERE mobile1 IS NULL);

-- (문제 3-2) sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요.
-- 1. 서브쿼리 --
SELECT name, CONCAT(mobile1, mobile2) 
FROM usertbl
WHERE name IN (
	SELECT name FROM usertbl 
		WHERE mobile1 IS NULL);
        
-- 2. 기본 --
SELECT name, CONCAT(mobile1, mobile2)
FROM usertbl
WHERE mobile1 IS NULL;