package se331.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se331.lab.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
}
