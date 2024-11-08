
-- 한번에 전체선택해서 테이블 생성되는거 F9번 누르면뎀 오라클은 F5

CREATE TABLE JOIN_STU (
	STU_NUM INT PRIMARY KEY
	, STU_NAME VARCHAR(50)
	, MAJOR VARCHAR(50)
);

INSERT INTO JOIN_STU VALUES (1, '김자바', '자바전공');
INSERT INTO JOIN_STU VALUES (2, '이자바', '자바전공');
INSERT INTO JOIN_STU VALUES (3, '박자바', '자바전공');
INSERT INTO JOIN_STU VALUES (4, '윤회계', '회계전공');
INSERT INTO JOIN_STU VALUES (5, '정회계', '회계전공');
INSERT INTO JOIN_STU VALUES (6, '최회계', '회계전공');

CREATE TABLE JOIN_SCORE (
	SCORE_NUM INT PRIMARY KEY
	, SCORE INT
	, STU_NUM INT
);

INSERT INTO JOIN_SCORE VALUES (1, 80, 1);
INSERT INTO JOIN_SCORE VALUES (2, 70, 2);
INSERT INTO JOIN_SCORE VALUES (3, 70, 5);
INSERT INTO JOIN_SCORE VALUES (4, 85, 6);
INSERT INTO JOIN_SCORE VALUES (5, 89, 7);
INSERT INTO JOIN_SCORE VALUES (6, 77, 8);


SELECT * FROM join_stu;
SELECT * FROM join_score;



-- 아래 쿼리의 실행결과 조회되는 데이터 수는 몇개인가 ? 
SELECT STU.STU_NUM, STU_NAME, SCORE
FROM join_stu STU, join_score SCORE
WHERE STU.STU_NUM = SCORE.STU_NUM;


-- 조인은 각 데이터베이스별 문법존재, 
-- 모든 데이터 베이스에서 사용가능한 문법(마리아디비)  'ANSI 문법'
-- , 대신 INNER JOIN
-- JOIN 조건은 WHERE이 아니라  on절에 작성 
-- ON : 조인조건문만 들어올수있음! 
-- INNER JOIN -> JOIN 대체 가능 ( 실상에서 JOIN을 쓰면 그냥 INNER JOIN으로 알아들음)

SELECT STU.STU_NUM, STU_NAME, SCORE
FROM join_stu STU INNER JOIN join_score SCORE
ON STU.STU_NUM = SCORE.STU_NUM
WHERE STU.STU_NUM = 1;


-- JOIN은 INNER JOIN, OUTER JOIN 두 가지로 구분 
-- OUTER JOIN : RIGHT OUTER JOIN, LEFT OUTER JOIN
-- 가정. 모든 학생에 대한 점수를 조회 

SELECT STU.STU_NUM, STU_NAME, IFNULL(SCORE,0), SCORE
FROM join_stu STU RIGHT OUTER JOIN join_score SCORE
ON STU.STU_NUM = SCORE.STU_NUM;



-- 아래 문법에서 OUTER JOIN 사용하기 
SELECT STU.STU_NUM, STU_NAME, SCORE
FROM join_stu STU, join_score SCORE
-- WHERE STU.STU_NUM = SCORE.STU_NUM -> INNER JOIN 문법 
-- WHERE STU.STU_NUM = SCORE.STU_NUM(+) -> LEFT JOIN
-- WHERE STU.STU_NUM(+) = SCORE.STU_NUM -> RIGHT JOIN 문법 























