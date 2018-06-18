drop sequence park_seq;
drop sequence img_seq;
drop sequence faq_seq;
drop sequence terms_seq;
drop sequence notice_seq;
drop sequence reserve_seq;
drop sequence qna_seq;

create sequence park_seq 
start with 1
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence img_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence faq_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence terms_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence notice_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence reserve_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;

create sequence qna_seq 
start with 1 
increment BY 1 
maxvalue 10000 
nocache 
nocycle;
