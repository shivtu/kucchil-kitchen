package com.example.retail.users.profiles;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
@Entity
@Table(name = "users_profile")
public class UsersProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_profile_table_id", updatable = false)
    private Long userProfile_TableId;

    @Column(name = "user_name", unique = true)
    @Email
    private String userName;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(name = "user_profile_given_name")
    private String userProfile_GivenName;

    @Min(value = 18, message = "You must be 18 years or older")
    @Max(100)
    @Column(name="user_profile_age")
    private Integer userProfile_Age;

    @Column(name = "user_profile_phone_number", nullable = false, unique = true)
    private Long userProfile_PhoneNumber;

    @Column(name = "user_profile_address")
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 200)
    private String userProfile_Address;

    @Column(name = "user_profile_gender")
    @NotNull
    private UserProfileGender userProfile_Gender;

    @Type(type = "string-array")
    @Column(columnDefinition = "text[]", name = "user_profile_social_media")
    private String[] userProfile_SocialMedia;

    @Column(name = "user_profile_added_on_date")
    @NotNull
    @NotEmpty
    private String userProfile_AddedOnDate;

    @Column(name = "user_profile_added_on_time")
    @NotNull
    @NotEmpty
    private String userProfile_AddedOnTime;

    @Column(name = "user_profile_kyc")
    @NotNull
    @NotEmpty
    private String userProfile_Kyc;

    @Column(name = "user_profile_image")
    @NotNull
    private String userProfile_Image;

    @Column(name = "user_profile_wish_list")
    private String[] userProfile_wishList;

    @Column(name = "user_profile_applied_loyalty_discount")
    private Float userProfile_AppliedloyaltyDiscount = 0F;

    public UsersProfile(){}

    public UsersProfile(@Email String userName,
                        @NotNull @NotEmpty @Size(min = 3) String userProfile_GivenName,
                        @Min(value = 18, message = "You must be 18 years or older") @Max(100) Integer userProfile_Age,
                        Long userProfile_PhoneNumber, @NotNull @NotEmpty @Size(min = 6, max = 200) String userProfile_Address,
                        @NotNull UserProfileGender userProfile_Gender, String[] userProfile_SocialMedia,
                        @NotNull @NotEmpty String userProfile_AddedOnDate,
                        @NotNull @NotEmpty String userProfile_AddedOnTime,
                        @NotNull @NotEmpty String userProfile_Kyc,
                        @NotNull String userProfile_Image,
                        String[] userProfile_wishList,
                        Float userProfile_AppliedloyaltyDiscount) {

        this.userName = userName;
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
        this.userProfile_wishList = userProfile_wishList;
        this.userProfile_AppliedloyaltyDiscount = userProfile_AppliedloyaltyDiscount;
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

    public Long getUserProfile_PhoneNumber() {
        return userProfile_PhoneNumber;
    }

    public void setUserProfile_PhoneNumber(Long userProfile_PhoneNumber) {
        this.userProfile_PhoneNumber = userProfile_PhoneNumber;
    }

    public String getUserProfile_Address() {
        return userProfile_Address;
    }

    public void setUserProfile_Address(String userProfile_Address) {
        this.userProfile_Address = userProfile_Address;
    }

    public UserProfileGender getUserProfile_Gender() {
        return userProfile_Gender;
    }

    public void setUserProfile_Gender(UserProfileGender userProfile_Gender) {
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

    public String[] getUserProfile_wishList() {
        return userProfile_wishList;
    }

    public void setUserProfile_wishList(String[] userProfile_wishList) {
        this.userProfile_wishList = userProfile_wishList;
    }

    public Float getUserProfile_AppliedloyaltyDiscount() {
        return userProfile_AppliedloyaltyDiscount;
    }

    public void setUserProfile_AppliedloyaltyDiscount(Float userProfile_AppliedloyaltyDiscount) {
        this.userProfile_AppliedloyaltyDiscount = userProfile_AppliedloyaltyDiscount;
    }
}
