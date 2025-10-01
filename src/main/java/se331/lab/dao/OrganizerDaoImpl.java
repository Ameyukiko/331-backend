package se331.lab.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import se331.lab.entity.Organizer;
import se331.lab.repository.OrganizerRepository;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("CodeMonkeys United")
                .image("https://example.com/images/codemonkeys.jpg")
                .build());

        organizerList.add(Organizer.builder()
                .id(2L)
                .name("StackOverflow.ai")
                .image("https://example.com/images/stackoverflow.jpg")
                .build());

        organizerList.add(Organizer.builder()
                .id(3L)
                .name("MicroApple Inc.")
                .image("https://example.com/images/microapple.jpg")
                .build());

        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Googlebooksoft")
                .image("https://example.com/images/googlebooksoft.jpg")
                .build());

        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Amazon Cloud99")
                .image("https://example.com/images/amazoncloud.jpg")
                .build());

        organizerList.add(Organizer.builder()
                .id(6L)
                .name("The MetaVerse Café")
                .image("https://example.com/images/metaverse.jpg")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;

        return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex + pageSize),
                PageRequest.of(page, pageSize), organizerList.size());
    }

    @Override
    public Page<Organizer> getOrganizers(Pageable pageRequest) {
        return new PageImpl<Organizer>(organizerList,
                PageRequest.of(1, organizerList.size()), organizerList.size());
    }

    @Override
    public Optional<Organizer> findById(Long id) {
        return Optional.ofNullable(organizerList.get(id.intValue()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
        organizerList.add(organizer);
        return organizer;
    }
}
