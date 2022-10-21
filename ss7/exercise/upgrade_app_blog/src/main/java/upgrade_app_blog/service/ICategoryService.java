package upgrade_app_blog.service;

import upgrade_app_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);

    void save(Category category);

    List<Category> findAll();
}
