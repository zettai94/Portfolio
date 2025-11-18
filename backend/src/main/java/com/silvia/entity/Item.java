package com.silvia.entity;

import com.silvia.model.CafeItemType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name ="items")
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "menu_items")
    private Long itemID;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private CafeItemType type;

    @Column(name = "item_name")
    @NotNull(message = "Item name cannot be null")
    private String itemName;

    @Column(name ="item_price")
    @Positive(message = "Item price must be greater than 0")
    private Double itemPrice;

    //this is used to autolink tracked inventory items
    //one to one relationship; auto cascade when item is deleted
    //lazy fetch to avoid loading inventory data unless needed (beverage not tracked)
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Inventory inventory;

    //constructors in progress

    //custom setter for managing bi-directional relationship between Item and Inventory
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        if(inventory != null)
        {
            inventory.setMenuItem(this);
        }
    }
    
}
