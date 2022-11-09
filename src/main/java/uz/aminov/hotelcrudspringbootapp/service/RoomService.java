package uz.aminov.hotelcrudspringbootapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.aminov.hotelcrudspringbootapp.dto.page.RoomPage;
import uz.aminov.hotelcrudspringbootapp.entity.Hotel;
import uz.aminov.hotelcrudspringbootapp.entity.Room;
import uz.aminov.hotelcrudspringbootapp.repository.RoomRepository;

import java.util.Optional;

@Service
public class RoomService {
    final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Page<Room> getRooms(RoomPage roomPage){
        Sort sort = Sort.by(roomPage.getSortDirection(), roomPage.getSortBy());
        Pageable pageable = PageRequest.of(roomPage.getPageNumber(), roomPage.getPageSize(), sort);
        return roomRepository.findAll(pageable);
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElseThrow();
    }
}
