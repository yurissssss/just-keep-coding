-- (문제 1) sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl1을 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
-- 컬럼 목록: a INT PRIMARY KEY, b INT, c INT
USE sqldb;

CREATE TABLE tbl1(
a INT PRIMARY KEY,
b INT,
c INT
);

SHOW INDEX FROM tbl1;

-- ----------------------------------------------------

-- (문제 2) sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl2를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
-- 컬럼 목록: a INT PRIMARY KEY, b INT UNIQUE, c INT UNIQUE, d INT
CREATE TABLE tbl2(
a INT PRIMARY KEY,
b INT UNIQUE,
c INT UNIQUE,
d INT
);

SHOW INDEX FROM tbl2;

-- ----------------------------------------------------

-- (문제 3) sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl3를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
-- 컬럼 목록: a INT UNIQUE, b INT UNIQUE, c INT UNIQUE, d INT
CREATE TABLE tbl3(
a INT UNIQUE,
b INT UNIQUE,
c INT UNIQUE,
d INT
);

SHOW INDEX FROM tbl3;

-- ----------------------------------------------------

-- (문제 4) sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl4를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
-- 컬럼 목록: a INT UNIQUE NOT NULL, b INT UNIQUE, c INT UNIQUE, d INT
CREATE TABLE tbl4(
a INT UNIQUE NOT NULL,
b INT UNIQUE,
c INT UNIQUE,
d INT
);

SHOW INDEX FROM tbl4;

-- ----------------------------------------------------

-- (문제 5) sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl5를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
-- 컬럼 목록: a INT UNIQUE NOT NULL, b INT UNIQUE, c INT UNIQUE, d INT PRIMARY KEY
CREATE TABLE tbl5(
a INT UNIQUE NOT NULL,
b INT UNIQUE,
c INT UNIQUE,
d INT PRIMARY KEY
);

SHOW INDEX FROM tbl5;

-- ----------------------------------------------------

-- (문제 6) 
-- (문제 6-1) testdb에 다음 컬럼 목록을 가지는 usertbl을 만드세요.
USE testdb;

CREATE TABLE usertbl(
userID 		CHAR(8) 		NOT NULL 	PRIMARY KEY,
name 		VARCHAR(10) 	NOT NULL,
birthYear 	INT 			NOT NULL,
addr 		NCHAR(2) 		NOT NULL
);

DESC usertbl;

-- (문제 6-2) 아래 데이터를 추가하고, 클러스터형 인텍스의 테이블 내용을 확인하세요.
INSERT INTO usertbl VALUES('LSG', '이승기', 1984, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');

SELECT * FROM usertbl;

-- (문제 6-3) ALTER를 사용하여 usertbl에서 PRIMARY KEY 제약조건을 제거하고, name 컬럼에 pk_name이라는 제약조건명으로 기보닠를 설정하세요.
ALTER TABLE usertbl DROP PRIMARY KEY;

ALTER TABLE usertbl
	ADD CONSTRAINT pk_name PRIMARY KEY(name);

DESC usertbl;

-- (문제 6-4) usertbl의 내용을 출력하여, 새로운 클러스터형 인텍스를 확인하세요.
SELECT * FROM usertbl;

SHOW INDEX FROM usertbl;  -- Column_name: name