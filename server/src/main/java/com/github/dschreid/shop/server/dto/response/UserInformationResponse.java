package com.github.dschreid.shop.server.dto.response;

import lombok.Data;

/**
 * Holds information about an User
 *
 * @author dschreid
 */
@Data
public class UserInformationResponse {
    private String username;
    private String email;
    private Integer permissionLevel;
}
