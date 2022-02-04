CREATE TABLE purchase_book (
	purchase_id INT NOT NULL,
	book_id INT NOT NULL,
	CONSTRAINT purchase_book_PK PRIMARY KEY (purchase_id,book_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;