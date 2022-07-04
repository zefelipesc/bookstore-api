package com.api.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bookstore.domain.Category;

@Repository // Layer that makes data access
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
