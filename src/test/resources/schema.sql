DROP TABLE IF EXISTS User;

CREATE TABLE User
(
    id int  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    age varchar(255),
    phone varchar(255),
    group_id varchar(255),
    date date
);