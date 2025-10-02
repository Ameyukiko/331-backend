package se331.lab.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantWithEventDTO {
    Long id;
    String name;
    String telNo;
    List<EventNoParticipantDTO> eventHistory;
}
