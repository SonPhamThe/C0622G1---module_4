package on_tap.repository;

import on_tap.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
