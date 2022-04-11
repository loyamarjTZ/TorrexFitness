package com.joseloya.torrexfitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TorrexFitnessController {
//
//    //spring security mappings
//    @GetMapping("/logi")
//    public String viewHomePageFirstTimeViaSecurity() {
//        return "login";
//    }
//
    @RequestMapping("/login")
    public String viewHomePageAgainViaSecurity() {
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
