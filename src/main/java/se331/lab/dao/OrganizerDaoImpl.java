package se331.lab.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import se331.lab.entity.Organizer;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("OpenAI Research")
                .address("San Francisco, CA 94110")
                .build());

        organizerList.add(Organizer.builder()
                .id(2L)
                .name("Tech Valley Solutions")
                .address("123 Innovation Drive, Austin, TX 73301")
                .build());

        organizerList.add(Organizer.builder()
                .id(3L)
                .name("MicroApple Inc.")
                .address("Redwood Forest, Cupertino North, CN 95014")
                .build());

        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Green Earth Foundation")
                .address("45 Sustainability St., Portland, OR 97035")
                .build());

        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Future Vision Labs")
                .address("88 Quantum Road, Boston, MA 02115")
                .build());

        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Harmony Music Org.")
                .address("77 Jazz Avenue, New Orleans, LA 70130")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;

        return organizerList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
