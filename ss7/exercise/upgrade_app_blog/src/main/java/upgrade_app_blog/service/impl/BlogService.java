package upgrade_app_blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upgrade_app_blog.model.Blog;
import upgrade_app_blog.repository.IBlogRepos;
import upgrade_app_blog.service.IBlogService;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepos blogRepos;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepos.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepos.findById(id).orElse(null);
    }

    @Override
    public void save(Blog bloger) {
        blogRepos.save(bloger);
    }

    @Override
    public void remove(Blog bloger) {
        blogRepos.delete(bloger);
    }
}
