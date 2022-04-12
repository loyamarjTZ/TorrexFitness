package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TorrexFitnessController {

    //spring security mappings
    @GetMapping("/")
    public String viewSecurityLogin1() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

//
//    //original project mappings
//    @GetMapping("/h")
//    public String viewHomePageFirstTime() {
//        return "indexTF";
//    }
//
//    @RequestMapping("/hom")
//    public String viewHomePageAgain() {
//        return "indexTF";
//    }
//
//    @RequestMapping("/sign-in")
//    public String viewSignInPage() {
//        return "sign-in";
//    }
//
//    @RequestMapping("/register")
//    public String viewRegisterPage() {
//        return "register";
//    }
//
//    @RequestMapping("/cart")
//    public String viewCartPage() {
//        return "cart";
//    }
//
}
