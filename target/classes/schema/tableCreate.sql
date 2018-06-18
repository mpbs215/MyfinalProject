drop table notice_TB;
drop table terms_TB;
drop table faq_TB;
drop table review_TB;
drop table park_Image_TB;
drop table car_Type_TB;
drop table authority_TB;
drop table seller_TB;
drop table qna_TB;
drop table park_Reserve_TB;
drop table park_Regist_TB;
drop table Park_TB;
drop table User_Info_TB;

insert into user_info_tb values('seller','2656','김돈황','daum','010','서울',sysdate,0);
insert into user_info_tb values('customer','2656','김돈희','naver','010','서울',sysdate,0);
insert into park_tb values(park_seq.nextval,'seller','돈황주차장','은평구 불광동',5000,'도난도난김도난주차자장',2000,10,10);
insert into park_regist_tb values(1,'2018-06-16','2018-06-17');
insert into park_Reserve_TB values(reserve_seq.nextval,1,'customer','2018-06-16 05:00','2018-06-16 12:00','소형');
insert into park_Reserve_TB values(reserve_seq.nextval,1,'customer','2018-06-16 21:00','2018-06-16 23:00','중형');
insert into park_Reserve_TB values(reserve_seq.nextval,1,'customer','2018-06-16 19:00','2018-06-17 01:00','중형');
insert into review_TB values('customer',1,5,'리뷰리뷰한내용');
insert into car_type_tb values(1,'소형',2);
insert into car_type_tb values(1,'중형',2);
insert into park_Image_TB values(img_seq.nextval,1,'https://s-i.huffpost.com/gen/4127522/thumbs/o-THE-570.jpg?7');
insert into park_Image_TB values(img_seq.nextval,1,'https://blog.fotolia.com/kr/files/2017/02/Fotolia_110632460_S_copyright-1.jpg');

commit

select reserveno,parkname,reservestart,reserveend,r.userid,price*(reserveend-reservestart)*24 price from park p join parkreserve r using(parkno) 
where p.userid=0 and reserve_end<sysdate

select user_info_tb.user_id,img_path,park_name,hp,price*EXTRACT(hour from reserve_end-reserve_start) as price
from park_Reserve_TB  left outer join (select* from park_image_tb where rownum<2)  using(park_no) 
join park_tb pt using(park_no) 
join user_info_tb on pt.user_id =user_info_tb.user_id


select EXTRACT(hour from reserve_end-reserve_start) from park_Reserve_TB;
create view sellerinfo as select * from user_info_tb join park_tb  using(user_id)

select * from user_info_tb join park_tb  using(user_id)

create table USER_INFO_TB
(
		USER_ID			varchar2(100)	primary key,
		password	varchar2(100) NOT NULL,
		USER_NAME   varchar2(100) NOT NULL,
		email			varchar2(100) NOT NULL,
		hp				varchar2(100) NOT NULL,
		address		varchar2(100) NOT NULL,
		regidate		timestamp NOT NULL,
		seller			char(1)
);

create table PARK_TB
(
		park_No				number 		   primary key,
		user_Id   			varchar2(100)  NOT NULL constraint park_userId_fk references user_info_tb(user_Id),
		park_Name			varchar2(100)  NOT NULL,
		park_Addr			varchar2(200)  NOT NULL,
		park_Size			long 		   NOT NULL,
		park_Content 		varchar2(2000) NOT NULL,
		price				number 		   NOT NULL,
		latitude			varchar2(100)  NOT NULL,
		longitude			varchar2(100)  NOT NULL
);

create table park_Regist_TB
(
		park_No			number	  primary key constraint regist_parkno_fk references park_tb(park_No),
		regi_Start		Timestamp NOT NULL,
		regi_End			Timestamp NOT NULL
);

create table park_Reserve_TB
(
		reserve_No		number 			primary key,
		park_No 			number 			NOT NULL constraint reserve_parkno_fk 	references park_Regist_tb(park_No),
		user_Id			varchar2(100)	NOT NULL constraint reserve_userId_fk references user_info_tb(user_Id),
		reserve_Start	Timestamp		NOT NULL,
		reserve_End		Timestamp  		NOT NULL,
		car_Type			varchar2(100)	NOT NULL
);

create table review_TB
(
		user_Id			varchar2(100)	constraint	review_userId_fk references user_info_tb(user_Id),
		park_No			number		 	constraint	review_parkno_fk references park_Regist_tb(park_no),
		rating			number			NOT NULL,			
		review_Content	varchar2(500)	NOT NULL,
		
		CONSTRAINT review_pk PRIMARY KEY (user_Id, park_No)
);

create table park_Image_TB
(
		img_No		number 		  primary key,
		park_No		number		  NOT NULL constraint	img_parkno_fk	references park_Regist_tb(park_No),
		img_Path		varchar2(100) NOT NULL
);

create table car_Type_TB
(		
		park_No	number			constraint	carType_parkno_fk	references park_Regist_tb(park_No),
		car_Type varchar2(100) ,
		max_Car  number not null,
		CONSTRAINT carType_pk PRIMARY KEY (park_No,car_Type)
);

create table seller_TB
(
		user_Id		varchar2(100) primary key constraint	seller_userId_fk references user_info_tb(user_Id),
		account		varchar2(200) NOT NULL,
		real_name	varchar2(200) NOT NULL
);

create table authority_TB
(
		user_Id	varchar2(100) constraint authority_userId_fk references user_info_tb(user_Id),
		role	varchar2(100),
		CONSTRAINT authority_pk PRIMARY KEY (user_Id,role)
);

create table qna_TB
(
		qna_No		number primary key,
		user_Id		varchar2(100) constraint qna_userId_fk references user_info_tb(user_Id),
		QNA_Sub  varchar2(200) NOT NULL,
		QNA_Content  varchar2(2000) NOT NULL,
		QNA_DT TIMESTAMP NOT NULL,
		QNA_Review	varchar2(2000),
		QNA_Review_DT timestamp,
		QNA_HIT		number NOT NULL,
		QNA_PWD		number,
		QNA_IMAGE varchar2(100)
);

create table faq_TB(
		faq_No	number	primary key,
		faq_Sub varchar2(200) not null,
		faq_Content varchar2(2000) not null
);

create table terms_TB(
		terms_no	number primary key,
		terms_Sub varchar2(200) not null,
		terms_Content varchar2(2000) not null
);


create table notice_TB(
		notice_No	number primary key,
		notice_sub varchar2(200) NOT NULL,
		notice_DT timestamp NOT NULL,
		notice_Content varchar2(2000) NOT NULL,
		notice_Hit	  number NOT NULL,
		notice_Image	  varchar2(100)
);

select * from user_info_tb;

select * from authority_tb;

commit