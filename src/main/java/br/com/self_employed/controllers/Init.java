package br.com.self_employed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Init {
    @GetMapping("/api")
    @ResponseBody
    public String welcomeMessage() {
        return "Welcome to the self_employed API.";
    }
}