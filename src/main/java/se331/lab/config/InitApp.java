package se331.lab.config;

import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer(org1)
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
                .organizer(org1)
                .build());


        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer(org1)
                .build());


        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("CAMT Open House 2025")
                .description("Explore Software Engineering, UX, AI, and more at CAMT CMU")
                .location("Chiang Mai University - CAMT Building")
                .date("20th November")
                .time("9.00 am - 4.00 pm")
                .petAllowed(false)
                .organizer(org1)
                .build());

        organizerRepository.save(Organizer.builder()
                .name("OpenAI Research")
                .address("San Francisco, CA 94110")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Tech Valley Solutions")
                .address("123 Innovation Drive, Austin, TX 73301")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("MicroApple Inc.")
                .address("Redwood Forest, Cupertino North, CN 95014")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Green Earth Foundation")
                .address("45 Sustainability St., Portland, OR 97035")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Future Vision Labs")
                .address("88 Quantum Road, Boston, MA 02115")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Harmony Music Org.")
                .address("77 Jazz Avenue, New Orleans, LA 70130")
                .build());
    }
}
