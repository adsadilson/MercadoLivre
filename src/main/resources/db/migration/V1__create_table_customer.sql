CREATE TABLE customer (
  id int AUTO_INCREMENT PRIMARY KEY,
  email varchar(250) NOT NULL UNIQUE,
  name varchar(100) NOT NULL
);