package com.example.retail.Welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin(origins = "*")
public class WelcomeController {

    @Autowired
    Welcome welcome;

    @GetMapping(value = "/welcome")
    public String returnWelcomeMessage() {
        return welcome.getWelcomeMessage();
    }
}
