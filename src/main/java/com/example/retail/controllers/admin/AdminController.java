package com.example.retail.controllers.admin;

import com.example.retail.users.Users;
import com.example.retail.users.UsersService;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import com.example.retail.util.CreateResponse;
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

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(method = RequestMethod.PATCH, value = "/user/enable/{userName}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> enableUser(@RequestBody Users users) {
       try{
           Optional<Users> user = usersService.getUserByName(users.getUserName());
           if(user.isPresent() && usersService.enableUser(users.getUserName()) == 1) {
               return ResponseEntity.status(201).body(
                   createResponse.createSuccessResponse(
                       201,
                       "User enabled",
                       null
                   )
               );
           } else {
               return ResponseEntity.status(422).body(
                   createResponse.createErrorResponse(
                       422,
                       users.getUserName() + " not found",
                       null
                   )
               );
           }
       } catch (Exception e) {
           return ResponseEntity.status(500).body(
                   createResponse.createErrorResponse(
                           500,
                           e.getLocalizedMessage(),
                           "NA"
                   )
           );
       }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/find/{userName}")
    public Optional<UsersProfile> getUserName (@PathVariable String userName) {
        return usersProfileService.findByUserName(userName);
    }
}
