
select * from t_manager;
insert into t_manager(sysaccount,syspassword) values('admin1','admin1');

select * from t_department;
insert into t_department(depname) values('�����ϵ');
insert into t_department(depname) values('��ѧϵ');
insert into t_department(depname) values('��ѧϵ');

select * from t_class;
insert into t_class(classname) values('12���Ʒ�1��');
insert into t_class(classname) values('12���Ʒ�2��');
insert into t_class(classname) values('12���Ʒ�3��');
insert into t_class(classname) values('12����ѧ1��');
insert into t_class(classname) values('12����ѧ2��');

select * from t_teacher;
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','����ʦ',1,38,'��ʦ',1);
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','����ʦ',0,40,'������',2);
insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('66666','����ʦ',1,45,'����',3);

select * from t_course;
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('�������',3,'�ܶ�78��','3��2003',1,50,0);
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('����Ӫ��',2,'����78��','4��2004',2,80,0);
insert into t_course(coursename,credit,ctime,caddress,teacher,limitnumber,truenumber) values('���ΰ˴��',2,'����78��','5��4008',3,100,0);


select * from t_student;
insert into t_student values(12831101,'000000','������',1,20,1,1);

insert into t_student values(12831201,'000000','�½�',0,20,2,1);

insert into t_student values(12831301,'000000','������',0,20,3,1);