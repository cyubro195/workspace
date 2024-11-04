

-- 서브쿼리 : 하나의 쿼리 안에 또 다른 쿼리가 존재하는 문법
-- 서브쿼리는 반드시 ()


SELECT * FROM emp; -- 김사랑 사원은 부서번호가 20번이다.
SELECT * FROM dept; -- 부서번호가 20번인 부서명이 인사부임을 알 수 있음.

-- '사원 이름이 김사랑인 사원이 소속된 부서명을 조회하랏!'
SELECT DNAME 
FROM dept, EMP
WHERE dept.DEPTNO = esales_infomp.DEPTNO
AND ENAME = '김사랑';

SELECT DNAME
FROM dept
WHERE DEPTNO = (SELECT DEPTNO
					FROM EMP
					WHERE ENAME = '김사랑');
					
-- 김사랑 부서번호 20 번 

SELECT DEPTNO
FROM emp
WHERE ENAME = '김사랑';



-- 모든 사원의 평균급여(= AVG= SAL)보다 더 많은 급여를 갖는 사원의 사번,이름,급여 조회
SELECT EMPNO, ENAME, SAL
FROM emp 
WHERE SAL > (SELECT AVG(SAL) FROM emp);

SELECT AVG(SAL) FROM emp;


-- 인사부에 소속된 직원 중 하반기에 입사한 사원들의 사번,이름,입사일을 조회
-- 입사일은 '2024년 08월 07일' 형태로 조회
-- 하반기 : 7월부터 12월 중 입사한 사원을 사원.

SELECT HIREDATE
		, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일')
FROM emp;

SELECT HIREDATE

FROM emp;


SELECT EMPNO,ENAME, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일') AS HIREDATE
FROM emp 
WHERE DEPTNO = (SELECT DEPTNO 
					FROM dept  
					WHERE DNAME = '인사부')
AND MONTH(HIREDATE) >= 7;


-- 사번, 사원명, 부서번호, 부서명 조회
SELECT EMPNO,ENAME,DEPTNO,(SELECT DNAME FROM dept WHERE DEPTNO = 10)
FROM emp;


SELECT * FROM board;
SELECT * FROM board_member;

-- 글번호가 10번이하인 게시글의 글 번호, 제목
-- 작성자 ID, 작성자 이름을 조회

-- 1) 조인

SELECT BOARD_NUM, TITLE, BOARD.MEM_ID, MEM_NAME
FROM board, BOARD_MEMBER
WHERE BOARD.MEM_ID = board_member.MEM_ID
AND BOARD_NUM <=10;

-- 2) 서브쿼리 

SELECT BOARD_NUM, TITLE, MEM_ID
		 ,(SELECT MEM_NAME FROM board_member
		   WHERE MEM_ID = board.MEM_ID) AS MEM_NAME 
		 ,(SELECT MEM_ROLE
		 	FROM BOARD_MEMBER
			WHERE MEM_ID = board.MEM_ID) AS MEM_FOLE
FROM BOARD
WHERE BOARD_NUM <= 10;
 