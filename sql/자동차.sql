

-- 자동차 정보 관리 테이블


CREATE TABLE car_info(
	CAR_NUM INT AUTO_INCREMENT PRIMARY KEY
	, CAR_NAME VARCHAR(50) NOT NULL 
	, CAR_PRICE INT NOT NULL 
	, CAR_BRAND VARCHAR(50) NOT NULL 
);

SELECT * FROM car_info;



-- 자동차 구매 관리 테이블

CREATE TABLE sales_info(

	SALES_NUM INT AUTO_INCREMENT PRIMARY KEY -- 판매번호
	, BUYER VARCHAR(50) NOT NULL -- 구매자
	, BUYER_TEL INT -- 구매자 연락처
	, COLOR VARCHAR(50) NOT NULL -- 자동차 색상
	, BUY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP -- 판매일
	, CAR_NUM INT NOT NULL REFERENCES car_info(CAR_NUM) -- 모델번호
);

SELECT * FROM sales_info;

team1