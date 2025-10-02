package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.DTO.*;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);
    OrganizerDTO getOrganizerDto(Organizer organizer);
    List<OrganizerDTO> getOrganizerDto(List<Organizer> organizers);

    // เพิ่ม mapping สำหรับ organizer
    EventOrgainzerDTO getEventOrgainzerDto(Organizer organizer);

    ParticipantDTO getParticipantDTO(Participant participant);

    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

    EventOrgainzerDTO getEventOrganizerDTO(Organizer organizer);

    EventNoParticipantDTO getEventNoParticipantDTO(Event event);

    List<EventNoParticipantDTO> getEventNoParticipantDTO(List<Event> event);

    @Mapping(target = "attendedEvents", source = "eventHistory")
    ParticipantEventDTO getParticipantEventDTO(Participant participant);

    List<ParticipantEventDTO> getParticipantEventDTO(List<Participant> participant);

}
