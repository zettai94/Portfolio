package com.silvia.service;

import com.silvia.entity.Item;
import com.silvia.repository.ItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MenuItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    // customer usage
    

    // admin usage
}