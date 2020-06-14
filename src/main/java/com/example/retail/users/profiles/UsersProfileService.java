package com.example.retail.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UsersProfileService {

    @Autowired
    UsersProfileRepository usersProfileRepository;

    public UsersProfile updateUsersProfile(@RequestBody UsersProfile newUsersProfile){
        return  usersProfileRepository.save(newUsersProfile);
    }

    public UsersProfile findByUserName(String userName) {
        return usersProfileRepository.findByUserName(userName);
    }

    public Optional<UsersProfile> findById (Long tableId) {
        return usersProfileRepository.findById(tableId);
    }
}
