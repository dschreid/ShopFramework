package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.dto.response.OrderItemInformationResponse;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.model.Order;
import com.github.dschreid.shop.server.model.OrderItem;

/**
 * OrderItem to OrderInformation Mapper
 *
 * @author dschreid
 */
public interface OrderMapper {

    /**
     * From item order item.
     *
     * @param item   the item
     * @param amount the amount
     * @return the order item
     */
    OrderItem fromItem(Item item, long amount);
    /**
     * To information order information response.
     *
     * @param order the order
     * @return the order information response
     */
    OrderInformationResponse toInformation(Order order);
    /**
     * To information order item information response.
     *
     * @param orderItem the order item
     * @return the order item information response
     */
    OrderItemInformationResponse toInformation(OrderItem orderItem);
}
