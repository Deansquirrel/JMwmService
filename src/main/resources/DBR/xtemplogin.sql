IF OBJECT_ID ('xtemplogin') IS NOT NULL
	DROP TABLE xtemplogin
GO

CREATE TABLE xtemplogin
	(
	FUserId		INT DEFAULT (0) NOT NULL,
	FLoginName  NVARCHAR (40) DEFAULT ('') NOT NULL,
	FUserPwd	NVARCHAR (40) DEFAULT ('') NOT NULL,
	Faddtime    DATETIME NOT NULL,
	Flastupdate DATETIME NOT NULL,
	Fdelete     TINYINT DEFAULT ((0)) NOT NULL,
	)
	
ALTER TABLE xtemplogin ADD PRIMARY KEY ( FUserId )
ALTER TABLE xtemplogin add constraint UQ_LoginName unique(FLoginName)

--初始化用户名：admin 密码：12345678
--insert into xtemplogin
--select -1,-1,'admin','25D55AD283AA400AF464C76D713C07AD',getdate(),getdate(),0

insert into xtemplogin
select 1,'yuansong','BEEBC8D004DD29ED659A856EE665C250',getdate(),getdate(),0

insert into xtemplogin
select 2,'gxnbbz','C60CFF441E0D97855C93E863951768B2',getdate(),getdate(),0
