package com.github.dschreid.shop.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * Holds information about how to add balance to a user
 *
 * @author dschreid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBalanceRequest {
    @NotEmpty private String username;
    @Positive private Long amount;
}
