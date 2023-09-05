package com.item.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.item.demo.models.Item;
import com.item.demo.models.service.ItemService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item>list(){
        return itemService.findAll();
    }

    @GetMapping("/{id}/{amount}")
    public Item detail(@PathVariable Long id, @PathVariable Integer amount){
        return itemService.findById(id, amount);
    }

}
