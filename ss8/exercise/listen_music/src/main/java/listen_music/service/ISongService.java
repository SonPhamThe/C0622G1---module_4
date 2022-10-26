package listen_music.service;

import listen_music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> displayAll(Pageable pageable);

    void save(Song song);

    Song findById(int id);
}
