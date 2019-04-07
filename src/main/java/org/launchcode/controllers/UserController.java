package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hackman
 */

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, @RequestParam String verifyPassword) {
        // if (user.getVerifyPassword() == (user.getPassword())) {
        if (user.getPassword().equals(verifyPassword)) {
            model.addAttribute("title", "New User");
            model.addAttribute("user", user);
            return "user/index";
        }
        user.setPassword("");
        model.addAttribute("title", "Register");
        model.addAttribute("user", user);
        model.addAttribute("error", "Passwords don't match!");
        return "user/add";
    }

}
