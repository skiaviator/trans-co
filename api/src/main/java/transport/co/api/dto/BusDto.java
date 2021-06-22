package transport.co.api.dto;

import lombok.Data;
import transport.co.api.model.Bus;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BusDto {

    private long id;

    private String busModel;

    private String mark;

    private Date prodDate;

    private String avFuelConsumption;

    private boolean availability;

    private int capacity;

    public static BusDto from(Bus bus){
        BusDto busDto=new BusDto();
        busDto.setId(bus.getId());
        busDto.setBusModel(bus.getBusModel());
        busDto.setMark(bus.getMark());
        busDto.setProdDate(bus.getProdDate());
        busDto.setAvFuelConsumption(bus.getAvFuelConsumption());
        busDto.setAvailability(bus.isAvailability());
        busDto.setCapacity(bus.getCapacity());

        return busDto;
    }

    public static List<BusDto> fromList(List<Bus> buses) {
        List<BusDto> busDtos = buses.stream()
                .map(bus -> from(bus))
                .collect(Collectors.toList());
        return busDtos;
    }
}
