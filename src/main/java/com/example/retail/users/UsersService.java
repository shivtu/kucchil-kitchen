package com.example.retail.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users addUser(Users newUser) {

        return usersRepository.save(newUser);
    }

    public Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserByName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    public Integer enableUser(String userName) {
       return usersRepository.enableUser(userName);
    }

    public Integer updatePassword(String newPassword, String userName) {
        return usersRepository.updatePassword(newPassword, userName);
    }
}
