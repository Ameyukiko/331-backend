package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.DTO.EventDTO;
import se331.lab.entity.Event;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);
}
