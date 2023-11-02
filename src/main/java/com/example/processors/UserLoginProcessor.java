package com.example.processors;

import com.example.services.LibraryService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserLoginProcessor {

    private final LibraryService libraryService;
    private String firstName;
    private String lastName;

    public UserLoginProcessor(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //* System first verifies user information using first and last name
    //* No password used at the moment
    public boolean isUserValid() {
        return libraryService.findUserByName(firstName, lastName) != null;
    }

    public int getUserId() {
        return libraryService.findUserByName(firstName, lastName).getId();
    }


}
