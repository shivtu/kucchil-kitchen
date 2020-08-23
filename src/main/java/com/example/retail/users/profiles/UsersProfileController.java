package com.example.retail.users.profiles;

import com.example.retail.util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/api/v1/userprofile")
@RestController
public class UsersProfileController {

    @Autowired
    UsersProfileService usersProfileService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/update")
    public ResponseEntity<?> updateUsersProfile(@RequestBody UsersProfile usersProfile, HttpServletRequest httpServletRequest) throws Exception {

        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
        final String jwt = authorizationHeader.substring(7);
        String requesterUserName = jwtUtil.extractUsername(jwt);
        String userProfileUserName = usersProfile.getUserName();

        if (requesterUserName.equals(userProfileUserName)) {
            UsersProfile updatedProfile = usersProfileService.updateUsersProfile(usersProfile);
            return new ResponseEntity(updatedProfile, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
    }
}
