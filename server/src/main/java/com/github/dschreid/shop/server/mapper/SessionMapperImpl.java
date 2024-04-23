package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.model.Session;
import com.github.dschreid.shop.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionMapperImpl implements SessionMapper {
    private final UserMapper userMapper;

    @Autowired
    public SessionMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public AuthResponse toAuthResponse(User user, Session session) {
        final AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(session.getToken());
        authResponse.setUserInformation(userMapper.toInformation(user));
        return authResponse;
    }

}
