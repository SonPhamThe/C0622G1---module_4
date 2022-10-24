package listen_music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDTO implements Validator {
    private int id;

    private String name;

    private String performanceArtist;

    private String category;

    public SongDTO() {
    }

    public SongDTO(int id, String name, String performanceArtist, String category) {
        this.id = id;
        this.name = name;
        this.performanceArtist = performanceArtist;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformanceArtist() {
        return performanceArtist;
    }

    public void setPerformanceArtist(String performanceArtist) {
        this.performanceArtist = performanceArtist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
