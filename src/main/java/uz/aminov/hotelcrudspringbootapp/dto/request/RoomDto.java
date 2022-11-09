package uz.aminov.hotelcrudspringbootapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoomDto {
    private Integer number;

    private Integer floor;

    private Double size;

    private Long hotelId;
}
