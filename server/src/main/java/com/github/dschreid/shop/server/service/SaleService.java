package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.BuyRequest;
import com.github.dschreid.shop.server.exception.InsufficientBalanceException;
import com.github.dschreid.shop.server.exception.InsufficientStockException;
import com.github.dschreid.shop.server.exception.InvalidShoppingCartException;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.model.User;

/**
 * Contains Buy Method
 *
 * @author dschreid
 */
public interface SaleService {
    /**
     * Attempts to buy all items inside the buyRequests shopping cart
     *
     * @param user       the user
     * @param buyRequest the buy request
     * @return true if successful
     * @throws InsufficientStockException   If there is insufficient quantity of a product in the shopping list
     * @throws InsufficientBalanceException If the user doesn't have enough credits
     * @throws InvalidShoppingCartException If there is an error with the provided shopping card
     * @throws ItemNotFoundException        If any requested item in the shopping card was not found
     */
    boolean buy(User user, BuyRequest buyRequest) throws InvalidShoppingCartException, ItemNotFoundException, InsufficientBalanceException, InsufficientStockException;
}
