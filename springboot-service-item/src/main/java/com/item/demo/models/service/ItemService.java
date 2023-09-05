package com.item.demo.models.service;

import java.util.List;

import com.item.demo.models.Item;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer amount);
}
