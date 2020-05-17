package com.example.retail.users;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;

public class SignUpRequestBody implements Serializable {

    private String userName;

    private String password;

    private String userProfile_GivenName;

    private Integer userProfile_Age;

    private Integer userProfile_PhoneNumber;

    private String userProfile_Address;

    private char userProfile_Gender;

    private String[] userProfile_SocialMedia;

    private String userProfile_AddedOnDate;

    private String userProfile_AddedOnTime;

    private String userProfile_Kyc;

    private String userProfile_Image;

    public SignUpRequestBody(){}

    public SignUpRequestBody(String userName, String password, String userProfile_GivenName, Integer userProfile_Age, Integer userProfile_PhoneNumber, String userProfile_Address, char userProfile_Gender, String[] userProfile_SocialMedia, String userProfile_AddedOnDate, String userProfile_AddedOnTime, String userProfile_Kyc, String userProfile_Image) {
        this.userName = userName;
        this.password = password;
        this.userProfile_GivenName = userProfile_GivenName;
        this.userProfile_Age = userProfile_Age;
        this.userProfile_PhoneNumber = userProfile_PhoneNumber;
        this.userProfile_Address = userProfile_Address;
        this.userProfile_Gender = userProfile_Gender;
        this.userProfile_SocialMedia = userProfile_SocialMedia;
        this.userProfile_AddedOnDate = userProfile_AddedOnDate;
        this.userProfile_AddedOnTime = userProfile_AddedOnTime;
        this.userProfile_Kyc = userProfile_Kyc;
        this.userProfile_Image = userProfile_Image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String[] getUserProfile_SocialMedia() {
        return userProfile_SocialMedia;
    }

    public void setUserProfile_SocialMedia(String[] userProfile_SocialMedia) {
        this.userProfile_SocialMedia = userProfile_SocialMedia;
    }

    public String getUserProfile_AddedOnDate() {
        return userProfile_AddedOnDate;
    }

    public void setUserProfile_AddedOnDate(String userProfile_AddedOnDate) {
        this.userProfile_AddedOnDate = userProfile_AddedOnDate;
    }

    public String getUserProfile_AddedOnTime() {
        return userProfile_AddedOnTime;
    }

    public void setUserProfile_AddedOnTime(String userProfile_AddedOnTime) {
        this.userProfile_AddedOnTime = userProfile_AddedOnTime;
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
