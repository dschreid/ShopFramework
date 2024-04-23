package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.exception.OrderNotFoundException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.service.OrderService;
import com.github.dschreid.shop.server.service.SessionService;
import com.github.dschreid.shop.server.api.OrderApi;
import com.github.dschreid.shop.server.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderApi {
    private final SessionService sessionService;
    private final OrderService orderService;

    @Autowired
    public OrderController(SessionService sessionService, OrderService orderService) {
        this.sessionService = sessionService;
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderInformationResponse> getOrder(String sessionToken, Long orderId) throws UnauthorizedAccessException, OrderNotFoundException {
        sessionService.authorize(sessionToken, Role.STAFF);
        OrderInformationResponse order = orderService.getOrder(orderId);
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<List<OrderInformationResponse>> getOrders(String sessionToken) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.STAFF);
        final List<OrderInformationResponse> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @Override
    public ResponseEntity<List<OrderInformationResponse>> getOrders(String sessionToken, Long userId) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.STAFF);
        final List<OrderInformationResponse> allOrders = orderService.getAllOrders(userId);
        return ResponseEntity.ok(allOrders);
    }

}
