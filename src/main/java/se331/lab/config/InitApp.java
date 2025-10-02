package se331.lab.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;
import se331.lab.rest.user.Role;
import se331.lab.rest.user.User;
import se331.lab.rest.user.UserRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());
        Event tempEvent;

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        Participant participant1 = participantRepository.save(Participant.builder()
                .name("Michael Scott")
                .telNo("0991234567")
                .build());

        Participant participant2 = participantRepository.save(Participant.builder()
                .name("Pam Beesly")
                .telNo("0982345678")
                .build());

        Participant participant3 = participantRepository.save(Participant.builder()
                .name("Jim Halpert")
                .telNo("0973456789")
                .build());

        Participant participant4 = participantRepository.save(Participant.builder()
                .name("Dwight Schrute")
                .telNo("0964567890")
                .build());

        Participant participant5 = participantRepository.save(Participant.builder()
                .name("Stanley Hudson")
                .telNo("0955678901")
                .build());

        Event midtermExam = eventRepository.findById(1L).orElse(null);
        midtermExam.getParticipants().add(participant1);
        midtermExam.getParticipants().add(participant2);
        midtermExam.getParticipants().add(participant3);

        participant1.getEventHistory().add(midtermExam);
        participant2.getEventHistory().add(midtermExam);
        participant3.getEventHistory().add(midtermExam);

        Event commencementDay = eventRepository.findById(2L).orElse(null);
        commencementDay.getParticipants().add(participant1);
        commencementDay.getParticipants().add(participant2);
        commencementDay.getParticipants().add(participant3);

        participant1.getEventHistory().add(commencementDay);
        participant2.getEventHistory().add(commencementDay);
        participant3.getEventHistory().add(commencementDay);

        Event loyKrathong = eventRepository.findById(3L).orElse(null);
        loyKrathong.getParticipants().add(participant1);
        loyKrathong.getParticipants().add(participant2);
        loyKrathong.getParticipants().add(participant3);

        participant1.getEventHistory().add(loyKrathong);
        participant2.getEventHistory().add(loyKrathong);
        participant3.getEventHistory().add(loyKrathong);

        Event songkran = eventRepository.findById(4L).orElse(null);
        songkran.getParticipants().add(participant1);
        songkran.getParticipants().add(participant4);
        songkran.getParticipants().add(participant5);

        participant1.getEventHistory().add(songkran);
        participant4.getEventHistory().add(songkran);
        participant5.getEventHistory().add(songkran);

        // Remember to comment addUser() everytime a database is change
        addUser();
        org1.setUser(user1);
        user1.setOrganizer(org1);
        org2.setUser(user2);
        user2.setOrganizer(org2);
        org3.setUser(user3);
        user3.setOrganizer(org3);
    }

    User user1, user2, user3;

    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .build();

        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disabled@user.com")
                .enabled(false)
                .build();

        user1.getRoles().add(Role.ROLE_USER);
        user1.getRoles().add(Role.ROLE_ADMIN);

        user2.getRoles().add(Role.ROLE_USER);
        user3.getRoles().add(Role.ROLE_USER);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
