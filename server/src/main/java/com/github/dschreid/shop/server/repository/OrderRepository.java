package com.github.dschreid.shop.server.repository;

import com.github.dschreid.shop.server.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository that holds Orders
 *
 * @author dschreid
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * @param user id of the user
     * @return list of all orders of this user
     */
    List<Order> findAllByUser(Long user);
}
