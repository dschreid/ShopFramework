package com.github.dschreid.shop.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Model for Item.
 *
 * @author dschreid
 */
@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Column private String title;
    @Column private String description;
    @Column private String iconUrl;
    @Column private String category;
    @Column private double price;
    @Column private long quantity;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> imageGallery;
}
