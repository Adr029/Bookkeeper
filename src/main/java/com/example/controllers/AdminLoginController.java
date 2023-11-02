package com.example.controllers;

import com.example.processors.AdminLoginProcessor;
import com.example.services.AdminLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    private final AdminLoginProcessor adminLoginProcessor;

    private final AdminLoginService adminLoginService;

    public AdminLoginController(AdminLoginProcessor adminLoginProcessor, AdminLoginService adminLoginService) {
        this.adminLoginProcessor = adminLoginProcessor;
        this.adminLoginService = adminLoginService;
    }

    @GetMapping("/adminlogin")
    public String displayLoginPage() {
        return "admin_login.html";
    }

    @PostMapping("/adminlogin")
    public String attemptLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        adminLoginProcessor.setUsername(username);
        adminLoginProcessor.setPassword(password);

        if (adminLoginProcessor.isCredentialsValid()) {
            adminLoginService.setAdminLoggedIn(true);
            return "redirect:/admin";
        }
        return "redirect:/login";
    }

    @PostMapping("/adminlogout")
    public String logoutUser() {
        adminLoginService.setAdminLoggedIn(false);
        return "redirect:/login";
    }

}
