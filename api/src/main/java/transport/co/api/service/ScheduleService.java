package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.model.Customer;
import transport.co.api.model.Schedule;
import transport.co.api.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule getSingleSchedule(long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }
}
