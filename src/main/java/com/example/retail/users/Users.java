package com.example.retail.users;

import com.example.retail.users.profiles.UsersProfile;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_table_id")
    private Long users_TableId;

    @Column(name = "user_name", unique = true)
    private String userName;

    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_table_id", referencedColumnName = "users_profile_table_id")
    private UsersProfile connectedUsersProfile;

    public Users(){}

    public Users(String userName, String password, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String roles, UsersProfile connectedUsersProfile) {
        this.userName = userName;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.roles = roles;
        this.connectedUsersProfile = connectedUsersProfile;
    }

    public Long getUsers_TableId() {
        return users_TableId;
    }

    public void setUsers_TableId(Long users_TableId) {
        this.users_TableId = users_TableId;
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
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public UsersProfile getConnectedUsersProfile() {
        return connectedUsersProfile;
    }

    public void setConnectedUsersProfile(UsersProfile connectedUsersProfile) {
        this.connectedUsersProfile = connectedUsersProfile;
    }
}
