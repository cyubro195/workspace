

-- 쇼핑몰 프로젝트 테이블 정의

-- [테이블 종류]

-- 1. 회원정보 테이블
-- 2. 상품 카테고리 테이블
-- 3. 상품 정보 테이블
-- 4. 상품 이미지 정보 테이블 
-- 5. 장바구니 테이블 
-- 6. 구매정보테이블








-- ------- 01. [회원정보 테이블]
-- 권한 : USER, ADMIN

CREATE TABLE SHOP_MEMBER(

	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(100) NOT NULL
	, MEM_NAME VARCHAR(50) NOT NULL
	, MEM_TEL VARCHAR(30) UNIQUE
	, POST VARCHAR(10)
	, MEM_ADDR VARCHAR(50)
	, ADDR_DETAIL VARCHAR(50)
	, MEM_EMAIL VARCHAR(100)
	, MEM_ROLE VARCHAR(30) DEFAULT 'USER'
			
	
);

SELECT * FROM shop_member;

UPDATE shop_member
SET
MEM_ROLE = 'ADMIN'
WHERE MEM_ID = 'qwer';

-- ------- 02. [상품 카테고리 테이블] (소설,에세이,인터넷 등등등..)

CREATE TABLE ITEM_CATEGORY(
	CATE_CODE INT AUTO_INCREMENT PRIMARY KEY
	, CATE_NAME VARCHAR(50) NOT NULL UNIQUE

);

-- 카테고리 데이터
INSERT INTO item_category VALUES (1,'인터넷/IT');
INSERT INTO item_category VALUES (2,'소설/에세이');
INSERT INTO item_category VALUES (3,'자기계발');


SELECT * FROM item_category;

INSERT INTO BOARD (
      TITLE
      , CONTENT
      , MEM_ID
 ) VALUES (
      '야호'
      ,'ㅎㅇ'
      ,'java'
 );
 

INSERT INTO shop_item (
	CATE_CODE
	, ITEM_NAME
	, ITEM_PRICE
	, ITEM_INTRO

) VALUES(
	2
	,'당신은 누군가를 죽였다'
	,18000
	,'【2023년 일본 베스트 미스터리 1위】
히가시노 게이고가 재현한 황금시대 본격 미스터리'
);


SELECT ITEM.ITEM_CODE
	, ITEM_NAME
	, ITEM_PRICE
	, ATTACHED_FILE_NAME
FROM shop_item ITEM, item_img IMG
WHERE ITEM.ITEM_CODE =  IMG.ITEM_CODE
AND IS_MAIN = 'Y'
ORDER BY ITEM_CODE DESC;

SELECT * FROM shop_item;

DELETE FROM SHOP_ITEM;

-- ------- 03. [상품 정보 테이블]
-- ITEM_STATUS(제품상태) : (FOR_SALE) 판매중 , SOLD_OUT (매진)
-- 'ON DELETE CASCADE'-> 카테고리 삭제하면 전체삭제 되는 위험한 아이.

CREATE TABLE SHOP_ITEM(

	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_NAME VARCHAR(50) NOT NULL UNIQUE
	, ITEM_PRICE INT NOT NULL
	, ITEM_INTRO VARCHAR(100)
	, ITEM_STOCK INT DEFAULT 20
	, ITEM_STATUS VARCHAR(10) DEFAULT 'FOR_SALE'
	, CATE_CODE INT NOT NULL REFERENCES ITEM_CATEGORY (CATE_CODE)
		
);



-- 상품이미지 정보 테이블
--  ORIGIN_FILE_NAME  : 원본 파일명
--  ATTACHED_FILE_NAME : 첨부된 파일명
--  ITEM_CODE INT NOT NULL REFERENCES shop_item(ITEM_CODE) ON DELETE CASCADE-- 외래키 넣음
-- IS_MAIN : 대표 이미지 여부

CREATE TABLE ITEM_IMG (
	IMG_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ORIGIN_FILE_NAME VARCHAR(100) NOT NULL 
	, ATTACHED_FILE_NAME VARCHAR(100) NOT NULL
	, IS_MAIN VARCHAR(5) NOT NULL
	, ITEM_CODE INT NOT NULL REFERENCES shop_item(ITEM_CODE) ON DELETE CASCADE
);

-- 장바구니 정보 테이블
CREATE TABLE SHOP_CART (
	CART_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_CODE INT NOT NULL REFERENCES shop_item (ITEM_CODE) -- 원하는 물건 장바구니에 넣을려면 '외래키' 줘야해용!
	, CART_CNT INT NOT NULL -- 장바구니 상품갯수	
	, MEM_ID VARCHAR(50) NOT NULL REFERENCES shop_member (MEM_ID) -- 회원의 아이디 + 외래키를 넣어줘야 장바구니가 각자 자기꺼로 나옴! 
	, CART_DATE DATETIME DEFAULT CURRENT_TIMESTAMP -- 장바구니에 상품 넣으면 시간 남기기
);

-- 장바구니 목록 조회 
SELECT * FROM shop_cart;

DELETE FROM shop_cart;

SELECT CART_CODE
		,ITEM_NAME
		,ITEM_PRICE
		,CART_CNT
		,ITEM_PRICE * CART_CNT
		,CART_DATE
		,ATTACHED_FILE_NAME
FROM shop_cart CART, shop_item ITEM, item_img IMG
WHERE CART.ITEM_CODE = ITEM.ITEM_CODE
AND CART.ITEM_CODE = IMG.ITEM_CODE
AND MEM_ID = 'tttt'
AND IS_MAIN = 'Y';


INSERT INTO ITEM_IMG(ORIGIN_FILE_NAME, ATTACHED_FILE_NAME, IS_MAIN, ITEM_CODE)
VALUES ('abc.jpg', 'aaa.jpg', 'Y' , 1),('BBBB.jpg', 'ffff.jpg', 'N' , 1); -- 빈값 다 채워줘야함...뭔
	-- 원본파일명, 첨부파일명, 아이템 코드

-- 데이터를 많이 넣을때 이렇게하세용
-- INSERT INTO [테이블명] () VALUES (),(),(),();


SELECT * FROM item_img;


																																				
SELECT ITEM.ITEM_CODE
	,ITEM_NAME
	,ITEM_PRICE
	,ITEM_INTRO
	,ATTACHED_FILE_NAME
	,IS_MAIN
FROM shop_item ITEM, item_img IMG
WHERE ITEM.ITEM_CODE = IMG.ITEM_CODE
AND ITEM.ITEM_CODE = 1;

SELECT * FROM item_img;



-- 내 장바구니에 현재 선택한 상품이 있는지 확인하는 쿼리

SELECT CART_CODE
FROM shop_cart
WHERE ITEM_CODE = 3
AND MEM_ID = 'tttt';

-- 내 장바구니 상품의 수량 및 날짜변경

UPDATE shop_cart
SET
	CART_CNT = CART_CNT + ?,
	CART_DATE = NOW()  -- 이친구한테는 따로 데이터 값 안줘두됨.
WHERE ITEM_CODE = ?
AND MEM_ID = ?; 



CREATE DATABASE PAYMENT_DB;
USE PAYMENT_DB;

CREATE TABLE orders (
	ID INT AUTO_INCREMENT PRIMARY KEY,
	ORDER_ID VARCHAR(255) NOT NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	CUSTOMER_NAME VARCHAR(255) NOT NULL,
	STATUS VARCHAR(50) NOT NULL
);































































