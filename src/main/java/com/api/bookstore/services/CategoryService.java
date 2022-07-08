package com.api.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Category;
import com.api.bookstore.dtos.CategoryDTO;
import com.api.bookstore.exceptions.ObjectNotFoundException;
import com.api.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id); // use Optional because we can ou not find the object.
        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Object with Id: " + id + " and type: " + Category.class.getName() + " not found"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create (Category obj) {
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDto) {
        Category obj = findById(id);
        obj.setName(objDto.getName());
        obj.setDescription(objDto.getDescription());
        return categoryRepository.save(obj);
    }
}
