package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserLoginService {

    private String firstName;
    private String lastName;
    //* used to query user
    private Integer userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getfullName() {
        //* used to display name as text
        return firstName + " " + lastName;
    }

    public boolean loggedInCheck() {
        //* check if user is logged in
        return userId != null;
    }
}
