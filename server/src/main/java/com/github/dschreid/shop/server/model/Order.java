package com.github.dschreid.shop.server.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Model for Order.
 *
 * @author dschreid
 */
@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinColumn
    private Set<OrderItem> items;

    @Column private long timestamp;
    @Column private boolean processed;
}
