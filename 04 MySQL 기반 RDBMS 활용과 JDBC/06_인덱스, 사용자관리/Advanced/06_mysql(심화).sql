-- (문제 1) sqldb의 usertbl 테이블에서 다음 내용들을 확인하세요.
USE sqldb;

-- (문제 1-1) usertbl의 내용 확인
SELECT * FROM usertbl;

-- (문제 1-2) usertbl의 인덱스 목록 확인
SHOW INDEX FROM usertbl;  -- userID

-- (문제 1-3) usertbl의 데이터 크기와 인덱스 크기 확인
SHOW TABLE STATUS LIKE 'usertbl';
-- Data_length: 16384
-- Index_length: 0
-- InnoDB는 테이블을 클러스터형 인덱스로 저장
-- -> PRIMARY KEY 나 UNIQUE 인덱스가 있어도, 그 인덱스는 실제 데이터와 "함께" 저장
-- --> 그 공간은 Data_length에만 포함되고, Index_length에는 별도로 측정되지 X 

-- ----------------------------------------------------

-- (문제 2) usertbl의 addr 컬럼에 대해 idx_usertbl_addr 이름으로 인덱스를 만들고, 인덱스 목록을 확인하세요.
CREATE INDEX idx_usertbl_addr ON usertbl(addr);

SHOW INDEX FROM usertbl;
-- PRIMARY: userID
-- idx_usertbl_addr: addr

-- ----------------------------------------------------

-- (문제 3) usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고, 내용이 없다면 실제 적용되도록 한 후, 인덱스의 크기를 확인하세요.
SHOW TABLE STATUS LIKE 'usertbl';
-- Index_length = 0

-- ANALYZE TABLE 문으로 먼저 테이블 분석 / 처리
-- -> 생성한 인덱스 실제로 적용됨
ANALYZE TABLE usertbl;
SHOW TABLE STATUS LIKE 'usertbl';

-- ----------------------------------------------------

-- (문제 4) usertbl에 대해 다음을 처리하세요.
-- (문제 4-1) birthYear 칼럼에 대해 idx_usertbl_birthYear 이름의 인덱스를 만드세요.
-- 에러가 난다면 그 이유를 설명하세요.
CREATE UNIQUE INDEX idx_usertbl_birthYear
	ON usertbl(birthYear);
-- ERROR: birthYear 컬럼에 중복값이 있어 인덱스 생성 X

-- (문제 4-2) name 컬럼에 대해 idx_usertbl_name 이름의 인덱스를 만드세요.
CREATE UNIQUE INDEX idx_usertbl_name
	ON usertbl(name);

-- (문제 4-3) 생성된 인덱스의 목록을 확인하세요.
SHOW INDEX FROM usertbl;

-- ----------------------------------------------------

-- (문제 5) usertbl에 대해 다음을 처리하세요.
-- (문제 5-1) name 컬럼에 대한 보조 인덱스를 삭제하세요.
DROP INDEX idx_usertbl_name ON usertbl;

-- (문제 5-2) name과 birthYear 컬럼 조합으로 idx_usertbl_name_birthYear 이름의 인덱스를 생성하세요.
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
	ON usertbl(name, birthYear);

-- (문제 5-3) 인덱스의 목록을 확인하세요.
SHOW INDEX FROM usertbl;
-- PRIMARY
-- idx_usertbl_name_birthYear: name
-- idx_usertbl_name_birthYear: birthYear
-- idx_usertbl_addr: addr

-- ----------------------------------------------------

-- (문제 6) usertbl에서 앞에서 만든 인덱스를 삭제하세요.
ALTER TABLE usertbl DROP INDEX idx_usertbl_addr;
ALTER TABLE usertbl DROP INDEX idx_usertbl_name_birthYear;

SHOW INDEX FROM usertbl;
-- PRIMARY: userID

-- ----------------------------------------------------

-- (문제 7) 다음과 같이 실습 데이터베이스 및 사용자를 생성하고, 해당 데이터베이스에 대해 모든 권한을 부여하세요.
-- 데이터베이스 명: scoula_db
-- 사용자 명: scoula
-- 비밀번호: 1234
-- 접속 호스트: 제한 없음
CREATE DATABASE scoula_db;

CREATE USER 'scoula'@'%'IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON scoula_db.* TO 'scoula'@'%';

FLUSH PRIVILEGES;
