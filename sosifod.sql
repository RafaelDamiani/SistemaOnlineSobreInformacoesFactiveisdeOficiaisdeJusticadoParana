create table tb_user_type (
	id serial not null primary key,
	user_type_name varchar(18) not null unique
);

insert into tb_user_type (user_type_name) values 
('Admin'),
('Oficial de Justiça');

create table tb_user(
	id bigserial not null primary key,
	user_email varchar(255) not null unique,
	user_password varchar(255) not null,
	user_name varchar(255) not null,
	user_cpf varchar(11) not null unique,
	user_type_id integer not null REFERENCES tb_user_type(id)
);

create table tb_subpoena(
	id bigserial not null primary key,
	subpoena_date timestamp not null,
	subpoena_cpf varchar(11) not null,
	subpoena_name varchar(255) not null,
	subpoena_execution_date timestamp null,	
	subpoena_status bit not null,
	probation_officer bigint not null REFERENCES tb_user(id),
	subpoena_prosecution bigint not null
);

create table tb_address(
	id bigserial not null primary key,
	address_zip_code varchar(8) not null,
	address_street varchar(255) not null,
	address_number smallint not null,
	address_city varchar(255) not null,
	address_state varchar(2) not null,
	subpoena_id bigint not null REFERENCES tb_subpoena(id)
);