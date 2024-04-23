package com.github.dschreid.shop.server.dto.response;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * Holds information about an Item
 *
 * @author dschreid
 */
@Data
public class ItemInformationResponse {
    @NotEmpty private String title;
    @NotEmpty private String description;
    private String iconUrl;
    private String category;
    @Positive private double price;
    @PositiveOrZero private long quantity;
    private List<String> imageGallery;
}
