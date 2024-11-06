


-- 시큐리티 연습용 회원 테이블 만들기
CREATE TABLE SECURITY_MEMBER(
	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(100) NOT NULL
	, MEM_NAME VARCHAR(50)
	, MEM_ROLE VARCHAR(30) -- USER, ADMIN
);

SELECT * FROM security_member;


-- 관리자 : admin / 비밀번호 : 1111 / ADMIN (권한)
-- 매니저 : manager / 비밀번호 : 1111 / MANAGER (권한)
-- 일반회원 : user / 비밀번호 : 1111 / USER


UPDATE security_member
SET MEM_ROLE = 'ADMIN'
WHERE MEM_ID = 'admin';

UPDATE security_member
SET MEM_ROLE = 'MANAGER'
WHERE MEM_ID = 'manager';

