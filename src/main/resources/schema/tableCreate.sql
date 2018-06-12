drop table notice;
drop table terms;
drop table faq;
drop table review;
drop table parkImage;
drop table carType;
drop table authority;
drop table seller;
drop table qna;
drop table parkReserve;
drop table parkRegist;
drop table Park;
drop table UserInfo;

select reserveno,parkname,reservestart,reserveend,r.userid,price*(reserveend-reservestart)*24 price from park p join parkreserve r using(parkno) 
where p.userid=0 and reserveend<sysdate

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

insert into userinfo values('KimD','1234','김돈황','mpbs215@naver.com','010-9324-9482','서울 은평구 불광동',sysdate,0);
insert into userinfo values('KimM','1234','김민성','KimM@daum.com','010-9324-9482','대구 수성구',sysdate,0);
insert into userinfo values('LeeJ','2345','이재문','LeeJaeDoor@naver.com','010-9324-9482','청주',sysdate,1);
insert into userinfo values('JeeM','1234','지문경','moonkyong@naver.com','010-9324-9482','수원',sysdate,0);
insert into userinfo values('KonE','3456','공은비','silverRain@naver.com','010-9324-9482','북한',sysdate,0);

create table PARK_TB
(
		park_No				number 		   primary key,
		user_Id   			varchar2(100)  NOT NULL constraint park_userId_fk references userinfo(userId),
		park_Name			varchar2(100)  NOT NULL,
		park_Addr			varchar2(200)  NOT NULL,
		park_Size			long 		   NOT NULL,
		park_Content 		varchar2(2000) NOT NULL,
		price				number 		   NOT NULL,
		latitude			varchar2(100)  NOT NULL,
		longitude			varchar2(100)  NOT NULL
);

insert into park values
(park_seq.nextval,'재문주차장1호','LeeJ','성남시 분당구 정자동 178-1',
'500.5','멋있는주차장',2000,5,'37.3594835','127.10520759999997')

insert into park values
(park_seq.nextval,'재문주차장2호','LeeJ','은평구 불광동 243-13번지 201',
'50','부실한주차장',500,3,'37.6143768','126.93204160000005')

insert into park values
(park_seq.nextval,'재문주차장3호','LeeJ','서울특별시 종로구 송월길 48 서울특별시교육청',
'5000','서울특별시교육청주차장',50000,10,'37.5701647','126.96724840000002')



create table park_Regist_TB
(
		park_No			number	  primary key constraint regist_parkno_fk references park(parkNo),
		regi_Start		Timestamp NOT NULL,
		regi_End			Timestamp NOT NULL
);

create table park_Reserve_TB
(
		reserve_No		number 			primary key,
		park_No 			number 			NOT NULL constraint reserve_parkno_fk 	references parkRegist(parkNo),
		user_Id			varchar2(100)	NOT NULL constraint reserve_userId_fk references userinfo(userId),
		reserve_Start	Timestamp		NOT NULL,
		reserve_End		Timestamp  		NOT NULL,
		car_Type			varchar2(100)	NOT NULL
);

create table review_TB
(
		user_Id			varchar2(100)	constraint	review_userId_fk references userinfo(userId),
		park_No			number		 	constraint	review_parkno_fk references parkRegist(parkno),
		rating			number			NOT NULL,			
		review_Content	varchar2(500)	NOT NULL,
		
		CONSTRAINT review_pk PRIMARY KEY (userId, parkNo)
);

create table park_Image_TB
(
		img_No		number 		  primary key,
		park_No		number		  NOT NULL constraint	img_parkno_fk	references parkRegist(parkNo),
		img_Path		varchar2(100) NOT NULL
);

create table car_Type_TB
(		
		park_No	number			constraint	carType_parkno_fk	references parkRegist(parkNo),
		car_Type varchar2(100) ,
		max_Car  number not null,
		CONSTRAINT carType_pk PRIMARY KEY (parkNo,carType)
);

create table seller_TB
(
		user_Id		varchar2(100) primary key constraint	seller_userId_fk references userinfo(userId),
		account		varchar2(200) NOT NULL,
		real_name	varchar2(200) NOT NULL
);

create table authority_TB
(
		user_Id	varchar2(100) constraint authority_userId_fk references userinfo(userId),
		role	varchar2(100),
		CONSTRAINT authority_pk PRIMARY KEY (userId,role)
);

create table qna_TB
(
		qna_No		number primary key,
		user_Id		varchar2(100) constraint qna_userId_fk references userinfo(userId),
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



commit