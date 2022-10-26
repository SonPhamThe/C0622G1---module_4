
package listen_music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class SongDTO implements Validator {
    private int id;

    @NotEmpty(message = "Không được để trống vùng này")
    private String name;

    @NotEmpty(message = "Không được để trống vùng này")
    private String performanceArtist;

    @NotEmpty(message = "Không được để trống vùng này")
    private String category;

    public SongDTO() {
    }

    public SongDTO( String name, String performanceArtist, String category) {
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
        SongDTO songDTO = (SongDTO) target;
        if (!songDTO.getName().matches("[\\w+\\s*]{1,800}") && !songDTO.getName().equals("")) {
            errors.rejectValue("name", "name.validation", "Không đúng định dạng");
        }
        if (!songDTO.getPerformanceArtist().matches("[\\w+\\s*]{1,300}") && !songDTO.getPerformanceArtist().equals("")) {
            errors.rejectValue("performanceArtist", "performanceArtist.validation", "Không đúng định dạng");
        }
        if (!songDTO.getCategory().matches("[\\w+\\s*\\,*]{1,1000}") && !songDTO.getCategory().equals("")) {
            errors.rejectValue("category", "category.validation", "Không đúng định dạng");
        }
    }
}
