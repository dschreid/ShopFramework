package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.dto.request.SetAmountRequest;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.service.ItemService;
import com.github.dschreid.shop.server.service.SessionService;
import com.github.dschreid.shop.server.api.ItemApi;
import com.github.dschreid.shop.server.mapper.ItemMapper;
import com.github.dschreid.shop.server.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController implements ItemApi {
    private final SessionService sessionService;
    private final ItemService itemService;
    private final ItemMapper mapper;

    @Autowired
    public ItemController(SessionService sessionService, ItemService itemService, ItemMapper mapper) {
        this.sessionService = sessionService;
        this.itemService = itemService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<ItemInformationResponse>> getAll(String sessionToken) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.GUEST);
        return ResponseEntity.ok(itemService.getAll());
    }

    @Override
    public ResponseEntity<ItemInformationResponse> get(String sessionToken, Long id) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.GUEST);
        final Optional<ItemInformationResponse> itemInfo = itemService.getItemInfo(id);
        return ResponseEntity.ok(itemInfo.orElse(null));
    }

    @Override
    public ResponseEntity<Boolean> add(String sessionToken, ItemInformationResponse item) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.STAFF);
        itemService.addItem(mapper.fromInformation(item));
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> setAmount(String sessionToken, SetAmountRequest request) throws UnauthorizedAccessException, ItemNotFoundException {
        sessionService.authorize(sessionToken, Role.STAFF);
        itemService.setAmount(request);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(String sessionToken, Long id) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.STAFF);
        itemService.deleteItem(id);
        return ResponseEntity.ok(true);
    }

}
