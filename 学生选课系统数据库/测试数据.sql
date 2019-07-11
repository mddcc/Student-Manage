
select * from t_manager;
insert into t_manager(sysaccount,syspassword) values('admin1','admin1');

select * from t_department;
insert into t_department(depname) values('计算机系');
insert into t_department(depname) values('商学系');
insert into t_department(depname) values('文学系');

select * from t_class;
insert into t_class(classname) values('12级计服1班');
insert into t_class(classname) values('12级计服2班');
insert into t_class(classname) values('12级计服3班');
insert into t_class(classname) values('12级商学1班');
insert into t_class(classname) values('12级商学2班');

select * from t_teacher;
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','王老师',1,38,'讲师',1);
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','张老师',0,40,'副教授',2);
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','刘老师',1,45,'教授',3);

select * from t_course;
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('软件开发',3,'周二78节','3教2003',1,50,0);
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('网络营销',2,'周三78节','4教2004',2,80,0);
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('唐宋八大家',2,'周五78节','5教4008',3,100,0);


select * from t_student;
insert into t_student values(12831101,'000000','安仕林',1,20,1,1);

insert into t_student values(12831201,'000000','陈洁',0,20,2,1);

insert into t_student values(12831301,'000000','步雯雯',0,20,3,1);