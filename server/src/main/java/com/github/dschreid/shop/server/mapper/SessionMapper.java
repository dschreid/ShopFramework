package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.model.Session;
import com.github.dschreid.shop.server.model.User;


/**
 * Session to AuthResponse mapper
 *
 * @author dschreid
 */
public interface SessionMapper {

    /**
     * Creates an Auth Response from a session
     *
     * @param user    user
     * @param session user's session
     * @return the auth response
     */
    AuthResponse toAuthResponse(User user, Session session);

}
