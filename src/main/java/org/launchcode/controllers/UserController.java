package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Hackman
 */

@Controller
@RequestMapping("user")
public class UserController {

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "New User");

        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User newUser, Errors errors, Model model, @RequestParam String verifyPassword) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "user/add";
        }

        // if (user.getVerifyPassword() == (user.getPassword())) {
        if (newUser.getPassword().equals(verifyPassword)) {
            model.addAttribute("title", "New User");
            model.addAttribute("user", newUser);
            return "user/index";
        }
        newUser.setPassword("");
        model.addAttribute("title", "Register");
        model.addAttribute("user", newUser);
        model.addAttribute("error", "Passwords don't match!");
        return "user/add";
    }

}
