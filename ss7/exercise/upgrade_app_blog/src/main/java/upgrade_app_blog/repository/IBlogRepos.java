package upgrade_app_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import upgrade_app_blog.model.Blog;

    public interface IBlogRepos extends JpaRepository<Blog, Integer> {
}
