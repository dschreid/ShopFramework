package com.github.dschreid.shop.server.api;

import com.github.dschreid.shop.server.exception.*;
import com.github.dschreid.shop.server.dto.request.BuyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * The interface Sale api.
 *
 * @author dschreid
 */
@RequestMapping("/services/sale")
public interface SaleApi {
    /**
     * Buys an item.
     *
     * @param token      user session token
     * @param buyRequest the buy request
     * @return response dto
     * @throws InsufficientStockException   If there is insufficient quantity of a product in the shopping list
     * @throws InsufficientBalanceException If the user doesn't have enough credits
     * @throws InvalidShoppingCartException If there is an error with the provided shopping card
     * @throws UnauthorizedAccessException  If the user is not logged in
     * @throws ItemNotFoundException        If any requested item in the shopping card was not found
     */
    @PostMapping("/buy")
    ResponseEntity<Boolean> buy(@RequestHeader("session-token") String token, @Valid @RequestBody BuyRequest buyRequest) throws InsufficientStockException, InsufficientBalanceException, InvalidShoppingCartException, UnauthorizedAccessException, ItemNotFoundException;
}
