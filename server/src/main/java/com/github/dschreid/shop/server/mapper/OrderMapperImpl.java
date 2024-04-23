package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.OrderInformationResponse;
import com.github.dschreid.shop.server.dto.response.OrderItemInformationResponse;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.model.Order;
import com.github.dschreid.shop.server.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class OrderMapperImpl implements OrderMapper {
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat();
    private final ItemMapper itemMapper;

    @Autowired
    public OrderMapperImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public OrderItem fromItem(Item item, long amount) {
        final OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setAmount(amount);
        return orderItem;
    }

    @Override
    public OrderInformationResponse toInformation(Order order) {
        final OrderInformationResponse result = new OrderInformationResponse();
        final Date date = new Date(order.getTimestamp());

        result.setTimestamp(DATE_FORMATTER.format(date));
        result.setOrderId(order.getOrderId());
        result.setItems(order.getItems().stream().map(this::toInformation).collect(Collectors.toList()));
        return result;
    }

    @Override
    public OrderItemInformationResponse toInformation(OrderItem orderItem) {
        final OrderItemInformationResponse result = new OrderItemInformationResponse();
        result.setItem(itemMapper.toInformation(orderItem.getItem()));
        result.setAmount(orderItem.getAmount());
        return result;
    }

}
