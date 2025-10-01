package se331.lab.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    // @GetMapping("organizers")
    // public ResponseEntity<?> getOrganizerList(@RequestParam(value = "_limit",
    // required = false) Integer perPage,
    // @RequestParam(value = "_page", required = false) Integer page) {
    // Page<Organizer> pageOutput = organizerService.getOrganizers(perPage, page);

    // HttpHeaders responseHeaders = new HttpHeaders();
    // responseHeaders.set("x-total-count",
    // String.valueOf(pageOutput.getTotalElements()));
    // return new ResponseEntity<>(pageOutput.getContent(), responseHeaders,
    // HttpStatus.OK);
    // }

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDto(organizerService.getAllOrganizers()));
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);

        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> addEntity(@RequestBody Organizer organizer) {
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(output);
    }
}
