package se331.lab.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import se331.lab.DTO.EventDTO;
import se331.lab.DTO.EventNoParticipantDTO;
import se331.lab.DTO.EventOrganizerDTO;
import se331.lab.DTO.OrganizerAuthDTO;
import se331.lab.DTO.OrganizerDTO;
import se331.lab.DTO.ParticipantDTO;
import se331.lab.DTO.ParticipantWithEventDTO;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);

    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO getParticipantDTO(Participant participant);

    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

    EventOrganizerDTO getEventOrganizerDTO(Organizer organizer);

    EventNoParticipantDTO getEventNoParticipantDTO(Event event);

    List<EventNoParticipantDTO> getEventNoParticipantDTO(List<Event> event);

    ParticipantWithEventDTO getParticipantWithEventDTO(Participant participant);

    List<ParticipantWithEventDTO> getParticipantWithEventDTO(List<Participant> participant);

    @Mapping(target = "roles", source = "user.roles")
    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);
}
