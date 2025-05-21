-- (문제 1) 다음 컬럼을 가지는 userTBL과 buyTBL을 정의하세요.
-- 기존에 테이블이 존재하면 삭제함
USE tabledb;

DROP TABLE IF EXISTS userTBL;

-- (문제 1-1) userTBL
CREATE TABLE userTBL(
userID 		CHAR(8) 	NOT NULL 	PRIMARY KEY,
name 		VARCHAR(10) 	NOT NULL,
birthyear 	INT 		NOT NULL
);

DESC userTBL;

-- (문제 1-2) buyTBL
DROP TABLE IF EXISTS buyTBL;

CREATE TABLE buyTBL(
num 		INT 		NOT NULL 	AUTO_INCREMENT 	PRIMARY KEY,
userID 		CHAR(8) 	NOT NULL,
prodName 	CHAR(6) 	NOT NULL
);

DESC buyTBL;

-- (문제 1-3) ALTER를 이용해 userID를 외래키로 수정하세요.
ALTER TABLE buyTBL 
	ADD CONSTRAINT FK_userTBL_buyTBL
    FOREIGN KEY(userID)
    REFERENCES userTBL(userID);

-- ----------------------------------------------------

-- (문제 2) 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
-- 기존 buyTBL, userTBL을 삭제하세요.
DROP TABLE IF EXISTS buyTBL;
DROP TABLE IF EXISTS userTBL;

CREATE TABLE userTBL(
userID 		CHAR(8) 	NOT NULL 	PRIMARY KEY,
name 		VARCHAR(10)	NOT NULL,
birthyear 	INT 		NOT NULL,
email 		CHAR(30) 	NOT NULL	UNIQUE  -- UNIQUE 중복불가
);

DESC userTBL;

-- ----------------------------------------------------

-- (문제 3) 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
-- 기존 userTBL을 삭제하세요.
DROP TABLE IF EXISTS userTBL;

CREATE TABLE userTBL(
userID 		CHAR(8) 	NOT NULL 	PRIMARY KEY,
name 		VARCHAR(10),
birthYear	INT 	   	CHECK(birthYear >= 1900 AND birthYear <= 2-23),
mobile		CHAR(3) 	NOT NULL,
);

-- ----------------------------------------------------

-- (문제 4) 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
-- 기존 userTBL을 삭제하세요.
DROP TABLE IF EXISTS userTBL;

CREATE TABLE userTBL(
userID 		CHAR(8) 	NOT NULL 	PRIMARY KEY,
name 		VARCHAR(10) 	NOT NULL,
birthYear 	INT 		NOT NULL 	DEFAULT -1,
addr 		CHAR(2)		NOT NULL	DEFAULT '서울',
mobile1 	CHAR(3)		NULL,
mobile2 	CHAR(8) 	NULL,
height 		SMALLINT 	NULL		DEFAULT 170,
mDate 		DATE 		NULL
);
-- 'INSERT INTO'문을 실행할 때 'default'로 입력 -> 설정된 기본값 (DEFAULT) 자동 입력
-- 'INSERT INTO'문을 실행할 때 컬럼 명 X -> 설정된 기본값 (DEFAULT) 자동 입력
-- 값 직접 입력 -> 설정된 기본값 (DEFAULT) 무시됨

DESC userTBL; 

-- ----------------------------------------------------

-- (문제 5) 앞에서 만든 userTBL에 대해서 다음 조건을 처리하도록 수정하세요.
-- (문제 5-1) mobile1 컬럼을 삭제함
ALTER TABLE usertbl
	DROP COLUMN mobile1;
    
DESC usertbl;

-- (문제 5-2) name 칼럼명을 uName으로 변경함
ALTER TABLE usertbl
	CHANGE COLUMN name uName VARCHAR(20) NULL;

DESC usertbl;

-- (문제 5-3) 기본키를 제거함
ALTER TABLE usertbl
	DROP PRIMARY KEY;
    
DESC usertbl;

-- ----------------------------------------------------

-- (문제 6) 모든 문제는 employees 데이터베이스에서 수행한다.
USE employees;

-- (문제 6-1) 다음 정보를 가지는 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성하세요.
CREATE OR REPLACE VIEW EMPLOYEES_INFO
AS
SELECT E.*, T.title, T.from_date t_from, T.to_date t_to, S.salary, S.from_date s_from, S.to_date s_to
FROM employees E
INNER JOIN titles T
	ON E.emp_no = T.emp_no
INNER JOIN salaries S 
	ON E.emp_no = S.emp_no;
    
SELECT * FROM EMPLOYEES_INFO;

-- (문제 6-2) EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력하세요.
SELECT * FROM EMPLOYEES_INFO WHERE s_to = '9999-01-01';

-- (문제 6-3) 다음 정보를 가지는 부서 정보를 출력하는 EMP_DEPT_INFO 뷰를 작성하세요.
-- 내가 푼 풀이
CREATE OR REPLACE VIEW EMP_DEPT_INFO
AS
SELECT E.emp_no, DE.dept_no, D.dept_name, DE.from_date, DE.to_date
FROM employees E
	INNER JOIN dept_emp DE
		ON E.emp_no = DE.emp_no
	INNER JOIN departments D
		ON DE.dept_no = D.dept_no
ORDER BY E.emp_no;  -- 순서대로 정렬
        
SELECT * FROM EMP_DEPT_INFO;

-- (문제 6-4) EMP_DEPT_INFO로 현재 재직자의 부서 정보를 출력하세요.
SELECT * 
FROM EMP_DEPT_INFO 
WHERE to_date = '9999-01-01';
