package com.github.dschreid.shop.server.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Model for Order item.
 *
 * @author dschreid
 */
@Entity
@Data
@Table(name = "order_items")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    @PrimaryKeyJoinColumn()
    private Order order;

    @ManyToOne
    @JoinColumn
    private Item item;

    @Column
    private Long amount;
}
