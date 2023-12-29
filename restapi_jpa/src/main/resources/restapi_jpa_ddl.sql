CREATE DATABASE RESTAPI_JPA2;
USE RESTAPI_JPA2;

CREATE TABLE PRODUCT (
	PRODUCT_ID INT PRIMARY KEY, 
	PRODUCT_NM VARCHAR(255),
	PRICE INT, 
	DELIVERY_PRICE INT, 
	ENROLL_DT TIMESTAMP, 
	BRAND_ID VARCHAR(255)
);

CREATE TABLE BRAND (
	BRAND_ID VARCHAR(255) PRIMARY KEY, 
	BRAND_NM VARCHAR(255),
	ACTIVE_YN VARCHAR(255),
	ENTERED_DT TIMESTAMP
);

INSERT INTO
	PRODUCT 
VALUES
	(1 , '삼성전자 2021 노트북 플러스2 15.6' , 598000 , 0 , '2021-01-07' , 'b1'), 
	(2 , '삼성전자 2021 갤럭시북 15.6' , 1208000 , 0 , '2021-02-28' , 'b1'),
	(3 , 'LG전자 10세대 코어i7 윈10탑재 17형 LG 그램 2020년형 17Z90N' , 2149000 , 0 , '2021-03-07' , 'b2'),
	(4 , 'LG전자 2021그램 360 14' , 1740000 , 0 , '2021-07-08' , 'b2'),
	(5 , 'LG전자 2020 울트라 PC 14' , 477000 , 0 , '2021-10-10' , 'b2'),
	(6 , '2020 맥북 프로 13' , 2129650 , 3000 , '2022-01-01' , 'b3'),
	(7 , 'Apple 2020 맥북 에어 13' , 1489800 , 3000 , '2022-03-03' , 'b3'),
	(8 , '레노버 2021 IdeaPad Slim3 15.6' , 2129650 , 2500 , '2022-07-07' , 'b4'),
	(9 , '기가바이트 2021 Gaming G5 15.6' , 1499000 , 2500 , '2022-11-11' , 'b5'),
	(10 , 'HP 2021 노트북 15s' , 768840 , 2500 , '2022-12-31' , 'b6');

INSERT INTO
	BRAND 
VALUES
	('b1' , 'samsung' , 'Y' , '2021-01-01' ), 
	('b2' , 'lg' , 'Y' , '2021-02-01' ), 
	('b3' , 'apple' , 'Y' , '2021-03-01'), 
	('b4' , 'lenovo' , 'N' , '2021-04-01'), 
	('b5' , 'gigabyte' , 'N' , '2021-05-01' ), 
	('b6' , 'hp' , 'N' , '2021-06-01' ); 
