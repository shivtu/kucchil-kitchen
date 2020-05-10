package com.example.retail.security;

import com.example.retail.users.Users;
import com.example.retail.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Convert user to MyUserDetails instance
        return user.map(MyUserDetails::new).get();
    }
}
