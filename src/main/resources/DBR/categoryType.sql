
IF OBJECT_ID ('categoryType') IS NOT NULL
	DROP TABLE categoryType
GO

CREATE TABLE categoryType
	(
	Fid   TINYINT NOT NULL,
	Fname NVARCHAR (20) NOT NULL,
	Ftype TINYINT NOT NULL,
	PRIMARY KEY (Fid)
	)

--Init Data
INSERT INTO categoryType select 0,'支出',1
INSERT INTO categoryType select 1,'收入',0