

create database selectivedb;

use selectivedb;
create table t_department
(
	id int primary key AUTO_INCREMENT,
	depname varchar(50) not null
)
;

create table t_class
(
	id int primary key AUTO_INCREMENT,
	classname varchar(50) not null
)
;

create table t_teacher
(
	tid int primary key AUTO_INCREMENT,
	tpassword Varchar(50) not null,
	Tname Varchar(20) not null,
	Tsex Tinyint not null,
	Tage Int not null,
	Tjob Varchar(50) not null,
	tDepartment Int not null
)
;

create table t_course
(
	id int primary key AUTO_INCREMENT,
	coursename varchar(50) not null UNIQUE,
	Credit Int not null,
	cTime Varchar(50) not null,
	caddress Varchar(50) not null,
	Teacher int not null,
	Limitnumber Int not null,
	Truenumber Int  not null
)
;

create table t_student
(
	sid int primary key,
	spassword Varchar(50) not null,
	sname Varchar(20) not null,
	ssex Tinyint not null,
	sage Int not null,
	sclass Int not null,
	sDepartment Int not null
)
;

create table t_selectcourse
(
	id int primary key AUTO_INCREMENT,
	sid	int not null,
	cid	Int not null ,
	Score Int 
)
;

create table t_manager
(
	id int primary key AUTO_INCREMENT,
	sysaccount varchar(50) not null ,
	Syspassword	Varchar(50) not null
)
;

create table t_log
(
	id int primary key AUTO_INCREMENT,
	Loginaccount varchar(50) not null,
	Logintime Datetime not null
)
;



create view v_teacher
as
select tid,tpassword,tname,tsex,tage,tjob,depname
from t_teacher,t_department
where t_teacher.tdepartment = t_department.id
;


create view v_course
as
select id,coursename,credit,ctime,caddress,tname,limitnumber,truenumber
from t_course,t_teacher
where t_course.teacher = t_teacher.tid
;

create view v_student
as
select sid,spassword,sname,ssex,sage,classname,depname
from t_student,t_class,t_department
where t_student.sclass = t_class.id
and t_student.sdepartment = t_department.id
;

create view v_selectcourse
as
select t_selectcourse.id,t_selectcourse.sid,sname,cid,coursename,score
from t_selectcourse,t_student,t_course
where t_selectcourse.sid = t_student.sid
and t_selectcourse.cid = t_course.id
;