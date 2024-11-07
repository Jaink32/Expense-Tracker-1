package com.expensetracker.expensetracker.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    // This method maps the root URL ("/") to the dashboard view
    @GetMapping("/")
    public String showDashboard() {
        // Returns the name of the HTML template (index.html) inside /templates
        return "index";
    }

    @GetMapping("/reports")
    public String showReports(Model model) {
        // Returns the name of the HTML template (index.html) inside /templates
        model.addAttribute("pageTitle", "Reports - Expense Tracker");
        return "reports";
    }


}
