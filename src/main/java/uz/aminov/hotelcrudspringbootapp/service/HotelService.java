package uz.aminov.hotelcrudspringbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.aminov.hotelcrudspringbootapp.dto.page.HotelPage;
import uz.aminov.hotelcrudspringbootapp.entity.Hotel;
import uz.aminov.hotelcrudspringbootapp.repository.HotelRepository;

@Service
public class HotelService {
    public final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Page<Hotel> getHotels(HotelPage hotelPage){
        Sort sort = Sort.by(hotelPage.getSortDirection(), hotelPage.getSortBy());
        Pageable pageable = PageRequest.of(hotelPage.getPageNumber(), hotelPage.getPageSize(), sort);
        return hotelRepository.findAll(pageable);
    }

    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
}
