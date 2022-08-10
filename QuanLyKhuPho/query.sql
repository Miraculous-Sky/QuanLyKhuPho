create table useritem (
	tentaikhoan varchar(30) primary key, 
	matkhau varchar(30) not null, 
	vaitro bit
);

create table hodan (
	mahodan char(4) primary key, 
	sothanhvien int, 
	sonha nvarchar(30), 
	makhupho char(4)
);

create table khupho (
	makhupho char(4) primary key, 
	tenkhupho nvarchar(30)
);

create table nguoi (
	manguoi char(4) primary key, 
	hovaten nvarchar(30), 
	tuoi int, 
	namsinh int, 
	nghenghiep nvarchar(30), 
	mahodan char(4)
);

insert into useritem values ('admin', 'admin', 1), ('user', 'user', 0);

insert into khupho values ('KP01', 'Khu phố 1'), ('KP02', 'Khu phố 2');

insert into hodan values ('HD01', 2, '1-Khu phố 1', 'KP01'), ('HD02', 1, '2-Khu phố 1', 'KP01'), ('HD03', 0, '3-Khu phố 1', 'KP01');

insert into nguoi values ('NG02', 'Nguyễn Thị Thanh Quỳnh', 20, 2000, 'Kỹ sư', 'HD01'), 
						('NG06', 'Nguyễn Thị Thúy Hiền', 17, 2003, 'Học sinh', 'HD01'), 
						('NG07', 'Nguyễn Hải Yến', 21, 1999, 'Kỹ sư', 'HD02');
