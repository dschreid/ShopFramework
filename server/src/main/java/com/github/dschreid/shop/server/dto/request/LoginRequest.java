package com.github.dschreid.shop.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * Holds information about the login requests of an user
 *
 * @author dschreid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotEmpty private String username;
    @NotEmpty private String password;
}
