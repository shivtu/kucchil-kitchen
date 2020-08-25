package com.example.retail.users;

import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1/signup")
public class UsersSignUpController {

    @Autowired
    UsersService usersService;

    @Autowired
    Validations validations;

    @Autowired
    CreateResponse createResponse;

    private UsersProfile createUserProfile(HttpEntity<SignUpRequestBody> signUpRequestBody) {
        UsersProfile usersProfile = new UsersProfile();
        usersProfile.setUserName(signUpRequestBody.getBody().getUserName());
        usersProfile.setUserProfile_GivenName(signUpRequestBody.getBody().getUserProfile_GivenName());
        usersProfile.setUserProfile_Age(signUpRequestBody.getBody().getUserProfile_Age());
        usersProfile.setUserProfile_PhoneNumber(signUpRequestBody.getBody().getUserProfile_PhoneNumber());
        usersProfile.setUserProfile_Address(signUpRequestBody.getBody().getUserProfile_Address());
        usersProfile.setUserProfile_Gender(signUpRequestBody.getBody().getUserProfile_Gender());
        usersProfile.setUserProfile_SocialMedia(signUpRequestBody.getBody().getUserProfile_SocialMedia());
        usersProfile.setUserProfile_AddedOnDate(LocalDate.now().toString());
        usersProfile.setUserProfile_AddedOnTime(LocalTime.now().toString());
        usersProfile.setUserProfile_Kyc(signUpRequestBody.getBody().getUserProfile_Kyc());
        // TODO: convert string to string Array and add default avatar
        usersProfile.setUserProfile_Image(signUpRequestBody.getBody().getUserProfile_Image());

        return usersProfile;
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> addUser(HttpEntity<SignUpRequestBody> signUpRequestBody) {

        try {
            ValidationResponse validationResponse = validations.validateNewUser(Objects.requireNonNull(signUpRequestBody.getBody()).getUserName(),
                    signUpRequestBody.getBody().getUserProfile_PhoneNumber());
            if(validationResponse.getStatusCode() != validations.validationSuccessCode){
                return ResponseEntity.status(validationResponse.getStatusCode()).body(
                        validationResponse
                );
            }

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

            List<Object> res = new ArrayList<>();

            res.add(createdUser);

            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Signup success", res)
            );

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }

    @PostMapping(value = "/retailer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> addRetailer (HttpEntity<SignUpRequestBody> signUpRequestBody) {

        try {
            ValidationResponse validationResponse = validations.validateNewUser(Objects.requireNonNull(signUpRequestBody.getBody()).getUserName(),
                    signUpRequestBody.getBody().getUserProfile_PhoneNumber());
            if(validationResponse.getStatusCode() != validations.validationSuccessCode){
                return ResponseEntity.status(validationResponse.getStatusCode()).body(
                        validationResponse
                );
            }
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

            List<Object> res = new ArrayList<>();

            res.add(createdUser.getConnectedUsersProfile());
            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Signup success", res)
            );

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }
}
