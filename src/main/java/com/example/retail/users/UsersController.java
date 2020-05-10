package com.example.retail.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Users addUser(@RequestBody(required = true) Users newUser) {
        return usersService.addUser(newUser);
    }

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
