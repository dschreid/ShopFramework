package com.github.dschreid.shop.server.api;

import com.github.dschreid.shop.server.dto.request.SetAmountRequest;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The interface Item api.
 *
 * @author dschreid
 */
@RequestMapping("/services/item")
public interface ItemApi {
    /**
     * Gets all items
     *
     * @param sessionToken the session token
     * @return the all
     * @throws UnauthorizedAccessException if the user is not logged in
     */
    @GetMapping("/all")
    ResponseEntity<List<ItemInformationResponse>> getAll(@RequestHeader("session-token") String sessionToken) throws UnauthorizedAccessException;

    /**
     * Find an Item by its id
     *
     * @param sessionToken the session token
     * @param id           the id
     * @return response dto
     * @throws UnauthorizedAccessException if the user is not logged in
     */
    @GetMapping("/{item}")
    ResponseEntity<ItemInformationResponse> get(@RequestHeader("session-token") String sessionToken, @PathVariable("item") Long id) throws UnauthorizedAccessException;

    /**
     * Add an item to the inventory
     *
     * @param sessionToken the session token
     * @param item         the item
     * @return response dto
     * @throws UnauthorizedAccessException if the user is not logged in
     */
    @PostMapping("/add")
    ResponseEntity<Boolean> add(@RequestHeader("session-token") String sessionToken, @Valid @RequestBody ItemInformationResponse item) throws UnauthorizedAccessException;

    /**
     * Sets the amount/quantity of an item
     *
     * @param sessionToken the session token
     * @param request      the request
     * @return the amount
     * @throws UnauthorizedAccessException if the user is not logged in
     * @throws ItemNotFoundException       if the item was not found
     */
    @PostMapping("/amount")
    ResponseEntity<Boolean> setAmount(@RequestHeader("session-token") String sessionToken, @Valid @RequestBody SetAmountRequest request) throws UnauthorizedAccessException, ItemNotFoundException;

    /**
     * Delete an item by its id.
     *
     * @param sessionToken the session token
     * @param id           the id
     * @return response dto
     * @throws UnauthorizedAccessException if the user is not logged in
     */
    @DeleteMapping("/delete/{item}")
    ResponseEntity<Boolean> delete(@RequestHeader("session-token") String sessionToken, @PathVariable("item") Long id) throws UnauthorizedAccessException;

}
