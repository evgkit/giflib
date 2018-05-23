package com.evgkit.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evgkit.giflib.dao.CategoryDao;
import com.evgkit.giflib.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryDao.findById(id);
        return category.orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {
        if (!category.getGifs().isEmpty()) {
            throw new CategoryNotEmptyException();
        }

        categoryDao.delete(category);
    }
}
