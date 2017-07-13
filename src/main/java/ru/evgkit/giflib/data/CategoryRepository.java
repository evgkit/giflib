package ru.evgkit.giflib.data;

import org.springframework.stereotype.Component;
import ru.evgkit.giflib.model.Category;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "fun"),
            new Category(2, "drama"),
            new Category(3, "shit")
    );

    public Category findById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if (id == category.getId()) {
                return category;
            }
        }

        return null;
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}
