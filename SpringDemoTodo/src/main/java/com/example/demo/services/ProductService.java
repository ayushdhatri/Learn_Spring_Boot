package com.example.demo.services;

import com.example.demo.dtos.CreateProductRequestDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class ProductService {

    // Best Practice Tip: Make injected fields 'private' instead of 'public'
    // to maintain encapsulation!
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public Product createProduct(CreateProductRequestDto createProductRequestDto){
        // here we need to map createProductRequestDTO to Product using model mapper or manually
        Product product1 = Product.builder()
                .title(createProductRequestDto.getTitle())
                .price(createProductRequestDto.getPrice())
                //.category(createProductRequestDto.getCategory()) TODO
                .build();
        this.productRepository.save(product1);
        // actually we should sent a productResponseDTO but we are sending raw data
        return product1;
    }

    public boolean deleteProduct(Long id){
        this.productRepository.deleteById(id);
        return true;
    }

    public List<Product> findByCategory(String category){
        return this.productRepository.findByCategory(category);
    }

    public List<String> getAllCategory(){
        return this.productRepository.findDistinctCategory();
    }
}
