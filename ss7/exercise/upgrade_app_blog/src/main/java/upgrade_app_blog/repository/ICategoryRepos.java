package upgrade_app_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upgrade_app_blog.model.Category;

public interface ICategoryRepos extends JpaRepository<Category,Integer> {
}
