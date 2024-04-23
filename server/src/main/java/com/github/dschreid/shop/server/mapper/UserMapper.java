package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.UserInformationResponse;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.model.User;


/**
 * User to Information Mapper
 *
 * @author dschreid
 */
public interface UserMapper {

    /**
     * Creates UserInformation from a user database entity
     *
     * @param user the user
     * @return the user information response
     */
    UserInformationResponse toInformation(User user);

    /**
     * Creates a User from a RegisterRequest.
     *
     * @param request the request
     * @return the user
     */
    User fromRegister(RegisterRequest request);
}
