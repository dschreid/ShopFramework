package com.github.dschreid.shop.server.dto.response;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Holds information about a Login Result
 *
 * @author dschreid
 */
@Data
public class AuthResponse {
    @NotEmpty private String token;
    @NotNull private UserInformationResponse userInformation;
}
