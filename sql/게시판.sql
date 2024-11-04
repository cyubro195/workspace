
-- 데이터베이스의 키(KEY) 종류
-- KEY : 데이터베이스에서 각 행을 구분하는 식별자를 의미
-- 슈퍼키(SUPER KEY) : 하나의 행을 식별할 수 있는 하나 이상의 칼럼
-- 후보키(CANDIDATE KEY) : 기본키가 될 수있는 후보
-- 기본키(PRIMARY KEY, PK) : 후보키중에 각 행을 구분짓기 위해 결정한 키
-- 대체 키(ALTERNATE KEY) : 후보키 중에서 기본키를 제외한 키.
-- 외래키(FOREIGN KEY, FK) : 다른 테이블ㅇ






-- 로그인, 게시글, 댓글 관련 기능 포함 게시판 프로젝트!!!!!! 
-- 테이블 갯수 : 회원정보 1 , 게시글 정보 1 , 댓글정보 1 = 3개의 테이블 만들 예정


-- 회원정보를 가지고 있는 테이블을 생성하기
-- [회원정보]

-- USER : 일반회원
-- ADMIN : 관리자 계정

CREATE TABLE BOARD_MEMBER(

	MEM_ID VARCHAR(50) PRIMARY KEY -- 회원 아이디
	, MEM_PW VARCHAR(50) NOT NULL -- 회원 비밀번호
	, MEM_NAME VARCHAR(50) NOT NULL -- 회원이름
	, GENDER VARCHAR(10) -- 회원성별 MALE,FEMALE
	, MEM_ROLE VARCHAR(20) DEFAULT 'USER' -- 회원의 권한( 관리자, 일반회원) * 따로 명시필요함
);


-- ---- 임시 회원 데이터 

INSERT INTO board_member (MEM_ID, MEM_PW, MEM_NAME, GENDER, MEM_ROLE)
VALUES ('java','1111','김자바','male','USER')
INSERT INTO board_member (MEM_ID, MEM_PW, MEM_NAME, GENDER, MEM_ROLE)
VALUES ('admin','1111','관리자','female','ADMIN');


-- 게시판 테이블( 회원만 게시글 작성가능!)
CREATE TABLE BOARD(
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY
	, TITLE VARCHAR(50) NOT NULL
	, CONTENT VARCHAR(100)
	, MEM_ID VARCHAR(50) REFERENCES BOARD_MEMBER (MEM_ID) -- 외래키!!!! 
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 게시글 임시데이터 

INSERT INTO board ( -- 만약에 여기에 ID자리에 다른 아이디 입력하면 입력이 안됨! 왜냐면 INSERT 위에 올린것만 들어가기때문에!!!!@@주의하소@@@
	TITLE, CONTENT, MEM_ID) VALUES ('1번글', '1번 내용','java');
	INSERT INTO board ( -- 만약에 여기에 ID자리에 다른 아이디 입력하면 입력이 안됨! 왜냐면 INSERT 위에 올린것만 들어가기때문에!!!!@@주의하소@@@
	TITLE, CONTENT, MEM_ID) VALUES ('2번글', '2번 내용','java');
	INSERT INTO board ( -- 만약에 여기에 ID자리에 다른 아이디 입력하면 입력이 안됨! 왜냐면 INSERT 위에 올린것만 들어가기때문에!!!!@@주의하소@@@
	TITLE, CONTENT, MEM_ID) VALUES ('3번글', '3번 내용','admin');




-- 댓글 테이블(회원만 가능하게!!)
-- 댓글은 게시판에 종속적(?)이라 연결고리가 있어야함?????

DROP TABLE board_reply;
CREATE TABLE BOARD_REPLY(
	REPLY_NUM INT AUTO_INCREMENT PRIMARY KEY
	, REPLY_CONTENT VARCHAR(50) NOT NULL
	, REPLY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
	, MEM_ID VARCHAR(50) REFERENCES BOARD_MEMBER (MEM_ID) -- 외래키
	, BOARD_NUM INT REFERENCES BOARD (BOARD_NUM) -- 외래키
);


-- 댓글 임시데이터

INSERT INTO board_reply (REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES('댓글1','java', 1);
INSERT INTO board_reply (REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES('댓글2','java', 2);
INSERT INTO board_reply (REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES('댓글3','java', 1);
INSERT INTO board_reply (REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES('댓글4','admin',1);
INSERT INTO board_reply (REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES('댓글5','admin',2);



SELECT * FROM board_member;
SELECT * FROM board;
SELECT * FROM board_reply;

-- 데이터 조회 연습

-- 회원의 이름이 '김자바'인 회원이 작성한 게시글의 글번호, 제목, 작성자 아이디, 이름을 조회, 작성일 기준 최신글부터 조회(내림차순)

SELECT BOARD_NUM, TITLE, B.MEM_ID, MEM_NAME
FROM board B, board_member M
WHERE B.MEM_ID = M.MEM_ID
AND MEM_NAME = '김자바'
ORDER BY CREATE_DATE DESC;


-- 모든 게시글의 글번호, 글제목, 작성자 및 해당 글에 작성된 댓글의 댓글내용, 댓글작성자, 댓글작성일을 조회
-- 게시글 번호 기준 최신순으로 정렬 후, 같은 게시글에 대한 댓글은 가장 최근에 달린 댓글 순으로 조회


SELECT A.BOARD_NUM, TITLE, A.MEM_ID, REPLY_CONTENT, C.MEM_ID, REPLY_DATE
FROM board A, board_reply C
WHERE A.BOARD_NUM = C.BOARD_NUM 
-- ORDER BY CREATE_DATE DESC < 이렇게도 됨!
ORDER BY BOARD_NUM DESC, REPLY_NUM DESC;



-- 아이디 중복 여부를 확인하는 쿼리

SELECT MEM_ID -- 애는 뭐라고 쓰든 중요하지않음! 조회가 되냐 안되냐~~~ 2개도 가능.
FROM board_member -- 회원의 아이디가 조회됨! 
WHERE MEM_ID = 'java123'; -- 동일한 아이디가 뜨면 가입이 안되게하는? 아이디 중복


SELECT MEM_ID
FROM board_member
WHERE MEM_ID = 'java'
AND MEM_PW = '1111';


SELECT * FROM board_member;
SELECT * FROM board_reply;

-- 댓글 확인 체크! 

SELECT REPLY_NUM
			, REPLY_CONTENT
			, MEM_ID
			, REPLY_DATE
FROM board_reply
WHERE BOARD_NUM = 1;


-- --------------------------------

SELECT * FROM board_member;
SELECT * FROM board;
SELECT * FROM board_reply;

-- 아이디가 'JAVA'인 회원이 작성한 게시글의 글제목, 내용, 작성자ID, 작성자의 권한을 조회

SELECT TITLE, CONTENT, B.MEM_ID, M.MEM_ID, MEM_NAME, MEM_ROLE
FROM board B, board_member M
WHERE B.MEM_ID = M.MEM_ID
AND M.MEM_ID = 'java';
-- ▲ B.MEM_ID랑 둘중에 상관없음! 


-- 글번호가 5번 이하인 게시글의 글번호, 제목, 글작성자명(이름)를 조회하되
-- 글번호 기준 오름차순으로 정렬하세요! 

SELECT BOARD_NUM, TITLE, MEM_NAME
FROM	board B, board_member M
WHERE B.MEM_ID = M.MEM_ID
AND BOARD_NUM <= 5
ORDER BY BOARD_NUM ASC;


-- 1번 게시글의 게시글 제목, 작성자 ID 및
-- 1번 게시글에 작성된 댓글내용,댓글,작성자 ID를 조회! 

SELECT TITLE, B.MEM_ID, REPLY_CONTENT, R.MEM_ID
FROM	board B, board_reply R
WHERE B.BOARD_NUM = R.BOARD_NUM
AND B.BOARD_NUM = 1;


--  1번 게시글의 게시글 제목, 작성자 ID 및
-- 1번 게시글에 작성된 댓글내용, 댓글 작성자Iid, 댓글 작성자 이름을 조회


SELECT TITLE, B.MEM_ID, REPLY_CONTENT, R.MEM_ID, MEM_NAME
FROM	board B, board_reply R, board_member m
WHERE B.BOARD_NUM = R.BOARD_NUM
AND B.MEM_ID = M.MEM_ID
AND B.BOARD_NUM = 1;


SELECT BOARD_NUM
        , TITLE
        , B.MEM_ID
        , MEM_ROLE
        , MEM_NAME
FROM BOARD B, BOARD_MEMBER M
WHERE B.MEM_ID = M.MEM_ID;


SELECT BOARD_NUM
	,TITLE
	,MEM_ID
	,CREATE_DATE
FROM board
WHERE ${searchType} LIKE CONCAT('%','#{searchValue}','%');

-- WHERE TITLE LIKE = '%#{title}%';
-- WHERE TITLE LIKE CONCAT('%','abc','%');
-- ▲ 문자열안에있으면 변수라고 인식못하기때문에 이렇게 넣어줘야함!

SELECT CONCAT('A','B','C','D');


 	SELECT BOARD_NUM
      , TITLE
      , MEM_ID
      , CREATE_DATE
	FROM board
	WHERE TITLE LIKE CONCAT %java%
	ORDER BY CREATE_DATE DESC;



INSERT INTO BOARD (
      TITLE
      , CONTENT
      , MEM_ID
 ) VALUES (
      '야호'
      ,'ㅎㅇ'
      ,'java'
 );
 
 
 SELECT BOARD_NUM
		 ,TITLE
		 ,MEM_ID
		 ,CREATE_DATE
 FROM board
 ORDER BY BOARD_NUM DESC
 LIMIT 5 OFFSET 5 * (1-1); -- 3칸뛰고 그 다음붙 3개를 가져온다...
 
 
 -- 테이블에 존재하는 데이터 갯수조회
 SELECT COUNT(BOARD_NUM)
 FROM board;
 
 
 
 
 
 