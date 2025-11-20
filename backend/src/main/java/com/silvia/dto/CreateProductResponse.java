package com.silvia.dto;

import com.silvia.entity.Product;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CreateProductResponse {
    
    private String status;
    private Product product;
}