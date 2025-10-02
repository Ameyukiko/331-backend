package se331.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import se331.lab.service.ParticipantService;
import se331.lab.util.LabMapper;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("participants")
    public ResponseEntity<?> getParticipants() {
        return ResponseEntity
                .ok(LabMapper.INSTANCE.getParticipantEventDTO(participantService.getAllParticipants()));
    }

}

