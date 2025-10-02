package se331.lab.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.DTO.EventNoParticipantDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantEventDTO {
    Long id;
    String name;
    String telNo;
    List<EventNoParticipantDTO> eventHistory;
}
