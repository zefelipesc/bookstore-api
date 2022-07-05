package com.api.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Book;
import com.api.bookstore.domain.Category;
import com.api.bookstore.repositories.BookRepository;
import com.api.bookstore.repositories.CategoryRepository;

@Service
public class DBServices {
    // The layer that makes data persistence is the repository layer, so we have to add here using @Autowired notation.
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    //
    public void instantiateDataBase(){
        Category category1 = new Category(null, "Development", "Books about programming");
        Category category2 = new Category(null, "SCI-FI", "Books about Science fiction");
        Category category3 = new Category(null, "Fantasy", "Books about mythical creatures");
        Category category4 = new Category(null, "Romance", "Books about lovers");

        Book book1 = new Book(0, "Clean code", "Robert Martin", "Lorem ipsum", category1);
        Book book2 = new Book(0, "War of the Worlds", "George Orwell", "Lorem ipsum", category1);
        Book book3 = new Book(0, "Lord of the Rings", "JRR Tolkien", "Lorem ipsum", category1);
        Book book4 = new Book(0, "Jane Eyre", "Emma Bronte", "Lorem ipsum", category1);

        category1.getBooks().addAll(Arrays.asList(book1, book2, book3, book4));

        // Saving in database
        this.categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4));
        this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
    }
}
