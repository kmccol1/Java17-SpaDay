package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController
{
    @GetMapping("add")
    public String displayAddUserForm(Model model)
    {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors)
    {
        String result;

        if(errors.hasErrors())
        {
            model.addAttribute("errors", errors.getFieldErrors());
            result = "user/add";
        }
        else
        {
            //if (verify.equalsIgnoreCase(user.getPassword()))
            if( (user.getVerifyPassword().isEmpty()) && (user.getVerifyPassword() != null))
            {
                result = "user/index";
                model.addAttribute("title", "Welcome, " + user.getUsername());
            }
            else
            {
                result = "user/add";
                //model.addAttribute("error", "Passwords do not match.");
                //model.addAttribute("username", user.getUsername());
                //model.addAttribute("email", user.getEmail());
            }
        }

        return result;
    }
}
