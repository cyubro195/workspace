
-- PRIMARY KEY는 데이터가 아무리 많아도 데이터 하나를 꼮 짚을수잇음 ㅎ 
CREATE TABLE TEST_MEMBER(
	MEM_NUM INT PRIMARY KEY -- 중복불가, NULL 못들어감 안됨!
	,MEM_NAME VARCHAR(50)
	,MEM_AGE INT
	,MEM_ADDR VARCHAR(50)
);

SELECT * FROM test_member;


-- 데이터베이스는 데이터가 잘못되는 것을 엄격히 금지하기 때문에
-- 데이터를 변화가 생기는 경우 => 해당 변화가 잘못이 없는지 한번 확인할 기회를 줌.
-- 변화된 데이터가 잘못되지 않았으며 COMMIT; 명령어로 데이터 변화를 확정지음
-- 잘못된 변화 : 변화를 취소시키고 싶다면 ROLLBACK; 명령어 실행 




-- 데이터 삽입 INSERT
-- INSERT INTO 테이블명(컬럼들) VALUES (값들); < 기본문맥
-- 입력한 칼럼 순서대로 값을 저장시켜야 함.
INSERT INTO test_member(MEM_NUM,MEM_NAME,MEM_AGE,MEM_ADDR)
VALUES (10,'김남구',26,'울산시');

ROLLBACK;
COMMIT;

INSERT INTO test_member(MEM_NUM,MEM_NAME,MEM_ADDR,MEM_AGE)
VALUES (11,'김광구','광주',33);

-- 컬럼명은 반드시 모든 칼럼이 작성될 필요는 없다.
-- 작성되지 않은 칼럼에는 기본적으로 NULL이 들어간다.

INSERT INTO test_member (MEM_NUM,MEM_NAME)
VALUES(12,'홍두식');

-- 이렇게 넣으면 NULL값으로 되어 있어서 안들어가유~~~~
-- 아래 쿼리는 MEM_NUM에 NULL이 들어가는데 MEM_NUM은 기본키(PRIMARY KEY)라 NULL값이 들어갈 수 없어 오류발생!
INSERT INTO test_member(MEM_NAME,MEM_AGE)
VALUES('이자바',30);

-- 테이블 생성 시 작성한 칼럼명 순서대로 데이터를 넣는다면 칼럼명 작성을 생략할 수 있다.
INSERT INTO test_member VALUES(13,'이이름',27,'부산시'); -- test_member()에 ()뺄때는 모든 칼럼의 값이 다 들어가져 있어야함!

-- 데이터 수정 UPDATE
-- UPDATE TABLE 테이블명 SET 컬럼명 = 값 [WHERE 조건];

-- WHERE 조건절을 작성하지 않으면 모든 데이터가 변경된다오! 
UPDATE test_member
SET
MEM_NAME = '고경표'; -- 이러면 모든 데이터의 이름이 고경표로 바껴버림 ㅎㄷㄷ;;

ROLLBACK; -- 이거 누르면 다시 돌아감! 


-- 문제야~~문제에에~~온 세상속에~~~~ 
-- 회원번호가 10번인 회원의 이름을 '박회원', 나이는 32살로 번경하는 쿼리로 하셈!

UPDATE test_member
SET
MEM_NAME = '박회원'
, MEM_AGE = 32;
WHERE MEM_NUM = 10;
ROLLBAKCK;
COMMIT;


-- 데이터 삭제 DELETE
-- DELETE 테이블명 [WHERE]
DELETE FROM test_member;
ROLLBACK;

-- 40살 이하인 회원을 모두 삭제
DELETE FROM test_member
WHERE MEM_AGE <= 40;
ROLLBACK;


-- 기억하라 최윤형... COMMIT을 눌르면 데이터가 저장된다..ROLLBACK;할때는 반드시 생각하고 COMMIT 쓸것...ㅠㅠㅠ




