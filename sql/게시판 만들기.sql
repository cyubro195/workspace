

-- 테이블 삭제하는 쿼리만들기( 데이터 삭제와 구분 꼮 하기!!!!! )

DROP TABLE basic_board; -- 테이블 삭제, !!!!!!애는 ROLLBACK 절대 안됨!!!반드시 조심하셈!!!!!
-- DELETE FROM basic_board; 데이터 삭제임...!!!


-- 게시판 프로그램 테이블 생성

CREATE TABLE BASIC_BOARD( -- 테이블생성
		
	-- 컬럼명 데이터타입 [제약조건들] / 기본키을 만들때는 중복되면 안됨.
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY -- 키본키도 제약조건(?)/프라이퀴 넣으면 기본키로 후루룩만듬. 암튼 그럼..심지어 중요하대;;
	-- AUTO_INCREMENT : 자동증가 -> 애를 넣어주면 알아서 +1씩 증가하게 해줌! 
	, TITLE VARCHAR(50) NOT NULL -- 최대 50글자가 들어갈수있게 만들어주는거! 그뒤로는 오류 영어+한글 전부 다!
	-- NOT NULL : NULL로 데이터가 못들어온다. 즉 필수입력사항. 제목은 무조건 넣어라! 
	, WRITER VARCHAR(50) NOT NULL -- NOT NULL UNIQUE 중복 가능! 
	, CONTENT VARCHAR(100) UNIQUE -- 널들어가도 상관없음! 내용이 필수입력사항이 아닌거! / UNIQUE : 중복불가
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP -- DATETIME : 날짜와 시,분,초까지 나오는거 
										-- CURRENT_TIMESTAMP  : 자동으로 오늘 날짜 나옴 근데 뒤에 () 이거 생기면 지워주셈!
	, READ_CNT INT DEFAULT 0 -- 게시글에 조회수를 정리하는거(+1씩 증가)
		
);


SELECT * FROM basic_board;

INSERT INTO basic_board (TITLE, WRITER, CONTENT)
VALUES('1','1','1'); 

INSERT INTO basic_board ( BOARD_NUM, TITLE, WRITER )
VALUES(1,'제목', '글쓴이');



INSERT INTO basic_board(BOARD_NUM, TITLE, WRITER, CONTENT, CREATE_DATE, READ_CNT)
VALUES (1, 'ZAA', '작성자1', '내용1', '2024-07-01', 5); 

INSERT INTO basic_board(BOARD_NUM, TITLE, WRITER, CONTENT, CREATE_DATE)
VALUES (5, 'EEEEEE', '작성자121', '내용121', '2024-07-01'); -- 날짜영역에 문자열도 들어갈수있음~근데 NO추천~><

INSERT INTO basic_board(BOARD_NUM, TITLE, WRITER, CONTENT,CREATE_DATE,READ_CNT)
VALUES (4, '1234', '작성자3', NULL, '2024-07-01', 3);


SELECT BOARD_NUM
	,TITLE
	,WRITER
	,CREATE_DATE
	,READ_CNT
	
FROM basic_board
WHERE #{searchKeyword} LAKE %안녕%';
WHERE WRITER LIKE '%JAVA%';

















