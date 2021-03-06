package transport.co.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.model.Stop;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StopDto {

    private long id;
    private String name;

    private StopDto(Stop stop) {
        this.id=stop.getId();
        this.name=stop.getName();
    }

    public StopDto(long id,String name){
        this.id=id;
        this.name=name;
    }

    public StopDto() { }

    public static List<StopDto> fromList(List<Stop> stops){
        // List<ReservationDto> reservationDtos = new ArrayList<>();

        List<StopDto> stopDtos = stops.stream()
                .map(stop -> new StopDto(stop))
                .collect(Collectors.toList());
        return stopDtos;
    }
    public static StopDto from(Stop stop){
        StopDto stopDto=new StopDto();
        stopDto.setName(stop.getName());
        return stopDto;
    }

}
