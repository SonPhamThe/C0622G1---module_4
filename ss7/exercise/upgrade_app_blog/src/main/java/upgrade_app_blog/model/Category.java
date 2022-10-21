package upgrade_app_blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCategory;

    private String name;

    public Category() {
    }

    public Category(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    @OneToMany(mappedBy = "category1")
    private Set<Blog> blogs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}


