drop database goliat_gym;
create schema goliat_gym;
use goliat_gym;

CREATE TABLE client (
	id_client int(4) primary key auto_increment, 
	c_name varchar(25) not null, 
    c_last_name varchar(25) not null, 
    c_second_last_name varchar(25) not null, 		
    c_age int(10),
    c_weight float(10),
	c_goal varchar(400),
	c_routine varchar(1500),
    c_starting_date date not null
);
	
CREATE TABLE gym_information (
	id_g_info int(4) primary key auto_increment,
	g_month_cost float(10)
);

INSERT INTO gym_information(g_month_cost) VALUES(180.00);

CREATE TABLE payment (
	id_payment int primary key auto_increment,
	id_client int(4),
	p_amount float,
	p_description varchar(500),
	p_date date,
	foreign key (id_client) references client(id_client)
);

CREATE TABLE gym_admin_user (
	id_admin_user int primary key auto_increment,
	u_user_name varchar(20) not null,
	u_user_pass varchar(20) not null
);

INSERT INTO gym_admin_user(u_user_name,u_user_pass) VALUES("ivan","admin");