package transport.co.api.dto;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.model.Customer;

import java.util.List;

@Getter
@Setter
public class CustomerDto extends PersonDto{


    private int points;
    private int notrealized;
    private List<ReservationDto> reservationDtoList;
    public CustomerDto(int points, int notrealized, List<ReservationDto> reservationDtoList) {
        this.points = points;
        this.notrealized = notrealized;
        this.reservationDtoList = reservationDtoList;
    }

    private CustomerDto(){}
    public static CustomerDto from(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());

        customerDto.setFirstname(customer.getFirstname());
        customerDto.setSurname(customer.getSurname());
        customerDto.setBirthdate(customer.getBirthdate());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhonenr(customer.getPhonenr());

        customerDto.setNotrealized(customer.getNotrealized());
        customerDto.setPoints(customer.getPoints());
        customerDto.setReservationDtoList(ReservationDto.fromList(customer.getReservations()));
        customerDto.setAddressDto(AddressDto.from(customer.getAddress()));
        return customerDto;
    }
}
