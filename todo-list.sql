-- Postgres
create table task (task_id  serial not null, task_complete boolean, task_due_date timestamp, task_name varchar(255), task_repeated varchar(255), task_start_date timestamp, primary key (task_id))
-- MySQL
create table task (task_id integer not null auto_increment, task_complete bit, task_due_date datetime(6), task_name varchar(255), task_repeated varchar(255), task_start_date datetime(6), primary key (task_id)) engine=InnoDB
