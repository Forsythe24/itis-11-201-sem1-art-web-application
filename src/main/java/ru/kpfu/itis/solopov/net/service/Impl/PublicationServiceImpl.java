package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.dao.Impl.CommentDaoImpl;
import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import java.util.List;
import java.util.stream.Collectors;

public class PublicationServiceImpl implements PublicationService {
    private final PublicationDaoImpl dao;
    public PublicationServiceImpl(Dao<Publication> dao) {
        this.dao = (PublicationDaoImpl) dao;
    }
    @Override
    public List<PublicationDto> getAll() {
        return dao.getAll().stream().map(
                p -> new PublicationDto(p.getId(), p.getUserID(), p.getTitle(), p.getText(), p.getDate(), p.getTime(), p.getGenre(), p.getDescription(), p.getImage())
        ).collect(Collectors.toList());
    }

    @Override
    public PublicationDto get(long id) {
        Publication publication = dao.get(id);
        return new PublicationDto(
                publication.getId(),
                publication.getUserID(),
                publication.getTitle(),
                publication.getText(),
                publication.getDate(),
                publication.getTime(),
                publication.getGenre(),
                publication.getDescription(),
                publication.getImage()
        );
    }

    @Override
    public void save(Publication publication) {
        dao.save(publication);
    }

    @Override
    public List<PublicationDto> getAllByTitle(String title) {
        return dao.getAllByTitle(title).stream().map(
                p -> new PublicationDto(p.getId(), p.getUserID(), p.getTitle(), p.getText(), p.getDate(), p.getTime(), p.getGenre(), p.getDescription(), p.getImage())
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void update(PublicationDto publicationDto) {
        Publication publication = dao.get(publicationDto.getId());

        publication.setTitle(publicationDto.getTitle());
        publication.setText(publicationDto.getText());
        publication.setGenre(publicationDto.getGenre());
        publication.setDescription(publicationDto.getDescription());
        publication.setImage(publicationDto.getImage());

        dao.update(publication);
    }
}
