package com.silvia.service;
package com.silvia.service.interfaces;

import com.silvia.entity.Item;
import com.silvia.repository.ItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MenuItemService implements ItemInterface{

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    /*  general usage:
        * get by itemID
        * get by category
        * get by name
        * view all
    */ 


    /* specifically admin usage:
        * add new item
        * update item
        * delete item
    */
}