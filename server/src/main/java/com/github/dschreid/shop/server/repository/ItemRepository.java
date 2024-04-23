package com.github.dschreid.shop.server.repository;

import com.github.dschreid.shop.server.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository that holds Items
 *
 * @author dschreid
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    /**
     * @param category the category
     * @return all items matching the category
     */
    List<Item> findAllByCategory(String category);
}
