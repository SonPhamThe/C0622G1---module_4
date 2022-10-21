package upgrade_app_blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upgrade_app_blog.model.Blog;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog bloger);

    void remove(Blog bloger);
}
