package com.example.controllers;

import com.example.processors.BooksProcessor;
import com.example.services.LibraryService;
import com.example.services.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    private final LibraryService libraryService;
    private final BooksProcessor booksProcessor;
    private final UserLoginService userLoginService;
    private int userId;
    private String fullName;

    public LibraryController(LibraryService libraryService, BooksProcessor booksProcessor, UserLoginService userLoginService) {
        this.libraryService = libraryService;
        this.booksProcessor = booksProcessor;
        this.userLoginService = userLoginService;
    }

    @GetMapping("/login")
    public String displayHome() {
        return "login.html";
    }

    //* For simplicity, system assumes user may only borrow one book at a time
    @GetMapping("/books")
    public String displayBooks(
            Model model) {
        if (!isUserLoggedIn()) {
            return "redirect:/login";
        }

        userId = userLoginService.getUserId();
        fullName = userLoginService.getfullName();

        var books = libraryService.displayBooksPublic();
        var borrowedBook = libraryService.displayBorrowedBook(userLoginService.getfullName());
        model.addAttribute("books", books);
        model.addAttribute("borrowedBook", borrowedBook);
        return "books.html";

    }

    @PatchMapping("/books/borrow")
    public String borrowBook(
            @RequestParam int bookId
    ) {
        if (!isUserLoggedIn()) {
            return "redirect:/login";
        }

        booksProcessor.setBookId(bookId);
        if (booksProcessor.isBookAvailable() && booksProcessor.isUserAvailable()) {
            libraryService.borrowBook(fullName, bookId, userId);
        }
        return "redirect:/books";

    }

    @PatchMapping("/books/return")
    public String returnBook(
            @RequestParam int bookId
    ) {
        libraryService.returnBook(userId, bookId);
        return "redirect:/books";
    }

    private boolean isUserLoggedIn() {
        return userLoginService.loggedInCheck();
    }

}
