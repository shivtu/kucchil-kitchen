package com.example.retail.users.profiles;

import com.example.retail.users.profiles.UsersProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsersProfileRepository extends JpaRepository<UsersProfile, String> {
}
