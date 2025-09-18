package se331.lab.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.querydsl.QPageRequest;
import se331.lab.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();

    Page<Event> findByTitle(String title, Pageable PageRequest);

    Page<Event> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable PageRequest);

    Page<Event> findByTitleContainingOrDescriptionContainingOrOrganizerContaining(String title, String description, String organizerName, Pageable pageRequest);
}