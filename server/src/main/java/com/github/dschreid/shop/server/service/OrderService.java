package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.exception.OrderNotFoundException;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.model.Order;
import com.github.dschreid.shop.server.model.User;

import java.util.List;

/**
 * Contains Methods to interact with orders
 *
 * @author dschreid
 */
public interface OrderService {
    /**
     * Create a temporary order, must be persisted using {@link #saveOrder(Order)}
     *
     * @param user the user
     * @return the order
     */
    Order createOrder(User user);
    /**
     * Saves an order to the database.
     *
     * @param order the order
     */
    void saveOrder(Order order);
    /**
     * Adds an item to an existing order, without persisting the change immediately
     *
     * @param order  the order
     * @param item   the item
     * @param amount the amount
     */
    void addToOrder(Order order, Item item, int amount);
    /**
     * Gets order by it's id.
     *
     * @param id the id
     * @return the order
     * @throws OrderNotFoundException the order not found exception
     */
    OrderInformationResponse getOrder(Long id) throws OrderNotFoundException;
    /**
     * Gets all orders.
     *
     * @return the all orders
     */
    List<OrderInformationResponse> getAllOrders();
    /**
     * Gets all orders associated with the user.
     *
     * @param user the userId
     * @return the all orders
     */
    List<OrderInformationResponse> getAllOrders(Long user);
}
