package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.SetAmountRequest;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.exception.ItemNotFoundException;
import com.github.dschreid.shop.server.mapper.ItemMapper;
import com.github.dschreid.shop.server.model.Item;
import com.github.dschreid.shop.server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.createDefault();
    }

    private void createDefault() {
        if (repository.count() != 0) return;

        final Item item = new Item();
        item.setTitle("example");
        item.setDescription("example");
        item.setCategory("example");
        item.setPrice(99999);
        item.setQuantity(0);
        repository.save(item);
    }

    @Override
    public Optional<Item> getItem(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ItemInformationResponse> getAll() {
        return repository.findAll().stream().map(mapper::toInformation).collect(Collectors.toList());
    }

    @Override
    public void addItem(Item item) {
        repository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void reduceAmounts(Map<Long, Integer> itemAndAmounts) {
        List<Item> toSafe = new ArrayList<>();

        itemAndAmounts.forEach((id, amount) -> {
            final Item item = getItem(id).orElse(null);
            assert item != null;
            item.setQuantity(item.getQuantity() - amount);
            toSafe.add(item);
        });

        repository.saveAll(toSafe);
    }

    @Override
    public Optional<ItemInformationResponse> getItemInfo(Long id) {
        return getItem(id).map(mapper::toInformation);
    }

    @Override
    public void setAmount(SetAmountRequest request) throws ItemNotFoundException {
        final Item item = getItem(request.getItemid()).orElseThrow(ItemNotFoundException::new);
        item.setQuantity(request.getNewAmount());
        repository.save(item);
    }
}
