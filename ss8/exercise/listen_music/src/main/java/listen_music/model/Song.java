package listen_music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String performanceArtist;

    private String category;

    public Song() {
    }

    public Song(int id, String name, String performanceArtist, String category) {
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
}
