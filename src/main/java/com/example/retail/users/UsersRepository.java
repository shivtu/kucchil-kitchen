package com.example.retail.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserName(String userName);
}
