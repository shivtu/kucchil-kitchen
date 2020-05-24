package com.example.retail.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserName(String userName);

    @Query(value = "UPDATE users SET enabled=true WHERE userName=?", nativeQuery = true)
    Users enableUser(String userName);
}
