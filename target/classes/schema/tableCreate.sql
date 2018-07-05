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
drop table sms_tb;
drop table User_Info_TB;


create table USER_INFO_TB
(
      user_id         varchar(100)   primary key,
      password   varchar(100) NOT NULL,
      user_name   varchar(100) NOT NULL,
      email         varchar(100) NOT NULL,
      hp            varchar(100) NOT NULL,
      address      varchar(100) NOT NULL,
      regidate      timestamp NOT NULL,
      seller         char(1)
);

create table PARK_TB
(
      park_No            int          primary key auto_increment,
      user_Id            varchar(100)  NOT NULL ,
      park_Name         varchar(100)  NOT NULL,
      park_Addr         varchar(200)  NOT NULL,
      park_Size         varchar(100)   NOT NULL,
      park_Content       varchar(2000) NOT NULL,
      price            int          NOT NULL,
      constraint park_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
       
);

create table park_Regist_TB
(
      park_No         int     primary key,
      regi_Start      Timestamp NOT NULL,
      regi_End         Timestamp NOT NULL,
      constraint parkRegist_parkNo_fk foreign key(park_No) references park_tb(park_No) ON DELETE CASCADE
);

create table park_Reserve_TB
(
      reserve_No      int          primary key auto_increment,
      park_No          int          NOT NULL,
      user_Id         varchar(100)   NOT NULL,
      reserve_Start   Timestamp      NOT NULL,
      reserve_End      Timestamp        NOT NULL,
      car_Type         varchar(100)   NOT NULL,
      constraint parkReserve_parkNo_fk foreign key(park_No) references park_tb(park_No) ON DELETE CASCADE,
      constraint parkReserve_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);

create table review_TB
(
      user_Id         varchar(100),
      park_No         int         ,
      rating         int         NOT NULL,         
      review_Content   varchar(500)   NOT NULL,
      
      CONSTRAINT review_pk PRIMARY KEY (user_Id, park_No),
      CONSTRAINT review_parkNo_fk foreign key(park_No) references park_tb(park_No) ON DELETE CASCADE,
      CONSTRAINT review_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);

create table park_Image_TB
(
      img_No      int         primary key auto_increment,
      park_No      int        NOT NULL,
      img_Path      varchar(100) NOT NULL,
      CONSTRAINT parkImage_parkNo_fk foreign key(park_No) references park_tb(park_No) ON DELETE CASCADE
);


create table car_Type_TB
(      
      park_No   int ,
      car_Type varchar(100) ,
      max_Car  int not null,
      CONSTRAINT carType_pk PRIMARY KEY (park_No,car_Type),
       CONSTRAINT carType_parkNo_fk foreign key(park_No) references park_tb(park_No) ON DELETE CASCADE
);

create table seller_TB
(
      user_Id      varchar(100) primary key,
      account      varchar(200) NOT NULL,
      real_name   varchar(200) NOT NULL,
      CONSTRAINT seller_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);

create table authority_TB
(
      user_Id   varchar(100),
      role   varchar(100),
      keydata varchar(10),
      hp varchar(20),
      CONSTRAINT authority_pk PRIMARY KEY(user_Id),
      CONSTRAINT authority_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);

create table qna_TB
(
      qna_No      int primary key auto_increment,
      user_Id      varchar(100),
      QNA_Sub  varchar(200) NOT NULL,
      QNA_Content  varchar(2000) NOT NULL,
      QNA_DT TIMESTAMP NOT NULL,
      QNA_Review   varchar(2000),
      QNA_Review_DT timestamp,
      QNA_HIT      int NOT NULL,
      QNA_PWD      int,
      QNA_IMAGE varchar(100),
      CONSTRAINT qna_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);

create table faq_TB(
      faq_No   int   primary key auto_increment,
      faq_Sub varchar(200) not null,
      faq_Content varchar(2000) not null
);

create table terms_TB(
      terms_no   int primary key auto_increment,
      terms_Sub varchar(200) not null,
      terms_Content varchar(2000) not null
);

create table notice_TB(
      notice_No   int primary key auto_increment,
      notice_sub varchar(200) NOT NULL,
      notice_DT timestamp NOT NULL,
      notice_Content varchar(2000) NOT NULL,
      notice_Hit     int NOT NULL,
      notice_Image     varchar(100)
);

create table SMS_TB (
        user_id varchar(100) PRIMARY KEY,
        hp varchar(20) not null,
        keydata varchar(100) not null,
        CONSTRAINT SMS_userId_fk foreign key(user_Id) references user_info_tb(user_Id) ON DELETE CASCADE
);