package com.example.demo;

import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;//create actual object and injects mock of the dependencies

    @Test
    void createCategory_savesAndReturnCategory(){

    }

    @Test
    void getCategoryById_whenFound_returnsCategory(){

    }

    @Test
    void getCategoryById_whenNotFound_throwsResourceNotFound(){

    }

}


