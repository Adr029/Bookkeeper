package com.example.controllers;

import com.example.model.Book;
import com.example.processors.BooksProcessor;
import com.example.services.AdminLoginService;
import com.example.services.AdminService;
import com.example.services.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    private final AdminService adminService;
    private final LibraryService libraryService;

    private final AdminLoginService adminLoginService;
    private final BooksProcessor booksProcessor;

    public AdminController(AdminService adminService, LibraryService libraryService, AdminLoginService adminLoginService, BooksProcessor booksProcessor) {
        this.adminService = adminService;
        this.libraryService = libraryService;
        this.adminLoginService = adminLoginService;
        this.booksProcessor = booksProcessor;
    }

    @GetMapping("/admin")
    public String displayUsers(
            Model model) {
        if (!isAdminLoggedIn()) {
            return "redirect:/login";
        }

        var users = adminService.displayUsers();
        var books = libraryService.displayBooksAdmin();
        model.addAttribute("users", users);
        model.addAttribute("books", books);
        return "admin.html";

    }

    @PostMapping("/admin/addbook")
    public String addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String genre,
            Model model
    ) {
        if (!isAdminLoggedIn()) {
            return "redirect:/login";
        }

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        adminService.addBook(book);
        return "redirect:/admin";

    }

    @GetMapping("/admin/editbook")
    public String getEditPage(
            @RequestParam int bookId,
            Model model
    ) {
        if (!isAdminLoggedIn()) {
            return "redirect:/login";
        }

        if (!isBookAvailable(bookId)) {
            return "redirect:/admin";
        }
        Book book = libraryService.findBookById(bookId);
        model.addAttribute("title", book.getTitle());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("genre", book.getGenre());
        model.addAttribute("bookId", bookId);

        return "edit_book.html";
    }

    @PatchMapping("/admin/editbook")
    public String editBook(
            @RequestParam int bookId,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String genre

    ) {
        adminService.editBook(bookId, title, author, genre);
        return "redirect:/admin";
    }


    @DeleteMapping("/admin/deletebook")
    public String deleteBook(
            @RequestParam int bookId
    ) {
        if (!isAdminLoggedIn()) {
            return "redirect:/login";
        }
        if (isBookAvailable(bookId)) {
            adminService.deleteBook(bookId);
        }
        return "redirect:/admin";
    }


    private boolean isBookAvailable(int bookId) {
        booksProcessor.setBookId(bookId);
        return booksProcessor.isBookAvailable();
    }


    private boolean isAdminLoggedIn() {
        return adminLoginService.isAdminLoggedIn();
    }

}
