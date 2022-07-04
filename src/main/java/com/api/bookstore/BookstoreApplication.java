package com.api.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.bookstore.domain.Book;
import com.api.bookstore.domain.Category;
import com.api.bookstore.repositories.BookRepository;
import com.api.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	// The layer that makes data persistence is th repository layer, so we have to add here using @Autowired notation.
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Every time that we started the application the code inside this method will run.
	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(0, "Development", "Books about programming");
		Book book1 = new Book(0, "Clean code", "Robert Martin", "Lorem ipsum", category1);

		category1.getBooks().addAll(Arrays.asList(book1));

		// Saving in database
		this.categoryRepository.saveAll(Arrays.asList(category1));
		this.bookRepository.saveAll(Arrays.asList(book1));
	}
}
