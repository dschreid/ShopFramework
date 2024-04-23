package com.github.dschreid.shop.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Holds information about the register request of an user
 *
 * @author dschreid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @Size(min = 3, max = 16) private String username;
    @Size(min = 6, max = 32) private String password;
    @Email private String email;
}
