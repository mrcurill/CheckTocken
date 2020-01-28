--liquibase formatted sql

--changeSet KAGAPOV:1
create table user (
    --id bigint primary key AUTO_INCREMENT,
    id IDENTITY NOT NULL PRIMARY KEY,
    login varchar(50),
    password varchar(50));
--rollback drop table user;

--changeSet KAGAPOV:2
insert into user (login, password) values ('admin','admin');
insert into user (login, password) values ('guest','guest');
--rollback delete from user where login in ('admin','guest');

create table user_components (
    user_id int,
    components varchar(50));

insert into user_components (user_id, components) VALUES (1, 'comp1');
insert into user_components (user_id, components) VALUES (1, 'comp2');
insert into user_components (user_id, components) VALUES (1, 'comp3');
insert into user_components (user_id, components) VALUES (1, 'comp4');
insert into user_components (user_id, components) VALUES (1, 'comp5');
insert into user_components (user_id, components) VALUES (2, 'comp1');
insert into user_components (user_id, components) VALUES (2, 'comp2');

create table user_roles (
    user_id int,
    roles varchar (50));

insert into user_roles (user_id, roles) values (1,'admin');
insert into user_roles (user_id, roles) values (2,'guest');



create table component (
    id IDENTITY NOT NULL PRIMARY KEY ,
    name varchar(50));

insert into component (name) values('comp1');
insert into component (name) values('comp2');
insert into component (name) values('comp3');
insert into component (name) values('comp4');
insert into component (name) values('comp5');

create table component_buttons (
    component_id int,
    buttons varchar(50));

insert into component_buttons (component_id, buttons) values (1,'button1');
insert into component_buttons (component_id, buttons) values (1,'button2');
insert into component_buttons (component_id, buttons) values (1,'button3');
insert into component_buttons (component_id, buttons) values (2,'button1');
insert into component_buttons (component_id, buttons) values (2,'button2');
insert into component_buttons (component_id, buttons) values (2,'button3');
insert into component_buttons (component_id, buttons) values (3,'button1');
insert into component_buttons (component_id, buttons) values (3,'button2');
insert into component_buttons (component_id, buttons) values (4,'button3');
insert into component_buttons (component_id, buttons) values (5,'button1');

create table component_inputs (
  component_id int,
  inputs varchar(50));

insert into component_inputs (component_id, inputs) values (1,'input1');
insert into component_inputs (component_id, inputs) values (1,'input2');
insert into component_inputs (component_id, inputs) values (1,'input3');
insert into component_inputs (component_id, inputs) values (2,'input1');
insert into component_inputs (component_id, inputs) values (2,'input2');
insert into component_inputs (component_id, inputs) values (2,'input3');
insert into component_inputs (component_id, inputs) values (3,'input1');
insert into component_inputs (component_id, inputs) values (4,'input2');
insert into component_inputs (component_id, inputs) values (5,'input3');
insert into component_inputs (component_id, inputs) values (5,'input1');

create table component_users (
    component_id int,
    users varchar (50));

insert into component_users (component_id, users) values (1,'admin');
insert into component_users (component_id, users) values (2,'admin');
insert into component_users (component_id, users) values (3,'admin');
insert into component_users (component_id, users) values (4,'admin');
insert into component_users (component_id, users) values (5,'admin');
insert into component_users (component_id, users) values (1,'guest');
insert into component_users (component_id, users) values (2,'guest');

create table component_roles (
    component_id int,
    roles varchar (50));

insert into component_roles (component_id, roles) values (1,'admin');
insert into component_roles (component_id, roles) values (2,'admin');
insert into component_roles (component_id, roles) values (3,'admin');
insert into component_roles (component_id, roles) values (4,'admin');
insert into component_roles (component_id, roles) values (5,'admin');
insert into component_roles (component_id, roles) values (1,'guest');
insert into component_roles (component_id, roles) values (2,'guest');