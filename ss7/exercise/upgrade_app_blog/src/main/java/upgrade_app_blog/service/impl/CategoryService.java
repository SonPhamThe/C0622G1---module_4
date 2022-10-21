package upgrade_app_blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgrade_app_blog.model.Category;
import upgrade_app_blog.repository.ICategoryRepos;
import upgrade_app_blog.service.ICategoryService;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepos categoryRepos;

    @Override
    public Category findById(int id) {
        return categoryRepos.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
       categoryRepos.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepos.findAll();
    }
}
