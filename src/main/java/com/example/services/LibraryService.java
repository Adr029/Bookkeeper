package com.example.services;

import com.example.model.Book;
import com.example.model.User;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public LibraryService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<Book> displayBooksAdmin() {
        return bookRepository.displayBooksAdmin();
    }


    //* Book id and borrower names omitted for public display
    public List<Book> displayBooksPublic() {
        return bookRepository.displayBooksPublic();
    }

    public Book findBookById(int id) {
        return bookRepository.findBookById(id);
    }

    public User findUserByName(String first_name, String last_name) {
        return userRepository.findUserByName(first_name, last_name);
    }

    public User findUserById(int userId) {
        return userRepository.findUserById(userId);
    }

    public Book displayBorrowedBook(String borrowerName) {
        return bookRepository.displayBorrowedBooks(borrowerName);
    }

    public void borrowBook(String userFullName, int bookId, int userId) {
        bookRepository.updateBookBorrowed(userFullName, bookId);
        userRepository.updateUserBorrowedBook(findBookById(bookId).getTitle(), userId);
    }

    public boolean checkBookAvailability(int id) {
        return bookRepository.isBookAvailable(id);
    }

    public void returnBook(int userId, int bookId) {
        bookRepository.updateBookReturned(bookId);
        userRepository.updateUserReturnedBook(userId);
    }


}
