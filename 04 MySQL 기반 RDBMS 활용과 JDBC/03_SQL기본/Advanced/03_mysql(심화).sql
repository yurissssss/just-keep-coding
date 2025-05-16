-- (문제 1) 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
USE sqldb;

-- (문제 1-1)
SELECT userID '사용자 아이디', SUM(amount) '총 구매 개수' FROM buytbl GROUP BY userID;

-- (문제 1-2)
SELECT userID '사용자 아이디', SUM(amount * price) '총 구매액' FROM buytbl GROUP BY userID;

-- ----------------------------------------------------

-- (문제 2) 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
-- USE sqldb;

-- (문제 2-1)
SELECT AVG(amount) '평균 구매 개수' FROM buytbl;

-- (문제 2-2)
SELECT userID, AVG(amount) '평균 구매 개수' FROM buytbl GROUP BY userID;

-- ----------------------------------------------------

-- (문제 3) 다음 결과가 나오도록 usertbl에 대한 SQL 문을 각각 작성하세요.
-- USE sqldb;

-- 1. 기본 --
SELECT name, height FROM usertbl 
WHERE height = (SELECT MIN(height) FROM usertbl)
				OR height = (SELECT MAX(height) FROM usertbl);
  
-- 2. UNION 이용 --
-- SELECT name, height FROM usertbl
-- WHERE height IN (SELECT MIN(height) FROM usertbl
-- 				UNION 
--                 SELECT MAX(height) FROM usertbl);

-- 3. ORDER BY, LIMIT, UNION 이용 --
-- (SELECT name, height FROM usertbl ORDER BY height ASC LIMIT 1)
-- UNION
-- (SELECT name, height FROM usertbl ORDER BY height DESC LIMIT 1);

-- ----------------------------------------------------

-- (문제 4) 다음 결과가 나오도록 usertbl에 대한 SQL 문을 각각 작성하세요.
-- USE sqldb;
SELECT COUNT(mobile1) '휴대폰이 있는 사용자' FROM usertbl;
-- SELECT COUNT(mobile2) '휴대폰이 있는 사용자' FROM usertbl;
-- SELECT COUNT(mobile1 OR mobile2) '휴대폰이 있는 사용자' FROM usertbl;

-- ----------------------------------------------------

-- (문제 5) buytbl 테이블로 다음을 처리하세요.
-- USE sqldb;

-- (문제 5-1) 사용자별 총 구매액을 출력하세요.
SELECT userID '사용자', SUM(amount * price) '총 구매액' FROM buytbl GROUP BY userID;

-- (문제 5-2) 총 구매액이 1,000 이상인 사용자만 출력하세요.
SELECT userID '사용자', SUM(amount * price) '총 구매액' 
FROM buytbl 
GROUP BY userID 
HAVING SUM(price * amount) > 1000;

-- ----------------------------------------------------

-- (문제 6) world 데이터베이스에서 다음 질문을 처리하세요.
Use world;

-- (문제 6-1) city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 총합을 구하시오.
SELECT SUM(Population) FROM city WHERE CountryCode = 'KOR';

-- (문제 6-2) city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최솟값을 구하시오.
-- 단, 결과를 나타내는 테이블의 필드는 "최솟값"으로 표시하시오.
SELECT MIN(Population) '최솟값' FROM city WHERE CountryCode = 'KOR';

-- (문제 6-3) city 테이블에서 국가코드가 'KOR'인 도시들의 평균을 구하시오.
SELECT AVG(Population) FROM city WHERE CountryCode = 'KOR';
-- (문제 6-4) city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최댓값을 구하시오.
-- 단, 결과를 나타내는 테이블의 필드는 "최댓값"으로 표시하시오.
SELECT MAX(Population) '최댓값' FROM city WHERE CountryCode = 'KOR';

-- (문제 6-5) country 테이블 각 레코드의 Name 칼럼의 글자수를 표시하시오.
SELECT length(name) FROM country;

-- (문제 6-6) country 테이블에서 나라명(NAme 칼럼)을 앞 세글자만 대문자로 표시하시오.
SELECT upper(mid(Name, 1, 3)) FROM country;

-- ----------------------------------------------------

-- (문제 7)
Use employees;

-- (문제 7-1) employees db에서 각 부서별 관리자를 출력하세요.
-- 단, 현 재직자만 출력한다.
SELECT * FROM dept_manager WHERE to_date = '9999-01-01';

-- (문제 7-2) 부서번호 d005 부서의 현재 관리자 정보를 출력하세요.
SELECT * FROM employees 
WHERE emp_no = (
SELECT emp_no FROM dept_manager WHERE dept_no = 'd005' 
AND to_date = '9999-01-01');

-- ----------------------------------------------------

-- (문제 8) employees 테이블에서 페이지네이션으로 페이지를 추출하려고 한다. 
-- 다음 조건 하에서 8번 페이지의 데이터를 출력하세요.
-- Use employees;

-- (문제 8-1) 입사일을 내림차순으로 정렬한다.
SELECT * FROM employees 
ORDER BY hire_date DESC;

-- (문제 8-2) 한 페이지당 20명의 정보를 출력한다.
SELECT * FROM employees
ORDER BY hire_date DESC
-- LIMIT offset, amount 
LIMIT 140, 20;  -- 8번 페이지

-- ----------------------------------------------------

-- (문제 9)
-- Use employees;

-- (문제 9-1) employees db에서 재직자의 총 수를 구하시오.
-- 제작자의 to_date 값은 '9999-01-01'로 저장되어 있음
SELECT COUNT(*) FROM dept_manager WHERE to_Date = '9999-01-01';

-- (문제 9-2) employees db에서 재직자의 평균 급여를 출력하시오.
SELECT AVG(salary) FROM salaries WHERE to_Date = '9999-01-01';

-- ----------------------------------------------------

-- (문제 10) 재직자 전체 평균 급여보다 급여를 더 많이 받는 재직자를 출력하세요.
SELECT * FROM salaries WHERE to_Date = '9999-01-01' AND salary > (SELECT AVG(salary) FROM salaries WHERE to_Date = '9999-01-01');

-- ----------------------------------------------------

-- (문제 11) employees db에서 각 부서별 재직자의 수를 구하시오.
-- 부서 번호로 구분하고, 부서 번호로 오름차순 정렬하여 출력한다.
SELECT dept_no,COUNT(*) FROM dept_emp
WHERE to_date = '9999-01-01'
GROUP BY dept_no
ORDER BY dept_no ASC;