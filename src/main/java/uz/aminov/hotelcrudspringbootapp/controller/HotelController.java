package uz.aminov.hotelcrudspringbootapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.aminov.hotelcrudspringbootapp.dto.page.HotelPage;
import uz.aminov.hotelcrudspringbootapp.entity.Hotel;
import uz.aminov.hotelcrudspringbootapp.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<Page<Hotel>> getHotels(HotelPage hotelPage){
        return new ResponseEntity<>(hotelService.getHotels(hotelPage),  HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(Hotel hotel){
        return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.OK);
    }

}
