package com.github.dschreid.shop.server.dto.response;

import lombok.Data;

/**
 * Holds information about OrderItem
 *
 * @author dschreid
 */
@Data
public class OrderItemInformationResponse {
    private ItemInformationResponse item;
    private Long amount;
}
