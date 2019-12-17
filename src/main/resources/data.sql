-- create table person
-- (
--     id integer not null,
--     name varchar(255) not null,
--     location varchar(255),
--     birth_date timestamp,
--     primary key(id)
-- );

insert into person (id, name, location, birth_date)
values (10001, 'Ranga', 'Hyderabad', sysdate());
insert into person (id, name, location, birth_date)
values (10002, 'James', 'New York', sysdate());
insert into person (id, name, location, birth_date)
values (10003, 'Pieter', 'Amsterdam', sysdate());


insert into course(id, name, created_date, last_updated_date)
values(10001, 'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
values(10002, 'Spring in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
values(10003, 'Spring Boot in 100 Steps', sysdate(), sysdate());