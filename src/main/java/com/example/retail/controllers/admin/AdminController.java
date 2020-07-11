package com.example.retail.controllers.admin;

import com.example.retail.users.UsersService;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    UsersService usersService;

    @Autowired
    UsersProfileService usersProfileService;

    @RequestMapping(method = RequestMethod.PATCH, value = "/user/enable/{userName}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity enableUser(@RequestBody String userName) {
        usersService.enableUser(userName);
        return new ResponseEntity(usersService.enableUser(userName), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/find/{userName}")
    public UsersProfile getUserName (@PathVariable String userName) {
        return usersProfileService.findByUserName(userName);
    }
}
