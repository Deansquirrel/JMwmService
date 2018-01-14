IF OBJECT_ID ('fixedList') IS NOT NULL
	DROP TABLE fixedList
GO

CREATE TABLE fixedList
	(
	Fid         INT DEFAULT (0) NOT NULL,
	Fname       NVARCHAR(20) NOT NULL,
	Ftype       INT DEFAULT (0) NOT NULL,
	)
GO

ALTER TABLE fixedList ADD PRIMARY KEY ( Fid, Ftype )