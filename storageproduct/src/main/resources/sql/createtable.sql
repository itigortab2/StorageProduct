CREATE TABLE `storageproduct`.`category` (
	idCat int NOT NULL auto_increment,
	title varchar(100),
	description varchar(800),
    primary key(idCat)
) CHARACTER SET utf8;


CREATE TABLE `storageproduct`.`product` (
	idProduct int NOT NULL auto_increment,
	title varchar(100),
	description varchar(800),
	price double,
	img varchar(255),
	number int,
	cat int,
    primary key(idProduct)
) CHARACTER SET utf8;
