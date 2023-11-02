package com.example.processors;

import com.example.model.User;
import com.example.services.LibraryService;
import com.example.services.UserLoginService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class BooksProcessor {

    private final LibraryService libraryService;
    private final UserLoginService userLoginService;
    private int bookId;

    public BooksProcessor(LibraryService libraryService, UserLoginService userLoginService) {
        this.libraryService = libraryService;
        this.userLoginService = userLoginService;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public boolean isBookAvailable() {
        //* only one copy of the book exists
        return libraryService.checkBookAvailability(bookId);
    }

    public boolean isUserAvailable() {
        //* user can only borrow one book at a time
        int userId = userLoginService.getUserId();
        User currentUser = libraryService.findUserById(userId);
        return currentUser.getBorrowedBook() == null;
    }
}
