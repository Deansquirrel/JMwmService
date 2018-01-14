CREATE TABLE bscategory
	(
	Fid         INT DEFAULT (0) NOT NULL,
	Fname       NVARCHAR(20) NOT NULL,
	Ftype       TINYINT  DEFAULT (0) NOT NULL,
	Fremark     NVARCHAR(40) NOT NULL,
	Faddtime    DATETIME NOT NULL,
	FlastUpdate DATETIME NOT NULL,
	Fstop       TINYINT  DEFAULT (0) NOT NULL
	)

ALTER TABLE bscategory ADD PRIMARY KEY ( Fid )
ALTER TABLE bscategory add constraint UQ_categoryName unique(Fname)