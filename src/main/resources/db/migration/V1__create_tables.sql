CREATE TABLE book (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  price decimal(19,2) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  customer_id int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_book_x_consumer (customer_id)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(250) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_email (email)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci