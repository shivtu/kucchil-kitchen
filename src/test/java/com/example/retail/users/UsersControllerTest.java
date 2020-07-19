package com.example.retail.users;

import com.example.demoauth.RetailApplicationTests;

import com.example.retail.users.profiles.UsersProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UsersControllerTest extends RetailApplicationTests {

    @InjectMocks
    UsersController usersController;

    @Mock
    UsersService usersService;

    Users users;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        final String[] socialMedia = new String[0];

        UsersProfile usersProfile = new UsersProfile();

        users = new Users();
        users.setConnectedUsersProfile(usersProfile);
        users.setRoles("ROLE_RETAILER");
        users.setEnabled(true);
        users.setCredentialsNonExpired(true);
        users.setAccountNonLocked(true);
        users.setAccountNonExpired(true);
        users.setPassword("sdrwer4r23r2++#$@#f");
        users.setUserName("batman@gmail.com");
        users.setUsers_TableId(1l);
    }

    @Test
    public void getAllUsersTest() {

        ArrayList<Users> userList = new ArrayList<>();
        userList.add(users);

        when(usersService.getAllUsers()).thenReturn(userList);

        Iterable<Users> resUser = usersController.getAllUsers();

        assertNotNull(resUser);
    }

    @Test
    public void getUserByNameTest() {

        when(usersService.getUserByName(anyString())).thenReturn(Optional.of(users));

        Optional<Users> resUser = usersController.getUserByName("batman@gmail.com");

        assertNotNull(resUser);

        assertEquals("batman@gmail.com", resUser.get().getUserName());

        assertEquals("200 OK", HttpStatus.valueOf(200).toString());
    }

    @Test
    public void getUserByNameTest_NoUsreFound() {

        when(usersService.getUserByName(anyString())).thenReturn(null);

        Optional<Users> resUser = usersController.getUserByName("batman@gmail.com");

        assertNull(resUser);
    }
}