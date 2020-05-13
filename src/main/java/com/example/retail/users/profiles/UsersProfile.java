package com.example.retail.users.profiles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "users_profile")
public class UsersProfile {

    @Id
    @GeneratedValue
    private Integer userProfile_TableId;

    @Email
    private String getUserProfile_userName;

    private String userProfile_GivenName;

    @Min(18)
    @Max(100)
    private Integer getUserProfile_Age;

    private Integer userProfile_PhoneNumber;

    private String userProfile_Address;

    private char userProfile_Gender;

    private List<String> userProfile_SocialMedia;

    private String userProfile_Kyc;
}
