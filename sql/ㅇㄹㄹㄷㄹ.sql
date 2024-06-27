

SELECT * FROM test_member;

-- 회원번호가 1번인 회원의 이름을 조회

SELECT MEM_NAME
FROM test_member
WHERE MEM_NUM = 1;


SELECT MEM_AGE
FROM test_member
WHERE MEM_NUM = 1;

SELECT MEM_NAME
FROM test_member
WHERE MEM_AGE >= 20;

SELECT MEM_NUM,MEM_NAME,MEM_AGE,MEM_ADDR
FROM test_member
WHERE MEM_NUM = 1;

SELECT MEM_NUM, MEM_NAME, MEM_AGE, MEM_ADDR
FROM test_member;

-- 삭제하기 만들기 

DELETE FROM test_member
WHERE MEM_NUM = 1;

SELECT * FROM test_member;
ROLLBACK;


