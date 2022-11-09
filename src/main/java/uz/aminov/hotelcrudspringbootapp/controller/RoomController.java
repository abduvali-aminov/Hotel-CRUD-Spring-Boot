package uz.aminov.hotelcrudspringbootapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import uz.aminov.hotelcrudspringbootapp.dto.page.HotelPage;
import uz.aminov.hotelcrudspringbootapp.dto.page.RoomPage;
import uz.aminov.hotelcrudspringbootapp.dto.request.RoomDto;
import uz.aminov.hotelcrudspringbootapp.entity.Hotel;
import uz.aminov.hotelcrudspringbootapp.entity.Room;
import uz.aminov.hotelcrudspringbootapp.service.HotelService;
import uz.aminov.hotelcrudspringbootapp.service.RoomService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    final RoomService roomService;
    final HotelService hotelService;

    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public Page<Room> getRooms(@RequestParam Optional<Integer> pageNumber,
                               @RequestParam Optional<Integer> pageSize,
                               @RequestParam Optional<Sort.Direction> sortDirection,
                               @RequestParam Optional<String> sortBy){

        RoomPage roomPage = new RoomPage();
        roomPage.setPageNumber(pageNumber.orElse(new HotelPage().getPageNumber()));
        roomPage.setPageSize(pageSize.orElse(new HotelPage().getPageSize()));
        roomPage.setSortDirection(sortDirection.orElse(new HotelPage().getSortDirection()));
        roomPage.setSortBy(sortBy.orElse(new HotelPage().getSortBy()));

        return roomService.getRooms(roomPage);
    }

    @PostMapping
    public Room addRooms(@RequestBody RoomDto roomDto){
        Hotel hotel = hotelService.getHotelById(roomDto.getHotelId());
        Room room = new Room(roomDto, hotel);
        return roomService.addRoom(room);
    }

}
