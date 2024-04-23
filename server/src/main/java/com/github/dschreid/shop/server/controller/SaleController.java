package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.exception.*;
import com.github.dschreid.shop.server.service.SaleService;
import com.github.dschreid.shop.server.service.SessionService;
import com.github.dschreid.shop.server.api.SaleApi;
import com.github.dschreid.shop.server.dto.request.BuyRequest;
import com.github.dschreid.shop.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController implements SaleApi {
    private final SaleService service;
    private final SessionService sessionService;

    @Autowired
    public SaleController(SaleService service, SessionService sessionService) {
        this.service = service;
        this.sessionService = sessionService;
    }

    @Override
    public ResponseEntity<Boolean> buy(String token, BuyRequest buyRequest) throws InsufficientStockException, InsufficientBalanceException, InvalidShoppingCartException, UnauthorizedAccessException, ItemNotFoundException {
        final User user = sessionService.authorize(token);
        return ResponseEntity.ok(service.buy(user, buyRequest));
    }

}
