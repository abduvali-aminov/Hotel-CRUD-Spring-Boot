package uz.aminov.hotelcrudspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.aminov.hotelcrudspringbootapp.dto.request.RoomDto;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Double size;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room(RoomDto roomDto, Hotel hotel){
        this.number = roomDto.getNumber();
        this.floor = roomDto.getFloor();
        this.size = roomDto.getSize();
        this.hotel = hotel;
    }
}
