package com.example.retail.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET enabled=true WHERE user_name= :userName", nativeQuery = true)
    Integer enableUser(@Param("userName") String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Users u set u.password= :newPassword WHERE u.userName= :userName")
    Integer updatePassword(@Param("newPassword") String newPassword, @Param("userName") String userName);
}
