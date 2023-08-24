create table if not exists employee (
    id int not null auto_increment primary key,
    name varchar(20),
    age int,
    email varchar(50)
);

alter table employee add column address varchar(100);