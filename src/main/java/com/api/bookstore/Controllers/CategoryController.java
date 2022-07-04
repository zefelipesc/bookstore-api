package com.api.bookstore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bookstore.domain.Category;
import com.api.bookstore.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") // localhost:8080/categories/1
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
