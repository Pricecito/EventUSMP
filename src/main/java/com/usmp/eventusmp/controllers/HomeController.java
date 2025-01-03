package com.usmp.eventusmp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("home")
@PreAuthorize("denyAll()")
public class HomeController {
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    public String index() {
        

        return "home/index";
    }

}
