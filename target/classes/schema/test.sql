select * from park_reserve_tb


select reserveno,parkname,reservestart,reserveend,r.userid,price*(reserveend-reservestart)*24 price from park p join parkreserve r using(parkno) 
where p.userid=0 and reserve_end<sysdate

select user_info_tb.user_id,img_path,park_name,hp,price*EXTRACT(hour from reserve_end-reserve_start) as price
from park_Reserve_TB  left outer join (select* from park_image_tb where rownum<2)  using(park_no) 
join park_tb pt using(park_no) 
join user_info_tb on pt.user_id =user_info_tb.user_id


select EXTRACT(hour from reserve_end-reserve_start) from park_Reserve_TB;
create view sellerinfo as select * from user_info_tb join park_tb  using(user_id);

select * from user_info_tb join park_tb  using(user_id);