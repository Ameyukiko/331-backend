package se331.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import se331.lab.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
}
