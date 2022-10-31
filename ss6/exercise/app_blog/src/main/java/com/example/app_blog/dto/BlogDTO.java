package com.example.app_blog.dto;

import com.example.app_blog.model.Category;

public class BlogDTO {
    private int id;
    private String nameBlog;
    private String nameWriter;
    private String content;
    private String compositionDay;
    private int view;

    private Category category;

    public BlogDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getNameWriter() {
        return nameWriter;
    }

    public void setNameWriter(String nameWriter) {
        this.nameWriter = nameWriter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompositionDay() {
        return compositionDay;
    }

    public void setCompositionDay(String compositionDay) {
        this.compositionDay = compositionDay;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BlogDTO(int id, String nameBlog, String nameWriter, String content, String compositionDay, int view) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.nameWriter = nameWriter;
        this.content = content;
        this.compositionDay = compositionDay;
        this.view = view;
    }


}
