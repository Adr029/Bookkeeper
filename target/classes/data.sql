-- Insert data into the books table
INSERT IGNORE INTO books (id, title, author, genre, availability, borrower_name) VALUES
(1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', false, 'John Doe'),
(2, 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', true, NULL),
(3, 'Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', true, NULL),
(4, '1984', 'George Orwell', 'Dystopian', false, 'Jane Smith'),
(5, 'Harry Potter', 'J.K. Rowling', 'Fantasy', true, NULL),
(6, 'The Shining', 'Stephen King', 'Horror', false, 'Michael Black'),
(7, 'Pride and Prejudice', 'Jane Austen', 'Romance', true, NULL),
(8, 'The Hunger Games', 'Suzanne Collins', 'Dystopian', true, NULL),
(9, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', false, 'Mark Johnson'),
(10, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', false, 'Emily White');


INSERT IGNORE INTO users (id, first_name, last_name, borrowed_book) VALUES
(1, 'Michael', 'Black', 'The Shining'),
(2, 'Ivy', 'Moore', NULL),
(3, 'John', 'Doe', 'The Great Gatsby'),
(4, 'Jack', 'Clark', NULL),
(5, 'David', 'Miller', NULL),
(6, 'Frank', 'White', NULL),
(7, 'Emily', 'White', 'The Hobbit'),
(8, 'Mark', 'Johnson', 'The Catcher in the Rye'),
(9, 'Grace', 'Taylor', NULL),
(10, 'Jane', 'Smith', '1984');
