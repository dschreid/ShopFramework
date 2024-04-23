package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.UserInformationResponse;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInformationResponse toInformation(User user) {
        final UserInformationResponse userInformation = new UserInformationResponse();
        userInformation.setUsername(user.getUsername());
        userInformation.setEmail(user.getEmail());
        userInformation.setPermissionLevel(user.highestRole().getPermissionLevel());
        return userInformation;
    }

    @Override
    public User fromRegister(RegisterRequest request) {
        return new User(request.getUsername(), request.getPassword(), request.getEmail());
    }

}
