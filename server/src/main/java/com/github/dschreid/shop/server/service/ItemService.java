package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.SetAmountRequest;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.model.Item;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Contains Methods to interact with items
 *
 * @author dschreid
 */
public interface ItemService {
    /**
     * Gets item by its id.
     *
     * @param id the id
     * @return the item
     */
    Optional<Item> getItem(Long id);
    /**
     * Gets all items.
     *
     * @return the all
     */
    List<ItemInformationResponse> getAll();
    /**
     * Gets item info by id.
     *
     * @param id the id
     * @return the item info
     */
    Optional<ItemInformationResponse> getItemInfo(Long id);
    /**
     * @param item Item without a proper id
     */
    void addItem(Item item);
    /**
     * @param id the item id
     */
    void deleteItem(Long id);
    /**
     * Reduce amounts of items in this shopping cart.
     *
     * @param shoppingCart the shopping cart > ItemId, Amount
     */
    void reduceAmounts(Map<Long, Integer> shoppingCart);
    /**
     * @param request the request
     * @throws ItemNotFoundException if the item was not found
     */
    void setAmount(SetAmountRequest request) throws ItemNotFoundException;
}
