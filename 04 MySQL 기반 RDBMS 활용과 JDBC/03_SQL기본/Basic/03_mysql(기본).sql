-- (문제1-1) 현재 서버에 존재하는 데이터베이스 확인
SHOW databases;

-- (문제 1-2) 현재 데이터베이스를 employees로 설정하기
USE employees;

-- (문제 1-3) employees 데이터베이스의 테이블 목록 보기
SHOW TABLES;

-- (문제 1-4) employees 테이블의 열 목록 출력하기
DESC employees;

-- (문제 2-1) titles 테이블의 데이터 출력하기
SELECT * FROM titles;

-- (문제 2-2) employees 테이블에서 first_name 컬럼만 출력하기
SELECT first_name FROM employees;

-- (문제 2-3) employees 테이블에서 first_name 컬럼, last_name 컬럼, gender 컬럼 출력하기
SELECT first_name, last_name, gender FROM employees;

-- (문제 3-1) employees 테이블 출력 시 다음과 같이 나오도록 쿼리를 작성하세요.
SELECT first_name AS 이름, gender AS 성별, hire_date AS "회사 입사일" FROM employees;

-- (문제 4) 배포된 sqldb.sql 파일을 이용하여 sqldb 데이터베이스를 구축하세요.
USE sqldb;

-- (문제 5-1) usertbl 테이블에서 이름이 '김경호'인 행을 출력하세요.
SELECT * FROM usertbl WHERE name = '김경호';

-- (문제 5-2) usertbl 테이블에서 생년이 1970 이상이고, 키가 182 이상인 데이터를 출력하세요.
SELECT * FROM usertbl WHERE birthYear >= 1970 AND height >= 182;

-- (문제 6-1) usertbl 테이블에서 키가 180 ~ 183 범위인 데이터를 출력하세요.
SELECT * FROM usertbl WHERE height BETWEEN 180 AND 183;

-- (문제 6-2) usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터를 출력하세요.
SELECT * FROM usertbl WHERE addr IN ('경남', '전남', '경북');

-- (문제 6-3) usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력하세요.
SELECT * FROM usertbl WHERE name LIKE '김%';

-- (문제 7) usertbl에서 김경호 보다 큰 사람들의 이름과 키를 출력하세요.
-- 서브쿼리를 이용하여 쿼리를 작성하세요.
SELECT name, height FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE name = '김경호');

-- (문제 8-1) usertbl을 mDate의 오름차순으로 정렬하여 출력하세요.
SELECT * FROM usertbl ORDER BY mDATE;

-- (문제 8-2) usertbl을 mDate의 내림차순으로 정렬하여 출력하세요.
SELECT * FROM usertbl ORDER BY mDate DESC;

-- (문제 8-3) usertbl을 height의 내림차순으로 정렬하고, 동률인 경우 name의 내림차순으로 정렬하여 출력하세요.
SELECT * FROM usertbl ORDER BY height DESC, name DESC;

-- (문제 9) usertbl의 주소지를 중복 없이 오름차순으로 출력하세요.
SELECT DISTINCT addr FROM usertbl ORDER BY addr;

-- (문제 10) World 데이터베이스에서 다음 질문을 처리하세요.
use world;

-- (문제 10-1) 국가 코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하세요.
SELECT population FROM city WHERE CountryCode = 'KOR' ORDER BY population DESC;

-- (문제 10-2) city 테이블에서 국가코드와 인구수를 출력하라. 정렬은 국가코드별로 오름차순으로, 동일한 코드(국가) 안에서는 인구 수의 역순으로 표시하세요.
SELECT CountryCode, population FROM city ORDER BY CountryCode, population DESC;

-- (문제 10-3) city 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요.
SELECT COUNT(*) AS `국가코드가 'KOR'인 도시의 수` FROM city WHERE CountryCode = 'KOR';

-- (문제 10-4) city 테이블에서 국가코드가 'KOR', 'CHN', 'JPN'인 도시를 찾으세요.
SELECT COUNT(*) AS `국가코드가 'KOR', 'CHN', 'JPN'인 도시의 수` FROM city WHERE CountryCode IN ('KOR', 'CHN', 'JPN');

-- (문제 10-5) 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요.
SELECT COUNT(*) AS `국가코드가 'KOR'이면서 인구가 100만 이상인 도시` FROM city WHERE CountryCode = 'KOR' AND population >= 1000000;

-- (문제 10-6) 국가코드가 'KOR'인 도시 중 인구수가 많은 순서로 상위 10개만 표시하세요.
SELECT * FROM city WHERE CountryCode = 'KOR' ORDER BY population DESC LIMIT 10;

-- (문제 10-7) city 테이블에서 국가코드가 'KOR'이고, 인구가 100만 이상 500만 이하인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode = 'KOR' AND population BETWEEN 1000000 AND 5000000;