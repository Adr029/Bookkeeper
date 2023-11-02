package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class AdminLoginService {
    private boolean isAdminLoggedIn;

    public boolean isAdminLoggedIn() {
        return isAdminLoggedIn;
    }

    public void setAdminLoggedIn(boolean adminLoggedIn) {
        isAdminLoggedIn = adminLoggedIn;
    }
}
