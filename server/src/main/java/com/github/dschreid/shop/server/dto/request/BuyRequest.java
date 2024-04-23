package com.github.dschreid.shop.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * Holds information about the shopping cart of a user
 *
 * @author dschreid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyRequest {
    @NotEmpty private Map<Long, Integer> shoppingCart;
}
