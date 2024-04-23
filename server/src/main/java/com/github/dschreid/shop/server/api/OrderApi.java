package com.github.dschreid.shop.server.api;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.exception.OrderNotFoundException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The interface Order api.
 *
 * @author dschreid
 */
@RequestMapping("/services/orders")
public interface OrderApi {

    /**
     * Gets order.
     *
     * @param sessionToken the session token
     * @param orderId      the order id
     * @return the order
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     * @throws OrderNotFoundException      the order not found exception
     */
    @GetMapping("/get/{order}")
    ResponseEntity<OrderInformationResponse> getOrder(@RequestHeader("session-token") String sessionToken, @PathVariable("order") Long orderId) throws UnauthorizedAccessException, OrderNotFoundException;

    /**
     * Gets orders.
     *
     * @param sessionToken the session token
     * @return the orders
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    @GetMapping("/all")
    ResponseEntity<List<OrderInformationResponse>> getOrders(@RequestHeader("session-token") String sessionToken) throws UnauthorizedAccessException;

    /**
     * Gets orders.
     *
     * @param sessionToken the session token
     * @param userId       the user id
     * @return the orders
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    @GetMapping("/all/user/{user}")
    ResponseEntity<List<OrderInformationResponse>> getOrders(@RequestHeader("session-token") String sessionToken, @PathVariable("user") Long userId) throws UnauthorizedAccessException;

}
