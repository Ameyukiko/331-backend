package se331.lab.service;

import java.util.List;

import se331.lab.entity.Organizer;

public interface OrganizerService {
    Integer getOrganizerSize();

    List<Organizer> getOrganizers(Integer pageSize, Integer page);

    Organizer getOrganizer(Long id);
}
