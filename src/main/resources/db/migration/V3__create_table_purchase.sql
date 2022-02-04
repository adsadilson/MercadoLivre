CREATE TABLE purchase (
  id int NOT NULL AUTO_INCREMENT,
  customer_id int NOT NULL,
  nfe varchar(255) DEFAULT NULL,
  price decimal(12,2) NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
