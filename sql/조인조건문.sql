

-- 여러 테이블의 내용을 동시에 조회하기! ( 조인 문법, JOIN)

SELECT * FROM emp;
SELECT * FROM dept;


-- 사원번호, 사원명, 부서명을 조회 ( 다른 테이블에있는 DB 2개 불러오기 )
-- EMP 테이블에서 DEPTNO 확인 -> 20(부서번호)
-- DEPT 테이블에서 DEPTNO가 20인 데이터 확인


-- 조인의 조건 : 두 테이블(FROM전에 만든 테이블)이 공통으로 지니는 칼럼의 값이 같은 데이터만 조회. 
-- EMP 안에있는 EMPNO를 조회한다 : 자바랑 비슷함! , 사실 테이블 명없어도 됨! 
SELECT EMP.EMPNO, EMP.ENAME, DEPT.DNAME, emp.DEPTNO
FROM emp, dept
WHERE emp.DEPTNO = dept.DEPTNO; 
-- EMP안에 DEPT.EMPTNO를 조회하겠습니다. < 조인조건문 반드시 넣어줘야 위에처럼 여러가지 조회할수있음! 


-- 조인 + 별칭
SELECT EMPNO AS 사원번호
, ENAME AS 사원명 -- AS빼도 별칭조회 됨 + 테이블도 똑같이 가능!
-- , EMP.SAL -- < 여기서 사원을 넣어주면 찾을수가없음! 근데 만약에 사원을 빼면 조회가 됨!
, 사원.SAL -- ▲ 조회하고싶으면 < 이렇게 해야 조회가 가능함!  
FROM emp 사원; -- 마리아만됨 오라클안됨! 쓰찌마셈!  


-- 직급이 '대리'인 사원들의
-- 사원번호, 사원명, 직급, 부서번호, 부서명, 부서의 지역 조회

SELECT EMPNO, ENAME, JOB, DNAME, LOC, E.DEPTNO -- EMP 테이블에 존재함.
FROM emp E, dept D -- 별칭을 넣어주는거야! EMP E라고 부르겠다~
WHERE E.DEPTNO = D.DEPTNO;
AND JOB = '사원';

-- 조회 시 데이터를 정렬하여 조회하기 

SELECT * FROM emp;

-- 사번, 사원명, 급여를 조회, 급여 기준 오름차순 정렬 
-- 오름차순 : ASC 급여가 낮은순부터 , 생략가능! 생략해서 쓰면 자동으로 오름차순이기 때문에 ㅇㅋㅇㅋㅇㅋ
-- 내림차순 : DESC

SELECT EMPNO, ENAME, SAL
FROM emp
ORDER BY SAL;

-- 부서번호가 30번 아닌 사원들의 사원명, 부서번호를 조회하되, 사원명 기준 내림차순으로 정렬....

SELECT EMPNO, ENAME
FROM emp
WHERE DEPTNO != 30 -- ! = 30번 아닌거 조회! 
ORDER BY ENAME DESC;


-- 부서명이 인사부가 아니면서 급여가 300이상인 사원들의
-- 사번, 사원명, 부서번호, 부서명, 급여를 조회하되 부서번호 기준 오름차순으로 정렬하셈
SELECT EMPNO,ENAME,E.DEPTNO,D.DEPTNO,SAL
FROM emp E, dept D
WHERE E.DEPTNO = D.DEPTNO -- 조인조건 성립! 
AND DNAME !='인사부'
AND SAL >= 300 
ORDER BY E.DEPTNO ASC; -- < ASC는 생략가능! 


SELECT EMPNO, ENAME, JOB, SAL
FROM emp
ORDER BY JOB DESC, SAL ASC; -- 최신순으로 한다고하면 이렇게~~~
-- 이렇게 조회한다고해도 ㄱㄴㄷ~기준으로 나옴! 직급순서대로 안나타남






