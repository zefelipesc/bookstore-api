package com.api.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.api.bookstore.domain.Category;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo Nome é requerido")
    @Length(min = 3, max = 100, message = "Campo nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotEmpty(message = "Campo Descrição é requerido")
    @Length(min = 3, max = 200, message = "Campo Descrição deve ter entre 3 e 100 caracteres")
    private String description;

    public CategoryDTO() {

    }

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
