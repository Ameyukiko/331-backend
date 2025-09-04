package se331.lab.dao;

import java.util.List;

import se331.lab.entity.Event;

public interface EventDao {
    Integer getEventSize();

    List<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);
}