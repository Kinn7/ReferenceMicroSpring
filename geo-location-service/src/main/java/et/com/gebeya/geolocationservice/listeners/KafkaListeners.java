package et.com.gebeya.geolocationservice.listeners;

import et.com.gebeya.geolocationservice.dto.AddLocationDto;
import et.com.gebeya.geolocationservice.dto.DeleteLocationDto;
import et.com.gebeya.geolocationservice.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static et.com.gebeya.geolocationservice.util.Constant.ADD_LOCATION_TOPIC;
import static et.com.gebeya.geolocationservice.util.Constant.DELETE_LOCATION_TOPIC;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListeners {

private final LocationService locationService;


    @KafkaListener(topics = ADD_LOCATION_TOPIC, groupId = "group2", containerFactory = "addLocationListenerFactory")
    void addLocationDtoListener(AddLocationDto dto) {
        log.info(dto.toString());
        locationService.addLocation(dto);
    }

    @KafkaListener(topics = DELETE_LOCATION_TOPIC, groupId = "group3", containerFactory = "deleteLocationListenerFactory")
    void deleteLocationDtoListener(DeleteLocationDto dto) {
        log.info(dto.toString());
        locationService.deleteLocation(dto);
    }
}


