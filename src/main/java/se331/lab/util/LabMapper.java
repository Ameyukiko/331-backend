package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.DTO.EventDTO;
import se331.lab.DTO.EventOrgainzerDTO;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);

    // เพิ่ม mapping สำหรับ organizer
    EventOrgainzerDTO getEventOrgainzerDto(Organizer organizer);
}
