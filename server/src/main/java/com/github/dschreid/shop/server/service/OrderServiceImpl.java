package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.exception.OrderNotFoundException;
import com.github.dschreid.shop.server.mapper.OrderMapper;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.model.Order;
import com.github.dschreid.shop.server.model.User;
import com.github.dschreid.shop.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Order createOrder(User user) {
        final Order order = new Order();
        order.setUser(user);
        order.setProcessed(false);
        order.setTimestamp(System.currentTimeMillis());
        order.setItems(new HashSet<>());
        return order;
    }

    @Override
    public void saveOrder(Order order) {
        repository.save(order);
    }

    @Override
    public void addToOrder(Order order, Item item, int amount) {
        order.getItems().add(mapper.fromItem(item, amount));
    }

    @Override
    public OrderInformationResponse getOrder(Long id) throws OrderNotFoundException {
        return repository.findById(id).map(mapper::toInformation).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<OrderInformationResponse> getAllOrders() {
        return repository.findAll().stream().map(mapper::toInformation).collect(Collectors.toList());
    }

    @Override
    public List<OrderInformationResponse> getAllOrders(Long userId) {
        return repository.findAllByUser(userId).stream().map(mapper::toInformation).collect(Collectors.toList());
    }
}
