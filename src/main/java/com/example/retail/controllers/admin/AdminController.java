package com.example.retail.controllers.admin;

import com.example.retail.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.PATCH, value = "/user/enable/{userName}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity enableUser(@RequestBody String userName) {
        usersService.enableUser(userName);
        return new ResponseEntity(usersService.enableUser(userName), HttpStatus.CREATED);
    }
}
