package transport.co.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDto extends PersonDto{


    private int points;
    private int notrealized;
    private List<ReservationDto> reservationDtoList;

}
