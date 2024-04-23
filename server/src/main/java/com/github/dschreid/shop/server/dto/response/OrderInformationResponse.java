package com.github.dschreid.shop.server.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Holds information about an Order
 *
 * @author dschreid
 */
@Data
public class OrderInformationResponse {
    private Long orderId;
    private List<OrderItemInformationResponse> items;
    private String timestamp;
}
