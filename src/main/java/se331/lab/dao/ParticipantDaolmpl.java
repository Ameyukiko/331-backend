package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {

    final ParticipantRepository participantRepository;

    @Override
    public Page<Participant> getParticipants(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }
}
