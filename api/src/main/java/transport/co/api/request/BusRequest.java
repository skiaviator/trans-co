package transport.co.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class BusRequest {

    private String busModel;

    private String mark;

    private Date prodDate;

    private String avFuelConsumption;

    private boolean availability;

    private int capacity;
}
