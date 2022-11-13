package com.example.finalproject.Service.Abstract;

import com.example.finalproject.Dto.RequestDto.UserForLoginRequestDto;
import com.example.finalproject.Entity.User;

public interface IAuthService {
    User signInAndReturnJWT(UserForLoginRequestDto userForLoginRequestDto);
}
