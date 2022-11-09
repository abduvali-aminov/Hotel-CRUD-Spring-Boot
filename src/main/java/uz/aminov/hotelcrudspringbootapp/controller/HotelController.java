package uz.aminov.hotelcrudspringbootapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.aminov.hotelcrudspringbootapp.dto.page.HotelPage;
import uz.aminov.hotelcrudspringbootapp.entity.Hotel;
import uz.aminov.hotelcrudspringbootapp.service.HotelService;

import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<Page<Hotel>> getHotels(@RequestParam Optional<Integer> pageNumber,
                                                 @RequestParam Optional<Integer> pageSize,
                                                 @RequestParam Optional<Sort.Direction> sortDirection,
                                                 @RequestParam Optional<String> sortBy){
        HotelPage hotelPage = new HotelPage();
        hotelPage.setPageNumber(pageNumber.orElse(new HotelPage().getPageNumber()));
        hotelPage.setPageSize(pageSize.orElse(new HotelPage().getPageSize()));
        hotelPage.setSortDirection(sortDirection.orElse(new HotelPage().getSortDirection()));
        hotelPage.setSortBy(sortBy.orElse(new HotelPage().getSortBy()));

        return new ResponseEntity<>(hotelService.getHotels(hotelPage),  HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.OK);
    }

}
