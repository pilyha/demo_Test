delete from k_pac_set where k_pac_set.id IS NOT NULL;

insert into k_pac_set(id,title) values(1,'first k_pac_set');
insert into k_pac_set(id,title) values(2,'second k_pac_set');
insert into k_pac_set(id,title) values(3,'third k_pac_set');

delete from k_pac where k_pac.id IS NOT NULL;

insert into k_pac(id,title,description,created_at,k_pac_set_id) values(1,'first k_pac','About medicine','26-09-2021',1);
insert into k_pac(id,title,description,created_at,k_pac_set_id) values(2,'second k_pac','About math','25-09-2021',1);
insert into k_pac(id,title,description,created_at,k_pac_set_id) values(3,'third k_pac','About cooking','24-09-2021',2);
insert into k_pac(id,title,description,created_at,k_pac_set_id) values(4,'fourth k_pac','About physics','27-09-2021',2);
insert into k_pac(id,title,description,created_at,k_pac_set_id) values(5,'fifth k_pac','About IT','23-09-2021',3);




