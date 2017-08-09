package ru.evgkit.giflib.service;

import ru.evgkit.giflib.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Category category);
}
