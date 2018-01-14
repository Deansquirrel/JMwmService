IF OBJECT_ID ('xtempinfo') IS NOT NULL
	DROP TABLE xtempinfo
GO

CREATE TABLE xtempinfo
	(
	FUserId			INT DEFAULT(0) NOT NULL,
	FUserName	NVARCHAR (40) DEFAULT ('') NOT NULL,
	Faddtime    DATETIME NOT NULL,
	Flastupdate DATETIME NOT NULL,
	Fdelete     TINYINT DEFAULT ((0)) NOT NULL,
	)
	
ALTER TABLE xtempinfo ADD PRIMARY KEY ( FUserId )

--初始化用户名：admin
--insert into xtempinfo
--select -1,'admin',getdate(),getdate(),0

insert into xtempinfo
select 1,'yuansong',getdate(),getdate(),0

insert into xtempinfo
select 2,'gxnbbz',getdate(),getdate(),0