package com.api.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Book;
import com.api.bookstore.domain.Category;
import com.api.bookstore.exceptions.ObjectNotFoundException;
import com.api.bookstore.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id) {
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Object with Id: " + id + " and type: " + Category.class.getName() + " not found"));
    }

    public List<Book> findAll(Integer id_cat) {
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj, obj);
        return bookRepository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor_name(obj.getAuthor_name());
        newObj.setText(obj.getText());
    }

    public Book create(Integer id_cat, Book obj) {
        obj.setId(null);
        Category category = categoryService.findById(id_cat);
        obj.setCategory(category);
        return bookRepository.save(obj);
    }

    public void delete(Integer id) {
        Book obj = findById(id);
        bookRepository.delete(obj);
    }
}
