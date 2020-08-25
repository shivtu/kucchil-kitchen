package com.example.retail.users;

import com.example.retail.util.CreateResponse;
import com.example.retail.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/passwordManager")
public class UsersPasswordManager {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UsersService usersService;

    @PostMapping(value = "/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody String newPassword, HttpServletRequest httpServletRequest) {
        try {
            final String authorizationHeader = httpServletRequest.getHeader("Authorization");
            final String jwt = authorizationHeader.substring(7);

            String requesterUserName = jwtUtil.extractUsername(jwt);

            BCrypt.hashpw(newPassword, BCrypt.gensalt());

            Integer res = usersService.updatePassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()), requesterUserName);

            if(res.equals(1)) {
                List<Object> finalRes = new ArrayList<>();
                finalRes.add("/api/v1/users/authenticate");
                return ResponseEntity.status(201).body(
                        createResponse.createSuccessResponse(201, "Password update success", finalRes)
                );
            } else {
                return ResponseEntity.status(500).body(
                        createResponse.createErrorResponse(500, "Unable to update password", "Process exited with code : " + res)
                );
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }

    @PostMapping(value = "/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody String userName) {
        // Send email with newly generated password
        return null;
    }
}
