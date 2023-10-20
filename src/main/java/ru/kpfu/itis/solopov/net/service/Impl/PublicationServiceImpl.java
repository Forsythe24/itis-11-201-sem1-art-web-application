package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import java.util.List;
import java.util.stream.Collectors;

public class PublicationServiceImpl implements PublicationService {
    private final Dao<Publication> dao = new PublicationDaoImpl();
    @Override
    public List<PublicationDto> getAll() {
        return dao.getAll().stream().map(
                p -> new PublicationDto(p.getId(), p.getUserID(), p.getTitle(), p.getText(), p.getDate(), p.getTime(), p.getGenre(), p.getDescription(), p.getImage())
        ).collect(Collectors.toList());
    }

    @Override
    public PublicationDto get(Long id) {
        return null;
    }

    @Override
    public void save(Publication publication) {
        dao.save(publication);
    }
}
