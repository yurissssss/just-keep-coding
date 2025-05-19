-- (문제 1) 앞에서 정의한 3개의 테이블을 이용해서 다음을 처리하세요.
USE sqldb;

-- (문제 1-1) 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해서 학생을 기준으로 학생 이름/지역/가입한 동아리/동아리방을 출력하세요.
SELECT S.stdName, S.addr, SC.clubName, C.roomNo
FROM stdtbl S
INNER JOIN stdclubtbl SC
	ON S.stdName = SC.stdName
INNER JOIN clubtbl C
	ON SC.clubName = C.clubName
ORDER BY S.stdName;

-- (문제 1-2) 동아리를 기준으로 가입한 학생의 목록을 출력하세요.
-- 출력 정보: clubName, roomNo, stdName, addr
SELECT SC.clubName, C.roomNo, S.stdName, S.addr
FROM stdtbl S
INNER JOIN stdclubtbl SC
	ON S.stdName = SC.stdName
INNER JOIN clubtbl C
	ON SC.clubName = C.clubName
ORDER BY SC.clubName;

-- ----------------------------------------------------

-- (문제 2) 앞에서 추가한 테이블에서 '우대리'의 상관 연락처를 확인하세요.
-- 출력할 정보: 부하직원, 직속상관, 직속상관 연락처
SELECT A.emp 부하직원, B.emp 직속상관, B.empTel 직속상관연락처
FROM empTbl A
INNER JOIN empTbl B
	ON A.manager = B.emp  -- B.empTel = 2222-2
WHERE A.emp = '우대리';  -- A.manager = '이부장' = B.emp

-- ----------------------------------------------------

-- (문제 3) 모든 문제는 employees 데이터베이스에서 수행한다.
USE employees;

-- (문제 3-1) 현재 재직 중인 직원의 정보를 출력하세요.
-- 출력 항목: emp_no, first_name, last_name, title
SELECT T.emp_no, E.first_name, E.last_name, T.title
FROM titles T
INNER JOIN employees E
	ON T.emp_no = E.emp_no
WHERE T.to_date = '9999-01-01';  -- 재직 중인

-- (문제 3-2) 현재 재직 중인 직원의 정보를 출력하세요.
-- 출력 항목: 직원의 기본 정보 모두, title, salary
SELECT E.*, T.title, S.salary
FROM employees E
INNER JOIN titles T
	ON E.emp_no = T.emp_no
INNER JOIN salaries S
	ON T.emp_no = S.emp_no
WHERE T.to_date = '9999-01-01'
	AND S.to_date = '9999-01-01';

-- (문제 3-3) 현재 재직 중인 직원의 정보를 출력하세요.
-- 출력 항목: emp_no, first_name, last_name, department
-- 정렬: emp_no 오름차순
SELECT E.emp_no, E.first_name, E.last_name, D.dept_name
FROM departments D
INNER JOIN dept_emp DE
	ON D.dept_no = DE.dept_no
INNER JOIN employees E 
	ON DE.emp_no = E.emp_no
WHERE DE.to_date = '9999-01-01'
ORDER BY E.emp_no;

-- (문제 3-4) 부서별 재직 중인 직원의 수를 출력하세요.
-- 출력 항목: 부서 번호, 부서명, 인원수
-- 정렬: 부서 번호 오름차순
SELECT D.dept_no, D.dept_name, COUNT(*)
FROM departments D
INNER JOIN dept_emp DE
	ON D.dept_no = DE.dept_no
INNER JOIN employees E 
	ON DE.emp_no = E.emp_no
WHERE DE.to_date = '9999-01-01'
GROUP BY D.dept_no
ORDER BY D.dept_no;

-- (문제 3-5) 직원 번호가 10209인 직원의 부서 이동 히스토리를 출력하세요.
-- 출력 항목: emp_no, first_name, last_name, dept_name, from_date, to_date
SELECT E.emp_no, E.first_name, E.last_name, D.dept_name, DE.from_date, DE.to_date
FROM employees E 
INNER JOIN dept_emp DE
	ON E.emp_no = DE.emp_no
INNER JOIN departments D
	ON DE.dept_no = D.dept_no
WHERE E.emp_no = 10209
ORDER BY E.emp_no, DE.from_date; 