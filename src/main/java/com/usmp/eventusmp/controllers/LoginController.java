package com.usmp.eventusmp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.usmp.eventusmp.persistence.models.Usuarios;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("login")
@PreAuthorize("permitAll()")
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    

    @GetMapping
    public String showCustomerLogin(Model modelo){
        modelo.addAttribute("prototipo", new Usuarios());
        return "login/index";
    }

    @PostMapping
    public ResponseEntity<?> loginCustomer(Usuarios prototipo) {
        prototipo.
        
        
        return ;
    }
    
    

}
