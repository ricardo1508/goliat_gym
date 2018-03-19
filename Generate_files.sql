drop database goliat_gym;
create schema goliat_gym;
use goliat_gym;

CREATE TABLE gym_information (
	id_g_info int(4) primary key auto_increment,
	g_month_cost float(10),
	g_backup_location varchar(1000)
);

INSERT INTO gym_information(g_month_cost) VALUES(180.00);

CREATE TABLE client (
	id_client int(4) primary key auto_increment, 
	c_name varchar(25) not null, 
    c_last_name varchar(25) not null, 
    c_second_last_name varchar(25) not null, 		
    c_age int(10),
    c_weight float(10),
	c_goal varchar(400),
	c_routine varchar(1500),
    c_starting_date datetime not null,
	c_next_payment_date datetime not null
);	

CREATE TABLE payment (
	id_payment int primary key auto_increment,
	id_client int(4),
	p_amount float,
	p_description varchar(500),
	p_date datetime,
	foreign key (id_client) references client(id_client)
);

CREATE TABLE client_visit(
	id_visit int primary key auto_increment,
	id_client int(4),
	cv_date datetime not null,
	foreign key (id_client) references client(id_client)
);

CREATE TABLE gym_admin_user (
	id_admin_user int primary key auto_increment,
	u_user_name varchar(20) not null,
	u_user_pass varchar(20) not null
);

INSERT INTO gym_admin_user(u_user_name,u_user_pass) VALUES("ivan","admin");
INSERT INTO gym_admin_user(u_user_name,u_user_pass) VALUES("admin","admin123");
INSERT INTO gym_admin_user(u_user_name,u_user_pass) VALUES("goliat","goli");