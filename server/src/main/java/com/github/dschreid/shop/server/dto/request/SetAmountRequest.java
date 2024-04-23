package com.github.dschreid.shop.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Holds information about how to set the amount of an item
 *
 * @author dschreid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetAmountRequest {
    @NotNull private Long itemid;
    @PositiveOrZero private Long newAmount;
}
