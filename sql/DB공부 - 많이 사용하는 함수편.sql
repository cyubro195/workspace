-- [ 안신나는 DB공부 ] --

-- (DB에서 많이 사용하는 함수) --

SELECT 'JAVA',123,'HELLO'; -- 이렇게 해도 충분힝? 검색되서 나옴;
SELECT 'JAVA', BOARD_NUM FROM board;

-- CONCAT : 문자열 나열해주는거  CONCAT('JAVA','HELLO','PYTHON') => JAVAHELLOPYTHON
SELECT 'JAVA', 'HELLO', CONCAT('JAVA','HELLO','PYTHON');
SELECT BOARD_NUM, TITLE, CONCAT(BOARD_NUM,'_',TITLE) AS BOARD_INFO
FROM board;

 
-- LENGTH : 문자열의 길이
SELECT 'JAVA', LENGTH('JAVA'), 'HELLO', LENGTH('HELLO');

-- SUBSTRING : 일부 문자열 추출
SELECT 'ABCDEFG', SUBSTRING('ABCDEFG', 3) -- 'ABCDEFG' 문자열에서 3번째부터 시작 => CDEFG 나옴
	, SUBSTRING('ABCEDFG',3,2); -- (원본글),(추출시작),(추출개수)
	
	
-- 대소문자 변경 함수  대문자    소문자 
SELECT 'MySQL', UPPER('MySQL'), LOWER('MySQL');


-- 문자나 숫자의 자릿수 맞추기 
SELECT LPAD('JAVA',5,'#'), RPAD('JAVA',5,'#'), LPAD('001',10,'0'); -- 빈자리에 # 들어감!


-- 문자열의 좌,우 공백제거 해주는 애들
SELECT 'AA BB', LTRIM (' AA BB '), RTRIM (' AA BB '),TRIM (' AA BB ');

-- 문자열 치환 함수
SELECT '010 1111 2222' , REPLACE('010 1111 2222', ' ','-');



-- 반올림 함수
SELECT 123.456, ROUND(123.456,2);



-- 연산 및 나머지 연산자! 
SELECT 10+10, 2*3, 15/4, MOD(10,3);


-- NULL 데이터를 치환하는 함수...
SELECT COMM, IFNULL(COMM,0) FROM emp;
-- NULL이 아니면 그대로 나오고 값이 NULL이면 0으로 나오게하라! 


-- 평균 계산 시 NULL데이터 주의!!
SELECT AVG(COMM) FROM emp;

-- COMM 컬럼의 평균 값을 계산하는 올바른 방법 
SELECT AVG(IFNULL(COMM,0)) FROM emp;
SELECT ROUND(AVG(IFNULL(COMM,0)),2) FROM emp; -- 소수점 2자리까지 나오게하기위해서는 ROUND(숫자, 자릿수) 활용하기 

-- --------------------------------------------
-- 단일행 함수 : 데이터의 갯수와 상관없이 조회결과 하나의 행 결과만 갖는 함수
-- SUM(), MAX(), MIN(), AVG(), COUNT() -> 갯수
-- ▲ 이런 함수들은 같이 쓸대 조심해야함 ▲

SELECT * FROM emp;

-- 모든 사원의 급여 총합 및 커미션 종합을 조회
-- SUM(10,10)  --> 이런거는 쿼리 불가! 

SELECT SUM(SAL), SUM(COMM), FROM emp;

-- SUM() 함수의 위임 함수와의 다른점
-- SUM() 함수는 데이터의 수와 상관없이 무조건 하나의 조회결과를 가짐
SELECT LENGTH(ENAME), LENGTH(JOB) FROM emp;


-- *** 쿼리 조회 시 조회하는 모든 칼럼의 조회 행 갯수는 모두 일치해야함!!! *** << 진짜 리얼 트루 중요함! 
-- 모든 사원의 이름과 급여의 합을 ㅈ조회
SELECT ENAME, SUM(SAL) FROM emp;



SELECT SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL), COUNT(SAL)
FROM emp;


-- 테이블이 있는 데이터의 수
SELECT COUNT(*) FROM emp;
-- 추천하는 방법 : COUNT(PK) <- 통상적으로는 PK를 많이 넣는다! 
SELECT COUNT(EMPNO) FROM emp;

-- NULL 데이터를 COUNT에서 제외함
SELECT COUNT(COMM) FROM emp;


SELECT AVG(COMM) FROM emp;



