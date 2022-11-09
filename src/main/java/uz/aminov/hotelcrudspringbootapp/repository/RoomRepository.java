package uz.aminov.hotelcrudspringbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.aminov.hotelcrudspringbootapp.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
