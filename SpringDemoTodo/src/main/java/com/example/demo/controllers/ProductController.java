package com.example.demo.controllers;

import com.example.demo.dtos.APIResponse;
import com.example.demo.dtos.CreateProductRequestDto;
import com.example.demo.schema.Product;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Product>> getProductById(@PathVariable Long id){
        Product existedProduct = productService.getProductById(id);
        APIResponse<Product> response = new APIResponse<>();
        response.setData(existedProduct);
        response.setMessage("Product returned successfully");
        response.setSuccess(true);
        response.setError("");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response)
                ;

    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto);
    }
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> findByCategory(@RequestParam(value = "category", required = false) String category){
        return this.productService.findByCategory(category);
    }

    @GetMapping("/categories")
    public List<String> getAllCategory(){
        return this.productService.getAllCategory();
    }


}
