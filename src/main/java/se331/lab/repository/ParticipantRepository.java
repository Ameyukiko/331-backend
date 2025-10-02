package se331.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAll();
}
