package com.example.controllers;

import com.example.model.User;
import com.example.processors.BooksProcessor;
import com.example.processors.UserLoginProcessor;
import com.example.services.AdminService;
import com.example.services.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {

    private final UserLoginProcessor userLoginProcessor;
    private final AdminService adminService;
    private final UserLoginService userLoginService;

    private final BooksProcessor booksProcessor;

    public UserLoginController(UserLoginProcessor userLoginProcessor, AdminService adminService, UserLoginService userLoginService, BooksProcessor booksProcessor) {
        this.userLoginProcessor = userLoginProcessor;
        this.adminService = adminService;
        this.userLoginService = userLoginService;
        this.booksProcessor = booksProcessor;
    }

    @PostMapping("/userlogin")
    public String attemptLogin(
            @RequestParam String firstName,
            @RequestParam String lastName,
            Model model
    ) {
        userLoginProcessor.setFirstName(firstName);
        userLoginProcessor.setLastName(lastName);

        //* For simplicity, system assumes each user is unique
        if (!userLoginProcessor.isUserValid()) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            adminService.addUser(user);
        }
        storeLoginDetails(firstName, lastName, userLoginProcessor.getUserId());
        return "redirect:/books";
    }

    @PostMapping("/userlogout")
    public String logoutUser() {
        storeLoginDetails(null, null, null);
        return "redirect:/login";
    }
    @DeleteMapping("/userdelete")
    public String deleteAccount() {
        if (!booksProcessor.isUserAvailable()) {
            return "redirect:/books";
        }
        adminService.deleteUser(userLoginService.getUserId());
        return "redirect:/login";
    }

    private void storeLoginDetails(String firstName, String lastName, Integer userId) {
        userLoginService.setFirstName(firstName);
        userLoginService.setLastName(lastName);
        userLoginService.setUserId(userId);
    }


}
