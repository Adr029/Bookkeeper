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
public class AdminService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public AdminService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<User> displayUsers() {
        return userRepository.findAllUsers();
    }

    public void addUser(User user) {
        userRepository.addUser(user.getFirstName(), user.getLastName());
    }

    public void addBook(Book book) {
        bookRepository.addBook(book.getTitle(), book.getAuthor(), book.getGenre(), true);
    }

    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteBook(bookId);
    }

    public void editBook(int bookId, String title, String author, String genre) {
        bookRepository.editBook(title, author, genre, bookId);
    }


}
