package com.joseloya.torrexfitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TorrexFitnessController {

//    spring security mappings
    @GetMapping("/login")
    public String viewHomePageFirstTimeViaSecurity() {
        return "login";
    }

    @RequestMapping("/login")
    public String viewHomePageAgainViaSecurity(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

//    original project mappings
    @GetMapping("/home")
    public String viewHomePageFirstTime() {
        return "indexTF";
    }

    @RequestMapping("/home")
    public String viewHomePageAgain(){
        return "indexTF";
    }

    @RequestMapping("/sign-in")
    public String viewSignInPage(){
        return "sign-in";
    }

    @RequestMapping("/register")
    public String viewRegisterPage(){
        return "register";
    }

    @RequestMapping("/cart")
    public String viewCartPage(){
        return "cart";
    }

}
