	
	
	-- 시험
	
	CREATE TABLE my_member (
		-- 회원번호,아이디,비밀번호,회원이름,나이,이메일주소
		MEM_NUM INT AUTO_INCREMENT PRIMARY KEY
		,MEM_ID VARCHAR(50) NOT NULL
		,MEM_PW VARCHAR(50) NOT NULL
		,MEM_NAME VARCHAR(50) NOT NULL
		,MEM_AGE INT
		,MEM_EMAIL VARCHAR(50)
	);
	
	SELECT * FROM my_member;
	
	-- 2. 데이터를 삽입하는 쿼리문, 모든 데이터를 삭제하는 쿼리문 
	-- 삽입되는 내용은 임의로 작성된다.
	
	INSERT INTO my_member(MEM_NUM,MEM_ID,MEM_PW,MEM_NAME,MEM_AGE,MEM_EMAIL)
	VALUES (1,'ONE11','1111','김일번',20,'one1@naver.com');
	
	INSERT INTO my_member(MEM_NUM,MEM_ID,MEM_PW,MEM_NAME,MEM_AGE,MEM_EMAIL)
	VALUES (2,'tttte','2222','박티티',23,'ttee@naver.com');
	
	DELETE FROM MY_MEMBER;
	
	-- 3. 회원번호가 1번인 회원의 이름을 '김자바'로 ID는 KIMJAVA로 수정하는 쿼리문
	
	UPDATE my_member
	SET
		MEM_NAME = '김자바'
		,MEM_ID = 'KIMJAVA'
	WHERE MEM_NUM = 1;
	
	
	
	-- 여기서부터는 참고하기 
	SELECT * FROM emp;
	SELECT * FROM dept;

 -- 4.급여가 500~3000 사이이고 커미션이 NULL이 아닌 사원의 사원번호, 사원명, 급여, 커미션?  

		SELECT EMPNO, ENAME, SAL, COMM
		FROM EMP
		WHERE SAL BETWEEN 500 AND 3000
		AND COMM IS NOT NULL;


 --  5. 사원들 중 이름이 ‘기’로 끝나기나, ‘김’이 들어가는 사원들의 사번, 이름, 입사일을 조회하되,
 --     사번기준 내림차순정렬하여 조회하는 쿼리문을 작성하세요.
 
		SELECT EMPNO, ENAME, HIREDATE
		FROM EMP
		WHERE ENAME LIKE '%기' OR ENAME LIKE '%김%'
		ORDER BY EMPNO DESC;
		

 --  6. 사원의 사번, 이름, 부서번호, 부서명을 조회해보자. 부서명은 부서번호가 10일 때는 ‘인사부’, 20일 때는 ‘영업부’, 
 --     30일 때는 ‘개발부’, 그 외의 값은 ‘생산부’로 조회되어야 한다. 조인 사용하는 문제 아님. CASE 사용.


	SELECT EMPNO, ENAME, DEPTNO, 
	CASE 
     WHEN DEPTNO = 10 THEN '인사부'
     WHEN DEPTNO = 20 THEN '영업부'
     WHEN DEPTNO = 30 THEN '개발부'
     ELSE '생산부'
	END AS DNAME
	FROM EMP;



-- 7. 1월에 입사한 모든 사원의 사번, 이름, 입사일, 커미션을 입사일 기준 오름차순으로 조회하는 쿼리문을 작성하세요. 
--    단, 커미션이 NULL일 경우 커미션은 0으로 조회되어야 한다.

	SELECT EMPNO, ENAME, HIREDATE, 
       COALESCE(COMM, 0) AS COMM
	FROM EMP
	WHERE MONTH(HIREDATE) = 1
	ORDER BY HIREDATE ASC;
	
	
-- 8. 부서별로 그룹지어서 부서별 급여의 합과 급여의 평균, 커미션의 평균을 조회하는 쿼리문을 작성하여라. 단 조회는 부서별 급여의 총합이 큰 순서대로 조회되어야 한다.
	
	SELECT DEPTNO, 
       SUM(SAL) AS TOTAL_SALARY, 
       AVG(SAL) AS AVG_SALARY, 
       AVG(COALESCE(COMM, 0)) AS AVG_COMM
	FROM EMP
	GROUP BY DEPTNO
	ORDER BY TOTAL_SALARY DESC;
	
	
 --  9. 서브쿼리를 사용하여 부서명이 ‘인사부’인 사원의 사번, 이름, 입사일, 급여, 부서번호, 부서명을 조회하는 쿼리문을 작성 
 
 	SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO, 
   (SELECT DNAME FROM DEPT WHERE DEPTNO = E.DEPTNO) AS DNAME
	FROM EMP E
	WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = '인사부');



 -- 10. 조인을 사용하여 부서명이 ‘인사부’가 아니고 급여가 500이상인 사원의 사번, 이름, 입사일, 급여, 부서번호, 
 --     부서명을 조회하는 쿼리문을 작성해보자. 단, 정렬은 사번 기준 내림차순으로 정렬 후 사원 이름 기준 오름차순으로 정렬
	
	SELECT E.EMPNO, E.ENAME, E.HIREDATE, E.SAL, E.DEPTNO, D.DNAME
	FROM EMP E
	JOIN DEPT D ON E.DEPTNO = D.DEPTNO
	WHERE D.DNAME != '인사부' AND E.SAL >= 500
	ORDER BY E.EMPNO DESC, E.ENAME ASC;
