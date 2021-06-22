package transport.co.api.request;

import lombok.Data;
import transport.co.api.dto.StopDto;
import transport.co.api.model.Stop;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StopRequest {
    private String name;

    public StopRequest(StopDto stopDto) {
        this.name=stopDto.getName();
    }

    public StopRequest() {
    }

    public static List<StopRequest> fromList(List<StopDto> stopDtos){
        // List<ReservationDto> reservationDtos = new ArrayList<>();

        List<StopRequest> stopRequests = stopDtos.stream()
                .map(stopDto -> new StopRequest(stopDto))
                .collect(Collectors.toList());
        return stopRequests;
    }
}
