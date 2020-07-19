package com.example.retail.users;

import com.example.retail.users.profiles.UsersProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1/signup")
public class UsersSignUpController {

    @Autowired
    UsersService usersService;

    private UsersProfile createUserProfile(HttpEntity<SignUpRequestBody> signUpRequestBody) {
        UsersProfile usersProfile = new UsersProfile();
        usersProfile.setUserName(signUpRequestBody.getBody().getUserName());
        usersProfile.setUserProfile_GivenName(signUpRequestBody.getBody().getUserProfile_GivenName());
        usersProfile.setUserProfile_Age(signUpRequestBody.getBody().getUserProfile_Age());
        usersProfile.setUserProfile_PhoneNumber(signUpRequestBody.getBody().getUserProfile_PhoneNumber());
        usersProfile.setUserProfile_Address(signUpRequestBody.getBody().getUserProfile_Address());
        usersProfile.setUserProfile_Gender(signUpRequestBody.getBody().getUserProfile_Gender());
        usersProfile.setUserProfile_SocialMedia(signUpRequestBody.getBody().getUserProfile_SocialMedia());
        usersProfile.setUserProfile_AddedOnDate(LocalDate.now().toString()); // Get Current Date
        usersProfile.setUserProfile_AddedOnTime(LocalTime.now().toString());
        usersProfile.setUserProfile_Kyc(signUpRequestBody.getBody().getUserProfile_Kyc());
        // TODO: convert string to string Array and add default avatar
        usersProfile.setUserProfile_Image(signUpRequestBody.getBody().getUserProfile_Image());

        return usersProfile;
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UsersProfile> addUser(HttpEntity<SignUpRequestBody> signUpRequestBody) {

        Users users = new Users();
        users.setUserName(Objects.requireNonNull(signUpRequestBody.getBody()).getUserName());
        users.setPassword(signUpRequestBody.getBody().getPassword());
        users.setAccountNonExpired(true);
        users.setAccountNonLocked(true);
        users.setCredentialsNonExpired(true);
        users.setEnabled(true);
        users.setRoles("ROLE_CUSTOMER");
        users.setConnectedUsersProfile(createUserProfile(signUpRequestBody));

        Users createdUser = usersService.addUser(users);

        return new ResponseEntity<>(createdUser.getConnectedUsersProfile(), HttpStatus.CREATED);
    }

    @PostMapping(value = "/retailer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UsersProfile> addRetailer (HttpEntity<SignUpRequestBody> signUpRequestBody) {

        Users users = new Users();
        users.setUserName(Objects.requireNonNull(signUpRequestBody.getBody()).getUserName());
        users.setPassword(signUpRequestBody.getBody().getPassword());
        users.setAccountNonExpired(true);
        users.setAccountNonLocked(true);
        users.setCredentialsNonExpired(true);
        users.setEnabled(false);
        users.setRoles("ROLE_RETAILER");
        users.setConnectedUsersProfile(createUserProfile(signUpRequestBody));

        Users createdUser = usersService.addUser(users);

        return new ResponseEntity<>(createdUser.getConnectedUsersProfile(), HttpStatus.CREATED);
    }
}
