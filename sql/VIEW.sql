
-- [ 가상 테이블 VIEW ]

-- VIEW 사용이유
-- 1. 민감한 데이터를 보안하기 위해서 (숨기기 위해서)
-- 2. 잦은 조인, 서브쿼리 작성에 대한 피로감을 줄이기 위해

SELECT * FROM emp;


-- VIEW(가상 테이블 - 테이블처럼 사용) -> 실무가면 만들기보다는 이미 만들어져있음..ㅎㅎ
-- VIEW 생성
-- 일반 테이블 생성 : CREATE TABLE 테이블명
-- 가상 테이블 생성 : CREATE VIEW 테이블명

CREATE VIEW EMP_VIEW AS
SELECT EMPNO, ENAME, JOB, HIREDATE
FROM emp;

-- VIEW 생성 후 조회문은 테이블과 동일
SELECT * FROM emp_view; -- 눈모양 테이블 생김! 


-- 민감한 MAJOR를 빼고 VIEW로 만들기 
SELECT * FROM join_stu;

CREATE VIEW STU_VIEW AS
SELECT STU_NUM, STU_NAME -- 공개할 내용만 넣어주! 
FROM join_stu;

-- 삭제하기
DELETE FROM join_stu WHERE STU_NUM = 6; -- 학번 6번 지우기 

-- 예시문 

SELECT * FROM STU_VIEW
WHERE STU_NUM > 2; 

SELECT STU_NUM, STU_NAME
FROM join_stu
WHERE STU_NUM > 2;


CREATE VIEW STU_VIEW_2 AS
SELECT STU_NUM S_NUM, STU_NAME S_NAME
FROM join_stu
WHERE STU_NUM < 4; -- 학번 1,2,3 애들만 부를거임

-- 전체보기 
SELECT * FROM STU_VIEW_2;
SELECT STU_NUM, STU_NAME FROM STU_VIEW_2;

CREATE VIEW STU_SCORE_VIEW AS
SELECT STU.STU_NUM, STU_NAME, SCORE
FROM join_stu STU JOIN join_score SCORE
ON STU.STU_NUM = SCORE.STU_NUM;

-- 뷰 삭제하기 @@!@!@1
DROP VIEW STU_SCORE_VIEW;

SELECT * FROM STU_SCORE_VIEW; -- 테이블 쓸 때는 변수로 만들어서 사용하면 됨!!! 
WHERE SCORE > 70;