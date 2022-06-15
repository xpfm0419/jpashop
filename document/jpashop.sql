SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category_goods;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS order_goods;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS member_order;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS order_delivery;




/* Create Tables */

-- 앨범
CREATE TABLE album
(
	goods_idx int NOT NULL COMMENT '상품 고유번호',
	artist varchar(200) NOT NULL COMMENT '아티스트',
	PRIMARY KEY (goods_idx)
) COMMENT = '앨범';


-- 책
CREATE TABLE book
(
	goods_idx int NOT NULL COMMENT '상품 고유번호',
	author varchar(200) NOT NULL COMMENT '저자',
	PRIMARY KEY (goods_idx)
) COMMENT = '책';


-- 카테고리
CREATE TABLE category
(
	category_idx int NOT NULL AUTO_INCREMENT COMMENT '카테고리 고유번호',
	p_category_idx int NOT NULL COMMENT '부모 카테고리 고유번호',
	category_name varchar(200) NOT NULL COMMENT '카테고리 명',
	PRIMARY KEY (category_idx)
) COMMENT = '카테고리';


-- 카테고리 상품
CREATE TABLE category_goods
(
	category_idx int NOT NULL COMMENT '카테고리 고유번호',
	goods_idx int NOT NULL COMMENT '상품 고유번호',
	PRIMARY KEY (category_idx, goods_idx)
) COMMENT = '카테고리 상품';


-- 상품
CREATE TABLE goods
(
	goods_idx int NOT NULL AUTO_INCREMENT COMMENT '상품 고유번호',
	goods_name varchar(200) NOT NULL COMMENT '상품명',
	goods_price int DEFAULT 0 NOT NULL COMMENT '상품 가격',
	stock_cnt int DEFAULT 0 COMMENT '재고 수량',
	dtype varchar(20) NOT NULL COMMENT '구분타입',
	PRIMARY KEY (goods_idx)
) COMMENT = '상품';


-- 회원
CREATE TABLE member
(
	member_idx int NOT NULL AUTO_INCREMENT COMMENT '회원 고유번호',
	member_name varchar(200) NOT NULL COMMENT '회원 이름',
	address1 varchar(200) NOT NULL COMMENT '주소 1',
	address2 varchar(200) COMMENT '주소 2',
	zipcode varchar(10) NOT NULL COMMENT '우편번호',
	PRIMARY KEY (member_idx)
) COMMENT = '회원';


-- 회원 주문
CREATE TABLE member_order
(
	mo_idx int NOT NULL AUTO_INCREMENT COMMENT '회원 주문 고유번호',
	member_idx int NOT NULL COMMENT '회원 고유번호',
	od_idx int NOT NULL COMMENT '주문 배송 고유번호',
	order_date datetime NOT NULL COMMENT '주문일시',
	order_status varchar(10) NOT NULL COMMENT '주문 상태',
	PRIMARY KEY (mo_idx)
) COMMENT = '회원 주문';


-- 영화
CREATE TABLE movie
(
	goods_idx int NOT NULL COMMENT '상품 고유번호',
	actor varchar(200) NOT NULL COMMENT '배우',
	PRIMARY KEY (goods_idx)
) COMMENT = '영화';


-- 주문 배송
CREATE TABLE order_delivery
(
	od_idx int NOT NULL AUTO_INCREMENT COMMENT '주문 배송 고유번호',
	delivery_status varchar(10) NOT NULL COMMENT '배송 상태',
	address1 varchar(200) NOT NULL COMMENT '주소 1',
	address2 varchar(200) NOT NULL COMMENT '주소 2',
	zipcode varchar(10) NOT NULL COMMENT '우편번호',
	PRIMARY KEY (od_idx)
) COMMENT = '주문 배송';


-- 주문 상품
CREATE TABLE order_goods
(
	og_idx int NOT NULL AUTO_INCREMENT COMMENT '주문 상품 고유번호',
	mo_idx int NOT NULL COMMENT '회원 주문 고유번호',
	goods_idx int NOT NULL COMMENT '상품 고유번호',
	order_price int DEFAULT 0 NOT NULL COMMENT '주문 가격',
	order_cnt int DEFAULT 0 NOT NULL COMMENT '주문 수량',
	reg_dt datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '등록일시',
	upd_dt datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
	PRIMARY KEY (og_idx)
) COMMENT = '주문 상품';



/* Create Foreign Keys */

ALTER TABLE category
	ADD CONSTRAINT fk_category1 FOREIGN KEY (p_category_idx)
	REFERENCES category (category_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE category_goods
	ADD CONSTRAINT fk_cg_category1 FOREIGN KEY (category_idx)
	REFERENCES category (category_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE album
	ADD CONSTRAINT fk_album_goods1 FOREIGN KEY (goods_idx)
	REFERENCES goods (goods_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book
	ADD CONSTRAINT fk_book_goods1 FOREIGN KEY (goods_idx)
	REFERENCES goods (goods_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE category_goods
	ADD CONSTRAINT fk_cg_goods1 FOREIGN KEY (goods_idx)
	REFERENCES goods (goods_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE movie
	ADD CONSTRAINT fk_movie_goods1 FOREIGN KEY (goods_idx)
	REFERENCES goods (goods_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_goods
	ADD CONSTRAINT fk_og_goods1 FOREIGN KEY (goods_idx)
	REFERENCES goods (goods_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member_order
	ADD CONSTRAINT fk_mo_member1 FOREIGN KEY (member_idx)
	REFERENCES member (member_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_goods
	ADD CONSTRAINT fk_og_mo1 FOREIGN KEY (mo_idx)
	REFERENCES member_order (mo_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member_order
	ADD CONSTRAINT fk_mo_od1 FOREIGN KEY (od_idx)
	REFERENCES order_delivery (od_idx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



