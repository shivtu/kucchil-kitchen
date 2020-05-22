package com.example.retail.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsersProfileService {

    @Autowired
    UsersProfileRepository usersProfileRepository;

    public UsersProfile updateUsersProfile(@RequestBody UsersProfile newUsersProfile){
        return  usersProfileRepository.save(newUsersProfile);
    }
}
