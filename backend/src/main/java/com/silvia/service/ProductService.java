package com.silvia.service;

import com.silvia.entity.Product;
import com.silvia.repository.ProductRepo;
import com.silvia.service.interfaces.ProductInterface;
import com.silvia.exceptions.ProductIDNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService implements ProductInterface{

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product getProductById(Long id)
    {
        return productRepo.findByProductId(id).orElseThrow(()-> new ProductIDNotFoundException(id));
    }

    @Override
    public List<Product> getProductsByCategory(String category)
    {
        return productRepo.findAllByCategory(category);
    }

    //search bar usage
    @Override
    public List<Product> getProductsByName(String name)
    {
        return productRepo.findByProductNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }

    @Override
    public CreateProductResponse createOrCheckProduct(Product newProduct)
    {
        Optional<Product> existing = productRepo.findByProductName(newProduct.getProductName());
        if(existing.isPresent())
        {
            return new CreateProductResponse("EXIST", existing.get());
            //to be handled in Controller 
        }
        //otherwise create new product
        Product saved = productRepo.save(newProduct);
        return new CreateProductResponse("CREATED", saved);
    }

    @Override
    public Product updateProduct(Long id, Product product)
    {
        Product exisitng = productRepo.findByProductId(id).orElseThrow(()-> new ProductIDNotFoundException(id));
        exisitng.setCategory(product.getCategory());
        exisitng.setProductName(product.getProductName());
        exisitng.setProductPrice(product.getProductPrice());
        return productRepo.save(exisitng);
    }

    @Override
    public void deleteProduct(Long id)
    {
        productRepo.deleteById(id);
    }

}