package com.example.demo;

import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Category;
import com.example.demo.schema.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.cache.ProductRedisCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductRedisCache productRedisCache;

    @InjectMocks
    private ProductService productService;

    @Test
    void getAllProducts(){
        // ARRANGE
        Product p1 = Product.builder().title("IPHONE 17")
                .price(BigDecimal.valueOf(20000))
                .category(new Category("ElELECTRONICS"))
                .build();
        Product p2 = Product.builder().title("WASHING MACHINE")
                .price(BigDecimal.valueOf(16000))
                .category(new Category("ElELECTRONICS"))
                .build();
        List<Product> expectedProducts = Arrays.asList(p1, p2);

        when(productRepository.findAll()).thenReturn(expectedProducts);

        // ACT
        List<Product> actualProducts = productService.getAllProducts();

        // ASSERT
        assertEquals(2, actualProducts.size());
        assertEquals("IPHONE 17", actualProducts.get(0).getTitle());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductByCorrectId(){

    }

    @Test
    void getProductByWrongId(){

    }

    @Test
    void createProduct(){

    }

    @Test
    void deleteProduct(){

    }











}
