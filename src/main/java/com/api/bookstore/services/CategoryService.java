package com.api.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Category;
import com.api.bookstore.exceptions.ObjectNotFoundException;
import com.api.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id); // use Optional because we can ou not find the object.
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with Id: " + id + " and type: " + Category.class.getName() + " not found"));
    }
}
