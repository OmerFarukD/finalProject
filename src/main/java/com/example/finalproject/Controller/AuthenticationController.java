package com.example.finalproject.Controller;

import com.example.finalproject.Dto.RequestDto.UserForLoginRequestDto;
import com.example.finalproject.Entity.User;
import com.example.finalproject.Service.Abstract.IAuthService;
import com.example.finalproject.Service.Abstract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
    @Autowired
    private IAuthService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserForLoginRequestDto userForLoginRequestDto) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(userForLoginRequestDto), HttpStatus.OK);
    }
}
