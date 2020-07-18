package com.example.retail.users;

import com.example.retail.users.profiles.UserProfileGender;
import com.example.retail.users.profiles.UsersProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {

    @InjectMocks
    UsersService usersService;

    @Mock
    UsersRepository usersRepository;

    @Autowired
    UserProfileGender userProfileGender;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserByName() {

        String[] socialMedia = new String[0];

        UsersProfile usersProfile = new UsersProfile();
        usersProfile.setUserProfile_TableId(1l);
        usersProfile.setUserProfile_Gender(userProfileGender);
        usersProfile.setUserProfile_AddedOnTime("12-12-2020");
        usersProfile.setUserProfile_AddedOnDate("12-12-2020");
        usersProfile.setUserProfile_SocialMedia(socialMedia);
        usersProfile.setUserProfile_Kyc("kyc");
        usersProfile.setUserProfile_Age(20);
        usersProfile.setUserProfile_GivenName("batman");
        usersProfile.setUserProfile_Address("Bangalore");
        usersProfile.setUserProfile_PhoneNumber(2l);
        usersProfile.setUserProfile_wishList(socialMedia);

        Users users = new Users();
        users.setConnectedUsersProfile(usersProfile);
        users.setRoles("ROLE_RETAILER");
        users.setEnabled(true);
        users.setCredentialsNonExpired(true);
        users.setAccountNonLocked(true);
        users.setAccountNonExpired(true);
        users.setPassword("sdrwer4r23r2++#$@#f");
        users.setUserName("batman@gmail.com");
        users.setUsers_TableId(1l);

        when(usersRepository.findByUserName("batman@gmail.com")).thenReturn(Optional.of(users));

        Optional<Users> resUser = usersService.getUserByName("batman@gmail.com");

        assertNotNull(resUser);
        assertEquals("batman@gmail.com", resUser.get().getUserName());
    }

}