package com.example.finalproject.Service.Concrete;

import com.example.finalproject.Dto.RequestDto.UserForLoginRequestDto;
import com.example.finalproject.Entity.User;
import com.example.finalproject.Security.UserPrincipal;
import com.example.finalproject.Security.jwt.IJwtProvider;
import com.example.finalproject.Service.Abstract.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements IAuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(UserForLoginRequestDto userForLoginRequestDto)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userForLoginRequestDto.getUsername(), userForLoginRequestDto.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);
        return signInUser;
    }
}
