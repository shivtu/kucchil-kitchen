package com.example.retail.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class UsersController {

    @Autowired
    UsersService usersService;


    @GetMapping("/allusers")
    public Iterable<Users> getAllUsers() {
        Users user = new Users();
        return usersService.getAllUsers();
    }

    @GetMapping(value = "/userbyname/{userName}")
    public Optional<Users> getUserByName(@PathVariable String userName) {
        return usersService.getUserByName(userName);
    }
}
