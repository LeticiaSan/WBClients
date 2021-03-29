package com.fatec.WBClients.application.http.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ApplicationController implements WebMvcConfigurer {

    @RequestMapping("/")
    public String homePage(Model model) {
        return "index";
    }

}
