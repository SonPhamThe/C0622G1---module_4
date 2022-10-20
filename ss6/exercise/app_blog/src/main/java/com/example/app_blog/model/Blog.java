package com.example.app_blog.model;

import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBlog;
    private String nameWriter;
    private String content;
    private String compositionDay;
    private int view;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
