package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.model.Item;

/**
 * ItemInformation to Item and vice-versa Mapper
 *
 * @author dschreid
 */
public interface ItemMapper {
    /**
     * To information item information response.
     *
     * @param item the item
     * @return the item information response
     */
    ItemInformationResponse toInformation(Item item);
    /**
     * From information item.
     *
     * @param information the information
     * @return the item
     */
    Item fromInformation(ItemInformationResponse information);
}
