package com.api.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotEmpty(message = "Campo título é requerido")
    //@Length(min = 3, max = 50, message = "Campo título deve ter entre 3 e 100 caracteres")
    private String title;

    //@NotEmpty(message = "Campo author é requerido")
    //@Length(min = 3, max = 50, message = "Campo author deve ter entre 3 e 100 caracteres")
    private String author_name;

    //@NotEmpty(message = "Campo Nome é requerido")
    //@Length(min = 20, max = 2000000, message = "Campo nome deve ter entre 20 e 2000000 caracteres")
    private String text;

    @JsonIgnore // it ignores the category, we'll see just the "book", - protection about serialization.
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(int id, String title, String author_name, String text, Category category) {
        this.id = id;
        this.title = title;
        this.author_name = author_name;
        this.text = text;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
