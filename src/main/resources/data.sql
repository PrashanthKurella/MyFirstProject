insert into Course(id,name,last_Updated_Date,created_Date) values(10001,'Anjular JS',current_date(),current_date());
//insert into Course(id,name) values(10002,'Java');
//insert into Course(id,name) values(10003,'HTML');
//insert into Course(id,name) values(10004,'Python');
//insert into Course(id,name) values(10006,'corejava');
insert into Course(id,name,last_Updated_Date,created_Date) values(10002,'Java ',current_date(),current_date());
insert into Course(id,name,last_Updated_Date,created_Date) values(10003,'HTML ',current_date(),current_date());
insert into Course(id,name,last_Updated_Date,created_Date) values(10004,'Python ',current_date(),current_date());
insert into Course(id,name,last_Updated_Date,created_Date) values(10005,'corejava ',current_date(),current_date());



insert into Passport(id,number) values(30001,'P122556');
insert into Passport(id,number) values(30002,'E125856');
insert into Passport(id,number) values(30003,'N125656');
insert into Passport(id,number) values(30004,'L123456');

/*need to insert passport table before student because we linked foreign key passport Id to student
*/
insert into Student(id,name,passport_id) values(20001,'Ramesh',30001);
insert into Student(id,name,passport_id) values(20002,'Suresh',30002);
insert into Student(id,name,passport_id) values(20003,'Namesh',30003);
insert into Student(id,name,passport_id) values(20004,'Naveen',30004);



insert into Review(id,description,rating,course_id) values(40001,'good',4,10002);
insert into Review(id,description,rating,course_id) values(40002,'awesome course',2,10001);
insert into Review(id,description,rating,course_id) values(40003,'excellent course ',5,10002);
insert into Review(id,description,rating,course_id) values(40004,'not bad',3,10004);



insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10003);




