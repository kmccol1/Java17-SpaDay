package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController
{
    @GetMapping("add")
    public String displayAddUserForm()
    {
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify)
    {
        String result;

        if (verify.equalsIgnoreCase(user.getPassword()))
        {
            result = "user/index";
            model.addAttribute("title", "Welcome, " + user.getUsername());
        }
        else
        {
            result = "user/add";
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
        }

        return result;
    }
}
