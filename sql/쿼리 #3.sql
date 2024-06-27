DROP TABLE test_member;

-- DB연결 연습용 테이블

CREATE TABLE TEST_MEMBER(
	MEM_NUM INT PRIMARY KEY
	,MEM_NAME VARCHAR(50)
	,MEM_AGE INT
	,MEM_ADDR VARCHAR(50)
);

SELECT * FROM test_member;


-- 데이터 삽입
INSERT INTO test_member VALUES(1,'신짱구',22,'서울시');
INSERT INTO test_member VALUES(2,'김철수',23,'울산시');
INSERT INTO test_member VALUES(3,'박맹구',20,'대구시');
INSERT INTO test_member VALUES(4,'정훈이',25,'부산시');
INSERT INTO test_member VALUES(5,'신유리',21,'대전시');
COMMIT;
