package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    //* SELECT queries
    @Query("SELECT * FROM books ORDER BY id ASC")
    List<Book> displayBooksAdmin();

    @Query("SELECT id, title, author, genre, availability FROM books ORDER BY id ASC")
    List<Book> displayBooksPublic();

    @Query("SELECT * FROM books WHERE id = :bookId")
    Book findBookById(int bookId);

    @Query("SELECT id, title, author, genre, availability FROM books WHERE borrower_name = :borrowerName")
    Book displayBorrowedBooks(String borrowerName);

    @Query("SELECT availability FROM books WHERE id = :bookId")
    Boolean isBookAvailable(int bookId);

    //* UPDATE queries
    @Modifying
    @Query("UPDATE books SET title = :title, author = :author, genre = :genre WHERE id = :bookId")
    void editBook(String title, String author, String genre, int bookId);

    @Modifying
    @Query("UPDATE books SET availability = 0, borrower_name = :borrower_name WHERE id = :bookId")
    void updateBookBorrowed(String borrower_name, int bookId);

    @Modifying
    @Query("UPDATE books SET availability = 1, borrower_name = NULL WHERE id = :bookId")
    void updateBookReturned(int bookId);

    //* INSERT and DELETE
    @Modifying
    @Query("DELETE FROM books WHERE id = :bookId")
    void deleteBook(int bookId);

    @Modifying
    @Query("INSERT INTO books VALUES(NULL, :title, :author, :genre, :availability, NULL )")
    void addBook(String title, String author, String genre, boolean availability);


}
