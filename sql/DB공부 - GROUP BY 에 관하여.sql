

-- GROUP BY : 데이터를 특정 기준에 맞춰 그룹지은 결과를 도출할 때 사용
-- 단일행 함수와 함께 사용하는 경우가 많음 ( <-- 통상적으로)
-- 단일행 함수 : SUM(), MAX(), MIN(), COUNT(), AVG()


-- 단일행이 아닌 함수?
-- IFNULL(), CONCAT(), SUBSTRING() 등등...
SELECT SUBSTRING(ENAME,1,2) FROM emp;
SELECT MAX(SAL) FROM emp; 


-- 사원중에서 가장 많은 급여를 조회하기! 
SELECT MAX(SAL)
FROM emp;

-- 각 부서별로 가장 많은 급여를 조회~~~~
-- 다른 컬럼이 동일한 행의 갯수를 가질수있는지 주의하셈(?) ?? 뭔말일까 ㅎ
-- 기본적으로 단일행 함수와 조회결과 가지는 행의 갯수가 다른 컬럼을 사용 못하지만, GROUP BY 절에서는 유일하게 그루핑한 칼럼은 조회가 가능함!

SELECT DEPTNO, MAX(SAL),SUM(SAL),CONUT(SAL), AVG(SAL)
FROM emp
GROUP BY DEPTNO;


-- 직급이 사원이 아닌 사람들 중 직급별 급여의 평균을 조회
-- 조회 결과를 직급기준 오름차순으로 정렬!
SELECT JOB, AVG(SAL)
FROM emp
WHERE JOB != '사원'
GROUP BY JOB -- WHERE 뒤에 나와야함 
ORDER BY JOB;

-- 조회 결과를 평균 급여기준 내림차순으로 정렬!
SELECT JOB, AVG(SAL)
FROM emp
WHERE JOB != '사원'
GROUP BY JOB -- WHERE 뒤에 나와야함 
ORDER BY AVG(SAL) DESC;


-- 직급별로 그룹하여 직급, 각 직급별 평균 급여를 조회하됭~ 평균 급여가 300이상인 직급에 대해서만 조회하셍! 
-- 정렬은 평균 급여기준 내림차순으로 정렬 쿠다사이~~~~~~

-- 그룹 한 후 결정해야 하는 조건은 HAVING절에 사용
SELECT JOB, AVG(SAL)
FROM emp 
GROUP BY JOB
HAVING AVG(SAL) >= 300; 

-- 20번 부서를 제외한 정보중에서 부서별로 그룹하여 부서번호, 부서별 급여의 합을 조회하되 
-- 각 그룹별 급여의 합이 700이상인 데이터만 조회, 조회결과 데이터는 부서별 급여의 합 기준 오름차순으로 정렬
SELECT DEPTNO, SUM(SAL)
FROM emp
WHERE DEPTNO != 20
GROUP BY DEPTNO
HAVING SUM(SAL) >= 700
ORDER BY SUM(SAL) ASC;


-- [ 조회 쿼리문의 해석 순서 ]
-- 해석순서에 따라 쿼리가 달라짐! 기억하셈! 
-- FROM -> JOIN > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
-- SELECT 보다 느린거는 ORDER BY 밖에 없음. 그 외에는 SELECT가 제일 느림~~~~
SELECT ENPNO AS 사번, ENAME
FROM emp 
WHERE EMPNO < 1003; -- 사번조회
ORDER BY EMPNO;


-- 시험에는 HAVIN 안나옴...후