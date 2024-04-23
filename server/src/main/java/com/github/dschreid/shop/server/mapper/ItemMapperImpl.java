package com.github.dschreid.shop.server.mapper;

import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemMapperImpl implements ItemMapper {
    @Override
    public ItemInformationResponse toInformation(Item item) {
        final ItemInformationResponse response = new ItemInformationResponse();
        response.setTitle(item.getTitle());
        response.setDescription(item.getDescription());
        response.setCategory(item.getCategory());
        response.setQuantity(item.getQuantity());
        response.setIconUrl(item.getIconUrl());
        response.setImageGallery(item.getImageGallery());
        response.setPrice(item.getPrice());
        return response;
    }

    @Override
    public Item fromInformation(ItemInformationResponse information) {
        final Item item = new Item();
        item.setTitle(information.getTitle());
        item.setDescription(information.getDescription());
        item.setCategory(information.getCategory());
        item.setQuantity(information.getQuantity());
        item.setIconUrl(information.getIconUrl());
        item.setImageGallery(information.getImageGallery());
        item.setPrice(information.getPrice());
        return item;
    }
}
