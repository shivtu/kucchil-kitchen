package com.example.retail.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/admin/userprofile")
@RestController
public class UsersProfileController {

    @Autowired
    UsersProfileService usersProfileService;

    @RequestMapping(value = "/add")
    public UsersProfile addUserProfile(@RequestBody UsersProfile newUsersProfile) {
        return usersProfileService.adduserProfile(newUsersProfile);
    }
}
