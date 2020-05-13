package com.example.retail.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UsersProfileService {

    @Autowired
    UsersProfileRepository usersProfileRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UsersProfile adduserProfile(@RequestBody UsersProfile newUsersProfile){
        return  usersProfileRepository.save(newUsersProfile);
    }
}
