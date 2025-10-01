package se331.lab.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.lab.entity.Organizer;

public interface OrganizerDao {
    Integer getOrganizerSize();

    Page<Organizer> getOrganizers(Integer pageSize, Integer page);

    Page<Organizer> getOrganizers(Pageable pageRequest);

    Optional<Organizer> findById(Long id);

    Organizer getOrganizer(Long id);

    Organizer save(Organizer organizer);
}
