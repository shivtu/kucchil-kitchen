package com.example.retail.users.profiles;

import com.example.retail.users.Users;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "users_profile")
public class UsersProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_profile_table_id")
    private Long userProfile_TableId;

    @Column(name = "user_name", unique = true)
    private String userName;

    private String userProfile_GivenName;

    @Min(18)
    @Max(100)
    private Integer userProfile_Age;

    private Integer userProfile_PhoneNumber;

    private String userProfile_Address;

    private char userProfile_Gender;

    private ArrayList<String> userProfile_SocialMedia;

    private String userProfile_Kyc;

    private String userProfile_Image;

    public UsersProfile(){}

    public UsersProfile(String userName, String userProfile_GivenName, @Min(18) @Max(100) Integer userProfile_Age, Integer userProfile_PhoneNumber, String userProfile_Address, char userProfile_Gender, ArrayList<String> userProfile_SocialMedia, String userProfile_Kyc, String userProfile_Image) {
        this.userName = userName;
        this.userProfile_GivenName = userProfile_GivenName;
        this.userProfile_Age = userProfile_Age;
        this.userProfile_PhoneNumber = userProfile_PhoneNumber;
        this.userProfile_Address = userProfile_Address;
        this.userProfile_Gender = userProfile_Gender;
        this.userProfile_SocialMedia = userProfile_SocialMedia;
        this.userProfile_Kyc = userProfile_Kyc;
        this.userProfile_Image = userProfile_Image;
    }

    public Long getUserProfile_TableId() {
        return userProfile_TableId;
    }

    public void setUserProfile_TableId(Long userProfile_TableId) {
        this.userProfile_TableId = userProfile_TableId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfile_GivenName() {
        return userProfile_GivenName;
    }

    public void setUserProfile_GivenName(String userProfile_GivenName) {
        this.userProfile_GivenName = userProfile_GivenName;
    }

    public Integer getUserProfile_Age() {
        return userProfile_Age;
    }

    public void setUserProfile_Age(Integer userProfile_Age) {
        this.userProfile_Age = userProfile_Age;
    }

    public Integer getUserProfile_PhoneNumber() {
        return userProfile_PhoneNumber;
    }

    public void setUserProfile_PhoneNumber(Integer userProfile_PhoneNumber) {
        this.userProfile_PhoneNumber = userProfile_PhoneNumber;
    }

    public String getUserProfile_Address() {
        return userProfile_Address;
    }

    public void setUserProfile_Address(String userProfile_Address) {
        this.userProfile_Address = userProfile_Address;
    }

    public char getUserProfile_Gender() {
        return userProfile_Gender;
    }

    public void setUserProfile_Gender(char userProfile_Gender) {
        this.userProfile_Gender = userProfile_Gender;
    }

    public ArrayList<String> getUserProfile_SocialMedia() {
        return userProfile_SocialMedia;
    }

    public void setUserProfile_SocialMedia(ArrayList<String> userProfile_SocialMedia) {
        this.userProfile_SocialMedia = userProfile_SocialMedia;
    }

    public String getUserProfile_Kyc() {
        return userProfile_Kyc;
    }

    public void setUserProfile_Kyc(String userProfile_Kyc) {
        this.userProfile_Kyc = userProfile_Kyc;
    }

    public String getUserProfile_Image() {
        return userProfile_Image;
    }

    public void setUserProfile_Image(String userProfile_Image) {
        this.userProfile_Image = userProfile_Image;
    }
}
