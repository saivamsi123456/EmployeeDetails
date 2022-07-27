# CreateEmployee
$ mysql -u root -p

Password: root

mysql> create database emp_database;

mysql> use emp_database;

mysql> create table employee (id integer not null auto_increment, name varchar(255), age integer, gender varchar(255), joining_date date, retiring_date date, dept varchar(255), primary key (id));


mysql> insert into employee (name, age, gender, joining_date, retiring_date, dept) values ('Jackson', 20, 'Male', '2019-01-22',  '2020-08-31','IT'),('Jennie', 30, 'Female', '2019-01-22',  '2020-07-31','Sales'),('Rose', 25, 'Female', '2019-01-22',  '2020-09-30','HR'),('Jungkook', 33, 'Male', '2019-01-22',  '2020-05-22','IT'),('RM', 40, 'Male', '2019-01-22',  '2020-06-23','IT'),('Jisoo', 28, 'Female', '2019-01-22',  '2020-09-15','Sales'),('Lisa', 24, 'Female', '2019-01-22',  '2020-10-31','HR'),('Jin', 29, 'Male', '2019-01-22',  '2020-11-09','IT'),('Suga', 38, 'Male', '2019-01-22',  '2020-08-31','IT'),('Jimin', 32, 'Male', '2019-01-22',  '2020-08-21','Sales'),('Jhope', 27, 'Male', '2019-01-22',  '2020-02-28','HR');

