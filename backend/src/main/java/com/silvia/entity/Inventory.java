package com.silvia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_inven")
@Getter @Setter
public class Inventory {

    //create invenID that takes itemID as PK
    @Id
    @Column(name = "invenID")
    private Long invenID;

    @OneToOne
    @MapsId
    @JoinColumn(name = "itenID")
    @Column(name = "item")
    private Item item;

    @Column(name = "current_qty")
    @PositiveOrZero(message = "Inventory stock cannot be negative")
    private int inStock;
    
    public void setMenuItem(Item item) 
    {
        //to be implemented
    }
}
