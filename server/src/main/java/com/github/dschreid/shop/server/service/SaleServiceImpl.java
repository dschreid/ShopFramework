package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.BuyRequest;
import com.github.dschreid.shop.server.exception.InsufficientBalanceException;
import com.github.dschreid.shop.server.exception.InsufficientStockException;
import com.github.dschreid.shop.server.exception.InvalidShoppingCartException;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.model.Order;
import com.github.dschreid.shop.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SaleServiceImpl implements SaleService {
    private final ReentrantLock lock = new ReentrantLock();
    private final UserService userService;
    private final ItemService itemService;
    private final OrderService orderService;

    @Autowired
    public SaleServiceImpl(UserService userService, ItemService itemService, OrderService orderService) {
        this.userService = userService;
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @Override
    public boolean buy(User user, BuyRequest buyRequest) throws InvalidShoppingCartException, ItemNotFoundException, InsufficientBalanceException, InsufficientStockException {
        try {
            validateShoppingCart(buyRequest);
            lock.lock();

            final Order order = orderService.createOrder(user);

            double totalSum = 0;
            final Map<Long, Integer> shoppingCart = buyRequest.getShoppingCart();
            for (Long itemId : shoppingCart.keySet()) {
                final Item item = itemService.getItem(itemId).orElseThrow(ItemNotFoundException::new);
                final Integer amount = shoppingCart.get(itemId);
                if (item.getQuantity() < amount) throw new InsufficientStockException();
                totalSum += item.getPrice() * amount;

                orderService.addToOrder(order, item, amount);
            }

            userService.reduceBalance(user, totalSum);
            itemService.reduceAmounts(shoppingCart);
            orderService.saveOrder(order);
            return true;
        } finally {
            lock.unlock();
        }
    }

    private void validateShoppingCart(BuyRequest request) throws InvalidShoppingCartException {
        final Map<Long, Integer> shoppingCart = request.getShoppingCart();
        if (shoppingCart.isEmpty()) throw new InvalidShoppingCartException();
        for (Long key : shoppingCart.keySet()) {
            if (shoppingCart.get(key) < 1) {
                throw new InvalidShoppingCartException();
            }
        }
    }
}
