package com.example.retail.users.profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersProfileRepository extends JpaRepository<UsersProfile, Long> {

    @Query(value = "SELECT * FROM users_profile WHERE user_name= :userName", nativeQuery = true)
    public UsersProfile findByUserName(@Param("userName") String userName);
}
